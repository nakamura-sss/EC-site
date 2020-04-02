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

@WebServlet("/AdminItemServlet")
public class AdminItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminItemServlet() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration<String> names = request.getParameterNames();

		String name;
		String item_id = "";

		int quantity;

		while (names.hasMoreElements()) {
			name = names.nextElement();

			if ("ç›å…í≤êÆ".equals(request.getParameter(name))) {

				item_id = name;

				quantity = Integer.parseInt(request.getParameter(item_id + "list"));

				AdminDao dao = null;
				try {
					dao = new AdminDao();
					dao.updateStock(quantity, item_id);

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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
