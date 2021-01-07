  // pages/login/login.js
var base=getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: "",
    openid: ""
  },
  wxlogin: function(e){
    const {userInfo}   = e.detail;

    wx.login({
      success(res){
        console.log("res.code"+res.code)
        wx.request({
          url: 'https://api.weixin.qq.com/sns/jscode2session',
          data: {
            appid: "wxea509e2fe57d041e",
            secret: "7e92c30b02ec571bdc1da47fee12ab0f",
            js_code: res.code,
            grand_type: "authorization_code"
          }, 
          method: "GET",
          success:function(res){
            wx.request({
              url:'http://localhost:8081/login',
              method: 'POST',
              data: {openid:res.data.openid,nickname:userInfo.nickName},
              success:(result)=>{
                console.log(res.data.openid+"        "+userInfo.nickName)
                console.log((result.data))
                if(result.data.status==null){
                  base.globalData.isIn=1;
                  wx.showToast({
                    title: '登录成功',
                    icon:"success"
                  })
                  wx.clearStorage({
                  })
                  wx.setStorageSync('userInfo', userInfo)
                  base.globalData.userInfo = userInfo
                  base.globalData.user = result.data
                  base.globalData.openid = res.data.openid
                  wx.setStorageSync('user', result.data)
                  wx.setStorageSync('openid', result.data.openid)
                  console.log(wx.getStorageSync('userInfo'))
                  setTimeout(function () {
                    wx.switchTab({
                      url: '../user/user',
                    })
                  }, 1000)
                }
                else{
                  wx.showToast({
                    title: '登录失败',
                    icon:"none"
                  })
                }
                }    
            })
          }
        })
      }
    })

  },
  // submit:function(){
  //   wx.request({
  //     url:'http://localhost:8081/login',
  //     data: {phone:this.data.phone, pwd:this.data.pwd},
  //     success:(result)=>{
  //       if(result.data!=""){
  //         base.globalData.isIn=1;
  //         wx.showToast({
  //           title: '登录成功',
  //           icon:"success"
  //         })
  //         wx.clearStorage({
  //         })
  //         wx.setStorageSync('phone', result.data)
  //         //发出请求
  //         this.getAll();
  //         setTimeout(function () {
  //           // login
  //           wx.navigateTo({
  //             url: '../user/user/changeUserInfo/changeUserInfo',
  //           })
  //         }, 1000)
  //       }
  //       else{
  //         wx.showToast({
  //           title: '登录失败',
  //           icon:"none"
  //         })
  //       }
  //     }
  //   })
  // },

  // getAll:function(){
  //   wx.request({
  //     url: 'http://localhost:8081/findByPhone',
  //     data: {phone:this.data.phone},
  //     success:(result)=>{
  //       console.log(result)
  //       wx.setStorageSync('username', result.data.username)
  //       wx.setStorageSync('phone', result.data.phone)
  //     }
  //   })
  // },
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