<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>  
  <body>
    <form action="sendMail" method="get">
       <table border="1">
          <tr>
             <td>��¼��:</td>
             <td><input type="text" name="username"/></td>
          </tr>
          <tr>
             <td>��¼����:</td>
             <td><input type="password" name="password"/></td>
          </tr>
          <tr>
             <td>�ʼ�����:</td>
             <td><input type="text" name="subject"/></td>
          <tr>
             <td>������:</td>
             <td> <input type="text" name="sender"/></td>
          </tr>
          <tr>
             <td>�ռ���:</td>
             <td><input type="text" name="reciver"/></td>
          </tr>
          <tr>
             <td>��Ϣ:</td>
             <td><TEXTAREA  name="message"  rows="10" cols="30"></TEXTAREA></td>
          </tr>
          <tr>
             <td>����:</td>
             <td>
             
               <input type="file" name="path"/>
             </td>
          </tr>
         <tr>
            <td  colspan="2" align="center">
               <input type="submit" value="����"/>
               <input type="reset" value="����"/>
            </td>
         </tr>
       </table>
    </form>
  </body>
</html>
