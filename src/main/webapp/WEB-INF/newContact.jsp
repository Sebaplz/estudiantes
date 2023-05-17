<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<div class="container mt-5">
 <div class="d-flex justify-content-end">
        <a href="/" class="ms-3 fs-3">Dashboard</a>
    </div>
    <form:form action="/contact/new" method="post" modelAttribute="contact" class="mt-5">
            <p class="d-flex justify-content-between mx-3">
                <form:label path="student" class="fs-5">Student:</form:label>
                <form:errors path="student" class="text-danger"/>
                <form:select path="student">
                    <c:forEach items="${students}" var="s">
                        <form:option value="${s.id}">${s.firstName} ${s.lastName}</form:option>
                    </c:forEach>
                </form:select>
            </p>
            <p class="d-flex justify-content-between mx-3">
                <form:label path="address" class="fs-5">Address:</form:label>
                <form:errors path="address" class="text-danger"/>
                <form:input path="address"/>
            </p>
            <p class="d-flex justify-content-between mx-3">
                <form:label path="city" class="fs-5">City:</form:label>
                <form:errors path="city" class="text-danger"/>
                <form:input path="city"/>
            </p>
            <p class="d-flex justify-content-between mx-3">
                <form:label path="state" class="fs-5">State:</form:label>
                <form:errors path="state" class="text-danger"/>
                <form:input path="state"/>
            </p>
            <div class="d-flex justify-content-end me-3">
                <input type="submit" value="Create" class="btn btn-primary"/>
            </div>
        </form:form>
    </div>
</div>

