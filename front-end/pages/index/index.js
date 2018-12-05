Page({



messageBtn:function(options){

wx.switchTab({
  url: '../message/message',
})

},


  SignBtn: function (options) {

  wx.switchTab({
    url: '../Sign/Sign',
  })

},


  /**
   *    * 页面的初始数据
   *    */

  /**
   * 页面的初始数据
   */
  data: {
    imgUrls: [
      '/image/海报/hello.png',
      '/image/海报/首页转换图片.png'
    ],
    indicatorDots: true,
    interval: 5000,
    duration: 1000,
    autoplay: true,  /*自动播放海报*/
    array: []
  },





  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var array = this.initData();
    this.setData({ array: array });
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



  initData: function () {
    var array = [];

    var object1 = new Object();
    object1.img = '/image/海报/酒店.png';
    object1.title = '投票一周日去哪里玩';
    object1.type = '2018-11-12  12:10';
    object1.pinglun = '发起人：组长';
    array[0] = object1;

    var object2 = new Object();
    object2.img = "/image/海报/文档.png";
    object2.title = "共享文档——小组会议报告";
    object2.type = "2018-11-11   12:30";
    object2.pinglun = "发起人：XXX";
    array[1] = object2;



    return array;
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