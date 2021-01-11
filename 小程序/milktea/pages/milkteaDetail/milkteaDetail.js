// pages/milkteaDetail/milkteaDetail.js
var base = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    milktea: "",
    //设置中间变量，把onLoad中的获取到的标题函数传入到onReady中使用
    navigateTitle: "",
    image: "",
    price: 0,
    total: "", //选择内容的描述
    num: 1, //购买数量
   

    sugar_buttons: [{
      id: 1,
      name: "标准糖"
    }, {
      id: 2,
      name: "半糖"
    }, {
      id: 3,
      name: "微糖"
    }, {
      id: 4,
      name: "无糖"
    }],
    sugar: 1,

    ice_buttons: [{
      id: 1,
      name: "正常"
    }, {
      id: 2,
      name: "少冰"
    }, {
      id: 3,
      name: "少少冰"
    }, {
      id: 4,
      name: "去冰"
    }],
    ice: 1,
  },

  generateTotal: function (e) {
    var description = ""
    description += this.data.sugar_buttons[this.data.sugar - 1].name
    description += ","
    description += this.data.ice_buttons[this.data.ice - 1].name
   
    this.setData({
      total: description
    })
  },

  minusCount: function (e) {
    if (this.data.num > 1) {
      // 当数量为1时不可减少
      // 计算单价
      var singlePrice = this.data.price / this.data.num
      console.log(singlePrice)
      var newPrice = this.data.price - singlePrice
      var newNum = this.data.num - 1
      this.setData({
        num: newNum,
        price: newPrice
      })
    }
  },

  plusCount: function (e) {
    // 计算单价
    var singlePrice = Math.round(this.data.price / this.data.num)
    console.log(singlePrice)
    var newPrice = Number(this.data.price) + Number(singlePrice)
    console.log(newPrice)
    var newNum = this.data.num + 1
    this.setData({
      num: newNum,
      price: newPrice
    })
  },

  sugarButtonTap: function (e) {
    console.log(e)
    let id = e.currentTarget.dataset.id
    console.log(id)
    for (let i = 0; i < this.data.sugar_buttons.length; i++) {
      if (this.data.sugar_buttons[i].id == id) {
        //当前点击的位置为true即选中
        this.data.sugar_buttons[i].checked = true
      } else {
        //其他的位置为false
        this.data.sugar_buttons[i].checked = false
      }
    }
    this.setData({
      sugar_buttons: this.data.sugar_buttons,
      sugar: id
    })
    this.generateTotal()
  },

  iceButtonTap: function (e) {
    console.log(e)
    let id = e.currentTarget.dataset.id
    console.log(id)
    for (let i = 0; i < this.data.ice_buttons.length; i++) {
      if (this.data.ice_buttons[i].id == id) {
        //当前点击的位置为true即选中
        this.data.ice_buttons[i].checked = true
      } else {
        //其他的位置为false
        this.data.ice_buttons[i].checked = false
      }
    }
    this.setData({
      ice_buttons: this.data.ice_buttons,
      ice: id
    })
    this.generateTotal()
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var name = JSON.parse(options.milktea).name
    this.setData({
      milktea: JSON.parse(options.milktea)
    })
    this.data.navigateTitle = name
    this.data.sugar_buttons[0].checked = true
    this.data.ice_buttons[0].checked = true
    console.log("奶茶详情页取全局图片url："+ this.data.milktea.image)
    this.setData({
      image: this.data.milktea.image,
      price: this.data.milktea.price,
      sugar_buttons: this.data.sugar_buttons,
      ice_buttons: this.data.ice_buttons,
      total: "标准糖,正常冰"
    })
  },

  confirmButtonTap: function (e) {
    var that = this
    var singlePrice = Number(this.data.price / this.data.num)
    base.cart.cartno = Number(base.cart.cartno) + 1
    console.log("supplyno in confirmButtonTap，购物车项目编号" + base.cart.cartno)
    console.log("插入购物车项目图片URL" + this.data.milktea.image)
    if (base.cart.add({
        supplyno: base.cart.cartno,
        id: this.data.milktea.id,
        name: this.data.milktea.name,
        size: this.data.total,
        price: singlePrice,
        num: this.data.num,
        image: this.data.milktea.image
      })) {
      this.setData({
        cartNum: base.cart.getNum()
      })
      base.modal({
        title: '加入成功！',
        content: "跳转到购物车或留在当前页",
        showCancel: true,
        cancelText: "继续点单",
        confirmText: "去购物车",
        success: function (res) {
          if (res.confirm) {
            wx.switchTab({
              url: "../cart/cart"
          })
          }else{
            wx.switchTab({
              url: "../milktea/milktea"
          })
          }
        }
      })
    }
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
    wx.setNavigationBarTitle({
      title: this.data.navigateTitle
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