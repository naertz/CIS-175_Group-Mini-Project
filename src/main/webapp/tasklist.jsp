<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="icon" href="#">
        <title>Tasklist - Tasklist</title>
    </head>
    <body>
        <form action="TaskNavigationServlet" method="post">
            <table>
                <c:forEach var="currentTask" items="${requestScope.taskList}">
                    <tr>
                        <td><input type="radio" id="task" name="id" value="${currentTask.id}"><label for="task">${currentTask.name}</label></td>
                    </tr>
                    <tr>
                        <td>Assigned to:</td>
                        <td>${currentTask.person.name}</td>
                    </tr>
                    <tr>
                        <td>Due:</td>
                        <td>${currentTask.dueDate}</td>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" value="Add Task" name="performTaskAction">
            <input type="submit" value="Edit Task" name="performTaskAction">
            <input type="submit" value="Delete Task" name="performTaskAction">
        </form>
    </body>
</html>