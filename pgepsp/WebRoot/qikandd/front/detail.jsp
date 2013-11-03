<%@ page language="java" import="java.util.*,javax.servlet.http.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>电子杂志与期刊导读详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="css/qkdd.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
var enterTime;
var closeTime;
var lookingTime;
var ip;
var FK_id;
var type="期刊导读";
function getEnterTime(){
enterTime=new Date();
}
var xmlHttp;
function createXMLHttpRequest(){
	if(window.ActiveXObject){
	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	else if(window.XMLHttpRequest){
	xmlHttp = new XMLHttpRequest();
	}
}
function getLookingTime(){
	createXMLHttpRequest();
	closeTime=new Date();
	lookingTime=closeTime.getTime()-enterTime.getTime();
	ip="<s:property value="ip"/>";
	FK_id="<s:property value="pubRea.id"/>";
	enterTime=enterTime.getTime();
	closeTime=closeTime.getTime();
	xmlHttp.open("POST","/pgepsp/analysis/addsta",true);
	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlHttp.send("totalTime="+lookingTime+"&sta.s_ip="+ip+
	"&sta.s_type="+type+"&sta.FK_id="+FK_id+"&enterTime="+enterTime+"&closeTime="+closeTime);
}
</script>
<script language="javascript" src="js/hbsy.js"></script>
  </head>

  <body  onload="getEnterTime()" onunload="getLookingTime()">
 <center>
<jsp:include page="/head.jsp"/>
    <table width="1024" border="0">
      <tr>
        <td width="214" height="191" style="background:url(images/qkdd_small.gif) no-repeat" valign="top">
<br />
				<br />
				<br />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img
					src="images/hbsy_head.png" width="20px" height="20px" />
					<a href="<s:url value="/qkdd/fclass"><s:param name="key" value="%{'国际环保'}"/></s:url>">国际环保</a> 
					<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img
					src="images/hbsy_head.png" width="20px" height="20px" />
					<a href="<s:url value="/qkdd/fclass"><s:param name="key" value="%{'节能环保'}"/></s:url>">节能环保</a>
					<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img
					src="images/hbsy_head.png" width="20px" height="20px" />
					<a href="<s:url value="/qkdd/fclass"><s:param name="key" value="%{'工程'}"/></s:url>">工程</a>
					<br /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img
					src="images/hbsy_head.png" width="20px" height="20px" />
					<a href="<s:url value="/qkdd/fclass"><s:param name="key" value="%{'热点'}"/></s:url>">热点</a>
        </td>


<td width="800px" rowspan="3" valign="top" align="center">
<!-- 右下区域800px         -->
<div style="margin-bottom: 0;">
		<table width="750px" border="0">
			<tr height="49px">
				<td valign="middle"
					style="background:url(images/qkdd.gif) no-repeat  " align="right">
					<font style="font-size: 12px;">您现在的位置:</font>
					<a style="font-size: 12px;color: #0099ee" href="/pgepsp">首页</a>
					<font style="font-size: 12px;font-weight: bold;color: #aaaaaa">＞</font>
					 <a style="font-size: 12px;color: #0099ee" href="/pgepsp/qkdd/findex">电子报纸与期刊导读</a>
					 </td>
			</tr>
			<tr>
				<td align="center"><h1>
						<s:property value="pubRea.p_title"/>
					</h1>
				</td>
			</tr>
			<tr>
				<td bgcolor="#F7F7F7" align="center">作者:<s:property value="pubRea.p_author"/>
				&nbsp;&nbsp;&nbsp;&nbsp;发布于:<s:property value="time"/>
				&nbsp;&nbsp;&nbsp;&nbsp;浏览次数:<s:property value="pubRea.p_count"/>
				&nbsp;&nbsp;&nbsp;&nbsp;
					文字:<a href="javascript:font_big()" style="font-size: 14px;color: #666666">【大】</a>
						<a href="javascript:font_middle()" style="font-size: 14px;color: #666666">【中】</a>
						<a href="javascript:font_small()" style="font-size: 14px;color: #666666">【小】</a>
				</td>
			</tr>
			<tr>
				<td>
				<div id="hbsylook1" style="margin-bottom: 30px;margin-top: 30px;">
						<div style="margin-bottom:-32px;font-size: 12px;font-weight: bold;">&nbsp;&nbsp;&nbsp;导读:</div>
						<div style="margin-left: 25px;font-size: 13px;margin-top: 18px;"><s:property value="viewPreread" escapeHtml="false"/></div>
				</div>
				</td>
			</tr>
			<tr>
				<td width="750" valign="top">
					<div id="hbsy_id1">
						<img src="<s:url value="/picture1/viewpic"><s:param name="id" value="pubRea.id"/></s:url>" width="320" height="210"/>
						<s:property value="viewDetail" escapeHtml="false"/>
					</div><br /></td>
			</tr>
			<tr><td align="center"><a href="<s:property value="pubRea.p_link" />" style="color: 0000ff;font-size: 12px;">点击查看完整原文</a></td></tr>
		</table>
	</div>


</td>
      </tr>
    </table>
    <jsp:include page="/foot.jsp"/>
  </center>
  </body>
</html>