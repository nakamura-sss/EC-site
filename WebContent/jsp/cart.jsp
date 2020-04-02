<%@ page import="java.util.ArrayList"%>
<%@ page import="shopping.CartBean"%>
<%@ page import="shopping.ItemBean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="cart_bean" scope="request" class="shopping.CartBean" />
<jsp:useBean id="item_bean" scope="request" class="shopping.ItemBean" />
<jsp:useBean id="login_user_bean" scope="session" class="login.LoginUserBean" />

<!DOCTYPE html>
<html>
<head>
<title>買い物かご</title>
<link href="css/shopping.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<jsp:include page="header.jsp" />

	<h1><jsp:getProperty name="login_user_bean" property="name" />さんの買い物かご
	</h1>

	<%
		ArrayList<CartBean> cartList = (ArrayList<CartBean>) request.getAttribute("cartList");
	%>
	 
	<form action="./BuyItemServlet" method="get">
	<table class="shopping_table">
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
				<td class="int"><%=bean.getPrice()%>円</td>
				<td class="int"><%=bean.getPurchased_num()%></td>
			
			    <td class="button"><input class="common_button" type="submit"
				value="削除する" name="<%=bean.getItemId()%>">
				</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<% if(cartList.size()!=0){%>
	<a class="common_button" href="BuyItemServlet?submit=buy">購入する</a>
	<% }else{%>
	<p>買い物かごは空です</p>
	<%} %>
</form>
	<form action="./ShoppingServlet" method="post">
		<input class="common_button" type="submit" value="一覧に戻る">
	</form>
</body>
</html>