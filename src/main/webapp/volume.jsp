<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String radius = request.getParameter("radius") != null ? request.getParameter("radius") : "";
    String height = request.getParameter("height") != null ? request.getParameter("height") : "";
    String error = (String) request.getAttribute("error");
    String result = (String) request.getAttribute("result");
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Volume/  Area Calculator</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
</head>
<body>
<div class="container my-4">
    <h1>Volume / Area of circle & cylinder Calculator</h1>
    <p class="lead">Enter the radius and height to calculate the volume or area of the circle & cylinder.</p>

    <form action="volume" method="post">
        <div class="form-group mb-3">
            <label for="radius">Radius:</label>
            <input type="text" class="form-control" id="radius" name="radius" value="<%= radius %>">
        </div>
        <div class="form-group mb-3">
            <label for="height">Height:</label>
            <input type="text" class="form-control" id="height" name="height" value="<%= height %>">
        </div>

        <% if (error != null) { %>
        <div style="color: red;">
            <%= error %>
        </div>
        <% } %>

        <% if (result != null) { %>
        <div style="color: green;">
            Volume: <%= result %>
        </div>
        <% } %>

        <button type="submit" class="btn btn-primary">Calculate Volume</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
