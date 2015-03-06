package com.zxpm.biz;

import java.util.List;

import com.zxpm.entity.Goods;

public interface GoodsBiz {

	//获取在拍商品列表
	public List getOnSaleGoodsList();
	
	//添加待拍商品
	public void addGoods(Goods goods);
	
	//根据条件获取商品列表
	public List getGoods(Goods condition);
	
	
	//根据商品编号获取商品信息
	public Goods getGoodsByGoodsId(int goodsId);
	
	//更新goods
	public void updateGoods(Goods goods);
}
