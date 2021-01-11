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
### 三.技术栈  

### 四.具体实现
####  客户端  
客户端采用小程序为客户提供图形界面，方便客户查看商品，下订单，查看订单状态
####  前端  
#####  1.登录：  
客户可以使用微信一键登录进入小程序，小程序会保存用户的登录信息  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0110/061934_35dc0c9b_4796963.png "屏幕截图.png")  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0110/062023_c926fdc2_4796963.png "屏幕截图.png")  
#####  2.首页（展示推荐信息，公告图片）：  
 ![输入图片说明](https://images.gitee.com/uploads/images/2021/0110/064927_97975e2d_4796963.png "屏幕截图.png")  
#####  3.点单页面
点单页面为客户展示商品列表以供选购  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0110/071637_eafb6713_4796963.png "屏幕截图.png")  
#####  4.购物车页面  
客户可以在购物车页面查看自己选购了那些商品，并提供下单入口  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0110/072110_a16121dc_4796963.png "屏幕截图.png")  
#####  5.订单页面
订单页面向客户展示了客户的历史订单，以及未完成订单  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0110/072514_6da64baa_4796963.png "屏幕截图.png")  
#####  6.客户个人信息页面  
客户可以在这个页面查看自己的个人信息，退出登录  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0110/073044_8880c001_4796963.png "屏幕截图.png")  
#####  小程序端操作说明  
#####  7.下订单  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0110/073452_8ae3054b_4796963.png "屏幕截图.png")  
#####  8.在购物车结算  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0110/073526_d7ac4866_4796963.png "屏幕截图.png")  
#####  9.支付  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0110/073548_2b708853_4796963.png "屏幕截图.png")  
#####  10.未取餐订单  
支付以后可以在未取餐订单中查看已下订单  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0110/074203_94674fad_4796963.png "屏幕截图.png")
####  后端
后端主要提供的功能：
#####  1.“为你推荐”接口   
在首页中随机显示8款奶茶
```java
@GetMapping("recommend")
    @ApiOperation(value = " 首页“为你推荐”")
    public List<Milktea> recommend() {
           随机选择8款奶茶向用户推荐
        Integer nums = 8;
        Integer start = 1;
        Integer end = countMilktea();
        //1.创建集合容器对象
        List list = new ArrayList();
        List ret = new ArrayList();
        //2.创建Random对象
        Random r = new Random();
        //循环将得到的随机数进行判断，如果随机数不存在于集合中，则将随机数放入集合中，如果存在，则将随机数丢弃不做操作，进行下一次循环，直到集合长度等于nums
        while (list.size() != nums) {
            Integer num = r.nextInt(end - start) + start;
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        for (Object l : list) {
            NumberFormat formatter = NumberFormat.getNumberInstance();
            String s = formatter.format(Integer.parseInt(l.toString()));

//            System.out.println(s);
            ret.add(selectOneMilktea(s));
        }
        return ret;
    }
```
mapper语句：
```xml
    <select id="selectMilkteaById" resultType="com.demo01.demo.entity.Milktea">
        select *
        from milktea
        where id = #{id}
    </select>
```
#####  2.按种类排序返回全部奶茶接口
用于小程序点单页面按照种类显示奶茶。先获取奶茶的种类数，然后根据种类id将全部奶茶按照种类装到各个数组中，再将这些数组装到一个大数组中
```java
    @GetMapping("selectAllByType")
    @ApiOperation(value = "返回全部的奶茶 会按奶茶种类排序")
    public List<List<Milktea>> selectAllByType(String type) {
    List<List<Milktea>> res= new ArrayList<List<Milktea>>();
            int countType = countType();
            for (int i = 0; i < countType; i++) {
                List<Milktea> temp = selectByType(Integer.toString(i+1) );
                res.add(temp);
            }
            return res;
        }
```
mapper语句：
```xml
    <select id="selectByType" resultType="com.demo01.demo.entity.Milktea">
        select *
        from milktea
        where type = #{type}
    </select>
```
#####  3.用户登录接口
用于用户使用微信进行登录的接口。先判断从小程序获得的openid是否为空，为空则登录失败返回空值，否则查询数据库该openid是否已存入数据库，未存入则将该openid与用户昵称插入数据库并且后端返回存有openid该用户对象，否则只更新用户昵称并返回存有对应用户信息的用户对象。
```java
@PostMapping("login")
    @ApiOperation(value = "登录")
    public User login(@RequestBody LoginInfoDTO loginInfoDTO) {
        String openid = loginInfoDTO.getOpenid();
        String nickname = loginInfoDTO.getNickname();
        User res = userService.login(openid);
        if (res.getOpenid() != null) {
            res.setNickname(nickname);
            userService.setNickName(res);
        }
        return res;
    }

//userService.login(String openid)方法
@Override
    public User login(String openid) {
        if (openid.equals("")) {
            System.out.println("ID是空的，无法登陆");
            return new User();
        }
        User successUser = userMapper.login(openid);
        if (null == successUser) {
            this.logon(openid);
            User user = new User();
            user.setOpenid(openid);
            return user;
        }
        return successUser;
    }
```
主要mapper语句：
```xml
    <select id="login" resultType="User">
    select *  from cusaccinfo where openid=#{openid}
    </select>

    <insert id="logon" parameterType="String">
        insert into cusaccinfo(openid) values(#{openid})
    </insert>
```
#####  4.下单接口  
用于用户下单的接口。后端先将订单时间、总价格、用户openid和用户地址信息插入数据库中的orderinfo表（订单信息表），获取自增的orderid后将从小程序获取的奶茶信息拆分开来，按照奶茶的id组成为单条条目，依照orderid插入数据库中的comselectinfo表（订单详情表）中
```java
    @PostMapping("addOneOrderByStr")
    @ApiOperation(value = "增加一个订单条目")
    public boolean addOneOrderByStr(String openid,String drinkStr,String address,String phoneNum,String name)
    {
//转对象集合
        JSONArray json = JSONArray.fromObject(drinkStr);
        List<OrderDrink> drinkList = (List<OrderDrink>) JSONArray.toCollection(json, OrderDrink.class);
        //加入时间
        Timestamp time = new Timestamp(System.currentTimeMillis());

        double totalPrice = 0;

        //统计价格
        for (OrderDrink d : drinkList) {
            totalPrice = totalPrice + d.getDrinkPrice();
        }

        //先插入orderinfo表
        Order order = new Order();

        order.setOpenid(openid);
        order.setTime(time);
        order.setTotal(totalPrice);
        order.setStatus(0);
        order.setAddress(address);
        order.setPhonenum(phoneNum);
        order.setName(name);
        if (orderMapper.addOneOrderInfo(order) == 0)
            return false;

        //后插入selectinfo表
        SelectInfo selectInfo;
        //获取orderinof表最大的orderid
        int orderId = orderMapper.findLastOrderId();

        //拆分drinklist,组成为单条条目，插入数据库
        for (OrderDrink d : drinkList) {
            selectInfo = new SelectInfo();
            selectInfo.setId(d.getDrinkId());
            selectInfo.setDescription(d.getDrinkInfo());
            selectInfo.setNumber(d.getDrinkNum());
            selectInfo.setPrice(d.getDrinkPrice());
            selectInfo.setOrderId(orderId);
            totalPrice = totalPrice + d.getDrinkPrice();
            if (orderMapper.addOneSelectInfo(selectInfo) == 0)
                return false;
        }
        return true;
    }
```
mapper语句：
```xml
    <insert id="addOneSelectInfo" parameterType="com.demo01.demo.entity.SelectInfo">
        insert into comselectinfo value(#{orderId},#{id},#{number},#{description},#{price})
    </insert>

    <insert id="addOneOrderInfo" parameterType="com.demo01.demo.entity.Order">
        insert into OrderInfo value(null,#{openid},#{time},#{total},#{status},#{address},#{phonenum},#{name})
    </insert>
```
#####  5.查询制作中订单接口
```java
    @GetMapping("findMakingMiniOrder")
    @ApiOperation(value = "查询用户制作中订单缩略信息")
    public List<MiniOrder> findMakingMiniOrder(String openid) {
        List<MiniOrderEntry> entryList = orderMapper.findMakingMiniOrder(openid);
        List<MiniOrder> orderList = new ArrayList<>();
        List<String> drinkIdList = new ArrayList<>();
        List<String> imageList = new ArrayList<>();
        MiniOrder orderTmp = new MiniOrder();
        int drinkId;
        int orderId = -1;
        double total = 0;
        //查询结果为空
        if (entryList.size() == 0)
            return null;
        //根据订单编号合并订单条目，组成一个完整订单
        for (MiniOrderEntry e : entryList) {
            //当前条目属于一个新订单
            if (orderId != e.getOrderId()) {
                //不是第一个订单才需要添加到orderList
                if (orderId != -1) {
                    orderTmp.setTotal(total);
                    orderTmp.setDrinkIdList(drinkIdList);
                    orderTmp.setImageList(imageList);
                    orderList.add(orderTmp);
                }
                //清空上个订单用到的变量
                orderTmp = new MiniOrder();
                drinkIdList = new ArrayList<>();
                imageList = new ArrayList<>();
                total = 0;
                //不是第一个订单才需要清空drinkList,imageList
                if (orderId != -1) {
                    drinkIdList.clear();
                    imageList.clear();
                }
                //
                orderId = e.getOrderId();
                orderTmp.setOrderId(e.getOrderId());
                orderTmp.setOrderTime(e.getTime());
                orderTmp.setOpenid(e.getOpenid());
                total += e.getPrice();
                //加入一种饮品
                drinkIdList.add(e.getId());
                imageList.add(e.getImage());

            }
            //当前条目与上条条目属于同一个订单，仅添加饮品
            else {
                total += e.getPrice();
                drinkIdList.add(e.getId());
                imageList.add(e.getImage());
            }
        }

        orderTmp.setTotal(total);
        orderTmp.setDrinkIdList(drinkIdList);
        orderTmp.setImageList(imageList);
        orderList.add(orderTmp);
        return orderList;
    }
```
mapper语句：
```xml
    <select id="findMakingMiniOrder" resultType="com.demo01.demo.entity.MiniOrderEntry">
        select a.orderId,a.openid,a.total,a.time,b.id,b.number,b.price,c.image
        from OrderInfo a, comselectinfo b, milktea c
        where openid=#{openid} and a.orderId = b.orderId and b.id = c.id and Status = 0;
    </select>
```
#####  6.查询已完成订单接口
```java
    @GetMapping("findCompletedMiniOrder")
    @ApiOperation(value = "查询用户已完成订单缩略信息")
    public List<MiniOrder> findCompletedMiniOrder(String openid) {
        List<MiniOrderEntry> entryList = orderMapper.findCompletedMiniOrder(openid);
        List<MiniOrder> orderList = new ArrayList<>();
        List<String> drinkIdList = new ArrayList<>();
        List<String> imageList = new ArrayList<>();
        MiniOrder orderTmp = new MiniOrder();
        int drinkId;
        int orderId = -1;
        double total = 0;
        //查询结果为空
        if (entryList.size() == 0)
            return null;
        //根据订单编号合并订单条目，组成一个完整订单
        for (MiniOrderEntry e : entryList) {
            //当前条目属于一个新订单
            if (orderId != e.getOrderId()) {
                //不是第一个订单才需要添加到orderList
                if (orderId != -1) {
                    orderTmp.setTotal(total);
                    orderTmp.setDrinkIdList(drinkIdList);
                    orderTmp.setImageList(imageList);
                    orderList.add(orderTmp);
                }
                //清空上个订单用到的变量
                orderTmp = new MiniOrder();
                drinkIdList = new ArrayList<>();
                imageList = new ArrayList<>();
                total = 0;
                //不是第一个订单才需要清空drinkList,imageList
                if (orderId != -1) {
                    drinkIdList.clear();
                    imageList.clear();
                }
                //
                orderId = e.getOrderId();
                orderTmp.setOrderId(e.getOrderId());
                orderTmp.setOrderTime(e.getTime());
                orderTmp.setOpenid(e.getOpenid());
                total += e.getPrice();
                //加入一种饮品
                drinkIdList.add(e.getId());
                imageList.add(e.getImage());

            }
            //当前条目与上条条目属于同一个订单，仅添加饮品
            else {
                total += e.getPrice();
                drinkIdList.add(e.getId());
                imageList.add(e.getImage());
            }
        }

        orderTmp.setTotal(total);
        orderTmp.setDrinkIdList(drinkIdList);
        orderTmp.setImageList(imageList);
        orderList.add(orderTmp);
        return orderList;
    }
```
mapper语句：
```xml
    <select id="findCompletedMiniOrder" resultType="com.demo01.demo.entity.MiniOrderEntry">
        select a.orderId,a.openid,a.total,a.time,b.id,b.number,b.price,c.image
        from OrderInfo a, comselectinfo b, milktea c
        where openid=#{openid} and a.orderId = b.orderId and b.id = c.id and Status = 1;
    </select>
``` 
###  后台 
####  前端  
前端主要有几个模块组成：左上角是LOGO，右上角是账户信息，左侧栏是菜单，占据页面大部分内容的是内容展示框  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0111/131038_f93697b6_6563150.png "屏幕截图.png")
前端的菜单有  

#####  1.首页  
首页向用户展示一些重要统计数据的图表信息，让经营者能够清楚知道自己的营收情况  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0111/132007_23d75e7c_6563150.png "屏幕截图.png")
#####  2.订单管理  
给经营者管理订单，或是给制作者查看订单信息，根据信息制作相应奶茶  


#####  3.商品管理  
经营者可以在这个页面添加或者删除商品  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0111/133733_ac6ce7f5_6563150.png "屏幕截图.png")  
添加商品操作：  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0111/133921_4f3f2a63_6563150.png "屏幕截图.png")  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0111/133949_a97dca45_6563150.png "屏幕截图.png")  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0111/134314_42e30d74_6563150.png "屏幕截图.png")
其中商品图标是动态获取的  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0111/134237_d2db90b1_6563150.png "屏幕截图.png")  
##### banner管理
banner指的是小程序首页的展示图片，可以从此页面进行更换  

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
提供给制作人员的接口:
#####  1.查看未制作订单  
制作人员可以在后台查看未制作订单以及订单描述信息，根据后台给出的提示进行制作商品  
![订单返回形式](https://images.gitee.com/uploads/images/2021/0109/142845_4af91cb3_4796963.png "屏幕截图.png")
#####  2.更新订单状态  
![输入图片说明](https://images.gitee.com/uploads/images/2021/0110/060757_e69d9fbb_4796963.png "屏幕截图.png")  
订单制作完成以后，制作员可以更新订单状态