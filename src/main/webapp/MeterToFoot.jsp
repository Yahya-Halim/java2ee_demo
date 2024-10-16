<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String result = (String)request.getAttribute("result");
  if(result == null) {
    result = "";
  }
  String meters = (String)request.getAttribute("meters");
  if(meters == null) {
    meters = "";
  }
  String metersError = (String) request.getAttribute("metersError");
  if(metersError == null) {
    metersError = "";
  }


%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Meter To Foot</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container my-4">
  <div class="row">
    <div class="col-6">
      <h1>Meters Converter</h1>
      <p class="lead">Enter meters To be Converter to Foot.</p>
      <form action="MeterToFoot" method="post">
        <div class="form-group mb-2">
          <label for="meters">Enter Meters:</label>
          <input type="text" class="form-control" id="meters" name="meters" value="<%= meters%>">
          <div style="color: red;"><%= metersError %></div>
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
