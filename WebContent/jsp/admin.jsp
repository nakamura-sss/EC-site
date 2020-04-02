<%@ page import="java.util.ArrayList"%>
<%@ page import="shopping.ItemBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫管理</title>
<link href="css/shopping.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%
		ArrayList<ItemBean> itemList = (ArrayList<ItemBean>) request.getAttribute("itemList");
	%>
	<h1>在庫管理</h1>
	<form action="./AdminItemServlet">
		<table class="shopping_table">
			<tbody>
				<tr>
					<th>商品ID</th>
					<th>商品名</th>
					<th>価格</th>
					<th>在庫数</th>
					<th>在庫変更</th>
				</tr>
				<%
					for (ItemBean bean : itemList) {
				%>
				<tr>
					<td><%=bean.getItemId()%></td>
					<td><%=bean.getItemName()%></td>
					<td class="int"><%=bean.getPrice()%>円</td>
					<td class="int"><%=bean.getQuantity()%></td>


					<td><select class="list" name="<%=bean.getItemId()%>list">
							<%
								for (int i = 0; i <= 100; i++) {
							%>
							<option value="<%=i%>"><%=i%></option>
							<%
								}
							%>
					</select></td>
					<td class="button"><input class="common_button" type="submit"
						value="在庫調整" name="<%=bean.getItemId()%>"></td>

				</tr>
				<%
					}
				%>
			</tbody>
		</table>

	</form>
	<h1>商品登録</h1>
	<form action="./AddItemServlet" method="post">
		<table class="shopping_table">
			<tbody>
				<tr>
					<th>商品ID</th>
					<th>商品名</th>
					<th>価格</th>
					<th>在庫数</th>

				</tr>

				<tr>
					<td><input type="text" class="text" name="item_id"></td>
					<td><input type="text" class="text" name="item_name"></td>
					<td class="int"><input type="text" class="text" name="price">
					</td>
					<td class="int"><input type="text" class="text"
						name="quantuty"></td>

					<td class="button"><input class="common_button" type="submit"
						value="新規追加" name="item_id"></td>

				</tr>

			</tbody>
		</table>
		<a class="common_button" href="./">戻る</a>
	</form>
</body>
</html>