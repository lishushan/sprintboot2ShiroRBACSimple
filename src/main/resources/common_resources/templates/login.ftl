<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <style type="text/css">
        #login_div{
            width: 200px;
            height: 400px;
            top: 50%;
            left: 50%;
            margin-left: -55px;
            margin-top: -200px;
            position: absolute;
        }
    </style>
</head>
<body>
    <div id="login_div">
        <form action="/login" method="post">
            用户名：<input name="username" type="text"  /><br/>
            密码：<input name="password" type="password"/><br/>
            <button type="submit">提交</button>
        </form>
    </div>
</body>
</html>