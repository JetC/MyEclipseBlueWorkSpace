<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>  
  <body>
    <form action="sendMail" method="get">
       <table border="1">
          <tr>
             <td>登录名:</td>
             <td><input type="text" name="username"/></td>
          </tr>
          <tr>
             <td>登录密码:</td>
             <td><input type="password" name="password"/></td>
          </tr>
          <tr>
             <td>邮件主题:</td>
             <td><input type="text" name="subject"/></td>
          <tr>
             <td>发件人:</td>
             <td> <input type="text" name="sender"/></td>
          </tr>
          <tr>
             <td>收件人:</td>
             <td><input type="text" name="reciver"/></td>
          </tr>
          <tr>
             <td>消息:</td>
             <td><TEXTAREA  name="message"  rows="10" cols="30"></TEXTAREA></td>
          </tr>
          <tr>
             <td>附件:</td>
             <td>
             
               <input type="file" name="path"/>
             </td>
          </tr>
         <tr>
            <td  colspan="2" align="center">
               <input type="submit" value="发送"/>
               <input type="reset" value="重置"/>
            </td>
         </tr>
       </table>
    </form>
  </body>
</html>
