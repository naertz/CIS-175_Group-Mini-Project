<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="icon" href="#">
        <title>Tasklist - Add Category Group</title>
    </head>
    <body>
        <form action="CreateNewCategoryGroupServlet" method="post">
            <fieldset>
                <legend>Enter the category group's name:</legend>
                <input type="text" name="name">
            </fieldset>
            <fieldset>
                <legend>Add tasks to the category group:</legend>
                <select name="tasks" multiple size="16">
                    <c:forEach var="task" items="${requestScope.tasks}">
                        <option value="${task.id}">${task.name} | Assigned to: ${task.person} | Due: ${task.dueDate}</option>
                    </c:forEach>
                </select>
            </fieldset>
            <fieldset>
                <legend>Submit the category group:</legend>
                <input type="submit" value="Submit">
            </fieldset>
        </form>
        <a href="index.html">Add tasks</a>
    </body>
</html>