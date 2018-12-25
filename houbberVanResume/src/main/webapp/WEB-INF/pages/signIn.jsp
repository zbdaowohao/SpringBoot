<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <title>Register Page</title>
    <link href="./plugin/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="./plugin/bootstrap-3.3.7/css/bootstrapValidator.css" rel="stylesheet" media="screen">
    <link href="./plugin/thin-admin/thin-admin.css" rel="stylesheet" media="screen">
    <link href="./plugin/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" media="screen">
    <link href="./plugin/thin-admin/switcher/style.css" rel="stylesheet">
    <link href="./plugin/thin-admin/switcher/switcher.css" rel="stylesheet">
    <link href="./plugin/thin-admin/switcher/switcher-defult.css" rel="stylesheet">
    <link href="./plugin/thin-admin/dashboard.css" rel="stylesheet">
    <link href="./plugin/thin-admin/switcher/wizard_progress.css" rel="stylesheet">
    
    
    <script src="./plugin/jQuery/js/jquery-3.2.1.js"></script>
    <script src="./plugin/switcher/switcher.js"></script>
    <script src="./plugin/switcher/moderziner.custom.js"></script>
    <script src="./plugin/switcher/smooth-sliding-menu.js"></script>
    <script src="./plugin/bootstrap-3.3.7/js/bootstrap.js"></script>
    <script src="./plugin/bootstrap-3.3.7/js/wizard_bootstrap.js"></script>
    <script src="./plugin/bootstrap-3.3.7/js/wizard.js"></script>
    <script src="./plugin/bootstrap-3.3.7\js/bootstrapValidator.js"></script>
    <!-- 国家、省份下拉选 -->
    <script src="./plugin/selectCountry_state.js"></script>
    <!-- 生成验证码 -->
    <script src="./plugin/gVerify.js"></script>
    <!-- 页面代码 -->
    <script src="./js/signIn.js"></script>
    <style type="text/css">
    body {
        background-size: cover;
        background-image: url(./images/sign-upBackgroundColor.jpg);
    }
    
    .widget {
        margin: 0 auto;
    }
    
    .col-md-2 {
        height: 40px;
    }
    
    #verificationCode_container {
        position: relative;
        left: -20px;
        top: 1px;
    }
    .widget{
    	display: block;
	    margin: 6% 15% 4% 15%;
    }
    .form-group{
    	margin-left: 0 !important;
    }
    #tab2 label{
    	text-align: center;
    }
    </style>
</head>

<body>
    <div class="wrapper">
        <div class="page-content">
            <div class="content container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="widget">
                            <div class="widget-header"> <i class="glyphicon glyphicon-pencil" style="font-size: 25px; margin: 0 10px 0 20px;"></i>
                            <h3 style="font-size: 25px">Process Registration</h3>
                            </div>
<div class="widget-content">
    <div id="wizard">
        <div id="rootwizard">
            <div class="navbar">
                <div class="navbar-inner">
                    <div class="container">
                        <ul class="nav">
                            <li class="active"><a href="#tab1" data-toggle="tab">Step 1</a></li>
                            <li class=""><a href="#tab2" data-toggle="tab">Step 2</a></li>
                            <li class=""><a href="#tab3" data-toggle="tab">Step 3</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div id="bar" class="progress progress-striped active">
                <div style="width: 42.8571%;" class="bar"></div>
            </div>
            <div class="tab-content">
                <div class="tab-pane active" id="tab1">
                    <form method="POST" action="" class="tab1-form-validat form-horizontal form-condensed">
                        <fieldset>
                            <div class="control-group">
                                <!-- Username -->
                                <label for="username" class="col-md-2">Username<span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="col-md-10">
                                        <input id="username" name="username" onblur="fillUserName();" data-bv-trigger="blur" placeholder="Username should contain 6-30 letters or numbers, without spaces ." type="text" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <div class="control-group">
                                <!-- Email -->
                                <label for="email" class="col-md-2">Email<span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="col-md-10">
                                        <input id="email" type="text" name="email" data-bv-trigger="blur" class="form-control" placeholder="Please provide your E-mail .">
                                    </div>
                                </div>
                            </div>
                            <div class="control-group">
                                <!-- Tel -->
                                <label for="tel" class="col-md-2">Tel</label>
                                <div class="form-group">
                                    <div class="col-md-10">
                                        <input id="tel" type="text" name="tel" data-bv-trigger="blur" class="form-control" placeholder="Please provide your phone Number .">
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
                <div class="tab-pane" id="tab2">
                    <form action="#" class="tab2-form-validat form-horizontal row-border" novalidate>
                        <fieldset>
                            <div class="control-group">
                                <!-- Password -->
                                <label for="password" class="col-md-2">Password<span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="col-md-10">
                                        <!-- 验证密码与用户名重名，回填提供校验使用 -->
                                        <input type="hidden" id="fillUsername" name="fillUsername" data-bv-trigger="blur" type="text" class="form-control">
                                        <input id="password" type="password" name="password" data-bv-trigger="blur" class="form-control" placeholder="Please provide your password over 6 letters, different from userName .">
                                    </div>
                                </div>
                            </div>
                            <div class="control-group">
                                <!-- Confirm Password -->
                                <label for="confirmPassword" class="col-md-2">Confirm Password<span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="col-md-10">
                                        <input id="confirmPassword" type="password" name="confirmPassword" data-bv-trigger="blur" class="form-control" placeholder="Please enter the password again .">
                                    </div>
                                </div>
                            </div>
                            <div class="control-group">
                                <!-- Verification Code -->
                                <label for="confirmPassword" class="col-md-2">Verification Code<span style="color: red;"> *</span></label>
                                <div class="form-group">
                                    <div class="col-md-8">
                                        <input id="verificationCode" type="text" name="verificationCode" data-bv-trigger="blur" class="form-control" placeholder="Please enter the right verification code .">
                                    </div>
                                    <div id="verificationCode_container" class="col-md-4" style="width: 100px;height: 30px;"></div>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
                <div class="tab-pane" id="tab3">
                    <form action="#" id="validate-3" class="form-horizontal row-border" novalidate>
                        <fieldset>
                            <div class="form-group">
                                <label class="col-md-2">Country</label>
                                <div class="col-md-10">
                                    <select id="country" class="form-control required" name="country"></select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-2">State</label>
                                <div class="col-md-10">
                                    <select name="state" class="form-control required" id="state"></select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-2">UpLoad Avatar</label>
                                <div class="col-md-10">
                                    <div class="fileinput-holder input-group input-medium">
                                        <div style="cursor: text; text-overflow: ellipsis; " class="fileinput-preview uneditable-input form-control">
                                        Select a image ...
                                        </div>
                                        <div class="input-group-btn inputGroup-btn">
                                        	<span style="overflow: hidden; position: relative; cursor: pointer; " class=" btn">Browse...
        										<input type="file" id="avatarImage" data-inputsize="medium" data-style="fileinput" accept="image/*" name="avatarImage" style="position: absolute; top: 0px; right: 0px; margin: 0px; cursor: pointer; font-size: 99px; opacity: 0;">
											</span>
										</div>
                                    </div>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
                <ul class="pager wizard">
                    <li class="previous first"><a href="#">First</a></li>
                    <li class="previous" style="margin-left: 50px;"><a href="#">Previous</a></li>
                    <li class="next last" style="margin-right: 50px;"><a href="#">Last</a></li>
                    <li class="next"><a href="#">Next</a></li>
                    <li>
                        <button class="btn btn-info sign_up" style="display: none;" onclick="signIn();">Sign Up</button>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="signFormError" tabindex="-1" role="dialog">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-body">
	      	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span class="model_close" aria-hidden="true">&times;</span></button>
	        <h4>Some information you entered is wrong,please check it carefully !</h4>
	      </div>
	    </div>
	  </div>
	</div>
	<div class="modal fade" id="signfailed" tabindex="-1" role="dialog">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-body">
	      	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span class="model_close" aria-hidden="true">&times;</span></button>
	        <h4 id="signfailedReas"></h4>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>