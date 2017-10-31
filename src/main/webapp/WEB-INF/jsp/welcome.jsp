<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.extra.model.HomeBean" %>
<%@ page import="java.util.List" %>
<%@ page import="com.extra.model.StatisticsBean" %><%--
  Created by IntelliJ IDEA.
  User: 戴尔
  Date: 2017/10/30
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HomeBean home = (HomeBean) request.getAttribute("data");
    List<StatisticsBean> list = home.getList();
%>
<html>
<head>
    <jsp:include page="/commons/public-head.jsp"/>
    <title>Home</title>
</head>
<body>

<div class="page-container">
    <p class="f-20 text-success">Welcome to SZFP Technology Limited parking management system</p>
    <p>Number of login：<%=home.getLoginNum()%></p>
    <p>Last login IP：<%=home.getIp()%>             Last Login Time：<%=home.getTime()%></p>

    <table class="table table-border table-bordered  table-bg">
        <thead>
        <tr>
            <th colspan="7" scope="col">Information statistics</th>
        </tr>

        <tr class="text-c">
            <th>statistics</th>
            <th>Parking statistics</th>
            <th>Parking income</th>
            <th>Recharge statistics</th>
            <th>Recharge income</th>
            <th>User</th>
            <th>administrator</th>
        </tr>
        </thead>
        <tbody>
                <%
                    for (int i = 0; i <list.size() ; i++) {

                        out.print("<tr class=\"text-c\">");
                        out.print("<td>");
                        switch (i) {
                            case 0:
                                out.print("total");
                                break;
                            case 1:
                                out.print("today");
                                break;
                            case 2:
                                out.print("Yesterday");
                                break;
                            case 3:
                                out.print("This Week");
                                break;
                            case 4:
                                out.print("This Month");
                                break;
                        }
                        out.print(" </td>");
                        out.print("<td>" + list.get(i).getParkingStatistics() + "</td>");
                        out.print("<td>" + list.get(i).getParkingIncome() + "</td>");
                        out.print("<td>" + list.get(i).getRechargeStatistics() + "</td>");
                        out.print("<td>" + list.get(i).getRechargeIncome() + "</td>");
                        out.print("<td>" + list.get(i).getUser() + "</td>");
                        out.print("<td>" + list.get(i).getAdministrator() + "</td>");
                        out.print("</tr>");
                    }
                %>
        </tbody>
    </table>

    <table class="table table-border table-bordered table-bg mt-20">
        <thead>
        <tr>
            <th colspan="2" scope="col">company information</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>company name</td>
            <td>${company.name}</td>
        </tr>
        <tr>
            <td>company phone</td>
            <td>${company.contactNumber}</td>
        </tr>
        <tr>
            <td>PIC</td>
            <td>${company.PIC}</td>
        </tr>
        <tr>
            <td>Company website</td>
            <td>${company.website}</td>
        </tr>
        <tr>
            <td>Company email</td>
            <td>${company.email}</td>
        </tr>
        <tr>
            <td>address</td>
            <td>${company.address}</td>
        </tr>
        <tr>
            <td>Join time</td>
            <td>${company.createTime}</td>
        </tr>
        </tbody>
    </table>
</div>

<!--public footer-->
<jsp:include page="/commons/public-footer.jsp"/>
</body>
</html>
