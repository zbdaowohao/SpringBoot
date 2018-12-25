<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <title>Login Page</title>
    <link href="./plugin/jQuery/css/jquery-ui.css" rel="stylesheet" media="screen">
    <link href="./plugin/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="./plugin/bootstrap-3.3.7/css/buttons.css" rel="stylesheet" media="screen">
    <link href="./plugin/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" media="screen">
    <link href="./plugin/shiningWords/style.css" rel="stylesheet"/>

    <script src="./plugin/jQuery/js/jquery-3.2.1.js"></script>
    <script src="./plugin/bootstrap-3.3.7/js/bootstrap.js"></script>
    <script src="./plugin/jQuery/js/jquery.cycle.all.js"></script>
    <script src="./plugin/jQuery/js/jquery-ui.js"></script>
    <!-- 页面代码 -->
    <script src="./js/login.js"></script>
    <style type="text/css">
    * {
        margin: 0;
        padding: 0;
    }
    html, body {
        height: 100%;
        width: 100%;
        overflow: hidden;
    }
    form,.avatar,#showName{
        z-index: 999;
    }
    label,.col-md-4{
        position: relative;
        top: -5px;
        text-align: left;
        color: #fff;
        padding-left: 20px;
        padding-right: 0;
    }
    .form-group {
        margin-top: 10px;
        margin-bottom: 0;
    }
    .form-control,.input-group-addon{
        background-color: rgba(0, 0, 0, 0.5);
    }
    h4{
        font-family: 'open-sans-light', sans-serif;
        font-weight: normal;
    }
    #showName{
        text-align: center;
        background: none;
    }
    #showName:focus{
        border: 0;
        outline: none;
        box-shadow: none;
    }
    #showName a{
        text-decoration: none;
    }
    </style>
</head>
<body>
    <div id="content">
        <div id="slideshow">
            <img src="./images/defaultLogin1.jpg">
            <img src="./images/defaultLogin2.jpg">
        </div>
        <form class="form-horizontal col-md-4" style="position: absolute;" role="form">
            <div class="avatar" style="position: absolute;">
               <button class="button button-circle" onclick="login()" type="button">
                    <i class="fa fa-github-alt"></i>
               </button> 
            </div>
            <div id="showName" class="col-md-8" style="position: absolute;">
                <p class="shiningPressStart"><a href="#"></a></p>
            </div>
            <div class="form-group">
                <label for="userName" class="col-md-4"><h4>User Name :</h4></label>
                <div class="col-md-8">
                    <input type="text" id="userName" onblur="associateName()" class="form-control" title="Plese enter the user name." style="color: #fff; font-size: 18px;">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-md-4"><h4>Password :</h4></label>
                <div class="col-md-8">
                    <div class="input-group" title="Plese enter the password.">
                        <input type="password" id="password" class="form-control" style="color: #fff; font-size: 18px;">
                        <span class="input-group-addon" style="font-size: 20px; background-color: #fff; cursor:pointer">&#8629;</span>
                    </div>
                </div>
            </div>
        </form>
    </div> 
    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-body">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span class="model_close" aria-hidden="true">&times;</span></button>
            <h4 id="loginInfo"></h4>
          </div>
        </div>
      </div>
    </div>   
</body>
</html>