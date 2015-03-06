package com.zxpm.biz;

import com.zxpm.entity.Bid;
import com.zxpm.entity.Goods;
import com.zxpm.entity.Users;

public interface BidBiz {

	//添加出价记录
	public void addBid(Goods goods,Users buyer,float myBidPrice);
	
	//根据编号从数据表bid中获取出价记录
	public Bid getBid(int bidId);
	
	////将数据表bid中的出价记录更新
	public void updateBid(Bid bid);
}
