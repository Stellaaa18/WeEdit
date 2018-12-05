
Page({

  data: {
    address: "2~100个字",
    times:"00:00",
    dates:"2018-10-01"
  },

   staticData:{

   },

  onShareAppMessage: function () {
    return {
      title: '通知',
      path: '/pages/publish/publish'
    }
  },


  handleContactChange(e) {
    console.log(e.detail.value)
  },
  handleAddressClick() {
    console.log("address");
  },
  handleMessageChange(e) {
    this.staticData.message = e.detail.value;
  },
  handleAddressChange(e) {
    this.staticData.address = e.detail.value;
  },
  handlethingsChange:function(e) {
    this.staticData.things = e.detail.value;
  },


  bindDateChange:function(e){
    this.setData({

      dates:e.detail.value
    })
    
  },


  bindTimeChange(e) {
    this.setData({

      times: e.detail.value
    })

  },


  handleSubmit() {
    if (this.data.address === "2~100个字" || !this.data.address)
      wx.showToast({
        title:"请填写地址",
        icon:'loading',
        duration: 2000
      })
      return;
      if(!this.staticData.message) 
      wx.showToast({
        title: "请填写事件名",
        icon: 'loading',
        duration: 2000
      })
    return;
    if (!this.staticData.address)
      wx.showToast({
        title: "请填写事件地点",
        icon: 'loading',
        duration: 2000
      })
    return;
    if (!this.staticData.things)
      wx.showToast({
        title: "请填写事件描述",
        icon: 'loading',
        duration: 2000
      })
    return;
  }





})
  