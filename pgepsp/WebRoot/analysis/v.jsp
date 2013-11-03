<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'v.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <img src="analysis/todaylooking" width="500" height="400"/>
      <table border="1">
      <tr><td>时段</td><td>浏览量</td></tr>
	  <tr><td>0-1</td><td><s:property value="countList[0]"/></td></tr>
	  <tr><td>1-2</td><td><s:property value="countList[1]"/></td></tr>
	  <tr><td>2-3</td><td><s:property value="countList[2]"/></td></tr>
	  <tr><td>3-4</td><td><s:property value="countList[3]"/></td></tr>
	  <tr><td>4-5</td><td><s:property value="countList[4]"/></td></tr>
	  <tr><td>5-6</td><td><s:property value="countList[5]"/></td></tr>
	  <tr><td>6-7</td><td><s:property value="countList[6]"/></td></tr>
	  <tr><td>7-8</td><td><s:property value="countList[7]"/></td></tr>
	  <tr><td>8-9</td><td><s:property value="countList[8]"/></td></tr>
	  <tr><td>9-10</td><td><s:property value="countList[9]"/></td></tr>
	  <tr><td>10-11</td><td><s:property value="countList[10]"/></td></tr>
	  <tr><td>11-12</td><td><s:property value="countList[11]"/></td></tr>
	  <tr><td>12-13</td><td><s:property value="countList[12]"/></td></tr>
	  <tr><td>13-14</td><td><s:property value="countList[13]"/></td></tr>
	  <tr><td>14-15</td><td><s:property value="countList[14]"/></td></tr>
	  <tr><td>15-16</td><td><s:property value="countList[15]"/></td></tr>
	  <tr><td>16-17</td><td><s:property value="countList[16]"/></td></tr>
	  <tr><td>17-18</td><td><s:property value="countList[17]"/></td></tr>
	  <tr><td>18-19</td><td><s:property value="countList[18]"/></td></tr>
	  <tr><td>19-20</td><td><s:property value="countList[19]"/></td></tr>
	  <tr><td>20-21</td><td><s:property value="countList[20]"/></td></tr>
	  <tr><td>21-22</td><td><s:property value="countList[21]"/></td></tr>
	  <tr><td>22-23</td><td><s:property value="countList[22]"/></td></tr>
	  <tr><td>23-24</td><td><s:property value="countList[23]"/></td></tr>
	  
      </table>
  </body>
</html>
