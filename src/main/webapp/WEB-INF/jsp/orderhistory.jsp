<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>${title}</title>
    <style>
        .table-responsive{margin-top:25px;}
    </style>
</head>
<body>
<h1>Orders history</h1>
<h2>Your orders</h2>

        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>#</th>
                    <th>date</th>
                    <th>Price</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="command" items="${allcommand}">
                <tr>
                    <td>${command.id}</td>
                    <td>${command.date}</td>
                    <td>${command.total_price}</td>
                    <td><a href="/firstSpring/command/"${command.id}>${command.status}</a></td>
                   <!-- <td><span class="label label-info">${status}</span></td>-->
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
</body>
</html>