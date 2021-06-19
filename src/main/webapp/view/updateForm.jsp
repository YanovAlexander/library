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
<style>
    input[type=text], input[type=number], select {
        width: 100%;
        padding: 6px 10px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=submit] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 6px 10px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type=submit] {
        background-color: gray;
    }
</style>
<h2 align="center" style="font-size: 180%; font-family: Arial, Helvetica, sans-serif;margin-top: 30px;">
    Update a book
</h2>
<form style="margin-left: auto; margin-right: auto;" name="bookForm" method="post" action="/books/update">
    <input type="hidden" name="id" value='${book.id}'/>
    Author: <input type="text" name="author" value="<c:out value='${book.author}' />"/> <br/>
    Name: <input type="text" name="name" value="<c:out value='${book.name}'/>"> <br/>
    Pages: <input type="number" name="countPages" value="<c:out value='${book.countPages}' />"/> <br/>
    Publication Year: <input type="number" min="1900" max="2099" step="1"
                             value="<c:out value='${book.publicationYear}' />" name="publicationYear"/> <br/>
    Description: <input type="text" name="description" value="<c:out value='${book.description}'/>"/> <br/>
    Genre: <select id="genre" name="genre" selected="<c:out value='${book.genre}' />">
    <option value="ROMANCE">ROMANCE</option>
    <option value="DETECTIVE">DETECTIVE</option>
    <option value="FANTASY">FANTASY</option>
    <option value="HISTORICAL">HISTORICAL</option>
    <option value="HORROR">HORROR</option>
    <option value="WOMEN_FICTION">WOMEN_FICTION</option>
</select>
    <input type="submit" value="Update Book"/>
</form>
</body>
</html>