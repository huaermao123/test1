function test(){
var sa=document.getElementById("input");
var box1= document.getElementsByName("inp");
    if(sa.checked==true){
	for(var i=0;i<box1.length;i++){
		var value1=box1[i];
		value1.checked=true;
	}
}else{
		for(var j=0;j<box1.length;j++){
		var value2=box1[j];
		value2.checked=false;
	}
  }
}