<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <title>Resume Home Page</title>
    <link href="./plugin/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet" media="screen">
    <link href="./plugin/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" media="screen">
    <link href="./plugin/shiningWords/style.css" rel="stylesheet"/>
    <link href="./plugin/circliful/material-design-iconic-font.css" rel="stylesheet">
    <link href="./plugin/circliful/jquery.circliful.css" rel="stylesheet"/>
    
    <script src="./plugin/jQuery/js/jquery-3.2.1.js"></script>
    <script src="./plugin/jQuery/js/jquery-ui.js"></script>
    <script src="./plugin/bootstrap-3.3.7/js/bootstrap.js"></script>
    <script src="./plugin/circliful/jquery.circliful.js"></script>
    <!-- 页面代码 -->
    <script src="./js/home.js"></script>
    <style type="text/css">
    *{
        margin: 0;
        padding: 0;
    }
    textarea{
    	resize:none;
    	border: none;
		margin: 0px;
		height: 100%;
		width: 100%;
		padding: 10px;
		overflow: auto;
    }
    .head textarea{
    	color: #e1e1e1;
    	font-size: 110%;
    }
    body{
        padding: 1%;
        min-width: 1320px;
        background: #dedede;
    }
    body textarea{
    	color: #53868B;
    	font-size: 170%;
    	background: #dedede;
    }
    li{
        list-style-type: none;
    }
    .head{
        position: relative;
        height: 250px;
        width: 100%;
    }
    .head, .head textarea{
    	 background: #6b6ea8;
    }
    .head div{
        float: left;
    }
    #avatar{
        position: absolute;
        height: 220px;
        width: 220px;
        margin-top: 15px;
        margin-left: 40px;
        border-radius: 50%;
        background: #5a87ae;
    }
    #avatar span{
        position: absolute;
        background:url(./images/avatar.jpg);
    	background-size: 100% 100%;
        height: 90%;
        width: 90%;
        margin: 5%;
        border-radius: 50%;
    }
    #brifeIntro{
        float: left;
        height: 100%;
        width: 36.5%;
        margin-left: 300px;
        line-height: 160%;
        font-size: 120%;
    }
    #personItem{
        height: 100%;
        float: none;
    }
    #personItem li:not(:last-child){
        display: inline-block;
        margin-left: 15px;
    }
    #personItem .fa:not(:last-child){
        font-size: 300%;
        margin: 5% 0 5px 15px;
    }
    #personItem span,#personItem label{
        position: relative;
        top: -5px;
        left: 15px;
        font-size: 130%;
        color: #f5f5f5;
    }
    .body{
        position: relative;
        height: 1200px;
        width: 100%;
    }
    .left,.right{
        width: 49%;
        height: 99%;
        float: left;
        margin: 0.5% 0.5%;
    }
    .left>div,.right>div{
        width: 100%;
        height: 50%;
    }
    .iconArea{
        width: 100%;
        height: 10%;
        padding: 0 10px;
        margin: 2% 0;
    }
    .circle{
        height: 55px;
        width: 55px;
        float: left;
        margin-left: 10px;
        margin-right: 25px;
        border-radius: 50%;
        border: 4px solid #2F4F4F;
    }
    .iconArea .fa{
        font-size: 220%;
        display: block;
        text-align: center;
        line-height: 48px;
        color: #4A708B;
    }
    .iconArea span{
        line-height: 55px;
        font-size: 190%;
        font-family:Pacifico;
        color: #53868B;
    }
    .line{
	    display: inline-block;
        position: relative;
        left: 20px;
	    top: -10px;
	    width: 40%;
	    border: 2px solid #2F4F4F;
    }
    .textArea{
        width: 98%;
        height: 83.5%;
        margin: 2% 1%;
    }
    .svgContain{
        float: left;
        height: 100%;
        width: 20%;
        padding: 0 0 0 15px;
        margin: 2px 0;
    }
    .progress{
        float: left;
        width: 62%;
        margin: 10px 0 0 -20px;
    }
    .cleanFloat{
        height: 19%;
        clear:both;
    }
    .circleful{
        position: relative;
        display: inline-block;
        top: -10px;
        left: 5px;
    }
    </style>
</head>
<body>
	<a href="https://blog.csdn.net/RO_wsy/article/details/51319963" target="_Blank">HTTPS实现</a>
    <section class="head">
       <div id="avatar"><span></span></div> 
       <div id="brifeIntro">
           <h1 id="name" style="padding-left: 20px; color: #f3f3f3;">侯博文
                <small style="margin-left: 35px; color: #e1e1e1;">Programmer For Java</small>
           </h1>
           <textarea id="brifeIntroduce" disabled="disabled"></textarea>
       </div>
       <div id="personItem">
           <ul>
               <li>
                    <i class="fa fa-university"></i>
                    <label>学校：</label>
                    <span>陕西科技大学</span>
               </li>
               <li>
                    <i class="fa fa-volume-control-phone"></i>
                    <label>电话：</label>
                    <span>18302966364</span>
               </li>
               <li>
                    <i class="fa fa-qq"></i>
                    <label>QQ：</label>
                    <span>137608422</span>
               </li>
               <li>
                    <i class="fa fa-commenting"></i>
                    <label>外语：</label>
                    <span>CET-6</span>
               </li>
               <li style="margin-left: 15px; display: inline-block;">
                    <i class="fa fa-telegram"></i>
                    <label>邮箱：</label>
                    <span>houbowen470@163.com</span>
               </li>
           </ul>
       </div>
    </section>
    <section class="body">
        <div class="left">
            <div class="ltop">
                <div class="iconArea">
                    <div class="circle"><i class="fa fa-gears" aria-hidden="true"></i></div>
                    <span>Professional&nbsp;&nbsp;Skill</span>
                    <div class="line"></div>
                </div>
                <div class="textArea">
                    <!-- <div id="skillChart" style="width: 500px;height: 500px;"></div> -->
                    <div class="cleanFloat">
                        <div class="svgContain">
                            <embed style="height: 100%; margin-left: 25px;" src="./svg/java.svg" type="image/svg+xml" pluginspage="http://www.adobe.com/svg/viewer/install/"/>
                        </div>
                        <div class="progress progress-striped active">
                            <div class="progress-bar progress-bar-success" role="progressbar" style="width: 90%;">
                            </div>
                        </div>
                        <div class="circleful circle-90"></div>
                    </div>    
                    <div class="cleanFloat">
                        <div class="svgContain">
                            <embed style="height: 100%; margin-left: 5px;" src="./svg/db.svg" type="image/svg+xml" pluginspage="http://www.adobe.com/svg/viewer/install/"/>
                        </div>
                        <div class="progress progress-striped active">
                            <div class="progress-bar progress-bar-info" role="progressbar" style="width: 80%;">
                            </div>
                        </div>
                        <div class="circleful circle-80" data-percent=80></div>
                    </div>    
                    <div class="cleanFloat">
                        <div class="svgContain">
                            <embed style="height: 100%;" src="./svg/js.svg" type="image/svg+xml" pluginspage="http://www.adobe.com/svg/viewer/install/"/>
                        </div>
                        <div class="progress progress-striped active">
                            <div class="progress-bar progress-bar-success" role="progressbar" style="width: 85%;">
                            </div>
                        </div>
                        <div class="circleful circle-90"></div>
                    </div>    
                    <div class="cleanFloat">
                        <div class="svgContain">
                            <embed style="height: 100%;" src="./svg/html5.svg" type="image/svg+xml" pluginspage="http://www.adobe.com/svg/viewer/install/"/>
                        </div>
                        <div class="progress progress-striped active">
                            <div class="progress-bar progress-bar-info" role="progressbar" style="width: 80%;">
                            </div>
                        </div>
                        <div class="circleful circle-80" data-percent=80></div>
                    </div>    
                    <div class="cleanFloat">
                        <div class="svgContain">
                            <embed style="height: 100%; margin-left: 12px;" src="./svg/css-3.svg" type="image/svg+xml" pluginspage="http://www.adobe.com/svg/viewer/install/"/>
                        </div>
                        <div class="progress progress-striped active">
                            <div class="progress-bar progress-bar-info" role="progressbar" style="width: 80%;">
                            </div>
                        </div>
                        <div class="circleful circle-80" data-percent=80></div>
                    </div>
                </div>
            </div>
            <div class="lbottom">
                <div class="iconArea">
                    <div class="circle"><i class="fa fa-sellsy" aria-hidden="true"></i></div>
                    <span>Project&nbsp;&nbsp;Introduction</span>
                    <div class="line"></div>
                </div>
                <div class="textArea">
                	<textarea id="projectIntroduction" disabled="disabled"></textarea>
                </div>
            </div>
        </div>
        <div class="right">
            <div class="rtop">
                <div class="iconArea">
                    <div class="circle"><i class="fa fa-vcard-o" aria-hidden="true"></i></div>
                    <span>Working&nbsp;&nbsp;Experience</span>
                    <div class="line"></div>
                </div>
                <div class="textArea">
                	<textarea id="workingExperience" disabled="disabled"></textarea>
                </div>
            </div>
            <div class="rbottom">
                <div class="iconArea">
                    <div class="circle"><i class="fa fa-line-chart" aria-hidden="true"></i></div>
                    <span>Career Planning</span>
                    <div class="line"></div>
                </div>
                <div class="textArea">
                	<textarea id="careerPlanning" disabled="disabled" style="line-height: 250%;"></textarea>
                </div>
            </div>
        </div>
    </section>
</body>
</html>