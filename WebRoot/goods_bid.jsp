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

    			<form action="/zxpm/bid/doSubmitBid" method="post">
    			<!-- 通过隐藏表单域传递商品编号 -->
    			    <s:set name="temp" value="#request.g.goodsId"></s:set>
                    <s:hidden name="goodsId" value="%{temp}"></s:hidden>

    				<table id="advEdit" width="480" height="66">
    					<tr>
    						<td width="20%">商品名称：</td>
    						<td><s:property value="#request.g.goodsName" /></td>
    					</tr>
    					<tr>
    						<td>起拍价格：</td>
    						<td><s:property value="#request.g.goodsPrice" /></td>
    					</tr>
    					<tr>
    						<td><s:textfield label="我的出价" name="myBidPrice" /></td>
    					</tr>
    					<tr><td><s:submit value="提交" align="center" /></td></tr>
    				</table>
    				
    			</form>
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

