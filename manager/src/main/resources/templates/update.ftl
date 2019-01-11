<!DOCTYPE>
<html>
<head>
    <title>freemark</title>
</head>
<body>
<form method="post" action="/dept/update">
    <input name="id" value="${department.id!''}" type="hidden">
    部门名称:<input name="deptName" value="${department.deptName!''}">
    <input type="submit" value="修改">
</form>
</body>
</html>
