// pages/pay/pay.js
var base = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    openid: "",
    phonenum:"",
    totalPrice:0,
    totalNum:0,
    drinkList:"",
    //传回后端的drinklist
    dl:"",
    address: "",
    name: ""
  },
  goWePay: function () {
    wx.showModal({
      title: '喜茶',
      content: '合计￥' + this.data.totalPrice,
      success: (result) => {
        if (result.confirm) {
          wx.showToast({
            title: '支付成功',
            icon: "success",
            image:"/icon/success.png"
          })
          //清空购物车缓存
          base.cart.clear();
          setTimeout(function () {
            // 回传后端订单，去往订单页面
            wx.switchTab({
              url: '../order/order',
            })
          }, 2000)
          
          var openid = base.globalData.openid
          this.setData(
            { openid:openid,
              address: base.globalData.user.address,
              phonenum: base.globalData.user.phonenum,
              name: base.globalData.user.name
            }
          )
          console.log(JSON.stringify(this.data.dl))
          wx.request({

            data: { openid: this.data.openid, drinkStr: JSON.stringify(this.data.dl), address: this.data.address,
              phoneNum: this.data.phonenum, name: this.data.name},
            url: 'http://localhost:8080/addOneOrderByStr',
            success: (result) => {
              console.log(result.data)
              if (result.data==true)
                wx.showToast({
                  title: '下单成功！',
                  image: "/icon/success.png"
                })
              else
                wx.showToast({
                  title: '下单失败！',
                  image: "/icon/fail.png"
                })
            }
          })
        } else {
          console.log('点击取消回调')
        }
      }
    })
  },
  
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) { 
    //1 取出缓存中的openid
    var phonenum = base.globalData.user.phonenum
    this.setData(
      { phonenum: phonenum,
        address : base.globalData.user.address
       }
    )
    //获得商品列表  
    var l = base.cart.getList();
    var tp = 0;
    var tn = 0;
    var tmpList=[];
    for (var i = 0; i < l.length; i++) {
      tp += l[i].price * l[i].num;
      tn += l[i].num;
      tmpList[i] = {
        drinkId: l[i].id,
        drinkName: l[i].name,
        drinkPrice: l[i].price*l[i].num,
        drinkInfo: l[i].size,
        drinkNum: l[i].num
      }

    }
    console.log(tmpList)
    this.setData({
      totalPrice:tp,
      totalNum:tn,
      drinkList:l,
      dl:tmpList
    })
  },
  changeAddress: function(){
    wx.navigateTo({
      url: '../address/changeAddress/changeAddress',
    })
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