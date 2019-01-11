<!DOCTYPE>
<html>
<head>
    <title>freemark</title>
</head>
<body>
<form method="post" action="/user/login">
    姓名:<input name="userName">
    密码:<input name="passWord" type="password">
    <input type="submit" value="提交">
    ${msg!''}
</form>
</body>
</html>
