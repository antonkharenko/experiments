<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div>
	<h2>Createa free Spitter account</h2>
	<sf:form method="POST" modelAttribute="spitter">
	<fieldset>
		<table cellspacing="0">
			<tr>
				<th><label for="user_screen_name">Username:</label></th>
				<td>
					<sf:input path="username" size="15" maxlength="15" id="user_screen_name"/>
					<small id="username_msg">No spaces, please.</small>
				</td>
			</tr>
			<tr>
				<th><label for="user_full_name">Fullname:</label></th>
				<td><sf:input path="fullName" size="15" id="user_full_name"/></td>
			</tr>
			<tr>
				<th><label for="user_password">Password:</label></th>
				<td>
					<sf:password path="password" size="30" showPassword="true" id="user_password"/>
					<small>6 characters or more (be tricky!)</small>
				</td>
			</tr>
			<tr>
				<th></th>
				<td>
					<input name="commit" type="submit" value="I accept. Create my account."/>
				</td>
			</tr>
		</table>
	</fieldset>
	</sf:form>
</div>