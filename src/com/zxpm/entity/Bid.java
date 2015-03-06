package com.zxpm.entity;
// Generated 2014-8-22 16:03:08 by Hibernate Tools 3.2.0.beta6a


import java.util.Date;

/**
 *        represents bids.
 *        @author lee(with help from hibernate)
 *        
 */
public class Bid  implements java.io.Serializable {

    // Fields    

     private Integer bidId;
     private Users buyer;
     private Goods goods;
     private Date bidTime;
     private Float bidPrice;
     private Integer bidStatus;

     // Constructors

    /** default constructor */
    public Bid() {
    }

    /** full constructor */
    public Bid(Users buyer, Goods goods, Date bidTime, Float bidPrice, Integer bidStatus) {
       this.buyer = buyer;
       this.goods = goods;
       this.bidTime = bidTime;
       this.bidPrice = bidPrice;
       this.bidStatus = bidStatus;
    }
    
   
    // Property accessors
    public Integer getBidId() {
        return this.bidId;
    }
    
    protected void setBidId(Integer bidId) {
        this.bidId = bidId;
    }
    public Users getBuyer() {
        return this.buyer;
    }
    
    public void setBuyer(Users buyer) {
        this.buyer = buyer;
    }
    public Goods getGoods() {
        return this.goods;
    }
    
    public void setGoods(Goods goods) {
        this.goods = goods;
    }
    public Date getBidTime() {
        return this.bidTime;
    }
    
    public void setBidTime(Date bidTime) {
        this.bidTime = bidTime;
    }
    public Float getBidPrice() {
        return this.bidPrice;
    }
    
    public void setBidPrice(Float bidPrice) {
        this.bidPrice = bidPrice;
    }
    public Integer getBidStatus() {
        return this.bidStatus;
    }
    
    public void setBidStatus(Integer bidStatus) {
        this.bidStatus = bidStatus;
    }

    /**
     * toString
     * @return String
     */
     public String toString() {
	  StringBuffer buffer = new StringBuffer();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
      buffer.append("bidTime").append("='").append(getBidTime()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }



}


