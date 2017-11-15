//后端访地址前缀
var baseUrl = 'http://localhost:7777/hr';

//全局ajax事件，处理ajax请求超时问题
$.ajaxSetup({
	complete:function(xhr,textStatus){
		//通过ajax核心对象获得响应报头
		var sessionStatus = xhr.getResponseHeader('sessionStatus');
		
		if(sessionStatus == 'timeout'){
			alert('登录超时');
			location.href= baseUrl + '/loginout.jsp';
		}
		
	}
})
