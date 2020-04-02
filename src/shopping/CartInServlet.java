package shopping;

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

@WebServlet("/CartInServlet")
public class CartInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartInServlet() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Enumeration<String> names = request.getParameterNames();

		String name;
		String item_id = "";

		int purchased_num;

		while (names.hasMoreElements()) {
			name = names.nextElement();

			if ("îÉÇ¢ï®Ç©Ç≤Ç…ì¸ÇÍÇÈ".equals(request.getParameter(name))) {

				item_id = name;

				purchased_num = Integer.parseInt(request.getParameter(item_id + "list"));

				ShoppingDao dao = null;
				try {
					dao = new ShoppingDao();
					dao.updateCart(item_id, purchased_num);

				} catch (SQLException sqle) {
					sqle.printStackTrace();
				} finally {
					if (dao != null) {
						dao.close();
					}
				}
				Shopping shopping = new Shopping();
				ArrayList<CartBean> cart_list = shopping.cartItem();
				System.out.println("cart_list" + cart_list);

				request.setAttribute("cartList", cart_list);

				RequestDispatcher rd = request.getRequestDispatcher("./jsp/cart.jsp");
				rd.forward(request, response);

			}
	

			if ("1ÉNÉäÉbÉNçwì¸".equals(request.getParameter(name))) {
				item_id = name;

				purchased_num = Integer.parseInt(request.getParameter(item_id + "list"));

				Shopping shopping = new Shopping();
				System.out.println("item_id: " + item_id);
				ItemBean item_bean = shopping.getItem(item_id);
				System.out.println("item_bean: " + item_bean);
				request.setAttribute("item_bean", item_bean);
				request.setAttribute("purchased_num", purchased_num);

				RequestDispatcher rd = request.getRequestDispatcher("./jsp/purchase_confirm1.jsp");
				rd.forward(request, response);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
