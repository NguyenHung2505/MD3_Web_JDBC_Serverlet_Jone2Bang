<%--
  Created by IntelliJ IDEA.
  User: QT
  Date: 30/05/2022
  Time: 4:00 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
List hoc sinh
<c:forEach items="${dsm}" var = "aidi" >
    <h2>${aidi.name},${aidi.age},${aidi.lop.name}
    </h2>
</c:forEach>
</body>
</html>
