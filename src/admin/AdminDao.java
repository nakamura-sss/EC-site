package admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    private Connection con_ = null;
    private ResultSet rs_ = null;
    private PreparedStatement ps_ = null;

    public AdminDao() throws SQLException{
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		this.con_=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping",
                    "root",
                    "");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
    public void updateStock(int quantity, String item_id) throws SQLException {
        this.ps_ = this.con_.prepareStatement("UPDATE stock SET quantity = ?  WHERE item_id = ?");

        this.ps_.setInt(1, quantity);
        
        this.ps_.setString(2, item_id);
       
        this.ps_.executeUpdate();
    }
    
    public ResultSet selectItem(String item_id) throws SQLException {
        this.ps_ = this.con_.prepareStatement(
                "SELECT item.item_name, item.price, stock.quantity FROM item INNER JOIN stock ON item.item_id = stock.item_id where item.item_id = ?"
        );
        this.ps_.setString(1, item_id);
        
        this.rs_ = this.ps_.executeQuery();

        return this.rs_;
	}
    
    public ResultSet selectItem() throws SQLException {
        this.ps_ = this.con_.prepareStatement(
                "SELECT item.item_id, item.item_name, item.price, stock.quantity FROM item INNER JOIN stock ON item.item_id = stock.item_id"
        );

        this.rs_ = this.ps_.executeQuery();

        return this.rs_;
    }
    public ResultSet insertItem(String item_id, String item_name, int price, int quantity) throws SQLException {
        this.ps_ = this.con_.prepareStatement("INSERT INTO cart(item_id, item_name, price) VALUES (?, ?, ?) INTO stock(item_id, quantity) VALUES(?,?)");
        
        this.ps_.setString(1, item_id);
        this.ps_.setString(2, item_name);
        this.ps_.setInt(3, price);
        
        this.ps_.setString(4, item_id);
        this.ps_.setInt(5, quantity);

        this.ps_.executeUpdate();
		return this.rs_;
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