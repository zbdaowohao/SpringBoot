var index=0;

$(function(){  
    $(window).resize(function() {
      window.location.reload(); 
    });
    /**图片轮播*/
    $('#slideshow').cycle({
        fx: 'fade',
        speed: 1500,
        timeout: 5000
    });
    /**取消鼠标滚轮事件*/
    document.onmousewheel=function(){
        return false;
    }
    /**title冒泡*/
    $(".form-group").tooltip({
        position:{
            my:"left+15 top",
            at:"right top-3"
        }
    })
    //切换用户名文字样式
    setInterval("shiningType()",3000);
    /**初始化背景图宽高*/
    $("img").height($("body").height());
    $("img").width($("body").width());
    /**初始输入框位置*/
    $("form").css("top",$("body").height()*0.65);
    $("form").css("left",$("body").width()*0.28);
    /**初始头像框*/
    var bottom=$("form").position().top*0.35;
    var left=$("form").width()*0.52;
    $(".avatar button").css({position:"absolute",bottom:bottom,left:left*0.9});
    $(".avatar button").css({height:left*0.72,width:left*0.72});
    $(".avatar i").css("font-size",left*0.38);
    /**初始化显示名*/
    var range=($("#showName").width()-$(".avatar button").width())*0.4
    $("#showName").css({position:"absolute",top:-bottom*0.7,left:left-range});
    $("#showName").css("font-size",left*0.25);

    $("#password").on("keyup",function(event){
    	if (event.keyCode == 13){
		 	login();
		 }
    })
    $(".input-group-addon").click(function(){
    	login();
    });
});

function shiningType(){
    index++;
    if(index==1){
        $("#showName p").removeClass();
        $("#showName p").addClass("shiningMonoton");
    }
    if(index==2){
        $("#showName p").removeClass();
        $("#showName p").addClass("shiningIceland");
    }
    if(index==3){
        $("#showName p").removeClass();
        $("#showName p").addClass("shiningPacifico");
    }
    if(index==4){
        $("#showName p").removeClass();
        $("#showName p").addClass("shiningPressStart");
    }
    if(index==5){
        $("#showName p").removeClass();
        $("#showName p").addClass("shiningAudiowide");
    }
    if(index==6){
        $("#showName p").removeClass();
        $("#showName p").addClass("shiningVampiroOne");
        index=0;
    }
}

function associateName(){
	$.ajax({
        url:"/resume/associateName",
        type:"post",
        data:{
            userName : $("#userName").val()
        },
        success:function(data){
            if(data.length>0){
                $('#showName a').html(data);
            }
        }
    });
}

function login(){
	$.ajax({
        url:"/resume/toLogin",
        type:"post",
        data:{
            userName : $("#userName").val(),
            password : $("#password").val()
        },
        success:function(data){
            if(data.result=="success"){
                window.location.href="/resume/home?userName="+$("#userName").val()+"&userId="+data.userId; 
            }else{
                $('#loginInfo').html(data.msg);
                $('#loginModal').modal('show');
            }
        }
    });
}

