package com.zxpm.entity;
// Generated 2014-8-22 16:03:08 by Hibernate Tools 3.2.0.beta6a

/**
 *           represents an user who is associated with goods.
 *           @author lee(with help from hibernate)
 *        
 */
public class Users  implements java.io.Serializable {

    // Fields    

     private Integer userId;
     private String userName;
     private String password;
     private String telephone;
     private String address;

     // Constructors

    /** default constructor */
    public Users() {
    }

    /** full constructor */
    public Users(String userName, String password, String telephone, String address) {
       this.userName = userName;
       this.password = password;
       this.telephone = telephone;
       this.address = address;
    }
    
   
    // Property accessors
    public Integer getUserId() {
        return this.userId;
    }
    
    protected void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * toString
     * @return String
     */
     public String toString() {
	  StringBuffer buffer = new StringBuffer();

      buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
      buffer.append("userName").append("='").append(getUserName()).append("' ");			
      buffer.append("]");
      
      return buffer.toString();
     }

}
