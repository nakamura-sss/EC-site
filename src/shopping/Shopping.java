package shopping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Shopping {
	public ArrayList<ItemBean> getItem() {
		ArrayList<ItemBean> item_bean_list = new ArrayList<>();
		ShoppingDao dao = null;
		ResultSet rs;

		try {
			dao = new ShoppingDao();
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
	
	public ArrayList<CartBean> cartItem() {
		ArrayList<CartBean> cart_list = new ArrayList<>();
		ShoppingDao dao = null;
		ResultSet rs;

		try {
			dao = new ShoppingDao();
			rs = dao.selectCart();

			while (rs.next()) {
				String item_id = rs.getString("item_id");
				String item_name = rs.getString("item_name");
				int price = rs.getInt("price");
				int purchased_num = rs.getInt("purchased_num");

				CartBean cart_bean = new CartBean(item_id, item_name, price, purchased_num);
				System.out.println("cartbean: " + cart_bean);

				cart_list.add(cart_bean);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if (dao != null) {
				dao.close();
			}
		}
		return cart_list;
	}
	public CartBean getCart(String item_id) {
		  CartBean cart_bean = null;
		  ShoppingDao dao = null;
		  ResultSet rs;
		
		  try {
			dao = new ShoppingDao();
			rs = dao.selectItem(item_id);
			
			while(rs.next()) {
				String item_name = rs.getString("item_name");
				int price = rs.getInt("price");
				int purchased_num = rs.getInt("purchased_num");
				cart_bean = new CartBean(item_id, item_name, price, purchased_num);
	        }
		 }catch(SQLException e) {
			e.printStackTrace();
			
		 }finally {
	    	if(dao != null) {
	    		dao.close();
	    	}
	    }
		return cart_bean;
	  }
		
	public ArrayList<CartBean> cartItem(String item_id, String item_name, int price, int purchased_num) {
		ArrayList<CartBean> cart_list = new ArrayList<>();
		ShoppingDao dao = null;
		ResultSet rs;

		try {
			dao = new ShoppingDao();
			rs = dao.updateCart(item_id, purchased_num);

			while (rs.next()) {
				String item_id1 = rs.getString("item_id");
				int purchased_num1 = rs.getInt("purchased_num");

				CartBean cart_bean = new CartBean(item_id1, item_id1, purchased_num1, purchased_num1);
				System.out.println("cartbean: " + cart_bean);

				cart_list.add(cart_bean);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			if (dao != null) {
				dao.close();
			}
		}
		return cart_list;
	}
	
	public ArrayList<HistoryBean> getHistory(String user_id){
		ArrayList<HistoryBean> history_bean_list = new ArrayList<>();
		ShoppingDao dao;
		ResultSet rs;
		
		try {
			dao = new ShoppingDao();
			rs = dao.selectHistory(user_id);
			
			while(rs.next()) {
				String item_id = rs.getString("item_id");
				String item_name = rs.getString("item_name");
				int quantity = rs.getInt("quantity");
				
				HistoryBean history_bean = new HistoryBean(item_id, item_name, quantity);
				
				history_bean_list.add(history_bean);
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		return history_bean_list;
	}
}