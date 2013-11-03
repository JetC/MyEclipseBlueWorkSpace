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
    
    <title>My JSP 'Hbsy2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="../css/hdjy.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript">
var enterTime;
var closeTime;
var lookingTime;
var ip;
var FK_id;
var type="文化活动纪要";
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
	ip="<s:property value="s_ip"/>";
	FK_id="<s:property value="h.id"/>";
	enterTime=enterTime.getTime();
	closeTime=closeTime.getTime();	
	xmlHttp.open("POST","hdjy/hdjy_sta",true);
	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlHttp.send("s_totalTime="+lookingTime+"&s_ip="+ip+
	"&s_type="+type+"&FK_id="+FK_id+"&s_enterTime="+enterTime+"&s_closeTime="+closeTime);
}
</script>
  </head>

  <body  onload="getEnterTime()" onunload="getLookingTime()">
   
  <script language="javascript" src="js/hdjy.js"></script><center>
<jsp:include page="../head.jsp"/>
<table width="1024" border="0">
      <tr>
        <td width="214" height="191" style="background:url(hdjy/images/hdjy_small.png) no-repeat" valign="top">
        <br/><br/><br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;浏览量最多:<br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>
        <a href="<s:url value="/hdjy/hdjy_look.action">
              		   <s:param name="id" value="numRankId[0]"/>
           			   </s:url>" ><s:property value="numRank[0]"/></a><br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>
        <a href="<s:url value="/hdjy/hdjy_look.action">
              		   <s:param name="id" value="numRankId[1]"/>
           			   </s:url>" ><s:property value="numRank[1]"/></a><br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>
        <a href="<s:url value="/hdjy/hdjy_look.action">
              		   <s:param name="id" value="numRankId[2]"/>
           			   </s:url>" ><s:property value="numRank[2]"/></a><br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>
        <a href="<s:url value="/hdjy/hdjy_look.action">
              		   <s:param name="id" value="numRankId[3]"/>
           			   </s:url>" ><s:property value="numRank[3]"/></a>
        </td>


<td width="800" rowspan="3" valign="top" align="center">
<!-- 右下区域800px         -->
<div style="margin-bottom: 0;">
		<table width="750px">
			<tr height="49px">
				<td valign="middle"
					style="background:url(hdjy/images/hdjy.png) no-repeat  " align="right">您现在的位置:首页&gt;
					文化活动纪要</td>
			</tr>
			<tr>
				<td align="center"><h1>
						<s:property value="h.a_title" />
					</h1>
				</td>
			</tr>
			<tr>
				<td bgcolor="#F7F7F7" align="center">作者:管理员&nbsp;发布于:${dateString}&nbsp;类型:<s:property value="h.a_type" />&nbsp;浏览次数:<s:property
						value="h.e_count" />&nbsp;文字:<a href="javascript:font_big()">【大】</a>
						<a href="javascript:font_middle()">【中】</a>
						<a href="javascript:font_small()">【小】</a>
				</td>
			</tr>
			<tr>
				<td><label style="background-color: #C0C0C0;font-size: 24px">摘要:</label>
				<div id="hdjylook1">
						<s:property value="h.a_abstract" />
					</div>
				</td>
			</tr>
			<tr>
				<td width="750" valign="top"><label
					style="background-color: #C0C0C0;font-size: 24px">详细说明:</label>
					<div id="middle_image">
						<s:property value="h.a_detail" />
					</div> <br /></td>
			</tr>

		</table>
	</div>


</td>
      </tr>
      <tr>
        <td height="253"  style="background:url(images/zyhyjy.png) no-repeat" valign="top">
		<br/><br/><br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>测试数据1<br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>测试数据2<br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>测试数据3<br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>测试数据4<br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>测试数据5<br/>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="hdjy/images/hdjy_head.png"  width="20px" height="20px"/>测试数据6<br/>


		</td>
      </tr>
     
    </table>
    <jsp:include page="../foot.jsp"/>
  </center>
  </body>
</html>
