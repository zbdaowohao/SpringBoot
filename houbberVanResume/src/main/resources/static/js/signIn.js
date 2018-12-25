var verifyCode=null;
$(function(){  
    /**初始化验证码图片*/
    verifyCode = new GVerify("verificationCode_container");
    /**注册提交按钮位置初始化*/
    $(".sign_up").css("margin-left", ($(".tab-content").width() - $(".sign_up").width()) / 2-20); 

    /**bootstrap 校验*/
    signInValidat();

    /**步骤导航*/
    wizard();

    /**step绑定事件判断是否最后一步*/
    $(".nav a").each(function(index,ele){
        $(this).on("click",function(){
            if($(this).html().indexOf("3")!=-1){
                $(".sign_up").css("display","block");
            }else{
                $(".sign_up").css("display","none");
            }
        });
    });
}); 

function signIn(){
    var isValid = $(".control-group [data-bv-result=INVALID]").length;
    var username=$("#username").val();
    var email=$("#email").val();
    var password=$("#password").val();
    if(username.length==0){
        $('#signFormError').modal('show');
        return;
    }
    if(email.length==0){
        $('#signFormError').modal('show');
        return;
    }
    if(password.length==0){
        $('#signFormError').modal('show');
        return;
    }
    if(isValid>0){
       $('#signFormError').modal('show');
    }else{
        $.ajax({
            url:"/resume/toSignIn",
            type:"post",
            data:{
                userName : $("#username").val(),
                email : $("#email").val(),
                tel : $("#tel").val(),
                password : $("#password").val(),
                country : $("#country").val(),
                state : $("#state").val()
            },
            success:function(data){
                if(data.result=="success"){
                    alert(88);
                }else{
                    $('#signfailedReas').html(data.msg);
                    $('#signfailed').modal('show');
                }
            }
        });
    }
}

function fillUserName(){
    /**用户名回显校验密码重复*/
    $("#fillUsername").val($("#username").val());
}

function signInValidat(){
    $('.tab1-form-validat').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: { /*输入框不同状态，显示图片的样式*/
            valid: 'glyphicon glyphicon-ok',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: { /*验证*/
            username: { /*键名username和input name值对应*/
                message: 'The username is not valid',
                validators: {
                    /*非空提示*/
                    notEmpty: {
                        message: 'Username should not be enmpy !'
                    },
                    /* 只需加此键值对，包含正则表达式，和提示 */
                    regexp: {
                        regexp: /^[a-zA-Z0-9]+$/,
                        message: 'Username should be letters or numbers, without spaces !'
                    },
                    /*长度提示*/
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'Username\' length should be 6-30 !'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email address is required and can\'t be empty !'
                    },
                    emailAddress: {
                        message: 'The input is not a valid email address !'
                    }
                }
            },
            tel: {
                message: 'The phone number is not valid',
                validators: {
                    regexp: {
                        /* 以1开头，第二位可能是3/4/5/7/8等的任意一个，后面9个任意数字 */
                        regexp: /^1(3|4|5|7|8)\d{9}$/,
                        message: 'Shoule enter the right phone number !'
                    }
                }
            }
        }
    });
    $('.tab2-form-validat').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: { /*输入框不同状态，显示图片的样式*/
            valid: 'glyphicon glyphicon-ok',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            fillUsername: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'Username should not be enmpy !'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9]+$/,
                        message: 'Username should be letters or numbers, without spaces !'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'Username\' length should be 6-30 !'
                    }
                }
            },
            password: {
                message: 'The password is not valid',
                validators: {
                    notEmpty: {
                        message: 'Password should not be enmpy !'
                    },
                    stringLength: {
                        min: 7,
                        message: 'Password\'s length should over 6 letters !'
                    },
                    //不能和用户名相同
                    different: {
                        field: 'fillUsername',
                        message: 'Can\'t enter the password same with the userName !'
                    },
                }
            },
            confirmPassword: {
                message: 'The password is not valid',
                validators: {
                    notEmpty: {
                        message: 'Password should not be enmpy !'
                    },
                    /**校验2次密码是否相同*/
                    identical: {
                        field: 'password',
                        message: 'Check the password same with you first entered !'
                    }
                }
            }/*,
            verificationCode: {
                validators: {
                    notEmpty: {
                        message: 'Verification code should not be enmpy !'
                    },
                    callback: {
                        message: 'Wrong verification Code !',
                        callback: function(value, validator) {
                            if ($("#verificationCode").val() == '') {
                                return true;
                            }
                            var res = verifyCode.validate($("#verificationCode").val());
                            return res;
                        }
                    }
                }
            }*/
        }
    });
}

function wizard(){
    $('#rootwizard').bootstrapWizard({
        'tabClass': 'nav',
        'debug': false,
        onShow: function(tab, navigation, index) {
            console.log('onShow');
        },
        onNext: function(tab, navigation, index) {
            console.log('onNext');
        },
        onPrevious: function(tab, navigation, index) {
            console.log('onPrevious');
        },
        onLast: function(tab, navigation, index) {
            console.log('onLast');
        },
        onTabShow: function(tab, navigation, index) {
            console.log('onTabShow');
            if($(".next.last.disabled").length>0){
                $(".previous a").css("background-color","rgba(0, 0, 0, 0.25)");
                $(".previous a").css("color","#fff");
                $(".next a").css("background-color","#fff");
                $(".next a").css("color","#777");
                $(".previous a").css("border","1px solid #61523f");
                $(".sign_up").css("display","block");
            }else{
                $(".sign_up").css("display","none");
            }
            if($(".previous.first.disabled").length>0){
                $(".next a").css("background-color","rgba(0, 0, 0, 0.25)");
                $(".next a").css("color","#fff");
                $(".previous a").css("background-color","#fff");
                $(".previous a").css("color","#777");
                $(".next a").css("border","1px solid #61523f");
            }
            var $total = navigation.find('li').length;
            var $current = index + 1;
            var $percent = ($current / $total) * 100;
            $('#rootwizard').find('.bar').css({
                width: $percent + '%'
            });
        }
    });
}