/**
 * 获得请求参数的JQuery插件
 */

$.extend({
	
	getParam:function(key) {
		var url = location.href;
				
		var index = url.indexOf('?');//返回url中问好的位置
		
		var str = url.substring(index + 1);
		
		var arr = str.split('&');
		
		for(var i = 0;i < arr.length;i ++) {
			//根据 = 分解字符串
			var param = arr[i].split('=');
			
			//判断参数名是否一致
			if(param[0] == key) 
				return param[1];
			
		}
	}
	
});
