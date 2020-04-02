<%@ page import="java.util.ArrayList"%>
<%@ page import="shopping.ItemBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>よろず屋</title>
        <link href="css/shopping.css" rel="stylesheet" type="text/css" />

    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>

            <main>
                <h1>ここはよろず屋です。何をお求めでしょう。</h1>

            <% ArrayList<ItemBean> itemList = (ArrayList<ItemBean>) request.getAttribute("itemList"); %>

            <form action="./CartInServlet">
                <table class="shopping_table">
                    <tbody>
                        <tr>
                            <th>商品ID</th>
                            <th>商品名</th>
                            <th>価格</th>
                            <th>在庫数</th>
                            <th>数量</th>
                        </tr>

           
                        <% for (ItemBean bean : itemList) {%>
                        <tr>
                            <td><%= bean.getItemId()%></td>
                            <td ><input type=hidden name="<%= bean.getItemId()%>itemName"><%= bean.getItemName()%></td>
                            <td class="int"><input type=hidden name="<%= bean.getItemId()%>price"><%= bean.getPrice()%>円</td>
                            <td class="int"><%= bean.getQuantity()%></td>

                            <% if (bean.getQuantity() != 0) {%>
                            <td>
                                <select class="list" name="<%= bean.getItemId()%>list">
                                    <% for (int i = 0; i <= bean.getQuantity(); i++) {%>
                                    <option value="<%= i%>"><%= i%></option>
                                    <% }%>
                                </select>
                            </td>
                            <td class="button">                              
                                <input class="common_button" type="submit" value="買い物かごに入れる" name="<%= bean.getItemId()%>">
                                <input class="common_button" type="submit" value="1クリック購入" name="<%= bean.getItemId()%>">

                            </td>
                            <% } else { %>
                            <td class="button">売り切れ</td>
                            <% } %>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
                <a class="common_button" href="./">戻る</a>
            </form>
        </main>
    </body>
</html>