<%@ include file="../include/importTags.jsp" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
    <!DOCTYPE html>
    <html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="type=text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <style>
            .w3-sidebar a {
                font-family: "Roboto", sans-serif
            }

            body, h1, h2, h3, h4, h5, h6, .w3-wide {
                font-family: "Montserrat", sans-serif;
            }
        </style>
        <title>${title}</title>
    </head>


    <body class="w3-content" style="max-width:1200px">

    <!-- Sidebar/menu -->
    <nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top" style="z-index:3;width:250px" id="mySidebar">
        <div class="w3-container w3-display-container w3-padding-16">
            <i onclick="w3_close()" class="fa fa-remove w3-hide-large w3-button w3-display-topright"></i>
            <h3 class="w3-wide"><b><a href="/firstSpring/home"> <img
                    src='<spring:url value="/images/logoGalaxie.jpg"/>'/></a> </b></h3>
        </div>
        <div class="w3-padding-64 w3-large w3-text-grey" style="font-weight:bold">
            <a href="/firstSpring/home" class="w3-bar-item w3-button w3-light-grey"><i
                    class="fa fa-caret-right w3-margin-right"></i><spring:message code="home"/></a>
            <!--<a href="/firstSpring/carrelageInterieur" class="w3-bar-item w3-button">Carrelage interieur</a>
             <a href="#" class="w3-bar-item w3-button">Carrelage exterieur</a>
             <a onclick="myAccFunc()" href="javascript:void(0)" class="w3-bar-item w3-button" id="myBtn">
                 Salle de bain <i class="fa fa-caret-down"></i>
             </a>
             <div id="demoAcc" class="w3-bar-block w3-hide w3-padding-large w3-medium">
                 <a href="#" class="w3-bar-item w3-button">Baignoire et balneo</a>
                 <a href="#" class="w3-bar-item w3-button">Colonne de rangement</a>
                 <a href="#" class="w3-bar-item w3-button">Douche</a>
                 <a href="#" class="w3-bar-item w3-button">Meuble salle de bain</a>
                 <a href="#" class="w3-bar-item w3-button">Receveurs de douche extraplats</a>
                 <a href="#" class="w3-bar-item w3-button">Vasque</a>
             </div>
             <a href="#" class="w3-bar-item w3-button">Robinetterie</a>
             <a href="#" class="w3-bar-item w3-button">Galet</a>
             <a href="#" class="w3-bar-item w3-button">Pierre</a>
             <a href="#" class="w3-bar-item w3-button">Colles et fournitures</a>-->
            <c:forEach items="${categories}" var="categorie">
                <a class="w3-bar-item w3-button" href="<spring:url value="home"/>">${categorie.name}</a>
            </c:forEach>
        </div>
        <a href="#footer" class="w3-bar-item w3-button w3-padding">Contact</a>
        <a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding"
           onclick="document.getElementById('newsletter').style.display='block'">Newsletter</a>
        <a href="#footer" class="w3-bar-item w3-button w3-padding">Subscribe</a>
    </nav>

    <!-- Top menu on small screens -->
    <header class="w3-bar w3-top w3-hide-large w3-black w3-xlarge">
        <div class="w3-bar-item w3-padding-24 w3-wide">Galaxie</div>
        <a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding-24 w3-right" onclick="w3_open()"><i
                class="fa fa-bars"></i></a>
    </header>

    <!-- Overlay effect when opening sidebar on small screens -->
    <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu"
         id="myOverlay"></div>

    <!-- !PAGE CONTENT! -->
    <div class="w3-main" style="margin-left:250px">

        <!-- Push down content on small screens -->
        <div class="w3-hide-large" style="margin-top:83px"></div>

        <!-- Top header -->
        <header class="w3-container w3-xlarge">
            <p class="w3-left">Galaxie Carrelage</p>
            <div class="w3-right">

                <div class="dropdown">
                    <spring:url var="localeFr" value="">
                        <spring:param name="locale" value="fr"/>
                    </spring:url>
                    <spring:url var="localeEn" value="">
                        <spring:param name="locale" value="en"/>
                    </spring:url>
                    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">LG
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="${localeFr}">Francais</a></li>
                        <li role="presentation"><a role="menuitem" tabindex="-1" href="${localeEn}">English</a></li>

                    </ul>
                </div>

            </div>
            <p class="w3-right">
                <a href="/firstSpring/cart"><i class="fa fa-shopping-cart w3-margin-right"></i></a>
                <i class="fa fa-search"></i>
                <a href="/firstSpring/connectionClient"><i class="glyphicon glyphicon-user"></i></a>
                <a href="/firstSpring/home"><i class="glyphicon glyphicon-home"></i></a>
            </p>


        </header>


        <main>

            <div>
                <tiles:insertAttribute name="main-content"/>

            </div>

            <!-- Product grid  Articles !!!! -->


            <div class="w3-row w3-grayscale">



                    <c:forEach items="${articles}" var="article">
                        <div class="w3-col l3 s6">
                        <div class="w3-container">
                            <a href="/firstSpring/home/${article.id}">
                                <img src='<spring:url value="/images/gray_tile.JPG"/>' style="width:100%">
                            </a>
                            <p>${article.name}<br><b>${article.price}$</b></p>
                        </div>
                        </div>
                    </c:forEach>


             <!--   <div class="w3-col l3 s6">
                    <div class="w3-container">
                        <div class="w3-display-container">
                            <img src="/w3images/jeans2.jpg" style="width:100%">
                            <span class="w3-tag w3-display-topleft">New</span>
                            <div class="w3-display-middle w3-display-hover">
                                <button class="w3-button w3-black">Detail <i class="fa fa-shopping-cart"></i></button>
                            </div>
                        </div>
                        <p>Mega Ripped Jeans<br><b>$19.99</b></p>
                    </div>
                    <div class="w3-container">
                        <img src="/w3images/jeans3.jpg" style="width:100%">
                        <p>Washed Skinny Jeans<br><b>$20.50</b></p>
                    </div>
                </div>-->

            </div>

        </main>


        <!-- Footer -->
        <footer class="w3-padding-64 w3-light-grey w3-small w3-center" id="footer">
            <div class="w3-row-padding">
                <div class="w3-col s4">
                    <h4>Contact</h4>
                    <p>Questions? Go ahead.</p>
                    <form action="/action_page.php" target="_blank">
                        <p><input class="w3-input w3-border" type="text" placeholder="Name" name="Name" required></p>
                        <p><input class="w3-input w3-border" type="text" placeholder="Email" name="Email" required></p>
                        <p><input class="w3-input w3-border" type="text" placeholder="Subject" name="Subject" required>
                        </p>
                        <p><input class="w3-input w3-border" type="text" placeholder="Message" name="Message" required>
                        </p>
                        <button type="submit" class="w3-button w3-block w3-black">Send</button>
                    </form>
                </div>

                <div class="w3-col s4">
                    <h4>About</h4>
                    <p><a href="#">About us</a></p>
                    <p><a href="#">We're hiring</a></p>
                    <p><a href="#">Support</a></p>
                    <p><a href="#">Find store</a></p>
                    <p><a href="#">Shipment</a></p>
                    <p><a href="#">Payment</a></p>
                    <p><a href="#">Gift card</a></p>
                    <p><a href="#">Return</a></p>
                    <p><a href="#">Help</a></p>
                </div>

                <div class="w3-col s4 w3-justify">
                    <h4>Store</h4>
                    <p><i class="fa fa-fw fa-map-marker"></i> Company Name</p>
                    <p><i class="fa fa-fw fa-phone"></i> 0044123123</p>
                    <p><i class="fa fa-fw fa-envelope"></i> ex@mail.com</p>
                    <h4>We accept</h4>
                    <p><i class="fa fa-fw fa-cc-amex"></i> Amex</p>
                    <p><i class="fa fa-fw fa-credit-card"></i> Credit Card</p>
                    <br>
                    <i class="fa fa-facebook-official w3-hover-opacity w3-large"></i>
                    <i class="fa fa-instagram w3-hover-opacity w3-large"></i>
                    <i class="fa fa-snapchat w3-hover-opacity w3-large"></i>
                    <i class="fa fa-pinterest-p w3-hover-opacity w3-large"></i>
                    <i class="fa fa-twitter w3-hover-opacity w3-large"></i>
                    <i class="fa fa-linkedin w3-hover-opacity w3-large"></i>
                </div>
            </div>
        </footer>

        <div class="w3-black w3-center w3-padding-24">Powered by <a href="https://www.w3schools.com/w3css/default.asp"
                                                                    title="W3.CSS" target="_blank"
                                                                    class="w3-hover-opacity">Gaz</a></div>

        <!-- End page content -->
    </div>

    <!-- Newsletter Modal -->
    <div id="newsletter" class="w3-modal">
        <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
            <div class="w3-container w3-white w3-center">
                <i onclick="document.getElementById('newsletter').style.display='none'"
                   class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
                <h2 class="w3-wide">NEWSLETTER</h2>
                <p>Join our mailing list to receive updates on new arrivals and special offers.</p>
                <p><input class="w3-input w3-border" type="text" placeholder="Enter e-mail"></p>
                <button type="button" class="w3-button w3-padding-large w3-red w3-margin-bottom"
                        onclick="document.getElementById('newsletter').style.display='none'">Subscribe
                </button>
            </div>
        </div>
    </div>

    <script>
        // Accordion
        function myAccFunc() {
            var x = document.getElementById("demoAcc");
            if (x.className.indexOf("w3-show") == -1) {
                x.className += " w3-show";
            } else {
                x.className = x.className.replace(" w3-show", "");
            }
        }

        // Click on the "Jeans" link on page load to open the accordion for demo purposes
        document.getElementById("myBtn").click();


        // Script to open and close sidebar
        function w3_open() {
            document.getElementById("mySidebar").style.display = "block";
            document.getElementById("myOverlay").style.display = "block";
        }

        function w3_close() {
            document.getElementById("mySidebar").style.display = "none";
            document.getElementById("myOverlay").style.display = "none";
        }

    </script>


    </body>

    </html>

