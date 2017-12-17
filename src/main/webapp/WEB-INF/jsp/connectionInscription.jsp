<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>${title}</title>
</head>
<body>
<h1>Bravo !!</h1>

<div class="w3-padding-64 w3-light-grey w3-small w3-center">
<div class="w3-row-padding">
    <h4>Inscription</h4>
    <p>Register your account here !</p>
<form:form  id="inscriptionClient" method="POST" action="/firstSpring/inscriptionClient/send" modelAttribute="currentClient">
    <p><form:input class="w3-input w3-border" type="text" path="email" placeholder="Email" name="Email"></form:input></p>
    <p><form:errors path="email" class="required"/></p>
    <p><form:input class="w3-input w3-border" type="password" path="password" placeholder="Password" name="Password"></form:input></p>
    <p><form:errors path="password" class="required"/></p>
    <p><form:input class="w3-input w3-border" type="password" path="passwordConfirmation" placeholder="Password Confirmation" name="Password"></form:input></p>
    <p><form:errors path="passwordConfirmation" class="required"/></p>
    <p><form:input class="w3-input w3-border" type="text" path="first_name" placeholder="FirstName" name="FirstName"></form:input></p>
    <p><form:errors path="first_name" class="required"/></p>
    <p><form:input class="w3-input w3-border" type="text" path="last_name" placeholder="LastName" name="LastName"></form:input></p>
    <p><form:errors path="last_name" class="required"/></p>
    <p><form:input class="w3-input w3-border" type="text" path="street_name" placeholder="StreetName" name="StreetName"></form:input></p>
    <p><form:errors path="street_name" class="required"/></p>
    <p><form:input class="w3-input w3-border" type="text" path="number_address" placeholder="NumberAddress" name="NumberAddress"></form:input></p>
    <p><p><form:errors path="number_address" class="required"/></p></p>
    <p><form:input class="w3-input w3-border" type="text" path="phone_number" placeholder="PhoneNumber" name="PhoneNumber"></form:input></p>
    <p><form:errors path="phone_number" class="required"/></p>
    <p><form:input class="w3-input w3-border" type="text" path="city" placeholder="City" name="City"></form:input></p>
    <p><form:errors path="city" class="required"/></p>
    <p><form:input class="w3-input w3-border" type="text" path="zip" placeholder="Zip" name="Zip"></form:input></p>
    <p><form:errors path="zip" class="required"/></p>
    <p><form:input class="w3-input w3-border" type="text" path="country" placeholder="Country" name="Country"></form:input></p>
    <p><form:errors path="country" class="required"/></p>

    <p><form:input class="w3-input w3-border" type="text" path="job" placeholder="Job" name="Job"></form:input></p>
    <p><form:errors path="job"/></p>

    <form:button type="submit" class="w3-button w3-block w3-black">Send</form:button>
</form:form>
    </div>
</div>
</body>
</html>