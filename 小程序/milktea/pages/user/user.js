// pages/user/user.js
var base = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  },
  clearInfo:function(){
    wx.clearStorage({
    })
    base.globalData.isIn = 0;
    base.globalData.userInfo = "";
    base.globalData.openid = "";
    base.globalData.user = "";
    wx.showToast({
      title: '成功退出',
      icon:"success"
    })
    setTimeout(function(){
      wx.navigateTo({
        url:"/pages/login/login"
      })
    },1000)
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
    // console.log("onshow")
    
    this.setData({
      userInfo : base.globalData.userInfo
    })
    
    console.log(this.data.userInfo)
    console.log("openid："+base.globalData.user.openid)
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