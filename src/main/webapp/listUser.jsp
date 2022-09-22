<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="com.db.entity.User" %>
<c:import url="include/header.jsp"><c:param name="title" value="List Users"/></c:import>
<div class="container mtb">
	<div class="row">
		<div class="col-lg-6">
			<strong>Listing users</strong>
			<hr/>
			<table border="1">
			<thead>
			<th>User ID </th>
			<th>Username </th>
			<th>Email </th>
			</thead>
			<%
			List<User> listUsers = (List)request.getAttribute("listUsers");
			for(int i=0;i<listUsers.size(); i++){
				out.print("<tr>");
				out.print("<td>"+listUsers.get(i).getUsers_id()+"</td>");
				out.print("<td>"+listUsers.get(i).getUsername()+"</td>");
				out.print("<td>"+listUsers.get(i).getEmail()+"</td>");
				out.print("</tr>");
			}
			
			%>
			</table>
		</div>
	</div>
</div>
<c:import url="include/footer.jsp"></c:import>






