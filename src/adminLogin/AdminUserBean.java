package adminLogin;

import java.io.Serializable;

public class AdminUserBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id_;
	private String name_;

	
	public AdminUserBean() {
		this.id_="";
		this.name_="";
	}
	
	public AdminUserBean(String id, String name, int age) {
		this.id_=id;
		this.name_=name;
	}
	
	public void setId(String id) {
		this.id_=id;
	}
    public String getId(){
        return this.id_;
    }
    
    public void setName(String name){
        this.name_ = name;
    }
    
    public String getName(){
        return this.name_;
    }

}
