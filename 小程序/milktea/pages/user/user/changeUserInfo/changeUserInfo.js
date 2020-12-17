// pages/user/user/changeUserInfo/changeUserInfo.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
      changeaddress:"",
      address:"",
      phone:"",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getAll();
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  },

  
 changeInfo:function(e){
    this.setData({
      changeaddress: e.detail.value.changeaddress
    })
    wx.request({
      url: 'http://localhost:8080/changeUser',
      data: {address:this.data.changeaddress},
      success:(result)=>{
        if(result.data=="修改成功"){
          //重新获取信息
          this.getAll();
          wx.showToast({
            title: '修改成功',
            icon:"success"
          })
          setTimeout(function () {
            // login
            wx.switchTab({
              url: '../../../user/user',
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
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  getAll:function(){
    this.setData({
      phone:wx.getStorageSync('phone')
    })
    console.log("修改信息中的getAll()")
    wx.request({
      url: 'http://localhost:8080/findByPhone',  //通过手机号获取信息，可修改成通过id获取地址信息
      data: {phone:this.data.phone},
      success:(result)=>{
        console.log(result)
        wx.setStorageSync('address', result.data.address)

        this.setData({
          address:wx.getStorageSync('address'),
        })
        console.log("222222222222")
      }
    })
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