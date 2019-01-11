<!DOCTYPE>
<html>
<head>
    <title>freemark</title>
</head>
<body>
<h1>欢迎回来！${(user.userName)!''}</h1>
<a href="/dept/toAdd">添加</a>
<table>
    <tr>
        <td>Id<td>
        <td>部门名称<td>
        <td>操作<td>
    </tr>
    <#if departments?? && departments?size gt 0>
        <#list departments as department>
        <tr>
            <td>${department.id!''}<td>
            <td>${department.deptName!''}<td>
            <td>
                <a href="/dept/del/${department.id!''}">删除</a>
                <a href="/dept/toUpdate/${department.id!''}">更新</a>
            <td>
        </tr>
        </#list>
    </#if>

</table>
</body>
</html>
