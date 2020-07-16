<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/8/28
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h>测试成功</h><br>
    <c:forEach items="${accounts}" var="account">
        ${account.name}
        ${account.money}<br>
    </c:forEach>
</body>
</html>
