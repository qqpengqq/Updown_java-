<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Spring MVC表单处理(复选框)</title>
</head>
<body>
   <h2>用户信息</h2>
   	<form:form method="POST" action="/Updown_java/adduser"  enctype="multipart/form-data">
   		<table>
   			<tr>
   				<td><form:label path="username">用户名：</form:label></td>
   				<td><form:input path="username"/></td>
   			</tr>
   			<tr>
   				<td><form:label path="password">密码：</form:label></td>
   				<td><form:password path="password"/></td>
   			</tr>
   			<tr>
   				<td><form:label path="address">地址：</form:label></td>
   				<td><form:textarea path="address"  rows="5" cols="30"/></td>
   			
   			</tr>
   			<tr>
   				<td><form:label path="receivePaper">订阅新闻？</form:label></td>
   				<td><form:checkbox path="receivePaper"/></td>
   			</tr>
   			<tr>
   				<td><form:label path="favoriteFrameworks">喜欢的技术/框架</form:label></td>
   				<td><form:checkboxes items="${webFrameworkList}" path="favoriteFrameworks" /></td>
   			</tr>
   			<tr>
   				<td><form:label path="gender">性别</form:label></td>
   				<td><form:radiobutton path="gender" value="M" label="男" />
					<form:radiobutton path="gender" value="F" label="女" /></td>
   			</tr>
   			<tr>
   				<td><form:label path="favoriteNumber">你喜欢的数字</form:label></td>
   				<td><form:radiobuttons items="${numbersList}" path="favoriteNumber"/></td>
   			</tr>
   			<tr>
   				<td><form:label path="country">所有国家：</form:label></td>
   				<td><form:select path="country">
   						<form:option value="NONE" label="请选择"/>
   						<form:options items="${countryList}"/>
   					</form:select></td>
   			</tr>
   			<tr>
   				<td><form:label path="file">上传文件：</form:label></td>
   				<td><form:input path="file" type = "file"/></td>
   			</tr>
   			<tr>
   				<td colspan="2"><input type="submit" value="提交"/> </td>
   				
   			</tr>
   		</table>
   	
   	
   	</form:form>

</body>
</html>