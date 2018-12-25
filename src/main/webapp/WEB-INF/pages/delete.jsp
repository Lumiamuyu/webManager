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
            background-image: url("img/quit.png");
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
        a{
            text-decoration: none;
            color: white;
        }

        table {
            border: 1px solid #ccc;
            border-collapse: collapse;
            margin: 0;
            padding: 0;
            width: 100%;
            table-layout: fixed;
        }

        table caption {
            font-size: 1.5em;
            margin: .5em 0 .75em;
            color: #155fb4;
        }

        table tr {
            background-color: #236eb4;
            border: 1px solid #ddd;
            padding: .35em;
        }

        table th,
        table td {
            padding: .625em;
            text-align: center;
        }

        table th {
            font-size: .85em;
            letter-spacing: .1em;
            text-transform: uppercase;
        }

        @media screen and (max-width: 600px) {
            table {
                border: 0;
            }

            table caption {
                font-size: 1.3em;
            }

            table thead {
                border: none;
                clip: rect(0 0 0 0);
                height: 1px;
                margin: -1px;
                overflow: hidden;
                padding: 0;
                position: absolute;
                width: 1px;
            }

            table tr {
                border-bottom: 3px solid #ddd;
                display: block;
                margin-bottom: .625em;
            }

            table td {
                border-bottom: 1px solid #ddd;
                display: block;
                font-size: .8em;
                text-align: right;
            }

            table td::before {
                /*
                * aria-label has no advantage, it won't be read inside a table
                content: attr(aria-label);
                */
                content: attr(data-label);
                float: left;
                font-weight: bold;
                text-transform: uppercase;
            }

            table td:last-child {
                border-bottom: 0;
            }
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
        <li tabindex="0" class="icon-brand" onclick="brand()"><span>品牌管理</span></li>
        <li tabindex="0" class="icon-dashboard" onclick="search()"><span>查询</span></li>
        <li tabindex="0" class="icon-customers" onclick="add()"><span>增加</span></li>
        <li tabindex="0" class="icon-users" onclick="update()"><span>修改</span></li>
        <li tabindex="0" class="icon-settings"><span>删除</span></li>
        <li tabindex="0" class="icon-edit" onclick="edit()"><span>修改密码</span></li>
        <li tabindex="0" class="icon-exit" onclick="exit()"><span>退出</span></li>
    </ul>
</nav>

<main>

    <div>
        <table>
            <caption>产品删除</caption>
            <form id="sear" method="post">
                <input type="text" name="text" value="${text}">
                <input type="submit" value="搜索">
            </form>
            <thead>
            <tr>
                <th scope="col">编号</th>
                <th scope="col">名称</th>
                <th scope="col">价格</th>
                <th scope="col">图片</th>
                <th scope="col">描述</th>
                <th scope="col">库存</th>
                <th scope="col">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${lists}" var="pro">
                <tr>
                    <td>${pro.productId}</td>
                    <td>${pro.productName}</td>
                    <td>${pro.price}</td>
                    <td><img src="${pro.url}" height="50px" alt="pic"></td>
                    <td>${pro.productDes}</td>
                    <td>${pro.reverse}</td>
                    <td><a href="doDelete?productId=${pro.productId}"><input type="button" value="删除"></a></td>
                </tr>
            </c:forEach>
            <%--            <tr>
                            <td data-label="Account">Visa - 3412</td>
                            <td data-label="Due Date">04/01/2016</td>
                            <td data-label="Amount">$1,190</td>
                            <td data-label="Period">03/01/2016 - 03/31/2016</td>
                        </tr>
                        <tr>
                            <td scope="row" data-label="Account">Visa - 6076</td>
                            <td data-label="Due Date">03/01/2016</td>
                            <td data-label="Amount">$2,443</td>
                            <td data-label="Period">02/01/2016 - 02/29/2016</td>
                        </tr>
                        <tr>
                            <td scope="row" data-label="Account">Corporate AMEX</td>
                            <td data-label="Due Date">03/01/2016</td>
                            <td data-label="Amount">$1,181</td>
                            <td data-label="Period">02/01/2016 - 02/29/2016</td>
                        </tr>
                        <tr>
                            <td scope="row" data-label="Acount">Visa - 3412</td>
                            <td data-label="Due Date">02/01/2016</td>
                            <td data-label="Amount">$842</td>
                            <td data-label="Period">01/01/2016 - 01/31/2016</td>
                        </tr>--%>
            </tbody>
        </table>
    </div>

    <%--    <div class="helper">

    &lt;%&ndash;        RESIZE THE WINDOW
            <span>Breakpoints on 900px and 400px</span>&ndash;%&gt;

        </div>--%>
</main>



<script  src="js/index.js"></script>
<script type="text/javascript">
    function edit(){
        window.location.href="profileedit";
    }
    function search(){
        window.location.href="list";
    }
    function add(){
        window.location.href="add";
    }
    function update(){
        window.location.href="updateView";
    }
    function del(){
        window.location.href="delete";
    }
    function exit(){
        window.location.href="exit";
    }
    function brand() {
        window.location.href="brandlist";
    }

</script>




</body>

</html>
