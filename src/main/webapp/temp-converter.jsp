<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String result = (String)request.getAttribute("result");
  if(result == null) {
    result = "";
  }
  String temp = (String)request.getAttribute("temp");
  if(temp == null) {
    temp = "";
  }
  String tempError = (String) request.getAttribute("tempError");
  if(tempError == null) {
    tempError = "";
  }


%>



<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Temperature Converter</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container my-4">
  <div class="row">
    <div class="col-6">
      <h1>Temperature Converter</h1>
      <p class="lead">Enter Fahrenheit To be Converter to Celsius.</p>
      <form action="temp-converter" method="post">
        <div class="form-group mb-2">
          <label for="temp">Enter Fahrenheit:</label>
          <input type="text" class="form-control" id="temp" name="temp" value="<%= temp%>">
          <div style="color: red;"><%= tempError %></div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
      </form>
      <div style="color: green;"><%= result %></div>
    </div>
  </div>
</div>

      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
