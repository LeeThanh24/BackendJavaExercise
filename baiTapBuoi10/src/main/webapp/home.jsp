<%--
  Created by IntelliJ IDEA.
  User: thanh
  Date: 1/3/2023
  Time: 8:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style>
        body
        {

            background-image: url("images/guess.png");
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
        }
        .btn{
            font-family: "Roboto", sans-serif;
            font-size: 18px;
            font-weight: bold;
            background: #1E90FF;
            width: 160px;
            padding: 20px;
            text-align: center;
            text-decoration: none;
            text-transform: uppercase;
            color: #fff;
            border-radius: 5px;
            cursor: pointer;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            -webkit-transition-duration: 0.3s;
            transition-duration: 0.3s;
            -webkit-transition-property: box-shadow, transform;
            transition-property: box-shadow, transform;

        }
        .btn:hover, .btn:focus, .btn:active{
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
            -webkit-transform: scale(1.1);
            transform: scale(1.1);
        }
    </style>
</head>
<body >
    <form style="text-align: center" action="http://localhost:8080/guestTheNumber">

           <button class="btn" > ENTER THE GAME</button>


    </form>
</body>
</html>
