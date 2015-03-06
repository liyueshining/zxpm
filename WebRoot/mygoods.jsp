 
<%@ page contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<%@ taglib uri='WEB-INF/struts-logic.tld' prefix='logic' %>
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
             <td width="35" background="../images/middle2.bmp">&nbsp;</td>
             <td width="495">
                 <logic:present scope="request" name="mygoodslist">
    	         <table border="0">
    		        <s:iterator id="goods" value="#request.mygoodslist">
    			    <tr>
    				   <td>
    				      <!-- 显示我的在拍商品信息 -->
    				      <div class="goods_pic"><img src="/zxpm/${goods.goodsPic}" title="${goods.goodsDesc}" style="width:100px;border:dashed 1px green;"/></div>
    				   </td>
    				   <td valign="top">
    					  <div class="goods_info" style="border:solid 0px blue;">
    				 		<span class="info_title">商品名称</span>&nbsp;<strong>${goods.goodsName}</strong><br/>
    				 		<span class="info_title">卖&nbsp;&nbsp;家</span>&nbsp;<em>${goods.saler.userName}</em><br/>
    				 		<span class="info_title">起拍价</span>&nbsp;<span style="color:green;">${goods.goodsPrice}</span><br/>
    				     </div>
    				  </td>
    			   </tr>
    			   <!-- 在每个商品下面显示出价记录 -->
    			   <logic:notEmpty name="goods" property="bids">
    			   <tr valign="top">
    			 	  <td>出价记录：<br>
    			 		 <s:iterator id="b" value="#goods.bids">
    			 			<em>${b.buyer.userName}</em>
    			 			<s:date name="#b.bidTime" format="yyyy-MM-dd hh:mm"/>
    			 			<span style="color:green;font-weight:bold;">${b.bidPrice}</span>
    			 			<logic:notEqual name="b" property="bidStatus" value="2">
    			 			   <a class="a_button" href="/zxpm/bid/doDeal?bidId=${b.bidId}&buyerId=${b.buyer.userId}" ><font color="red">成交</font></a>
    			 			</logic:notEqual><br/>
    			 		 </s:iterator>
    			 		 </td>
    			 		</tr>
    			    </logic:notEmpty>
    		      </s:iterator>
    	        </table>
               </logic:present>
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
