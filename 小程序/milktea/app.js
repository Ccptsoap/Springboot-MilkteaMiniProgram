App({
  globalData: {
    openid: "",
    userInfo: "",
    user: "",
    count_type: 0,
    milktea: [],
    isIn: 0,
    apiHost: 'http://localhost:8081'
  },
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)
    console.log("开启触发登录")

    // 获取用户信息
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.globalData.userInfo = res.userInfo
              console.log("写入userinfo")

              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        }
      }
    })


    var that = this;
    wx.login({

      success(res) {

        console.log("登录返回code：" + res.code)
        wx.request({
          url: 'https://api.weixin.qq.com/sns/jscode2session',
          data: {
            appid: "wxea509e2fe57d041e",
            secret: "7e92c30b02ec571bdc1da47fee12ab0f",
            js_code: res.code,
            grand_type: "authorization_code"
          },
          method: "GET",

          success: function (res) {
            that.globalData.openid = res.data.openid
            console.log("微信返回的openid：" + that.globalData.openid)
            wx.request({
              url: getApp().globalData.apiHost + '/login',
              method: 'POST',
              data: {
                openid: res.data.openid,
                nickname: that.globalData.userInfo.nickName
              },
              success: (result) => {
                console.log("服务端返回数据： 服务器返回openid：" + result.data.openid + " 用户姓名：" + result.data.name)
                console.log((result.data))

                if (result.data.name != null) {
                  that.globalData.isIn = 1;
                  console.log("成功从服务器获取个人信息：" + " 姓名：" + result.data.name + " 地址：" + result.data.address)
                  wx.clearStorage({})
                  that.globalData.user = result.data
                  that.globalData.openid = res.data.openid
                  wx.setStorageSync('user', result.data)
                  wx.setStorageSync('openid', result.data.openid)
                } else {
                  console.log("登录成功，但从服务器获取信息失败！")
                  that.globalData.user = result.data
                  that.globalData.isIn = 1
                  wx.showToast({
                    title: '请填写个人信息',
                    icon: "none"
                  })
                  setTimeout(function () {
                    wx.navigateTo({
                      url: '/pages/address/changeAddress/changeAddress'
                    })
                  }, 1000)
                }
              }
            })
          }
        })
      }
    })


    this.getReady()
  },

  cart: {
    key: "cart",
    ref: "",
    add: function (p) {
      var re = false;
      if (p.supplyno && p.id && p.price && p.size && p.name && p.num) {
        var dic = wx.getStorageSync(this.key) || {};
        var flag = false
        var des
        for (var d in dic) {
          if (dic[d].id == p.id && dic[d].size == p.size) {
            flag = true
            des = d
            break
          }
        }
        if (flag) {
          dic[des].num += p.num;
        } else {
          dic[p.supplyno] = {
            id: p.id,
            name: p.name,
            price: p.price,
            size: p.size,
            num: p.num,
            image: p.image
          }
        }
        wx.setStorageSync(this.key, dic);
        re = true;
      }
      return re;
    },
    exist: function (sno) {
      var re = false;
      var dic = wx.getStorageSync(this.key) || {};
      if (sno in dic) {
        re = true;
      }
      return re;
    },
    remove: function (sno) {
      var dic = wx.getStorageSync(this.key) || {};
      if (sno in dic) {
        delete dic[sno];
        wx.setStorageSync(this.key, dic);
      }
    },
    getNum: function () {
      var n = 0;
      var dic = wx.getStorageSync(this.key) || {}
      for (var i in dic) {
        n += dic[i].num;
      }
      return n;
    },
    num: function (sno, n) {
      var dic = wx.getStorageSync(this.key) || {};
      if (sno in dic) {
        if (n > 0) {
          dic[sno].num = n;
        } else {
          delete dic[sno];
        }
        wx.setStorageSync(this.key, dic);
      }
    },
    cartno: Number(0),
    getList: function () {
      var list = [];
      var dic = wx.getStorageSync(this.key);
      for (var p in dic) {
        list.push({
          supplyno: p,
          id: dic[p].id,
          name: dic[p].name,
          price: dic[p].price,
          size: dic[p].size,
          num: dic[p].num,
          image: dic[p].image
        });
      }
      return list;
    },
    clear: function () {
      wx.removeStorageSync(this.key);
    }
  },
  // 获取奶茶数据
  getReady: function (options) {
    var that = this
    wx.request({
      // 获取种类数
      url: this.globalData.apiHost + '/countType',
      success: (result) => {
        this.globalData.count_type = result.data
        var count_type = result.data
        wx.request({
          // 获取每种类型对应的奶茶产品
          url: this.globalData.apiHost + '/selectAllByType',
          success: (result) => {
            var temp_category = result.data
            for (var i = 0; i < count_type; i++) {
              var newtemp = []
              newtemp.id = "id" + (String)(i + 1)
              newtemp.name = temp_category[i][0].typeName
              newtemp.category = temp_category[i]
              this.globalData.milktea[i] = newtemp
            }
          }
        })
      }
    })

  },



  modal: function (p) {
    wx.showModal(p);
  }

})