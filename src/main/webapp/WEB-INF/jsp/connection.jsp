<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>${title}</title>
    <style>
        body{padding-top:30px;}

        .glyphicon {  margin-bottom: 10px;margin-right: 10px;}

        small {
            display: block;
            line-height: 1.428571429;
            color: #999;
        }
    </style>

</head>
<body>
<h1><spring:message code="connection"/></h1>
<c:if test="${empty currentClient.last_name && empty currentClient.last_name}">
    <div class="w3-padding-64 w3-light-grey w3-small w3-center">
        <div class="w3-row-padding">
            <h4><spring:message code="connection"/></h4>
            <p></p>
            <form:form  id="inscriptionClient" method="POST" action="/firstSpring/connectionClient/send" modelAttribute="loginForm">

                <p><form:input class="w3-input w3-border" type="text" path="email" placeholder="Email" name="Email"></form:input></p>
                <p><form:errors path="email" class="required"></form:errors></p>


                <p>
                    <form:input class="w3-input w3-border" type="password" path="password" name="Password" placeholder="password"></form:input>
                    <form:errors path="password"></form:errors>
                </p>
                <p></p>
                <form:button type="submit" class="w3-button w3-block w3-black"><spring:message code="send"/></form:button>
            </form:form>
        </div>
        <p>

        </p>
        <a href="/firstSpring/inscriptionClient"><spring:message code="askInscription"/> </a>
    </div>
</c:if>
<c:if test="${currentClient.registered == true && not empty currentClient.last_name}">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="well well-sm">
                    <div class="row">
                        <div class="col-sm-6 col-md-4">
                            <img src="http://placehold.it/380x500" alt="" class="img-rounded img-responsive" />
                        </div>
                        <div class="col-sm-6 col-md-8">
                            <h4>${currentClient.first_name} ${currentClient.last_name}</h4>
                            <small>${currentClient.street_name} n°${currentClient.number_address}, ${currentClient.zip} ${currentClient.city}, ${currentClient.country} <i class="glyphicon glyphicon-map-marker">
                            </i></small>
                            <p>
                                <i class="glyphicon glyphicon-envelope"></i>${currentClient.email}
                                <br />
                                <i class="glyphicon glyphicon-earphone"></i>${currentClient.phone_number}</p>
                            <!-- Split button -->
                            <div class="btn-group">
                                <button type="button" class="btn btn-primary">
                                    Action</button>
                                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                                    <span class="caret"></span><span class="sr-only">Action</span>
                                </button>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="/firstSpring/cart"><spring:message code="cart"/></a></li>
                                    <li><a href="/firstSpring/cart/buyCommand"><spring:message code="historyOrder"/></a></li>
                                    <li><a href="#"><spring:message code="modify"/></a></li>
                                    <li><a href="#"><spring:message code="delete"/></a></li>
                                    <li class="divider"></li>
                                    <li><a href="/firstSpring/cart/logout"><spring:message code="logout"/></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</c:if>
</body>
</html>

