<%--
  Created by IntelliJ IDEA.
  User: Lumia
  Date: 2018/12/21
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Spectre sign up form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,300'>
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto:400,700,300'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>

    <!-- <link rel="stylesheet" href="css/style.css"> -->
    <style type="text/css">
        body {
            font: 100% / 1.414 "Open Sans", "Roboto", arial, sans-serif;
            background: #e9e9e9;
        }

        a,
        [type="submit"] {
            transition: all .25s ease-in;
        }

        .signup__container {
            position: absolute;
            top: 50%;
            right: 0;
            left: 0;
            margin-right: auto;
            margin-left: auto;
            -webkit-transform: translateY(-50%);
            transform: translateY(-50%);
            overflow: hidden;
            display: flex;
            align-items: center;
            justify-content: center;
            width: 50rem;
            height: 30rem;
            border-radius: 0.1875rem;
            box-shadow: 0px 0.1875rem 0.4375rem rgba(0, 0, 0, 0.25);
        }

        .signup__overlay {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.76);
        }

        .container__child {
            width: 50%;
            height: 100%;
            color: #fff;
        }

        .signup__thumbnail {
            position: relative;
            padding: 2rem;
            display: flex;
            flex-wrap: wrap;
            align-items: center;
            background: url(https://wallpapers.wallhaven.cc/wallpapers/full/wallhaven-714946.jpg);
            background-repeat: no-repeat;
            background-position: top center;
            background-size: cover;
        }

        .thumbnail__logo,
        .thumbnail__content,
        .thumbnail__links {
            position: relative;
            z-index: 2;
        }

        .thumbnail__logo {
            align-self: flex-start;
        }

        .logo__shape {
            fill: #fff;
        }

        .logo__text {
            display: inline-block;
            font-size: .8rem;
            font-weight: 700;
            vertical-align: bottom;
        }

        .thumbnail__content {
            align-self: center;
        }

        h1,
        h2 {
            font-weight: 300;
            color: white;
        }

        .heading--primary {
            font-size: 1.999rem;
        }

        .heading--secondary {
            font-size: 1.414rem;
        }

        .thumbnail__links {
            align-self: flex-end;
            width: 100%;
        }

        .thumbnail__links a {
            font-size: 1rem;
            color: #fff;
        }
        .thumbnail__links a:focus, .thumbnail__links a:hover {
            color: rgba(255, 255, 255, 0.5);
        }

        .signup__form {
            padding: 2.5rem;
            background: #fafafa;
        }

        label {
            font-size: .85rem;
            text-transform: uppercase;
            color: #ccc;
        }

        .form-control {
            background-color: transparent;
            border-top: 0;
            border-right: 0;
            border-left: 0;
            border-radius: 0;
        }
        .form-control:focus {
            border-color: #111;
        }

        [type="text"] {
            color: #111;
        }

        [type="password"] {
            color: #111;
        }

        .btn--form {
            padding: .5rem 2.5rem;
            font-size: .95rem;
            font-weight: 600;
            text-transform: uppercase;
            color: #fff;
            background: #111;
            border-radius: 2.1875rem;
        }
        .btn--form:focus, .btn--form:hover {
            background: #323232;
        }

        .signup__link {
            font-size: .8rem;
            font-weight: 600;
            text-decoration: underline;
            color: #999;
        }
        .signup__link:focus, .signup__link:hover {
            color: #787878;
        }

    </style>

</head>

<body>

<div class="signup__container">
    <div class="container__child signup__thumbnail">
        <div class="thumbnail__logo">
            <svg class="logo__shape" width="25px" viewBox="0 0 634 479" xmlns="http://www.w3.org/2000/svg">
            </svg>
            <h1 class="logo__text">Sign Up</h1>
        </div>
        <div class="thumbnail__content text-center">
            <h1 class="heading--primary">欢迎.</h1>
            <h2 class="heading--secondary">Ni Jue De Wo Zai Shuo Shen Me?</h2>
        </div>
        <div class="thumbnail__links">
        </div>
        <div class="signup__overlay"></div>
    </div>
    <div class="container__child signup__form">
        <form action="#">
            <div class="form-group">
                <label for="username">username</label>
                <input class="form-control" type="text" name="username" id="username" placeholder="username" required />
            </div>
            <div class="form-group">
                <label for="email">email</label>
                <input class="form-control" type="email" name="email" id="email" placeholder="username@domain.com" required />
            </div>
            <div class="form-group">
                <label for="password">password</label>
                <input class="form-control" type="password" name="password" id="password" placeholder="请输入6-16位密码" required />
            </div>
            <div class="form-group">
                <label for="passwordRepeat">confirm password</label>
                <input class="form-control" type="password" name="passwordRepeat" id="passwordRepeat" placeholder="确认已输入的密码"
                       required />
            </div>
            <div class="m-t-lg">
                <ul class="list-inline">
                    <li>
                        <input class="btn btn--form" type="submit" value="注册" />
                    </li>
                    <li>
                        <a class="signup__link" href="login">已经注册？请登录</a>
                    </li>
                </ul>
            </div>
        </form>
    </div>
</div>



</body>

</html>
