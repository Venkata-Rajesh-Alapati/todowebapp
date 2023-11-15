<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="common/header.jspf"%>
<%@include file="common/footer.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
	<h2>Your TODOs</h2>
	<div class="table">
		<table>
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Done</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="todo" items="${todos }">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a href="/delete-todo?id=${todo.id}"
							class="btn btn-warning">DELETE</a></td>
						<td><a href="/update-todo?id=${todo.id}"
							class="btn btn-success">UPDATE</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br /> <a href="/add-todo" class="btn btn-success">Add ToDo</a>
	</div>
</div>