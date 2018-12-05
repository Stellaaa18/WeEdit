// pages/me/me.js

//获取应用程序事例
var instance=getApp();
var me=require("../../public/publlic.js")

Page({

  /**
   * 页面的初始数据
   */
  data: {
       name:"Jimon",


       name:"Jimon",

       message:"测试内容绑定",  /**内容的绑定，数据传递。 */
       id:"test",
       condition:true,   /**控制真假属性， */
        flag:false,
        conditions:20,
           a:1,
           b:2,
           c:8,

    object:{
       key:"hahahahahaahah",
    },
  array:[1,'hihi','heheehe',"ii"],
  zero:"yesyesyesyes"
  
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log("打开我的界面。")
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  console.log("界面初次渲染完成。")
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  console.log(instance.testText);
      me.sayHello(this.data.name);
/**console.log(this.data.flag);*/

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
        console.log("下拉更新成功。")
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