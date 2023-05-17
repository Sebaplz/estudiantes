<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<div class="container mt-5">
    <div class="d-flex justify-content-around mb-3">
        <a href="/students/new" class="mt-2">New Student</a>
        <a href="/contact/new" class="mt-2">New Contact</a>
    </div>
    <h1>All Students</h1>
    <div>
        <table class="table table-striped border border-1">
            <thead>
                <tr class="table-secondary">
                    <th scope="col">Name</th>
                    <th scope="col">Age</th>
                    <th scope="col">Address</th>
                    <th scope="col">City</th>
                    <th scope="col">State</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${allStudents}" var="student">
                <tr>
                    <td>${student.firstName} ${student.lastName}</td>
                    <td>${student.age}</td>
                    <td>${student.contact.address}</td>
                    <td>${student.contact.city}</td>
                    <td>${student.contact.state}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

