<%--
  Created by IntelliJ IDEA.
  User: Lumia
  Date: 2018/12/21
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" >

<head>
    <meta charset="UTF-8">
    <title>List</title>

    <style type="text/css">
        body {
            background: #cfe7fa;
            margin: 0;
            font-family: "Open Sans", Helvetica Neue, Helvetica, Arial, sans-serif;
            color: #fff;
            padding-left: 240px;
        }
        main {
            position: relative;
            height: 100vh;
        }
        main .helper {
            background: rgba(0, 0, 0, 0.2);
            color: #ffea92;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate3d(-50%, -50%, 0);
            padding: 1.2em 2em;
            text-align: center;
            border-radius: 20px;
            font-size: 18px;
            font-weight: normal;
        }
        main .helper table {
            color: rgba(0, 0, 0, 0.5);
            font-size: 15px;
            font-family: "Microsoft YaHei UI";
            display: block;
        }
        .menu {
            background: #236eb4;
            height: 100vh;
            width: 240px;
            position: fixed;
            top: 0;
            left: 0;
            z-index: 5;
            outline: none;
        }
        .menu .avatar {
            background: rgba(0, 0, 0, 0.1);
            padding: 2em 0.5em;
            text-align: center;
        }
        .menu .avatar img {
            width: 100px;
            border-radius: 50%;
            overflow: hidden;
            border: 4px solid #ffea92;
            box-shadow: 0 0 0 4px rgba(255, 255, 255, 0.2);
        }
        .menu .avatar h2 {
            font-weight: normal;
            margin-bottom: 0;
        }
        .menu ul {
            list-style: none;
            padding: 0.5em 0;
            margin: 0;
        }
        .menu ul li {
            padding: 0.5em 1em 0.5em 3em;
            font-size: 0.95em;
            font-weight: regular;
            background-repeat: no-repeat;
            background-position: left 15px center;
            background-size: auto 20px;
            transition: all 0.15s linear;
            cursor: pointer;
        }
        .menu ul li.icon-dashboard {
            background-image: url("img/search.png");
        }
        .menu ul li.icon-customers {
            background-image: url("img/add.png");
        }
        .menu ul li.icon-users {
            background-image: url("img/update.png");
        }
        .menu ul li.icon-settings {
            background-image: url("img/delete.png");
        }
        .menu ul li.icon-exit {
            background-image: url("img/Back.png");
        }
        .menu ul li.icon-edit {
            background-image: url("img/key.png");
        }
        .menu ul li.icon-brand {
            background-image: url("img/brand.png");
        }

        .menu ul li:hover {
            background-color: rgba(0, 0, 0, 0.1);
        }
        .menu ul li:focus {
            outline: none;
        }
        @media screen and (max-width: 900px) and (min-width: 400px) {
            body {
                padding-left: 90px;
            }
            .menu {
                width: 90px;
            }
            .menu .avatar {
                padding: 0.5em;
                position: relative;
            }
            .menu .avatar img {
                width: 60px;
            }
            .menu .avatar h2 {
                opacity: 0;
                position: absolute;
                top: 50%;
                left: 100px;
                margin: 0;
                min-width: 200px;
                border-radius: 4px;
                background: rgba(0, 0, 0, 0.4);
                transform: translate3d(-20px, -50%, 0);
                transition: all 0.15s ease-in-out;
            }
            .menu .avatar:hover h2 {
                opacity: 1;
                transform: translate3d(0px, -50%, 0);
            }
            .menu ul li {
                height: 60px;
                background-position: center center;
                background-size: 30px auto;
                position: relative;
            }
            .menu ul li span {
                opacity: 0;
                position: absolute;
                background: rgba(0, 0, 0, 0.5);
                padding: 0.2em 0.5em;
                border-radius: 4px;
                top: 50%;
                left: 80px;
                transform: translate3d(-15px, -50%, 0);
                transition: all 0.15s ease-in-out;
            }

            .exit{
                text-decoration: none;
                color: white;
            }

            .menu ul li span a{
                text-decoration: none;
                color: white;
            }
            .menu ul li span:before {
                content: '';
                width: 0;
                height: 0;
                position: absolute;
                top: 50%;
                left: -5px;
                border-top: 5px solid transparent;
                border-bottom: 5px solid transparent;
                border-right: 5px solid rgba(0, 0, 0, 0.5);
                transform: translateY(-50%);
            }
            .menu ul li:hover span {
                opacity: 1;
                transform: translate3d(0px, -50%, 0);
            }
        }
        @media screen and (max-width: 400px) {
            body {
                padding-left: 0;
            }
            .menu {
                width: 230px;
                box-shadow: 0 0 0 100em rgba(0, 0, 0, 0);
                transform: translate3d(-230px, 0, 0);
                transition: all 0.3s ease-in-out;
            }
            .menu .smartphone-menu-trigger {
                width: 40px;
                height: 40px;
                position: absolute;
                left: 100%;
                background: #5bc995;
            }
            .menu .smartphone-menu-trigger:before,
            .menu .smartphone-menu-trigger:after {
                content: '';
                width: 50%;
                height: 2px;
                background: #fff;
                border-radius: 10px;
                position: absolute;
                top: 45%;
                left: 50%;
                transform: translate3d(-50%, -50%, 0);
            }
            .menu .smartphone-menu-trigger:after {
                top: 55%;
                transform: translate3d(-50%, -50%, 0);
            }
            .menu ul li {
                padding: 1em 1em 1em 3em;
                font-size: 1.2em;
            }
            .menu:focus {
                transform: translate3d(0, 0, 0);
                box-shadow: 0 0 0 100em rgba(0, 0, 0, 0.6);
            }
            .menu:focus .smartphone-menu-trigger {
                pointer-events: none;
            }
        }

        input {
            border:1px solid #ccc;
            width:200px;
            padding:10px;
            margin:5px 15px;
            border-radius:5px;
        }
        .send {
            width:220px;
        }

        h1{
            margin-left: 15px;
            color: #155fb4;
        }

        form{
            color: #155fb4;
            padding-left: 15px;
        }

        #rId{
            margin-top: 20px;
            margin-left: 30px;
            margin-bottom: 20px;
        }

        select{
            height: 30px;
            width: 100px;
        }


    </style>



</head>

<body>

<nav class="menu" tabindex="0">
    <div class="smartphone-menu-trigger"></div>
    <header class="avatar">
        <img src="img/head.png" />
        <h2>${user.username}</h2>
    </header>
    <ul>
        <li tabindex="0" class="icon-dashboard" onclick="search()"><span>用户查询</span></li>
        <li tabindex="0" class="icon-customers" onclick="add()"><span>用户增加</span></li>
        <li tabindex="0" class="icon-users" onclick="update()"><span>用户修改</span></li>
        <li tabindex="0" class="icon-settings" onclick="del()"><span>用户删除</span></li>
        <li tabindex="0" class="icon-exit" onclick="exit()"><span>返回</span></li>
    </ul>
</nav>

<main>
    <div>
        <h1>用户添加</h1>
    </div>

    <div>
        <form action="doUserUpdate" method="post">
            <input type="text" hidden="hidden" name="id" value="${u.id}">
            用户名称<input class='required' name="name" value="${u.username}" placeholder='用户名称' type='text'>

            <div id='br'>
                密码<input class='required' name="pwd" value="${u.password}" placeholder='密码' type='text'>
            </div>
            <div id='br'>
                邮箱<input class='required' name="email" value="${u.email}" placeholder='邮箱' type='text'>
            </div>
            <div id='br'>
                权限<select name="rId" id="rId" class='required'>
                        <option value="1">基本没有权限的管理员</option>
                        <option value="2">普通管理员</option>
                        <option value="3">超级管理员</option>
                    </select>

                <%--              <input class='required' name="brandname" placeholder='商品品牌' type='text'>--%>
            </div>

            <%--        <div id='br'>
                        <input placeholder='Phone' type='text'>
                    </div>--%>
            <div id='br'>
                <input class='send' type='submit' value='确认修改'>
            </div>
        </form>

    </div>

    <%--    <div class="helper">

    &lt;%&ndash;        RESIZE THE WINDOW
            <span>Breakpoints on 900px and 400px</span>&ndash;%&gt;

        </div>--%>
</main>

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    function brand() {
        window.location.href="brandlist";
    }

    function search(){
        window.location.href="userList";
    }
    function add(){
        window.location.href="userAdd";
    }
    function update(){
        window.location.href="userUpdateView";
    }
    function del(){
        window.location.href="userDelete";
    }
    function exit(){
        window.location.href="list";
    }

    function edit(){
        window.location.href="profileedit";
    }

    jQuery('document').ready(function($) {
        $('.required').keyup(function() {

            var empty = false;
            $('.required').each(function() {
                if ($(this).val() === '') {
                    empty = true;
                }
            });

            if (empty) {
                $('.send').prop('disabled', true);
                $('.send').css('background-color', '#ccc');
            } else {
                $('.send').prop('disabled', false);
                $('.send').css({'background-color': '#21759b','color':'#ffffff'});
            }
        });
    });

    function imgChange(obj){
        var les = (obj.files[0].name).substr((obj.files[0].name).indexOf(".")+1);
        if (les=="jpg"||les=="png"||les=="jpeg"||les=="gif"){
            var reader = new FileReader();
            reader.onload=function (e) {
                var img = document.getElementById("img");
                img.src=e.target.result;
            }
            reader.readAsDataURL(obj.files[0]);
        }else {
            img.src="";
        }
    }


</script>




</body>

</html>

