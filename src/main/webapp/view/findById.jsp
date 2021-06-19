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
<table style="border:1px solid gray;width:100%;margin-left:auto;margin-right:auto;margin-top: 20px;font-size: large; font-family: Arial, Helvetica, sans-serif;"
       cellpadding="5">
    <caption>
        <h2>
            Book's details
        </h2>
    </caption>
    <thead style="background: lightgray; border:1px solid gray;">
    <tr>
        <style>
            td {
                border: 1px solid gray;
            }
        </style>

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
        <td>${book.author}</td>
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