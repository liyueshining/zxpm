<%@ page contentType="text/html; charset=GBK" pageEncoding="GBK"%>
<%@ taglib uri='/struts-tags' prefix='s' %>
<%@ taglib uri='/WEB-INF/struts-logic.tld' prefix='logic' %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
    <logic:present scope="request" name="onSaleGoodsList">
    	<table border="0">
    		<s:iterator id="goods" value="#request.onSaleGoodsList">
    			<tr>
    			   <td>
    				   <!-- 显示在拍商品信息 -->
    				   <div class="goods_pic"><img src="/zxpm/${goods.goodsPic}" title="${goods.goodsDesc}" style="width:100px;border:dashed 1px green;"/></div>
    				</td>
    			   <td valign="top"><div class="goods_info" style="border:solid 0px blue;">
    			                 <span class="info_title">商品名称</span>&nbsp;<strong>${goods.goodsName}</strong><br/>
    			                 <span class="info_title">卖&nbsp;&nbsp;家</span>&nbsp;<em>${goods.saler.userName}</em><br/>
    			                 <span class="info_title">起拍价</span>&nbsp;<span style="color:green">${goods.goodsPrice}</span><br/>
    			                 
    			                 <!-- 如果用户已经登录，且不是该商品的卖家，则在商品旁显示“我要出价”按钮 -->
    			                 <logic:notEmpty name="user" scope="session">
    			                 	<logic:notEqual name="goods" property="saler.userId" value="${sessionScope.user.userId}">
    			                 		<a class="a_button" href="/zxpm/goods/doBid?goods.goodsId=${goods.goodsId}"><font color="red">我要出价</font></a>
    			                 	</logic:notEqual>
    			                 </logic:notEmpty>
    			                 </div>
    			  </td>
    		    </tr>
    		    
    		    <!-- 在每个商品下显示出价纪录 -->
    		    <logic:notEmpty name="goods" property="bids">
    		    	<tr valign="top">
    		    	     <td>出价纪录：<br>
    		    	        <s:iterator id="b" value="#goods.bids">
    		    	      	   <em><s:property value="buyer.userName"/></em>
    		    	      	   <s:date name="#b.bidTime" format="yyyy-MM-dd hh:mm"/>
    		    	      	   <span style="color:green;font-weight:bold;"><s:property value="bidPrice"/></span><br/>
    		    	      	</s:iterator>
    		    	     </td>
    		    	 </tr>
    		   </logic:notEmpty>
    		</s:iterator>
    	</table>
    </logic:present>
  </body>
</html>
