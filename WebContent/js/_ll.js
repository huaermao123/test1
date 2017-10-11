function _ll(){
	var img=document.getElementById("_img");
	/*
	 * 获取隐藏的div的id
	 *  再进行添加样式
	 */
	var _sl=document.getElementById("shop_li");
	 var _style="transition: height 0.2s;height: 150px;width:210px; border: 1px solid green;overflow: hidden";
		 _sl.setAttribute("style",_style);
	if(img.src.match("55646.png")){
		img.src="img/55525.png";
		 
		          
		
	}else{
		var _sl=document.getElementById("shop_li");
	 var _style="transition: height 0.2s;height: 0px;width:210px; border: 1px solid green;overflow: hidden";
		 _sl.setAttribute("style",_style);
		img.src="img/55646.png";
	}
}


function _ll2(){
	var img=document.getElementById("_img2");
	/*
	 * 获取隐藏的div的id
	 *  再进行添加样式
	 */
	var _sl=document.getElementById("order_gl");
	 var _style="transition: height 0.2s;height: 35px;width:210px; border: 1px solid green;overflow: hidden";
		 _sl.setAttribute("style",_style);
	if(img.src.match("55646.png")){
		img.src="img/55525.png";
		 
		          
		
	}else{
		var _sl=document.getElementById("order_gl");
	 var _style="transition: height 0.2s;height: 0px;width:210px; border: 1px solid green;overflow: hidden";
		 _sl.setAttribute("style",_style);
		img.src="img/55646.png";
	}
}

