<%@ page import="Model.Player" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
<head>
    <title>Guest the number</title>
    <style>
        .table_width {
            width: 320px;
            background-color: black;
        }

        .total_width {
            width: 1280px;
        }
        body
        {

            background-image: url("images/vecteezy_forest-game-background_9206912.jpg");
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
        }
        .tr1 {
            background-color: grey;
        }

        .tr2 {
            background-color: lightgrey;
        }


        .button-35 {
            align-items: center;
            background-color: #fff;
            border-radius: 12px;
            box-shadow: transparent 0 0 0 3px, rgba(18, 18, 18, .1) 0 6px 20px;
            box-sizing: border-box;
            color: #121212;
            cursor: pointer;
            display: inline-flex;
            flex: 1 1 auto;
            font-family: Inter, sans-serif;
            font-size: 1.2rem;
            font-weight: 700;
            justify-content: center;
            line-height: 1;
            margin: 0;
            outline: none;
            padding: 1rem 1.2rem;
            text-align: center;
            text-decoration: none;
            transition: box-shadow .2s, -webkit-box-shadow .2s;
            white-space: nowrap;
            border: 0;
            user-select: none;
            -webkit-user-select: none;
            touch-action: manipulation;

            position: absolute;
             /* taken out of the normal flow of the document */
            top: 50%; /* moved down by 50% of the screen height */
            transform: translateY(-50%); /* moved back up (Y axis) by half of its height to achieve the perfect center */
            width: 30%; /* needs to be defined to keep the default block behavior */



        }

        .button-35:hover {
            box-shadow: #121212 0 0 0 3px, transparent 0 0 0 0;
        }
        .form
        {

            position: absolute;
            /* taken out of the normal flow of the document */
            top: 45%; /* moved down by 50% of the screen height */

            transform: translateY(-50%); /* moved back up (Y axis) by half of its height to achieve the perfect center */
            width: 30%;

        }
    </style>
</head>
<body>

<c:choose>
    <c:when test="${start ==0}">
        <form method="post">
            <input class="form" type="text" name="number" placeholder="Enter number of players">
            <button class ="button-35" type="submit">Enter</button>
        </form>
    </c:when>


    <c:when test="${start >=1 }">
        <p style="color: white;top: 30%"><b>ENTER NAME</b></p>
        <form method="post">
            <input class="form" type="text" name="playerName">
            <button class ="button-35" type="submit">Enter</button>

        </form>

    </c:when>
    <%--        <c:when test="${start ==-1 }">--%>
    <%--           Done--%>

    <%--        </c:when>--%>
    <%--        if not exist start ==-1 --%>

    <c:when test="${countTimes == 0 && start ==-1 }">
        <p style="color: white ;top :30%" >PLAYER <c:out value="${name}"/> </p>
        <form method="post">
            <input  class="form" type="text" name="numGuest" placeholder="Type your number">
            <button  class ="button-35"  type="submit">GUESS</button>
<%--            <c:out value="${numGuest}"/>--%>
        </form>
    </c:when>
    <%--                    test dau tien--%>
    <c:when test="${countTimes==-1   && start ==-1  }">
        <h1 style="text-align: center;color: white"><b>SCORE BOARD</b></h1>
        <br>
        <table style="background-color: black" class="total_width">
            <tbody>
            <tr style="background-color: grey;color :white">
                <th class="table_width">Rank</th>
                <th class="table_width">Name</th>
                <th class="table_width">Random number</th>
                <th class="table_width">Counting times</th>
            </tr>
            <%List<Player> playerList = (List<Player>) request.getAttribute("playerList");%>
            <%int end = playerList.size();%>

            <%
                int count = 1;
                for (Player player : playerList) {

            %>
            <tr style="background-color: lightgrey">
                <td style="text-align: center"><%=count++%>
                </td>
                <td style="text-align: center"><%=player.getName()%>
                </td>
                <td style="text-align: center"><%=player.getRandNum()%>
                </td>
                <td style="text-align: center"><%=player.getCountTimes()%>
                </td>
            </tr>

            <%}%>


            </tbody>

        </table>


    </c:when>
    <c:when test="${countTimes >=1 && numGuest >rand  && start ==-1 }">
<%--        <p>PLAYER <c:out value="${name}"/> and your random number is <c:out value="${rand}"/>--%>
<%--            and the times : <c:out value="${countTimes}"/> and you have to guess smaller number </p>--%>

        <p style="color: white" >PLAYER <c:out value="${name}"/> you have to guess smaller number </p>
        <form method="post">
            <input  class="form" type="text" name="numGuest" placeholder="Type your number">
            <button  class ="button-35"  type="submit">GUESS</button>
            <br>

        </form>

    </c:when>

    <c:when test="${countTimes >=1   && numGuest <rand && start ==-1 }">
        <p style="color: white">PLAYER <c:out value="${name}"/> you have to guess bigger number </p>
        <form method="post">
            <input class="form" type="text" name="numGuest" placeholder="Type your number">
            <button  class ="button-35"  type="submit">GUESS</button>
            <br>

        </form>

    </c:when>


    <c:otherwise>
    </c:otherwise>
</c:choose>

</body>
</html>
