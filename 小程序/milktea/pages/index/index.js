Page({

  /**
   * 页面的初始数据
   */
  data: {
    recommendedMilktea: "",
    // 单击后需要跳转至详情页面的奶茶id
    selectedMilkteaId: "",
    bannerImgUrl1:"",
    bannerImgUrl2:"",
    bannerImgUrl3:""
  },

  //获取Banner
  getBanner: function () {
    wx.request({
      url: getApp().globalData.apiHost + '/getBannerImgUrl',
      success: (result) => {
        console.log("获取Banner")
        console.log(result)
        this.setData({
          bannerImgUrl1: result.data.data[0],
          bannerImgUrl2: result.data.data[1],
          bannerImgUrl3: result.data.data[2]
        })
      }
    })
  },

  // 为你推荐
  recommend: function () {
    wx.request({
      url: getApp().globalData.apiHost + '/recommend',
      success: (result) => {
        console.log("为你推荐奶茶数据：")
        console.log(result)
        this.setData({
          recommendedMilktea: result.data
        })
      }
    })
  },

  showDetail: function (e) {
    var selectedMilkteaId = e.currentTarget.dataset.id
    wx.request({
      url: getApp().globalData.apiHost + '/selectOneMilktea',
      data: {
        id: selectedMilkteaId
      },
      success: (result) => {
        // 跳转到奶茶详情页面
        wx.navigateTo({
          url: '../milkteaDetail/milkteaDetail?milktea=' + JSON.stringify(result.data),
        })
      }
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log("全局apiHost:" + getApp().globalData.apiHost)

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
    this.getBanner()
    this.recommend()
    console.log("登录页缓存中的openid："+wx.getStorageSync('openid'))
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