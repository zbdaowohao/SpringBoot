$(function(){
	var breafTextAreaHeight = $('#brifeIntro').height()-($('#brifeIntroduce').offset().top-$('#brifeIntro').offset().top);
	$("#brifeIntroduce").css("height",breafTextAreaHeight);
    var ulWidth = $(".head").width()+$("#personItem").offset().left-$("#brifeIntro").width()-$("#brifeIntro").offset().left;
    var liHeight = $("#personItem").height();
    $("li").css({"width":ulWidth/2.1,"height":liHeight/3.5,"margin":(liHeight-liHeight/3.5*3)/6+"px "+(ulWidth-ulWidth/2.05*2)/4+"px"});
    $("ul li:last-child").css("width","");

    $(".circleful").css("width",$(".svgContain").height()+35);
    $(".circle-90").circliful({
            animation: 1,
            animationStep: 5,
            foregroundBorderWidth: 15,
            foregroundColor: '#61d861',
            backgroundBorderWidth: 15,
            percent: 90,
            textSize: 28,
            textColor: '#666'
        },
        function(){
            $(".timer").css("font-size","30px");
    });
    $(".circle-80").circliful({
            animation: 1,
            animationStep: 8,
            foregroundBorderWidth: 15,
            backgroundBorderWidth: 15,
            percent: 80,
            textSize: 30,
            textColor: '#666'
        },
        function(){
            $(".timer").css("font-size","30px");
    });
    $(".timer").css("font-size","30px");
    
    var leftOffset = ($('.cleanFloat').offset().left+$('.cleanFloat').width()-($('circle ').offset().left+$('.circleful ').width()*0.6))/2;
    $('.circleful').css("left",leftOffset);
    
    readText();
    
});

function readText(){
	$.ajax({
        url:"/resume/readBrifeIntroduceg",
        type:"get",
        success:function(data){
            if(data.length>0){
                $('#brifeIntroduce').html(data);
            }
        }
    });
$.ajax({
    url:"/resume/readWorkingExperience",
    type:"get",
    success:function(data){
        if(data.length>0){
            $('#workingExperience').html(data);
        }
    }
});
	$.ajax({
        url:"/resume/readProjectIntroduction",
        type:"get",
        success:function(data){
            if(data.length>0){
                $('#projectIntroduction').html(data);
            }
        }
    });
    $.ajax({
        url:"/resume/readCareerPlanning",
        type:"get",
        success:function(data){
            if(data.length>0){
                $('#careerPlanning').html(data);
            }
        }
    });
}