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
		alert('�Ļ����Ҫ�����ⲻ��Ϊ��!');
		return false;
	}
	else{
		if(s2.length==0){
			alert('�Ļ����Ҫ�Ľ��ͽ��ܲ���Ϊ��!');
			return false;
		}
		else{
			if(s3.length==0){
				alert('�������ѡ���Ļ����Ҫ������');
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