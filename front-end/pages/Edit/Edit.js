
Page({

  data: {

    text: '字符串',
    address: "2~100个字",

    array: ['单选', '双选', '任意选'],
    objectArray: [
      {
        id: 0,
        name: '单选'
      },
      {
        id: 1,
        name: '双选'
      },
      {
        id: 2,
        name: '任意选'
      }
      
    ],
    index: 0,
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
  handlethingsChange(e) {
    this.staticData.things = e.detail.value;
  },
  handleSubmit() {
    if (this.data.address === "2~100个字" || !this.data.address)
      wx.showToast({
        title: "请先填写完整的事件名",
        icon: 'loading',
        duration: 2000
      })
    return;
    if (!this.staticData.message)
      wx.showToast({
        title: "请填写事件名",
        icon: 'loading',
        duration: 2000
      })
    return;
    if (!this.staticData.address)
      wx.showToast({
        title: "请填写事件名",
        icon: 'loading',
        duration: 2000
      })
    return;
    if (!this.staticData.things)
      wx.showToast({
        title: "请填写事件名",
        icon: 'loading',
        duration: 2000
      })
    return;
  }



})
