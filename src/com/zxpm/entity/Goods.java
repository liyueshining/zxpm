package com.zxpm.entity;
// Generated 2014-8-22 16:03:08 by Hibernate Tools 3.2.0.beta6a


import java.util.HashSet;
import java.util.Set;

/**
 *        represents goods which showed for auction.
 *        @author lee(with help from hibernate)
 *        
 */
public class Goods  implements java.io.Serializable {

    // Fields    

     private Integer goodsId;
     private Users buyer;
     private Users saler;
     private String goodsName;
     private Float goodsPrice;
     private String goodsPic;
     private String goodsDesc;
     private Integer goodsStatus;
     private Set<Bid> bids = new HashSet<Bid>(0);

     // Constructors

    /** default constructor */
    public Goods() {
    }

	/** minimal constructor */
    public Goods(Users buyer, Users saler, String goodsName, Float goodsPrice, Integer goodsStatus) {
        this.buyer = buyer;
        this.saler = saler;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsStatus = goodsStatus;
    }
    /** full constructor */
    public Goods(Users buyer, Users saler, String goodsName, Float goodsPrice, String goodsPic, String goodsDesc, Integer goodsStatus, Set<Bid> bids) {
       this.buyer = buyer;
       this.saler = saler;
       this.goodsName = goodsName;
       this.goodsPrice = goodsPrice;
       this.goodsPic = goodsPic;
       this.goodsDesc = goodsDesc;
       this.goodsStatus = goodsStatus;
       this.bids = bids;
    }
    
   
    // Property accessors
    public Integer getGoodsId() {
        return this.goodsId;
    }
    
    protected void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
    public Users getBuyer() {
        return this.buyer;
    }
    
    public void setBuyer(Users buyer) {
        this.buyer = buyer;
    }
    public Users getSaler() {
        return this.saler;
    }
    
    public void setSaler(Users saler) {
        this.saler = saler;
    }
    public String getGoodsName() {
        return this.goodsName;
    }
    
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public Float getGoodsPrice() {
        return this.goodsPrice;
    }
    
    public void setGoodsPrice(Float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
    public String getGoodsPic() {
        return this.goodsPic;
    }
    
    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }
    public String getGoodsDesc() {
        return this.goodsDesc;
    }
    
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }
    public Integer getGoodsStatus() {
        return this.goodsStatus;
    }
    
    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }
    public Set<Bid> getBids() {
        return this.bids;
    }
    
    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    /**
     * toString
     * @return String
     */
     public String toString() {
	  StringBuffer buffer = new StringBuffer();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
      buffer.append("goodsName").append("='").append(getGoodsName()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


