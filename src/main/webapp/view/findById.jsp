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
<c:set var="book" value="${book}"/>
<table cellpadding="5">
    <caption>
        <h2>
            Book's details
        </h2>
    </caption>
    <thead>
    <tr>
        <th align="left">Author</th>
        <th align="left">Book name</th>
        <th align="left">Pages</th>
        <th align="left">Publication year</th>
        <th align="left">Genre</th>
        <th colspan="2" align="center">Actions</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><div class="tooltip">${book.author.firstName} ${book.author.lastName}
                   <span class="tooltiptext">${book.author.firstName} ${book.author.lastName} ${book.author.gender} ${book.author.birthDate}</span>
                </div></td>
        <td>${book.name}</td>
        <td>${book.countPages}</td>
        <td>${book.publicationYear}</td>
        <td>${book.description}</td>
        <td>${book.genre}</td>
    </tr>
    </tbody>
</table>
</body>
</html>