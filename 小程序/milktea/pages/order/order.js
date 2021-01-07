// pages/order/order.js
var base = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    currentTab:0,
    userName:"",
    miniOrderList:"",
    openid :""
  },

  swichTab: function (e) {
    var that = this;
    if (this.data.currentTab === e.target.dataset.current) {
      return false;
    } else {
      that.setData({
        currentTab: e.target.dataset.current
      })
    }
    this.update()
  },
  update: function(){
   // 1 取出缓存中的用户名
    var openid = base.globalData.openid
    this.setData(
      { 
        openid: openid
      }
    )
    if (this.data.currentTab==0)
    {
      wx.request({

        data: { openid: this.data.openid},
        url: 'http://localhost:8081/findTodayMiniOrder',
        success: (result) => {
          //console.log(result.data)
          var tmp = result.data
          var img = []
          for (var i = 0; i < tmp.length; i++) {
            img = []
            for (var j = 0; j < tmp[i].imageList.length; j++) {
              img[j] = tmp[i].imageList[j];
            }
            tmp[i].img = img;
          }
          
          for (var i = 0; i < tmp.length;i++)
          {
            //console.log(tmp[i].orderTime);  //2019-01-21T06:25:50.000Z
            var d = new Date(tmp[i].orderTime);
            //console.log(d);   //Sun Jan 20 2019 16:43:42 GMT+0800
            //console.log(d.getTime());  //这个全输入时间戳
            var y = d.getFullYear();
            var mon = d.getMonth()+1;
           
            var day = d.getDate();
            var h = d.getHours();//12
            var m = d.getMinutes(); //12
            var s = d.getMinutes();
            if (h < 10) {
              h = "0" + h;
            }
            if (m < 10) {
              m = "0" + m;
            }

            tmp[i].orderTime =y + '/' + mon + '/' + day + ' ' +h + ':' + m +':'+s
            //console.log(tmp[i].orderTime);//12:12或09:07,这是最终输入的格式
            // var d1 = new Date(tmp[i].orderTime);
            // var dateee = d1.toJSON();
            // var d2 = Date(+new Date(dateee) + 8 * 3600 * 1000)
            // tmp[i].orderTime=d2.toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
            // console.log(tmp[i].orderTime)
          }

          this.setData(
            { miniOrderList: tmp }
          )
        }
      })
    }
    else
    {
      wx.request({

        data: { openid: this.data.openid },
        url: 'http://localhost:8081/findAllMiniOrder',
        success: (result) => {
          //console.log(result.data)
          var tmp = result.data
          var img=[]
          for (var i=0;  i< tmp.length; i++) {
            img = []
            for (var j = 0; j < tmp[i].imageList.length;j++)
            {
              img[j] = tmp[i].imageList[j];
            }  
            tmp[i].img=img;
          }
          for (var i = 0; i < tmp.length; i++) {
            //console.log(tmp[i].orderTime);  //2019-01-21T06:25:50.000Z
            var d = new Date(tmp[i].orderTime);
            //console.log(d);   //Sun Jan 20 2019 16:43:42 GMT+0800
            //console.log(d.getTime());  //这个全输入时间戳
            var y = d.getFullYear();
            var mon = d.getMonth() + 1;

            var day = d.getDate();
            var h = d.getHours();//12
            var m = d.getMinutes(); //12
            var s = d.getMinutes();
            if (h < 10) {
              h = "0" + h;
            }
            if (m < 10) {
              m = "0" + m;
            }

            tmp[i].orderTime = y + '/' + mon + '/' + day + ' ' + h + ':' + m + ':' + s
          }
          this.setData(
            { miniOrderList: tmp }
          )
        }
      })
    }
  },

  showDetail: function (e) {
    console.log(e.currentTarget.dataset)
    var orderId = e.currentTarget.dataset.id
    //发送请求的api
    wx.request({
      data: { orderId: orderId},
      url: 'http://localhost:8081/findOneOrder',
      success: (result) => {
        console.log(result.data)
        wx.navigateTo({
          url: '../orderDetail/orderDetail?orderDetail=' + JSON.stringify(result.data),
        })
        //JSON
        //js对象传值时先转换为字符串，接受后再把字符串转成对象
        //传值
        //js对象-->JSON字符串
        //JSON.stringify()
        //接收
        //JSON字符串-->js对象
        //JSON.parse()
      }

    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.update()

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.update()
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})