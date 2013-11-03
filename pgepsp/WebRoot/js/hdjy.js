function font_big(){
	document.getElementById("hdjylook1").style.fontSize="18px";
	document.getElementById("middle_image").style.fontSize="18px";
}
function font_middle(){
	document.getElementById("hdjylook1").style.fontSize="14px";
	document.getElementById("middle_image").style.fontSize="14px";
}
function font_small(){
	document.getElementById("hdjylook1").style.fontSize="12px";
	document.getElementById("middle_image").style.fontSize="12px";
}
function check_hdjyadd(){
	var s1=document.getElementById("hdjy_a_title").value;
	var s2=document.getElementById("hdjy_a_detail").value;
	var s3=document.getElementById("hdjy_a_type").value;
	if(s1.length==0){
		alert('文化活动纪要的主题不能为空!');
		return false;
	}
	else{
		if(s2.length==0){
			alert('文化活动纪要的解释介绍不能为空!');
			return false;
		}
		else{
			if(s3.length==0){
				alert('请输入或选择文化活动纪要的类型');
				return false;
			}
		}
	}
	return true;
}
function change_hdjy_type(){
	var s=document.getElementById("select_types").value;
	document.getElementById("hdjy_a_type").value=s;
}