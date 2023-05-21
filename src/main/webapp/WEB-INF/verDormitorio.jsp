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
    <h1>${idDormitory.name} Dormitory</h1>
    <form:form action="/dorms/${idDormitory.id}" method="post" modelAttribute="dormitory" class="mt-5">
        <p class="d-flex justify-content-end mx-3">
            <form:input type="hidden" path="dormitory" value="${idDormitory.id}"/>
            <form:label path="dormitory" class="fs-5 me-3">Student:</form:label>
            <form:errors path="dormitory" class="text-danger"/>
            <form:select path="dormitory">
                <c:forEach items="${todosStudents}" var="s">
                    <form:option value="${s.id}">${s.firstName} ${s.lastName}</form:option>
                </c:forEach>
            </form:select>
        </p>
        <div class="d-flex justify-content-end me-3">
            <input type="submit" value="Add" class="btn btn-primary"/>
        </div>
    </form:form>
</div>

