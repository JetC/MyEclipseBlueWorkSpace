function font_big(){
	document.getElementById("hyjylook1").style.fontSize="18px";
	document.getElementById("middle_image").style.fontSize="18px";
}
function font_middle(){
	document.getElementById("hyjylook1").style.fontSize="14px";
	document.getElementById("middle_image").style.fontSize="14px";
}
function font_small(){
	document.getElementById("hyjylook1").style.fontSize="12px";
	document.getElementById("middle_image").style.fontSize="12px";
}
function check_hyjyadd(){
	var s1=document.getElementById("hyjy_m_title").value;
	var s2=document.getElementById("hyjy_m_detail").value;
	var s3=document.getElementById("hyjy_m_type").value;
	if(s1.length==0){
		alert('��Ҫ�����Ҫ�����ⲻ��Ϊ��!');
		return false;
	}
	else{
		if(s2.length==0){
			alert('��Ҫ�����Ҫ�Ľ��ͽ��ܲ���Ϊ��!');
			return false;
		}
		else{
			if(s3.length==0){
				alert('�������ѡ����Ҫ�����Ҫ������');
				return false;
			}
		}
	}
	return true;
}
function change_hyjy_type(){
	var s=document.getElementById("select_types").value;
	document.getElementById("hyjy_m_type").value=s;
}