package com.zxpm.action;

import com.zxpm.entity.Users;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zxpm.biz.GoodsBiz;
import com.zxpm.entity.Goods;

public class GoodsAction extends ActionSupport implements RequestAware,SessionAware{

	//使用GoodsBiz声明goodsBiz对象，并添加set方法用于依赖注入
	GoodsBiz goodsBiz;
	public void setGoodsBiz(GoodsBiz goodsBiz){
		this.goodsBiz = goodsBiz;
	}
	
	Map<String, Object> request;
	Map<String, Object> session;
	
	public void setSession(Map<String, Object> session) {
		this.session = session;		
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;		
	}

	//使用Goods实体类声明属性goods，用于封装参数
	private Goods goods;
	public Goods getGoods(){
		return goods;
	}
	public void setGoods(Goods goods){
		this.goods = goods;
	}
	
	//在拍商品列表
	public String toOnSaleGoodsList(){
		List onSaleGoodsList = goodsBiz.getOnSaleGoodsList();
		System.out.println("onSaleGoodsList: "+onSaleGoodsList.size());
		request.put("onSaleGoodsList", onSaleGoodsList);
		
		System.out.println("list's size= "+ ((List)request.get("onSaleGoodsList")).size());
		return "onSaleGoodsList";
	}
	
	//添加在拍商品
	public String toAddGoodsInfo(){
		//从session中获取上传文件的相对路径
		String filepath = (String)session.get("filepath");
		System.out.println("filepath: "+filepath);
		goods.setGoodsPic(filepath);
		Users saler = (Users)session.get("user");
		System.out.println("saler : "+saler.getUserName());
		goods.setGoodsStatus(new Integer(1));
		//新添加的在拍商品，卖家和买家相同
		goods.setBuyer(saler);
		goods.setSaler(saler);
		goodsBiz.addGoods(goods);
		return "index";
	}
	
	//我发布的在拍商品列表
	public String toMyGoods(){
		Goods goods = new Goods();
		//从session中取出商品的卖家
		Users saler = (Users)session.get("user");
		goods.setSaler(saler);
		//要求商品状态为1表示该商品未拍出
		goods.setGoodsStatus(new Integer(1));
		//根据指定条件查询商品信息，即商品卖家为登陆用户的商品列表
		List mygoodsList = goodsBiz.getGoods(goods);
		request.put("mygoodslist", mygoodsList);
		return "mygoods";
	}
	
	int goodsId;
	public void setGoodsId(int goodsId){
		this.goodsId = goodsId;
	}
	//我要出价
	public String doBid(){
		//从goods对象中获取通过查询字符串传递的商品编号
		//int goodsId = (Integer)request.get("goodsId");
		//int goodsId = goods.getGoodsId();
		
		
		//根据商品编号获取商品信息并保存，以便在出价页面显示
		Goods g = goodsBiz.getGoodsByGoodsId(goodsId);
		request.put("g", g);
		//页面跳转到goods_bid.jsp
		return "goodsbid";
	}
}
