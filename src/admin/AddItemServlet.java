package admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopping.ItemBean;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get request");
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/admin.jsp").forward(request, response);
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration<String> names = request.getParameterNames();

		String name;
		String item_id = "";
		String item_name="";
		int price = 0;
		int quantity;

		while (names.hasMoreElements()) {
			name = names.nextElement();

//			if ("êVãKí«â¡".equals(request.getParameter(name))) {

				item_id = name;
				item_name=request.getParameter("item_name");
				price=Integer.parseInt(request.getParameter("price"));
				quantity = Integer.parseInt(request.getParameter("quantity"));

				AdminDao dao = null;
				try {
					dao = new AdminDao();
					dao.insertItem(item_id, item_name, price, quantity);

				} catch (SQLException sqle) {
					sqle.printStackTrace();
				} finally {
					if (dao != null) {
						dao.close();
					}
				}
				Admin admin = new Admin();
				ArrayList<ItemBean> item_list = admin.getItem();
				System.out.println("item_list" + item_list);

				request.setAttribute("itemList", item_list);

				RequestDispatcher rd = request.getRequestDispatcher("./jsp/admin.jsp");
				rd.forward(request, response);

			}
		}
	}



