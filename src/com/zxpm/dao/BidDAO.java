package com.zxpm.dao;

import com.zxpm.entity.Bid;

public interface BidDAO {

	//向数据表bid中添加出价记录
	public void add(Bid bid);
	
	//根据编号从数据表bid中获取出价记录
	public Bid get(int bidId);
	
	//将数据表bid中的出价记录更新
	public void updateBid(Bid bid);
}
