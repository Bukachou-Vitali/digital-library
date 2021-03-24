<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Book Update</title>
    </head>

        <h2>Update information:</h2>


    <body>

        <form action="<%=request.getContextPath() %>/book/update" method="post">
            <table border="1">
                     <tr>
                          <th>ID</th>
                          <th>Name</th>
                          <th>Author</th>
                          <th>Year</th>
                          <th>Description</th>
                     </tr>
                     <tr>
                          <td>${idUpdate}</td>
                          <input type="hidden" name="updateIdBook" value="${idUpdate}"/>
                          <td><input type="text" name="nameUpdateBook" value="${nameUpdate}"/></td>
                          <td><input type="text" name="authorUpdateBook" value="${authorUpdate}"/></td>
                          <td><input type="text" name="yearUpdateBook" value="${yearUpdate}"/></td>
                          <td><input type="text" name="descriptionUpdateBook" value="${descriptionUpdate}"/></td>
                     </tr>
            </table>
            <button type="submit">Update</button>
        </form>

        <form action="<%=request.getContextPath() %>/" method="get">
        <button type="submit">Cancel</button>
        </form>



    </body>
</html>