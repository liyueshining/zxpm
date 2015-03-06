package com.zxpm.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zxpm.dao.BidDAO;
import com.zxpm.entity.Bid;

public class BidDAOImpl extends HibernateDaoSupport implements BidDAO{

	//向数据表bid中添加记录
	public void add(Bid bid) {
		super.getHibernateTemplate().save(bid);
	}

	public Bid get(int bidId) {
		Bid bid = (Bid)super.getHibernateTemplate().get(Bid.class, new Integer(bidId));
		return bid;
	}

	public void updateBid(Bid bid) {
		super.getHibernateTemplate().update(bid);
	}

}
