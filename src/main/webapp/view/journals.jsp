<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>GOIT Library</title>
    <style>
        <%@include file="/view/css/style.css" %>
    </style>
</head>
<body>
<c:import url="/view/navibar.jsp"/>

<table cellpadding="5">
    <caption>
        <h2>
            List of Journals
        </h2>
    </caption>
    <thead>
    <tr>
        <th align="left">Journal name</th>
        <th align="left">Journal number</th>
        <th align="left">Count pages</th>
        <th align="left">Publication year</th>
        <th align="left">Journal type</th>
        <th align="left">Description</th>
        <th colspan="2" align="center">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="journal" items="${journals}">
        <tr>
            <td>${journal.name}</td>
            <td>${journal.journalNumber}</td>
            <td>${journal.countPages}</td>
            <td>${journal.year}</td>
            <td>${journal.journalType}</td>
            <td>${journal.description}</td>
            <td align="center"><a href="#">
                <button>Details</button>
            </a>
            </td>
            <td align="center"><a href="#">
                <button>Update</button>
            </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>