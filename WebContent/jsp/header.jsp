<%@ page language="java" contentType="text/html charset=UTF-8"%>
<jsp:useBean id="login_user_bean" scope="session"
	class="login.LoginUserBean" />
	<link href="css/shopping.css" rel="stylesheet" type="text/css" />

<header>

	<p>
		ようこそ「<jsp:getProperty name="login_user_bean" property="name" />」さん！ <a
			href="ShoppingServlet?submit=history">購入履歴</a> <a
			href="ShoppingServlet?submit=cart">買い物かご</a> <a
			href="LoginServlet?submit=logout">ログアウト</a>
	</p>
</header>