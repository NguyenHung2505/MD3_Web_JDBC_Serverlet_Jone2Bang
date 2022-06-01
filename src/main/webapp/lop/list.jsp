<%--
  Created by IntelliJ IDEA.
  User: QT
  Date: 30/05/2022
  Time: 10:56 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="">danh sach hoc sinh</a>
<a href="/lopse?atc=them">them lop</a>
<c:forEach items="${ds}" var = "vao" >
    <h2>${vao.id}, ${vao.name}
    </h2>
</c:forEach>

</body>
</html>
