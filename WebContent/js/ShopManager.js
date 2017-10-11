var arrs=[
      {"atext":"19","_img":"img/P.png","yw":"好一条金鱼","btext":"9","_img01":"img/O.png","btext01":"1","ctext":"修改","img_02":"img/xiugai.png",
      "dtext":"删除","img_03":"img/shanchu.png"},
    {"atext":"19","_img":"img/P.png","yw":"好一条金鱼","btext":"9","_img01":"img/I.png","btext01":"1","ctext":"修改","img_02":"img/xiugai.png",
      "dtext":"删除","img_03":"img/shanchu.png"},
          {"atext":"19","_img":"img/P.png","yw":"好一条金鱼","btext":"9","_img01":"img/I.png","btext01":"1","ctext":"修改","img_02":"img/xiugai.png",
      "dtext":"删除","img_03":"img/shanchu.png"},
         {"atext":"19","_img":"img/P.png","yw":"好一条金鱼","btext":"9","_img01":"img/I.png","btext01":"1","ctext":"修改","img_02":"img/xiugai.png",
      "dtext":"删除","img_03":"img/shanchu.png"},
         {"atext":"19","_img":"img/P.png","yw":"好一条金鱼","btext":"9","_img01":"img/I.png","btext01":"1","ctext":"修改","img_02":"img/xiugai.png",
      "dtext":"删除","img_03":"img/shanchu.png"},
         {"atext":"19","_img":"img/P.png","yw":"好一条金鱼","btext":"9","_img01":"img/I.png","btext01":"1","ctext":"修改","img_02":"img/xiugai.png",
      "dtext":"删除","img_03":"img/shanchu.png"}
    ];
function _onload(){
	//获取table
	var _mtb=document.getElementById("tf");
	_mtb.cellPadding="0px";
     _mtb.cellSpacing="0px";
     _mtb.border="0px";
for(var i=0;i<arrs.length;i++){
		var tri="_tr"+i;
	    tri=document.createElement("tr");
	    var style01="height:50px";
	    tri.setAttribute("style",style01);
 	    _mtb.appendChild(tri);
 	  //第一列的内容
 	  var _td1=document.createElement("td");
 	  tri.appendChild(_td1);
 	  //添加checkbox
 	  var _input=document.createElement("input");
 	  var _type="checkbox";
 	  _input.setAttribute("type",_type);
 	  var _style="width:20px;height:20px";
 	  var _idi="input"+i;
 	  var name="inp";
 	  _input.setAttribute("name",name);
 	  _input.setAttribute("id",_idi);
 	  _input.setAttribute("style",_style);
 	  _td1.appendChild(_input);
 	     //第二列的内容
 	    var _td2=document.createElement("td");
 	     tri.appendChild(_td2);
 		var _a=document.createElement("a");
 		
 	    _td2.appendChild(_a);
 	    var _text=document.createTextNode(arrs[i].atext);
 	    _a.appendChild(_text);
	      //第仨列的内容
	     var _td3=document.createElement("td");
 	     tri.appendChild(_td3);
 	       //添加图片
 	     var img=document.createElement("img");
 	     var _src=arrs[i]._img;
 	     var _style_01="text-align:left;height:100px";
 	      _td3.setAttribute("style",_style_01);
 	      img.setAttribute("src",_src);
 	      _td3.appendChild(img);
 	     //添加文本
 	     var imga=document.createElement("p");
 	     _td3.appendChild(imga);
 	     var sty="margin-top:-50px;margin-left:100px";
 	      imga.setAttribute("style",sty);
 	      var imgtext=document.createTextNode(arrs[i].yw);
 	     imga.appendChild(imgtext);
 	     //第四列
 	      var _td4=document.createElement("td");
 	     tri.appendChild(_td4);
	 	  var _a=document.createElement("a");
	 	  _td4.appendChild(_a);
	 	  var _text=document.createTextNode(arrs[i].btext);
	 	  _a.appendChild(_text);
 	     //第五列
 	      var _td5=document.createElement("td");
 	     tri.appendChild(_td5);
	 	  var  _img_01=document.createElement("img");
	 	  _td5.appendChild(_img_01);
	 	  var _src01=arrs[i]._img01;
	 	  _img_01.setAttribute("src",_src01);
 	     //第六列
 	     var _td6=document.createElement("td");
 	     tri.appendChild(_td6);
	 	 var _a02=document.createElement("a");
	 	 _td6.appendChild(_a02);
	 	 var _text=document.createTextNode(arrs[i].btext01);
	 	 _a02.appendChild(_text);
	    //第七列
	      var _td7=document.createElement("td");
 	      tri.appendChild(_td7);
		  var _a03=document.createElement("a");
		  var _href="#";
 		_a03.setAttribute("href",_href);
		 _td7.appendChild(_a03);
		 var _text=document.createTextNode(arrs[i].ctext);
		 _a03.appendChild(_text);
		 	  
		 var im_g=document.createElement("img");
		 var _src=arrs[i].img_02;
		 var _style="width:20px;height:20px";
		 im_g.setAttribute("style",_style);
		 im_g.setAttribute("src",_src);
		 _td7.appendChild(im_g);
		 	  
		 	  
		 var _a04=document.createElement("a");
		 var _href="#";
 		_a04.setAttribute("href",_href);
		 _td7.appendChild(_a04);
		 var _text=document.createTextNode(arrs[i].dtext);
		 _a04.appendChild(_text);
		 var d=document.createElement("img");
		 var _src_d=arrs[i].img_03;
		 var _style="width:20px;height:20px"
		 d.setAttribute("style",_style);
		 d.setAttribute("src",_src_d);
		 _a04.appendChild(d);
		 	     
 	     
	} 	 
 }
	




























