<%--
  Created by IntelliJ IDEA.
  User: bachk
  Date: 02/06/2022
  Time: 1:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
    <Style>
        .top{
            width: 100%;
            height: 150px;

            margin-bottom: 5px;
        }
        .logo{
            width: 30%;
            height: 150px;
            background-color: cadetblue;
            float : left;
            margin-right: 1%;
        }
        .banner{
            width: 69%;
            height: 150px;
            background-color: olivedrab;
            float : left;
        }

        .menu{
            width: 100%;
            height: 50px;
            background-color: orange;
            margin-bottom: 5px;
        }

        .content{
            width: 100%;
            height: 600px;
            background-color: yellow;
            margin-bottom: 5px;
        }
        .left{
            width: 14%;
            height: 600px;
            background-color: red;
            float : left;
            margin-right: 1%;
        }
        .mid{
            width: 59%;
            height: 600px;
            background-color: black;
            float : left;
            margin-right: 1%;
        }
        .right{
            width: 25%;
            height: 600px;
            background-color: darkorchid;
            float : left;
        }

        .footer{
            width: 100%;
            height: 150px;
            background-color: blue;
        }
    </Style>


</head>
<body>
<div class="top">
    <div class="logo"></div>
    <div class="banner"></div>
</div>

<div class="menu"></div>

<div class="content">
    <div class="left"></div>
    <div class="mid"></div>
    <div class="right"></div>
</div>
<div class="footer"></div>
</body>
</html>
