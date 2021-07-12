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
            List of Books
        </h2>
    </caption>
    <thead>
    <tr>
        <th align="left">Book name</th>
        <th align="left">Pages</th>
        <th align="left">Publication year</th>
        <th align="left">Genre</th>
        <th colspan="2" align="center">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.name}</td>
            <td>${book.countPages}</td>
            <td>${book.publicationYear}</td>
            <td>${book.genre}</td>
            <td align="center"><a href="/books/findById?id=${book.id}">
                <button>Details</button>
            </a>
            </td>
            <td align="center"><a href="/books/form/update?id=${book.id}">
                <button>Update</button>
            </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>