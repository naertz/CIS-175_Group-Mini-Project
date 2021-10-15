<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="icon" href="#">
        <title>Tasklist - Edit Task</title>
    </head>
    <body>
        <h1>Edit the Task:</h1>
        <form action="EditTaskServlet" method="post">
            <fieldset>
                <legend>Enter the person's name this task is assigned to:</legend>
                <input type="text" name="personName" value="${newTask.person.name}">
            </fieldset>
            <fieldset>
                <legend>Enter the task's name:</legend>
                <input type="text" name="name" value="${newTask.name}">
            </fieldset>
            <fieldset>
                <legend>Enter the task's due date:</legend>
                <input type="text" name="month" placeholder="mm" size="4" value="${month}">
                <input type="text" name="day" placeholder="dd" size="4" value="${day}">
                <input type="text" name="year" placeholder="yyyy" size="4" value="${year}">
            </fieldset>
            <fieldset>
                <legend>Update the task:</legend>
                <input type="hidden" name="id" value="${newTask.id}">
                <input type="submit" value="Save">
            </fieldset>
        </form>
    </body>
</html>