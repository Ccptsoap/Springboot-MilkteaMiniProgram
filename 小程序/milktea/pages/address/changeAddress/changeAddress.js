// pages/address/changeAddress/changeAddress.js
var base = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    openid:"",
    phonenum: "",
    region: ['广东省', '东莞市', '松山湖'], // 初始值
    addressDetail: "",
    changeaddress: "",
    name:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getAll();
  },
  getAll:function(){
    this.setData({
      phonenum:base.globalData.user.phonenum,
      name: base.globalData.user.name,
      openid: base.globalData.openid
    })
  },
  changeaddress:function(e){
    this.setData({
      changeaddress: this.data.region+","+e.detail.value.addressDetail,
      phonenum: e.detail.value.phonenum,
      openid: base.globalData.openid,
      name: e.detail.value.name
    })
    console.log("address"+this.data.changeaddress)
    console.log("name"+this.data.name)
    console.log("num"+this.data.phonenum)
    console.log("openid"+this.data.openid)
    wx.request({
      url: getApp().globalData.apiHost+'/changeUser',
      method: 'POST',
      data: {openid:this.data.openid,name:this.data.name,phonenum:this.data.phonenum,address:this.data.changeaddress},
      success:(result)=>{
        console.log(result.data)
        if(result.data=="修改成功"){
          //重新获取信息
          base.globalData.user.address =this.data.changeaddress
          base.globalData.user.phonenum =this.data.phonenum
          base.globalData.user.name =this.data.name
          this.getAll();
          
          wx.showToast({
            title: '修改成功',
            icon:"success"
          })
          setTimeout(function () {
            wx.switchTab({
              url: '/pages/address/address',
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