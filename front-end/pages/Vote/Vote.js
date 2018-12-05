// pages/Vote/Vote.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

    items: [
      { name: 'idea1', value: '考虑到我个人，赞同' },
      { name: 'idea2', value: '未考虑到我的情况，反对', checked: 'true' },
      { name: 'idea3', value: '我有其他的想法' },
     
    ]
    },
 
    staticData:{


    },

 
 
 
  checkboxChange: function (e) {
    console.log('checkbox发生change事件，携带value值为：', e.detail.value)
  },




  commentTxtFn(e){
    this.staticData.otheridea = e.detail.value;
  },
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