package shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShoppingDao {
    private Connection con_ = null;
    private ResultSet rs_ = null;
    private PreparedStatement ps_ = null;

    public ShoppingDao() throws SQLException{
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		this.con_=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping",
                    "root",
                    "");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
    public ResultSet selectItem() throws SQLException {
        this.ps_ = this.con_.prepareStatement(
                "SELECT item.item_id, item.item_name, item.price, stock.quantity FROM item INNER JOIN stock ON item.item_id = stock.item_id"
        );

        this.rs_ = this.ps_.executeQuery();

        return this.rs_;
    }
    public ResultSet selectItem(String item_id) throws SQLException {
        this.ps_ = this.con_.prepareStatement(
                "SELECT item.item_name, item.price, stock.quantity FROM item INNER JOIN stock ON item.item_id = stock.item_id where item.item_id = ?"
        );
        this.ps_.setString(1, item_id);
        
        this.rs_ = this.ps_.executeQuery();

        return this.rs_;
    }
  
    
    public ResultSet selectHistory(String user_id) throws SQLException {
        
        this.ps_ = this.con_.prepareStatement("SELECT history.item_id, item.item_name, history.quantity FROM history INNER JOIN item ON history.id = ? and history.item_id = item.item_id");
        this.ps_.setString(1, user_id);

        this.rs_ = this.ps_.executeQuery();
        return this.rs_;
    }
    public void updateItem(String item_id, int purchased_num) throws SQLException {
       this.ps_ = this.con_.prepareStatement("UPDATE stock SET quantity = quantity - ? WHERE item_id = ?");

       this.ps_.setInt(1, purchased_num);
       
       this.ps_.setString(2, item_id);
      
       this.ps_.executeUpdate();
   }
    
    public ResultSet selectCart() throws SQLException {
        this.ps_ = this.con_.prepareStatement(
                "SELECT cart.item_id, item_name, price, purchased_num FROM cart JOIN item ON cart.item_id=item.item_id"
        );

        this.rs_ = this.ps_.executeQuery();

        return this.rs_;
    }
    public ResultSet updateCart(String item_id, int purchased_num) throws SQLException {
        this.ps_ = this.con_.prepareStatement("INSERT INTO cart(item_id, purchased_num) VALUES (?, ?)");
        
        this.ps_.setString(1, item_id);

        this.ps_.setInt(2, purchased_num);

        this.ps_.executeUpdate();
		return this.rs_;
    }
    public void deleteCart(String item_id) throws SQLException {
        this.ps_ = this.con_.prepareStatement("DELETE FROM cart WHERE item_id=?");
        this.ps_.setString(1, item_id);

        this.ps_.executeUpdate();
    }
    public void updateHistory(String user_id, String item_id, int purchased_num) throws SQLException {
       this.ps_ = this.con_.prepareStatement("INSERT INTO history(id, item_id, quantity) VALUES (?, ?, ?)");
       
       this.ps_.setString(1, user_id);
       this.ps_.setString(2, item_id);
       this.ps_.setInt(3, purchased_num);

       this.ps_.executeUpdate();
   }
    public void close() {
        try {
            if (this.con_ != null) {
                this.con_.close();
            }
            if (this.ps_ != null) {
                this.ps_.close();
            }
            if (this.rs_ != null) {
                this.rs_.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
    	}
    }
}
