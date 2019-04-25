<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2019/4/20
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    $(function () {

        $('.nav_mini ul li').hover(function () {
            $(".two_nav").empty();
            var flbh1 = $(this).val();
            $.getJSON("js/json/class_2_" + flbh1 + ".js", function (data) {
                $(data).each(function (i, json) {
                    $(".two_nav").append('<a href="goto_list.do?flbh2=' + json.id + '" target="_blank">' + json.flmch2 + '</a>');
                })
            })

            $(this).find('.two_nav').show(50);
        }, function () {
            $(this).find('.two_nav').hide(50);
        })
    })
</script>
<body>
<div class="menu">
    <div class="nav">
        <div class="navs">
            <div class="left_nav">
                全部商品分类
                <div class="nav_mini">
                    <ul>
                        <li value="7" class="class_1">
                            <a href="">家用电器</a>
                            <div class="two_nav"></div>
                        </li>
                        <li value="11" class="class_1">
                            <a href="">手机、数码、通信</a>
                            <div class="two_nav"></div>
                        </li>
                        <li value="8">
                            <a href="">电脑、办公</a>
                            <div class="two_nav"></div>
                        </li>
                        <li>
                            <a href="">家具、家居、家装</a>
                            <div class="two_nav"></div>
                        </li>
                        <li value="6">
                            <a href="">男装、女装、内衣</a>
                            <div class="two_nav"></div>
                        </li>
                        <li>
                            <a href="">美妆、个户清洁、宠物</a>
                            <div class="two_nav"></div>
                        </li>
                        <li value="13">
                            <a href="">鞋靴、箱包、钟表</a>
                            <div class="two_nav"></div>
                        </li>
                        <li value="14">
                            <a href="">男鞋、户外、运动</a>
                            <div class="two_nav"></div>
                        </li>
                        <li>
                            <a href="">汽车、房产、汽车用品</a>
                            <div class="two_nav"></div>
                        </li>
                        <li>
                            <a href="">母婴、玩具乐器</a>
                            <div class="two_nav"></div>
                        </li>
                        <li>
                            <a href="">食品，酒类、生鲜</a>
                            <div class="two_nav"></div>
                        </li>
                        <li>
                            <a href="">营养保健、机身轻巧</a>
                            <div class="two_nav"></div>
                        </li>
                        <li>
                            <a href="">图书、文娱、电子书</a>
                            <div class="two_nav"></div>
                        </li>
                        <li>
                            <a href="">彩票，机票、车票</a>
                            <div class="two_nav"></div>
                        </li>
                        <li>
                            <a href="">理财、众筹、白条</a>
                            <div class="two_nav"></div>
                        </li>
                    </ul>
                </div>
            </div>
            <ul>
                <li><a href="">服装城</a></li>
                <li><a href="">美妆馆</a></li>
                <li><a href="">超市</a></li>
                <li><a href="">全球购</a></li>
                <li><a href="">闪购</a></li>
                <li><a href="">团购</a></li>
                <li><a href="">拍卖</a></li>
                <li><a href="">金融</a></li>
                <li><a href="">智能</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
