<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>GOIT Library</title>
    </head>
    <body>
    <p>GOIT Library</p>
    <c:set var="book" value="${book}" />
    <table border="1" cellpadding="5">
        <thead>
            <tr>
                <td>Author</td>
                <td>Book name</td>
                <td>Pages</td>
                <td>Publication year</td>
                <td>Description</td>
                <td>Genre</td>
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