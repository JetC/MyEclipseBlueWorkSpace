<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd ">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<!--加入收藏代码-->
<script language="javascript">   
	function addBookmark(title,url) {   
		if (window.sidebar) {   
		window.sidebar.addPanel(title, url,"");   
		} else if( document.all ) {   
		window.external.AddFavorite( url, title);   
		} else if( window.opera && window.print ) {   
		return true;   
		}   
		}   
	function setHome(url)   
		{   
		if (document.all){   
		document.body.style.behavior='url(#default#homepage)';   
		document.body.setHomePage(url);   
		}else if (window.sidebar){   
		if(window.netscape){   
		try{   
		netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");   
		}catch (e){   
		alert( "该操作被浏览器拒绝，如果想启用该功能，请在地址栏内输入 about:config,然后将项 signed.applets.codebase_principal_support 值该为true" );   
		}   
		}   
		if(window.confirm("你确定要设置"+url+"为首页吗？")==1){   
		var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);   
		prefs.setCharPref('browser.startup.homepage',url);   
		}   
		}   
		}   
</script>
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script type="text/javascript">
/* 文本溢出显示省略号 */
/* 用法：$(".box").ellipsis(50) */
/*box为需要实现的Class*/
(function($){
jQuery.fn.ellipsis = function(maxwidth){
	this.each(function(){
		if ($(this).text().length > maxwidth) {
			$(this).text($(this).text().substring(0, maxwidth));
			$(this).html($(this).html() + '...');
		}
	});};
})(jQuery);
$(document).ready(function(){
	$(".dian").ellipsis(72);
});
</script> 

	<link rel="stylesheet" type="text/css" href="css/CSS.css" />

	<!--[if lte IE 8]>  
	 <link rel="stylesheet" href="css/ie8.css" type="text/css" media="screen, projection" />  
	<![endif]-->  




	<title>网页标题</title>


</head>




<body>

<jsp:include page="head.jsp"/>
<center>
		<div class="contents1">
			<div class="HuanBaoShuYu">

				<h1 class="header_HBSY">环保术语</h1>
				<ul>
				<s:iterator value="hbsList">
					<li><a href="<s:url value="/hbsy/hbsy_look.action">
              		   <s:param name="id" value="id"/>
           			   </s:url>" class="contents_hbsy"><s:property value="e_name"/></a></li>
				</s:iterator>
				</ul>
			</div>


			<div class="HuiYiJiYao">

					<h1 class="header1_HYJY">重要会议纪要</h1>
					<div class="contents_hyjy_1">
						<a href="<s:url value="/hyjy/hyjy_look.action">
              		   <s:param name="id" value="hyj.id"/>
           			   </s:url>" class="contents_hyjy_1"><p class="dian"><s:property value="hyj.m_detail"/></p></a>
					</div>
					<a href="hyjy/hyjy_index_look.action" class="more_hyjy"><img src="images/more.jpg" border="0px"/></a>
					<ul>
						<s:iterator value="hyjList">
						<li><a href="<s:url value="/hyjy/hyjy_look.action">
              		   <s:param name="id" value="id"/>
           			   </s:url>" class="header_hyjy"><s:property value="m_title"/></a></li>
						</s:iterator>
					</ul>


			</div>


			<div class="WenHuaHuoDongJiYao">
				<h1 class="header1_WHHDJY">文化活动纪要</h1>
				<a href="hdjy/hdjy_index_look.action" class="more_whhdjy"><img src="images/more.jpg" border="0px"/></a>
				<div class="headers_whhdjy">
				<ul>
				<s:iterator value="hdjList">
					<li><a href="<s:url value="/hdjy/hdjy_look.action">
              		   <s:param name="id" value="id"/>
           			   </s:url>" class="header_whhdjy"><s:property value="a_title"/></a></li>
				</s:iterator>
				</ul>
				</div>
			</div>
		
		</div>

		<div class="contents2">
		    <div class="DianZiBaoZhi">
				<h1 class="header1_DZBZ">电子报纸与期刊导读</h1>
				<div class="headers_dzbz">
					<ul>
					<s:iterator value="pubReaList">
						<li><a href="<s:url value="/qkdd/fdetail">
  			<s:param name="id" value="id"/>
  		</s:url>" class="header_dzbz"><s:property value="p_title"/></a></li>
					</s:iterator>
					</ul>
				</div>

			</div>
			
			<div class="TuPianYingXiang">
				
				<div class="header1_TPYX">
				<table border="0"  >
		            <tr align="center" style="color:white;font-size:18px;">
		            	<td>图</td>
		            </tr>
		            <tr align="center" style="color:white;font-size:18px;">
		            	<td>片</td>
		            </tr>
		            <tr align="center" style="color:white;font-size:18px;">
		            	<td>影</td>
		            </tr>
		            <tr align="center" style="color:white;font-size:18px;">
		            	<td>像</td>
		            </tr>
	            </table>
				</div>
				
				<div class="Pictures">
					<marquee behavior="alternate" scrollamount="3" direction="right" onMouseOver="this.stop()" onMouseOut="this.start()" >
						<a href=""><img src="images/pic1.jpg"></a>
						<a href=""><img src="images/pic1.jpg"></a>
						<a href=""><img src="images/pic1.jpg"></a>
						<a href=""><img src="images/pic1.jpg"></a>
					</marquee>
				</div>


			</div>
</div>
</center>
 <jsp:include page="foot.jsp"/>
</body>




</html>
