package adminLogin;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminLoginServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String para = request.getParameter("submit");
		HttpSession session = request.getSession();
		
		if(para.contentEquals("logout")) {
			session.removeAttribute("admin_login_state");
		    session.removeAttribute("admin_user_bean");
		    response.sendRedirect("./");
	}
}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String btn = request.getParameter("submit");
		
		HttpSession session = request.getSession();
		RequestDispatcher rd ;
		
		if(btn.contentEquals("ログイン")) {
			String id = request.getParameter("id");
			String pass = request.getParameter("pass");
			
			AdminDB login = new AdminDB();
			AdminUserBean bean = login.getAdminData(id, pass);
			
			if(bean != null) {
				session.setAttribute("Admin_user_bean", bean);
				session.setAttribute("admin_login_state", "login");
				
				rd = request.getRequestDispatcher("./AdminServlet");
			}else {
			rd =request.getRequestDispatcher("./index.jsp"); 
			}	
			rd.forward(request, response);
			
		}else if(btn.equals("ログアウト")){
            session.removeAttribute("admin_login_state");
            session.removeAttribute("admin_user_bean");
            response.sendRedirect("./");	

		}	
		
		}
	
	@Override
	public String getServletInfo() {
		return "Short description";
	}

}