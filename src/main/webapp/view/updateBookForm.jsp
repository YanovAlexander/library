<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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

<h2 align="center" class="formCapture">
    Update a book
</h2>
<form:form name="bookForm" method="post" action="/books/update" modelAttribute="book">
    <form:input type="hidden" path="id" name="id" value='${book.id}'/>
    Author: <form:select path="authorId" items="${authors}" itemLabel="fullName" itemValue="id">
            </form:select>
    Name: <form:input type="text" name="name" path="name" placeholder="<c:out value='${book.name}'/>"/> <br/>
    Pages: <form:input type="number" name="countPages" path="countPages" placeholder="${book.countPages}"/> <br/>
    Publication Year: <form:input type="number" min="1900" max="2099" step="1"
                             placeholder="${book.publicationYear}" path="publicationYear" name="publicationYear"/> <br/>
    Description: <form:input type="text" path="description" name="description" placeholder="${book.description}"/> <br/>
    Genre: <form:select id="genre" path="genre" name="genre" items="${genres}"/>
    <input type="submit" value="Update Book"/>
</form:form>
</body>
</html>