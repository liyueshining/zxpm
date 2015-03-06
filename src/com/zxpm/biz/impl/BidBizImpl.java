package com.zxpm.biz.impl;

import com.zxpm.entity.Users;

import java.util.Date;

import com.zxpm.biz.BidBiz;
import com.zxpm.dao.BidDAO;
import com.zxpm.entity.Bid;
import com.zxpm.entity.Goods;

public class BidBizImpl implements BidBiz{

	//使用BidDAO接口声明对象bidDAO，并添加set方法用于依赖注入
	private BidDAO bidDAO;
	public void setBidDAO(BidDAO bidDAO){
		this.bidDAO = bidDAO;
	}
	
	//添加出价记录
	public void addBid(Goods goods, Users buyer, float myBidPrice) {
		
		//创建Bid类
		Bid bid = new Bid();
		//设置出价记录
		bid.setBidPrice(new Float(myBidPrice));
		//设置成交状态为1
		bid.setBidStatus(new Integer(1));
		//设置出价时间
		bid.setBidTime(new Date());
		//设置出价记录中商品的买家
		bid.setBuyer(buyer);
		//根据关联关系，设置出价记录中的商品编号
		bid.setGoods(goods);
		bidDAO.add(bid);
		
	}

	public Bid getBid(int bidId) {
		Bid bid = bidDAO.get(bidId);
		return bid;
	}

	public void updateBid(Bid bid) {
		bidDAO.updateBid(bid);
	}

}
