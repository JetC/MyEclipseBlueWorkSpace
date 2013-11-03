function font_big(){
	document.getElementById("hbsylook1").style.fontSize="18px";
	document.getElementById("hbsy_id1").style.fontSize="18px";
}
function font_middle(){
	document.getElementById("hbsylook1").style.fontSize="14px";
	document.getElementById("hbsy_id1").style.fontSize="14px";
}
function font_small(){
	document.getElementById("hbsylook1").style.fontSize="12px";
	document.getElementById("hbsy_id1").style.fontSize="12px";
}
function check_hbsyadd(){
	var s1=document.getElementById("hbsy_e_name").value;
	var s2=document.getElementById("hbsy_e_detail").value;
	var s3=document.getElementById("hbsy_e_type").value;
	if(s1.length==0){
		alert('环保术语的名称不能为空!');
		return false;
	}
	else{
		if(s2.length==0){
			alert('环保术语的解释介绍不能为空!');
			return false;
		}
		else{
			if(s3.length==0){
				alert('请输入或选择环保术语的类型');
				return false;
			}
		}
	}
	return true;
}
function change_hbsy_type(){
	var s=document.getElementById("select_types").value;
	document.getElementById("hbsy_e_type").value=s;
}


