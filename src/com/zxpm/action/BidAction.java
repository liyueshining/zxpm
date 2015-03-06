package com.zxpm.action;

import com.zxpm.entity.Users;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zxpm.biz.BidBiz;
import com.zxpm.biz.GoodsBiz;
import com.zxpm.biz.UserBiz;
import com.zxpm.entity.Bid;
import com.zxpm.entity.Goods;

public class BidAction extends ActionSupport implements RequestAware,SessionAware{

	//使用GoodsBiz声明goodsBiz对象，并添加set方法用于依赖注入
	GoodsBiz goodsBiz;
	public void setGoodsBiz(GoodsBiz goodsBiz){
		this.goodsBiz = goodsBiz;
	}
	
	//使用BidBiz声明bidBiz对象，并提供依赖注入
	BidBiz bidBiz;
	public void setBidBiz(BidBiz bidBiz){
		this.bidBiz = bidBiz;
	}
	
	//使用UserBiz声明userBiz对象，提供依赖注入方法
	UserBiz userBiz;
	public void setUserBiz(UserBiz userBiz){
		this.userBiz = userBiz;
	}
	
	
	Map<String, Object> request;
	Map<String, Object> session;
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	//声明属性myBidPrice，用于封装表单参数
	private Float myBidPrice;
	public Float getMyBidPrice(){
		return myBidPrice;
	}
	public void setMyBidPrice(Float myBidPrice){
		this.myBidPrice = myBidPrice;
	}
	
	//声明对象goods，用于封装表单参数
	private Goods goods;
	public Goods getGoods(){
		return goods;
	}
	public void setGoods(Goods goods){
		this.goods = goods;
	}
	
	
	//声明属性bidId和buyerId,用于封装用户提交的参数
	private int bidId;
	private int buyerId;
	public int getBuyerId(){
		return buyerId;
	}
	public void setBuyerId(int buyerId){
		this.buyerId = buyerId;
	}
	public int getBidId(){
		return bidId;
	}
	public void setBidId(int bidId){
		this.bidId = bidId;
	}
	
	private int goodsId;
	public void setGoodsId(int goodsId){
		this.goodsId = goodsId;
	}
	//提交我的报价
	public String doSubmitBid(){
		System.out.println("myBidPrice:  "+myBidPrice);
		//goods对象中封装了出价页面通过隐藏表单域传递的商品编号参数
		//int goodsId = goods.getGoodsId().intValue();
		System.out.println("goodsId:  "+goodsId);
		//根据商品编号获取商品信息
		Goods goodss = goodsBiz.getGoodsByGoodsId(goodsId);
		//从session中取出登陆用户对象，作为出价时商品的买家
		Users buyer = (Users)session.get("user");
		//调用业务方法向数据库表bid中写入记录
		bidBiz.addBid(goodss, buyer, myBidPrice);
		return "index";
	}
	
	
	//成交
	public String doDeal(){
		//根据编号从数据表bid中获取出价记录
		Bid bid = bidBiz.getBid(bidId);
		//根据关联关系，从出价记录中获取商品对象
		Goods goods = bid.getGoods();
		//成交后，将获取的出价记录状态改为2
		bid.setBidStatus(new Integer(2));
		//将数据表bid中的出价记录更新
		bidBiz.updateBid(bid);
		//根据买家编号获取买家用户对象
		Users buyer = userBiz.getUsersById(buyerId);
		//将数据表goods中的成交商品的状态设置为2，表示该商品已成交
		goods.setGoodsStatus(new Integer(2));
		//设置数据表goods中成交商品的买家
		goods.setBuyer(buyer);
		//更新数据goods
		goodsBiz.updateGoods(goods);
		return "index";
	}


}
