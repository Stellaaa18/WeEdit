// pages/informLeaveMsg/informLeaveMsg.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  //确认发布
  goDetail: function (e) {

    const data = Object.assign({}, this.staticData, {

    })

    setTimeout(() => {
      var subValue = e.detail.value.textarea
      console.log(subValue)
      if (subValue == null || subValue == "") {
        console.log("不能为空")
        this.setData(
          { popErrorMsg: "发布的留言内容不能为空" }
        );
        this.ohShitfadeOut();
        return;
      }

    }, 100)


    wx.request({
      url: 'https://nuanwan.wekeji.cn/student/index.php/trade/add_item',
      data: data,
      method: "POST",
      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      success: this.handleSubmitSucc.bind(this)
    })


  },

  commentTxtFn(e){

this.staticData.Signmessage = e.detail.value;

  },


  //定时器提示框3秒消失
  ohShitfadeOut() {
    var fadeOutTimeout = setTimeout(() => {
      this.setData({ popErrorMsg: '' });
      clearTimeout(fadeOutTimeout);
    }, 3000);
  },


  fileOperation: function () {

    //下载文件
    wx.downloadFile({
      url: "http://91ruankao.com/wx.doc",
      // type: 'image', // 下载资源的类型，用于客户端识别处理，有效值：image/audio/video
      // header: {}, // 设置请求的 header
      success: function (res) {
        // success

        console.log("downloadFile------success")

        //获取下载文件路径
        var filePath = res.tempFilePath
        console.log("filePath------", filePath)

        //保存文件到本地
        lmy_SaveFile(filePath)

        //打开文件
        lmy_openDocument(filePath)

      },
      fail: function () {
        // fail
        console.log("downloadFile------fail")
      },
      complete: function () {
        // complete
        console.log("downloadFile------complete")
      }
    })
  },
  userSetData: function () {
    wx.navigateTo({
      url: '../demoSetData/demoSetData'
    })
  },
  userUtil: function () {

    this.setData({
      dateString: util.formatTime(new Date("2017031893030"))
    })
  },

/*打开文件结束*/


submit(){

  const data = Object.assign({}, this.staticData, {
   
  })


 /* if (!this.staticData.Signmessage) {
    wx.showToast({
      title: "请填写事件描述",
      icon: 'loading',
      duration: 2000
    })
    return;
  }*/




}





})
