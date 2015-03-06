<%@ page contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<!-- %@ taglib prefix="c" uri="http://java.sun.com/jsp/jst1/core" %-->
<%@ taglib uri='/struts-tags' prefix='s' %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>在线商品拍卖</title>
    <meta http-equiv="Content-Type" content="text/html;charset=GBK">
    <link href="/zxpm/style/mycss.css" rel="stylesheet" type="text/css" />
    <link href="/zxpm/style/texts.css" rel="stylesheet" type="text/css" />
    <link href="/zxpm/style/btn.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        .table_title{
                     border:solid 1px #aaa;
                     border-width:0 0 1px 0;
                    }
    </style>
  </head>
  
  <body bgcolor=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 valign="top">
      <table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
             <td colspan="5"><img src="../images/top.bmp" width="780" height="213"/></td>
          </tr>
          <tr>
             <td colspan="5"><img src="../images/middle1.bmp" width="780" height="47"/></td>
          </tr>
          <tr>
             <td width="38" background="../images/middle2.bmp">&nbsp;</td>
             <td width="172" valign"top"><%@ include file="in.jsp" %></td>
             <td width="35" background="../images/layout_24.gif">&nbsp;</td>
             <td width="495">
                 <table width="479" height="287" style="height:287px;">
                     <tr>
                         <td width="3%">&nbsp;</td>
                         <td width="97%">
                             <script type="text/javascript">
                                function SwitchDisplay(oid){
                                    var o = document.getElementById(oid);
                                    if(o){
                                       if(o.style.display == "none"){
                                           o.style.display = "block";
                                       }else{
                                           o.style.display = "none";
                                       }
                                    }
                                }
                             </script>
                             <div id="middle">
                                 <div class="m_title"></div>
                                 <div class="bar"></div>
                                 <div class="m_content" style="height:369px;width:440px;overflow-y:scroll;">
                                    <s:action name="toOnSaleGoodsList" namespace="/goods" executeResult="true"/>
                                 </div>
                             </div>
                          </td>
                       </tr>
                       <tr>
                          <td colspan="2"></td>
                       </tr>
                 </table>
             </td>
             <td width="40" background="../images/middle4.bmp">&nbsp;</td>
          </tr>
          <tr>
             <td colspan="5"><img src="../images/bottom.bmp" width="780" height="82"/></td>
          </tr>       
      </table>
      <p align="">版权所有</p>
      <br>
  </body>
</html>
