// pages/address/changeAddress/changeAddress.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: "",
    phone: "",
    region: ['广东省', '东莞市', '松山湖'], // 初始值
    addressDetail: "",
    changeaddress: ""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  },
  getAll:function(){
    this.setData({
      phone:wx.getStorageSync('phone'),
      userInfo:wx.getStorageSync('userInfo')
    })
  },
  changeaddress:function(e){
    this.setData({
      changeaddress: this.data.region+","+e.detail.value.addressDetail,
      phone: e.detail.value.phone
    })
    console.log(this.data.changeaddress)
    wx.request({
      url: 'http://localhost:8080/changeAddress',  //
      data: {openid:wx.getStorageSync('openid'),address:this.data.changeaddress,phone:this.data.phone},
      success:(result)=>{
        if(result.data=="修改成功"){
          //重新获取信息
          this.getAll();
          wx.setStorageSync('address', changeaddress)
          wx.setStorageSync('phone', phone)
          wx.showToast({
            title: '修改成功',
            icon:"success"
          })
          setTimeout(function () {
            // login
            wx.switchTab({
              url: '../../address/address',
            })
          }, 1000)
        }
        else{
          wx.showToast({
          title: result.data,
          icon:"none"
         })
        }
      }
    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  bindRegionChange: function (e) {  // picker值发生改变都会触发该方法
    console.log('picker发送选择改变，携带值为', e.detail.value)
    this.setData({
      region: e.detail.value
    })
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