package adminLogin;

import java.sql.ResultSet;
import java.sql.SQLException;

import adminLogin.AdminLogin;
import adminLogin.AdminLoginDao;
import adminLogin.AdminUserBean;

public class AdminDB extends AdminLogin{
	
	@Override
	public AdminUserBean getAdminData(String id, String pass) {
		
		AdminUserBean bean =null;
		AdminLoginDao dao = null;
		ResultSet rs;
		
		try {
			dao =new AdminLoginDao();
			rs = dao.selectUser(id, pass);
			
			while(rs.next()) {
				bean = new AdminUserBean();
				bean.setId(id);
				bean.setName(rs.getString("name"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(dao != null) {
				dao.close();
			}
		}
		return bean;
	}

}
