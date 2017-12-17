<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>${title}</title>
</head>
<body>
<h1>Carrelage Interieur</h1>

<div class="w3-container w3-text-grey" id="jeans">
    <p>8 items</p>
</div>

<!-- Product grid -->
<div class="w3-row w3-grayscale">
    <div class="w3-col l3 s6">
        <div class="w3-container">
            <img src="/w3images/jeans1.jpg" style="width:100%">
            <p>Ripped Skinny Jeans<br><b>$24.99</b></p>
        </div>
        <div class="w3-container">
            <img src="/w3images/jeans2.jpg" style="width:100%">
            <p>Mega Ripped Jeans<br><b>$19.99</b></p>
        </div>
    </div>

    <div class="w3-col l3 s6">
        <div class="w3-container">
            <div class="w3-display-container">
                <img src="/w3images/jeans2.jpg" style="width:100%">
                <span class="w3-tag w3-display-topleft">New</span>
                <div class="w3-display-middle w3-display-hover">
                    <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
                </div>
            </div>
            <p>Mega Ripped Jeans<br><b>$19.99</b></p>
        </div>
        <div class="w3-container">
            <img src="/w3images/jeans3.jpg" style="width:100%">
            <p>Washed Skinny Jeans<br><b>$20.50</b></p>
        </div>
    </div>

    <div class="w3-col l3 s6">
        <div class="w3-container">
            <img src="/w3images/jeans3.jpg" style="width:100%">
            <p>Washed Skinny Jeans<br><b>$20.50</b></p>
        </div>
        <div class="w3-container">
            <div class="w3-display-container">
                <img src="/w3images/jeans4.jpg" style="width:100%">
                <span class="w3-tag w3-display-topleft">Sale</span>
                <div class="w3-display-middle w3-display-hover">
                    <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
                </div>
            </div>
            <p>Vintage Skinny Jeans<br><b class="w3-text-red">$14.99</b></p>
        </div>
    </div>

    <div class="w3-col l3 s6">
        <div class="w3-container">
            <img src="/w3images/jeans4.jpg" style="width:100%">
            <p>Vintage Skinny Jeans<br><b>$14.99</b></p>
        </div>
        <div class="w3-container">
            <img src="/w3images/jeans1.jpg" style="width:100%">
            <p>Ripped Skinny Jeans<br><b>$24.99</b></p>
        </div>
    </div>
</div>

<!-- Subscribe section -->
<div class="w3-container w3-black w3-padding-32">
    <h1>Subscribe</h1>
    <p>To get special offers and VIP treatment:</p>
    <p><input class="w3-input w3-border" type="text" placeholder="Enter e-mail" style="width:100%"></p>
    <button type="button" class="w3-button w3-red w3-margin-bottom">Subscribe</button>
</div>

</body>
</html>