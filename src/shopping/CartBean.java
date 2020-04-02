package shopping;

import java.io.Serializable;

public class CartBean implements Serializable{
	private static final long serialVersionUID =1L;
	
	private String item_id_;
	private String item_name_;
    private int price_;
	private int purchased_num_;
	
	public CartBean() {
		this.item_id_="";
		this.item_name_="";
		this.price_=0;
		this.purchased_num_=0;
	}
	 public CartBean(String item_id, String item_name, int price, int purchased_num) {
	        this.item_id_ = item_id;
			this.item_name_=item_name;
			this.price_= price;
	        this.purchased_num_ = purchased_num;
	    }
	    
	    public void setItemId(String item_id){
	        this.item_id_ = item_id;
	    }
	    
	    public String getItemId(){
	        return this.item_id_;
	    }
	    public void setItemName(String item_name){
	        this.item_name_ = item_name;
	    }
	    
	    public String getItemName(){
	        return this.item_name_;
	    }
	    
	    public void setPrice(int price){
	        this.price_ = price;
	    }
	    
	    public int getPrice(){
	        return this.price_;
	    }
	    
	    public void setPurchasede_num(int purchased_num){
	        this.purchased_num_ = purchased_num;
	    }
	    
	    public int getPurchased_num(){
	        return this.purchased_num_;
	    }

}
