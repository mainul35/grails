<%--
  Created by IntelliJ IDEA.
  User: MiaVai
  Date: 10/02/2015
  Time: 8:50 PM
--%>



<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <asset:javascript src="lib/jquery-1.10.2.js"/>
    <asset:javascript src="lib/jquery.tablesorter.min.js"/>
    <asset:stylesheet src="tablesortable.css"/>

    <g:javascript>
        $(document).ready(function()
                {
                    $("#myTable").tablesorter();
                }
        );

    </g:javascript>

</head>

<body>
<table id="myTable" class="tablesorter">
    <thead>
    <tr>
        <th>Last Name</th>
        <th>First Name</th>
        <th>Email</th>
        <th>Due</th>
        <th>Web Site</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>Smith</td>
        <td>John</td>
        <td>jsmith@gmail.com</td>
        <td>$50.00</td>
        <td>http://www.jsmith.com</td>
    </tr>
    <tr>
        <td>Bach</td>
        <td>Frank</td>
        <td>fbach@yahoo.com</td>
        <td>$50.00</td>
        <td>http://www.frank.com</td>
    </tr>
    <tr>
        <td>Doe</td>
        <td>Jason</td>
        <td>jdoe@hotmail.com</td>
        <td>$100.00</td>
        <td>http://www.jdoe.com</td>
    </tr>
    <tr>
        <td>Conway</td>
        <td>Tim</td>
        <td>tconway@earthlink.net</td>
        <td>$50.00</td>
        <td>http://www.timconway.com</td>
    </tr>
    </tbody>
</table>
</body>
</html>