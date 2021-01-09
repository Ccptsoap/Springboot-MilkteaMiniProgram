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
        var openid = String(wx.getStorageSync('openid'))

        this.globalData.openid = openid
        console.log("加载时从缓存获取的openid：" + this.globalData.openid)
        if (res.authSetting['scope.userInfo'] && this.globalData.openid != "") {
          console.log("用户已同意授权")
          wx.getUserInfo({
            success: res => {
              this.globalData.userInfo = res.userInfo
              console.log("写入userinfo")
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        } else {
          console.log("用户未同意授权")
          setTimeout(function () {
            wx.navigateTo({
              url: '/pages/login/login'
            })
          }, 1000)
        }
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