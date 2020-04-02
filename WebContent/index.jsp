<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="login_user_bean" scope="session" class="login.LoginUserBean" />
<jsp:useBean id="Admin_user_bean" scope="session" class="adminLogin.AdminUserBean" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ログイン画面</title>
        <link href="css/shopping.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <main class="login_pane">
            <h1>ようこそよろず屋へ！</h1>
            <p>ログインIDとパスワードを入力して下さい</p>
            <form action="./LoginServlet" method="post">
                <table class="table_form">
                    <tbody>
                        <tr>
                            <th>ログインID</th>
                            <td><input type="text" name="id" value="<%=login_user_bean.getId()%>"/></td>
                        </tr>
                        <tr>
                            <th>パスワード</th>
                            <td><input type="password" name="pass"/></td>
                        </tr>
                    </tbody>
                </table>

                <div class="buttons">
                    <input class="common_button" type="submit" name="submit"  value="ログイン"/>

                   
                    <% if ("login".equals(session.getAttribute("login_state"))) { %>
                    <input class="common_button" type="submit" name="submit" value="ログアウト"/>
                    <% }%>
                </div>
            </form>
            <a>管理者の方はこちら</a>
                        <form action="./AdminLoginServlet" method="post">
                <table class="table_form">
                    <tbody>
                        <tr>
                            
                            <th>ログインID</th>
                            <td><input type="text" name="id" value="<%=Admin_user_bean.getId()%>"/></td>
                        </tr>
                        <tr>
                            <th>パスワード</th>
                            <td><input type="password" name="pass"/></td>
                        </tr>
                    </tbody>
                </table>

                <div class="buttons">
                    <input class="common_button" type="submit" name="submit"  value="ログイン"/>

                   
                    <% if ("login".equals(session.getAttribute("login_state"))) { %>
                    <input class="common_button" type="submit" name="submit" value="ログアウト"/>
                    <% }%>
                </div>
            </form>
        </main>
    </body>
</html>