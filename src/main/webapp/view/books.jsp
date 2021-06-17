<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>GOIT Library</title>
        <style><%@include file="/view/css/style.css"%></style>
    </head>
    <body>
    <c:import url="/view/navibar.jsp"/>
    <table border="1" cellpadding="5">
        <thead>
            <tr>
                <td>Author</td>
                <td>Book name</td>
                <td>Pages</td>
                <td>Publication year</td>
                <td>Genre</td>
            </tr>
        </thead>
        <tbody>
             <c:forEach var="book" items="${books}">
                 <tr>
                     <td>${book.author}</td>
                     <td>${book.name}</td>
                     <td>${book.countPages}</td>
                     <td>${book.publicationYear}</td>
                     <td>${book.genre}</td>
                     <td> <a href="/books/findById?id=${book.id}">
                             <button>Details</button>
                          </a>
                      </td>
                 </tr>
             </c:forEach>
        </tbody>
     </table>
    </body>
</html>