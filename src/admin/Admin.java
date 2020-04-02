package admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shopping.ItemBean;
import shopping.ShoppingDao;

public class Admin {
	public ArrayList<ItemBean> getItem() {
		ArrayList<ItemBean> item_bean_list = new ArrayList<>();
		AdminDao dao = null;
		ResultSet rs;

		try {
			dao = new AdminDao();
			rs = dao.selectItem();

			while (rs.next()) {
				String item_id = rs.getString("item_id");
				String item_name = rs.getString("item_name");
				int price = rs.getInt("price");
				int quantity = rs.getInt("quantity");

				ItemBean item_bean = new ItemBean(item_id, item_name, price, quantity);
				System.out.println("itembean: " + item_bean);

				item_bean_list.add(item_bean);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if (dao != null) {
				dao.close();
			}
		}
		return item_bean_list;
	}
	public ItemBean getItem(String item_id) {
		  ItemBean item_bean = null;
		  ShoppingDao dao = null;
		  ResultSet rs;
		
		  try {
			dao = new ShoppingDao();
			rs = dao.selectItem(item_id);
			
			while(rs.next()) {
				String item_name = rs.getString("item_name");
				int price = rs.getInt("price");
				int quantity = rs.getInt("quantity");
				item_bean = new ItemBean(item_id, item_name, price, quantity);
	        }
		 }catch(SQLException e) {
			e.printStackTrace();
			
		 }finally {
	    	if(dao != null) {
	    		dao.close();
	    	}
	    }
		return item_bean;
	  }
}

