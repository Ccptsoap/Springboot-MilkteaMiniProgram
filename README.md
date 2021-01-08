## 东莞理工学院网络空间安全学院

| **课程名称：**     |              企业级开发框架专题               |  **学期**：2020秋季  |
| :----------------- | :-------------------------------------------: | :------------------: |
| **实验名称**：     |期末大作业：基于微信小程序的新零售移动电商系统设计与实验 |   **实验序号**：期末大作业   |
| **姓名**： |            **学号**：            | **班级**：18网工1班  |
| **实验地址**：宿舍 |           **实验日期**：2020-12-10           | **指导老师**：黎志雄 |
| **教师评语**：XXX  |               **实验成绩**：XXX               |   **同组同学**：  |


## 期末大作业：基于微信小程序的新零售移动电商系统设计与实验
<br>　　　　　　　　**基于小程序和Spring Boot的奶茶点单系统**
### 一.项目背景
<br> 　　受新冠疫情影响，消费者闭门不出，线下门店纷纷关闭，实体经济收到重大冲击。除了疫情的挑战，传统
<br>零售与传统电商，一直被效率、场景、管控等问题困扰。
<br>　　新零售赋能传统零售转型升级。线上商城与线下门店的交易无缝缝合，通过技术改变消费者的习惯，集合
<br>结合高效的物流配送,极大提高消费者的购物体验。基于微信的生态圈用户流量,让平台更快的传播获客，吸引
<br>海量用户资源。
### 二.需求分析 
<br>本项目需要分为两个客户端：
1. **用户端**  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0108/204756_2c80bc8a_4796963.png "屏幕截图.png")
2. **后台管理端**  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0108/205013_17ee09ba_4796963.png "屏幕截图.png")
![输入图片说明](https://images.gitee.com/uploads/images/2021/0108/205103_b6c610bc_4796963.png "屏幕截图.png")
### 三.具体实现
####  客户端  
#####  前端  
#####  后端  
###  后台 
####  前端  
####  后端  
后端主要提供的功能：
#####  1.管理员登录接口  
管理员使用账号密码登录，后端判断是否可以登录，如果不能登录则返回错误信息，成功则可以得到相关权限并跳转到后台主界面  
控制器：
```java  
//AdminLoginController
@RestController
@Api(tags = "管理员登录控制器")
public class AdminLoginController {
    @Autowired
    private AdminService adminService;
    
    @PostMapping("/admin/login")
    @ApiOperation(value = "管理员登录")
    public Result<?> login(@RequestParam String username,
                           @RequestParam String password_md5,
                           HttpSession session) {
        Admin admin = adminService.checkAdmin(username, password_md5);
        if (admin != null) {
//            admin.setPassword_md5("");
            session.setAttribute("admin",admin);
            return ResultUtils.success(admin);
        }else
        {
            return ResultUtils.error(-14,"用户名或密码错误");
        }
    }
}

```   
实体类：  
```java  
public class Admin extends BaseRowModel {
    @ExcelProperty(value = "id",index = 0)
    private int id;
    @ExcelProperty(value = "账号",index = 1)
    private String username;
    @ExcelProperty(value = "密码",index = 2)
    private String password_md5;

    public Admin() {

    }

    public Admin(int id, String username, String password_md5) {
        this.id = id;
        this.username = username;
        this.password_md5 = password_md5;
    }

    public Admin(int id, String username) {
        this.id = id;
        this.username = username;
    }
    public Admin(String username, String password_md5) {
        this.username = username;
        this.password_md5 = password_md5;
    }

    public Admin(String username) {
        this.username = username;
        //……省略getter and setter
    }}

```   
相关SQL语句
```MYSQL  
        select *
        from admin
        where username = #{username}
          and password = #{password_md5}
```
#####  2.获取奶茶列表  
管理员可以查看目前商品的列表,需要登录后操作
![在swagger获取奶茶列表](https://images.gitee.com/uploads/images/2021/0109/021921_c35d6b94_4796963.png "屏幕截图.png")  
sql语句：
```mysql  
     select *
        from milktea
```
实体类:  
```java  
public class Milktea extends BaseRowModel {
    @ExcelProperty(value = "编号",index = 0)
    String id;
    @ExcelProperty(value = "品名",index = 1)
    String name;
    @ExcelProperty(value = "单价",index = 2)
    String price;
    @ExcelProperty(value = "类型编号",index = 3)
    String type;
    @ExcelProperty(value = "类型",index = 4)
    String typeName;
    @ExcelProperty(value = "展示图片",index = 5)
    String image;
    //……省略Getter and Setter
    }
```
Controller:
```java  
@RestController
@Api(tags = "管理员控制器")
public class AdminController {
//…………
    @GetMapping("/admin/order/getTodayInfo")
    @ApiOperation(value = "统计今日订单数")
    public Integer getTodayOrderNum() {
        return orderService.getTodayOrderNum();
    }
//…………
}
```

奶茶列表导出Excel：  
数据库中的所有奶茶可以导出一份Excel方便管理员管理查看
![Excel内容](https://images.gitee.com/uploads/images/2021/0109/022721_efdea42b_4796963.png "屏幕截图.png")  
实体类依旧是同上，不同的是接口实现：  
Controller:
```java

@Controller
@Api(tags="Excle导出")
public class getExcleController {
    //……
    MilkteaService milkteaService;
    //……
        @GetMapping("/getMilkTeaExcle")
    @ApiOperation(value = "下载全部奶茶信息")
    public void getAllMilkTea(HttpServletResponse response){

        List<Milktea> milkteas= milkteaService.selectAllMilktea();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String time=sdf.format(new Date());
        time=time.replaceAll("-","").replaceAll(":","").replaceAll(" ","");
        String fileName="全部奶茶信息";
        ExcelUtil.writeExcel(response,milkteas,fileName+time,fileName,new Milktea());
    }
    //……
}
```  
#####  3.新增一个品种的奶茶  
商品（奶茶）的增加操作  
演示且看后台前端部分的内容  
SQL语句：  
```mysql
 INSERT INTO milktea (id, type, price, TypeName, image, name) VALUES (#{id},#{type},#{price},#{typeName},#{image},#{name})
```
对应实体类与2.一致  
Controller:
```java  
@RestController
@Api(tags = "管理员控制器")
public class AdminController {
//…………

    @PostMapping("/admin/milktea")
    @ApiOperation(value = "新增奶茶信息")
    public Result<?> saveMilkteaInfo(@RequestBody Milktea milktea) {
        return ResultUtils.success(milkteaService.saveMilktea(milktea));
    }
//…………
}
```
#####  4.根据ID修改奶茶信息  
 MilkteaMapper.xml:  
```xml
……
            update milktea
            <trim prefix="set" suffixOverrides=",">
                <if test="type != null">type = #{type},</if>
                <if test="price != null">price = #{price},</if>
                <if test="typeName != null">TypeName = #{typeName},</if>
                <if test="image != null">image = #{image},</if>
                <if test="name != null">name = #{name},</if>
            </trim>
            <where>id = #{id}</where>
……
```
Controller:
```java  
@RestController
@Api(tags = "管理员控制器")
public class AdminController {
//…………

    @PutMapping("/admin/milktea")
    @ApiOperation(value = "根据ID修改奶茶")
    public Result<?> updateMilkteaInfo(@RequestBody Milktea milktea) {
        return ResultUtils.success(milkteaService.updateMilktea(milktea));
    }
//…………
}
```
#####  5.根据ID查询奶茶信息
  对应实体类与2.一致  
Controller:
```java  
@RestController
@Api(tags = "管理员控制器")
public class AdminController {
//…………
    @GetMapping("/admin/milktea/{milkteaId}")
    @ApiOperation(value = "根据ID查询奶茶")
    public Result<?> getMilkteaById(@PathVariable("milkteaId") String milkteaId) {
        return ResultUtils.success(milkteaService.selectOneMilktea(milkteaId));
    }
//…………
}
```
#####  6.根据ID删除奶茶信息  
略
#####  7.统计近N日每日销售量  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0109/035510_98bc7ef0_4796963.png "屏幕截图.png")  
给前端返回的是Json以便解析  
对应实体类:  
```java
public class OrderInfoChart extends BaseRowModel {
    @ExcelProperty(value = "时间",index = 0)
    String time;
    @ExcelProperty(value = "订单数",index = 1)
    int orderNum;
    //省略Getter and Setter
}  
```
Controller:
```java  
@RestController
@Api(tags = "管理员控制器")
public class AdminController {
//…………
    @GetMapping("/admin/orders/getOrderInfoAnyTime")
    @ApiOperation(value = "统计历史每日订单数")
    public Result<?> getOrderInfoAnyTime(int days) {
        return ResultUtils.success(orderService.getOrderInfo_anyTime(days));
    }
//…………
}
SQL语句：
```mysql
        SELECT DATE_FORMAT( Time, '%Y-%m-%d' ) time, count(*) orderNum
        FROM orderinfo
        where DATE_SUB(CURDATE(), INTERVAL #{days} DAY) &lt;= date(Time)
        group by DATE_FORMAT( Time, '%Y-%m-%d' )
```
将每日销售量 导出为Excel：
![输入图片说明](https://images.gitee.com/uploads/images/2021/0109/040557_47a51137_4796963.png "屏幕截图.png")
Controller:
```java

@Controller
@Api(tags="Excle导出")
public class getExcleController {
    //……
    @Resource
    OrderService orderService;
    //……
    @GetMapping("/getOrderInfoChart")
    @ApiOperation(value = "下载订单数目统计")
    public void getAllMilkTea(HttpServletResponse response,int days){

        List<OrderInfoChart> OrderInfo= orderService.getOrderInfo_anyTime(days);
        System.out.println(OrderInfo.get(0).getTime());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        String time=sdf.format(new Date());
        time=time.replaceAll("-","").replaceAll(":","").replaceAll(" ","");
        String fileName="订单数目统计";
        ExcelUtil.writeExcel(response,OrderInfo,fileName+time,fileName,new OrderInfoChart());
    }
    //……
}
```  