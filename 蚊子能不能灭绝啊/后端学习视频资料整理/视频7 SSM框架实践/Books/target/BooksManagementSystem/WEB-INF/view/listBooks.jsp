<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
<h2>Book List</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Author</th>
        <th>PublishDate</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.publishDate}</td>
            <td>${book.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
