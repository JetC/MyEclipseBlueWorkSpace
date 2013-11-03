<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'head.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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

  </head>

<center>

    <table width="1024" border="0" style="display:block;margin:0 0 0 0;">
      <tr>
        <td width="287" rowspan="3" align="left" valign="top"><img src="images/logo.gif" width="250" height="80"></td>
        <td width="289" height="61" rowspan="2">&nbsp;</td>
        <td align="right" style="height:30px;">
        <div style="float:right;margin-top:-2px;"><a href="mailto:g7733pf@gmail.com" style="text-decoration: none;color:#83B462;font-size: 12px;">联系我们</a>&nbsp;&nbsp;&nbsp;&nbsp;</div>
        <img src="images/contact.png" width="16" height="14" style="display: block;float: right;">
        <div style="float:right;"><a  href="javascript:addBookmark('百度','http://www.baidu.com')" style="text-decoration: none;color:#83B462;font-size: 12px;">加入收藏&nbsp;</a></div>
        <img src="images/fav.png" width="16" height="14" style="display: block;float: right;margin-top: 1.5px;">
        <div style="float:right;"><a href="/qkdd/qkdd/findex" onClick="setHome('http://www.baidu.com');" style="text-decoration: none;color:#83B462;font-size: 12px;">设为首页&nbsp;</a></div>
        <img src="images/gobackhome.png" width="16" height="14" style="display: block;float: right;margin-top: 1.5px;">
        </td>
      </tr>
      <tr>
        <td colspan="2"  style="background:url(images/menu.png) no-repeat; color:#FFF; font-size:14px" valign="middle">
        <div style="margin:0 0 5px 0;">
        <table width="726" height="33" border="0">
          <tr align="center" style="color:#FFF; font-size:12px" >
            <td width="60"><a href="/pgepsp" style="color:#ffffff;text-decoration: none;">首页</a></td>
            <td width="84"><a href="hbsy/hbsy_index_look.action" style="color:#ffffff;text-decoration: none;">环保术语</a></td>
            <td width="88"><a href="hyjy/hyjy_index_look.action" style="color:#ffffff;text-decoration: none;">会议纪要</a></td>
            <td width="115"><a href="hdjy/hdjy_index_look.action" style="color:#ffffff;text-decoration: none;">文化活动纪要</a></td>
            <td width="158"><a href="/pgepsp/qkdd/findex" style="color:#ffffff;text-decoration: none;">电子报纸与期刊导读</a></td>
            <td width="96"><a href="/pgepsp/picture/listPicture.jsp" style="color:#ffffff;text-decoration: none;">图片影像</a></td>
            <td width="95"><a href="/pgepsp/message/message.jsp" style="color:#ffffff;text-decoration: none;">留言板</a></td>
          </tr>
        </table>
        </div>
        </td>
      </tr>
    </table>
    <img src="images/banner.png" width="1024" height="242">
    </center>
