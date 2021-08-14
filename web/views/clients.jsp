<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 14.08.2021
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clients</title>
</head>
<body>
<a href="/homework13_from_lesson19_elementary_war"><b>Main page</b></a> <br> <%-- в скобочках пишем адресс ссылки, а затем отображаемый текст "активной ссылки"  --%>
<a href="/homework13_from_lesson19_elementary_war/accounts">Accounts</a> <br>
<a href="/homework13_from_lesson19_elementary_war/clients_statuses">Clients Statuses</a> <br>
<a href="/homework13_from_lesson19_elementary_war/statuses">Statuses</a> <br>

<table border="2" cellspacing="0,5" bordercolor="#23417d">
    <caption>Clients table</caption>
    <tr> <%-- тег начала строки --%>
        <th> ID </th> <%-- тег ячейки c выделенным текстом внутри --%>
        <th> Name </th>
        <th> Email </th>
        <th> Phone </th>
        <th> About </th>
        <th> Age </th>
    </tr>

    <c:forEach items="${clients}" var="st"> <%-- "<с: ..." <- тег библиотеки для передачи списка (customers(указаный как ключ в сервлете) дальше как "item"), имеет встроенный forEach  &ndash;%&gt;--%>
        <tr>
            <td> ${st.id} </td>
            <td> ${st.name} </td> <%-- тег ячейки с обычным толщиной "текста" внутри --%>
            <td> ${st.email} </td>
            <td> ${st.phone} </td>
            <td> ${st.about} </td>
            <td> ${st.age} </td>
        </tr>
    </c:forEach>
</table>

<table border="2" cellspacing="0,5" bordercolor="#23417d">
    <caption>Accounts table</caption>
    <tr>
        <th> ID </th>
        <th> Client ID </th>
        <th> Number </th>
        <th> Value </th>
    </tr>

    <c:forEach items="${accounts}" var="st">
        <tr>
            <td> ${st.id} </td>
            <td> ${st.clientId} </td>
            <td> ${st.number} </td>
            <td> ${st.value} </td>
        </tr>
    </c:forEach>
</table>

<table border="2" cellspacing="0,5" bordercolor="#23417d">
    <caption>Clients statuses table</caption>
    <tr>
        <th> Client ID </th>
        <th> Status ID </th>
    </tr>

    <c:forEach items="${clients_statuses}" var="st">
        <tr>
            <td> ${st.clientId} </td>
            <td> ${st.statusId} </td>
        </tr>
    </c:forEach>
</table>

<table border="2" cellspacing="0,5" bordercolor="#23417d">
    <caption>Table of statuses</caption>
    <tr>
        <th> ID </th>
        <th> Alias </th>
        <th> Description </th>
    </tr>

    <c:forEach items="${statuses}" var="st">
        <tr>
            <td> ${st.id} </td>
            <td> ${st.alias} </td>
            <td> ${st.description} </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
