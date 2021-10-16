<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="icon" href="#">
        <title>Tasklist - Categories</title>
    </head>
    <body>
        <form action="CategoryGroupNavigationServlet" method="post">
            <table>
                <c:forEach var="currentCategory" items="${requestScope.categories}">
                    <tr>
                        <td><input type="radio" id="category" name="id" value="${currentCategory.id}"><label for="category">${currentCategory.name}</label></td>
                    </tr>
                    <tr>
                        <td>Tasklist:</td>
                        <c:forEach var="task" items="${currentCategory.tasks}">
                            <td>
                                <h3>${task.name}</h3>
                            </td>
                            <td>
                                <ul>
                                    <li>Assigned to: ${task.person.name}</li>
                                    <li>Due: ${task.dueDate}</li>
                                </ul>
                            </td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" value="Add Category Group" name="performCategoryAction">
            <input type="submit" value="Edit Category Group" name="performCategoryAction">
            <input type="submit" value="Delete Category Group" name="performCategoryAction">
        </form>
        <a href="AddCategoryGroupServlet">Add new category group</a><br>
        <a href="index.html">Add new task</a>
    </body>
</html>