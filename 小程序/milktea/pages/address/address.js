// pages/user/user/changeUserInfo/changeUserInfo.js
var base = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
      address:"",
      phonenum:"",
      name: ""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
  },
  
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  },

  jumpBtn: function(){
    wx.navigateTo({
      url: './changeAddress/changeAddress',
    })
  },
  
  getAll:function(){
    console.log("修改信息中的getAll()")
    wx.request({
      url: 'http://localhost:8081/findByID',  //通过手机号获取信息，可修改成通过id获取地址信息
      data: {openid:base.globalData.openid},
      success:(result)=>{
        console.log(result)
        base.globalData.user.address =result.data.address
        base.globalData.user.phonenum =result.data.phonenum
        base.globalData.user.name =result.data.name
        this.setData({
          address:base.globalData.user.address,
          phonenum:base.globalData.user.phonenum,
          name:base.globalData.user.name
        })
        console.log("222222222222")
      }
    })
  },
  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    this.getAll();
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