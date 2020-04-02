<%@ page import="java.util.ArrayList"%>
<%@ page import="shopping.CartBean"%>
<%@ page import="shopping.ItemBean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="item_bean" scope="request" class="shopping.ItemBean" />
<jsp:useBean id="cart_bean" scope="request" class="shopping.CartBean" />
<jsp:useBean id="login_user_bean" scope="session" class="login.LoginUserBean" />

<!DOCTYPE html>
<html>
<head>
<title>購入確認画面</title>
<link href="css/shopping.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="header.jsp" />
	

	<main>
		<h1>購入確認</h1>
		<p>次の商品を購入しますか？</p>
		<%
			ArrayList<CartBean> cartList = (ArrayList<CartBean>) request.getAttribute("cartList");
		%>

		<form action="./ResultServlet" method="post">
			<table class="table_list">
				<tbody>
					<tr>
						<th>商品ID</th>
						<th>商品名</th>
						<th>価格</th>
						<th>購入数</th>
					</tr>
					<%
						for (CartBean bean : cartList) {
					%>
					<tr>
						<td><%=bean.getItemId()%></td>
						<td><%=bean.getItemName()%></td>
						<td class="int"><%=bean.getPrice()%></td>
						<td class="int"><%=bean.getPurchased_num()%></td>


					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<input class="common_button" type="submit" value="購入する" name="">
		</form>
		<form action="./ShoppingServlet" method="post">
			<input class="common_button" type="submit" value="一覧に戻る">
		</form>
	</main>
</body>
</html>