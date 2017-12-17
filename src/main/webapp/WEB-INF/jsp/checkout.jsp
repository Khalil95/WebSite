<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title}</title>
</head>
<body>
<h1>Checkout</h1>
<h2>Your command</h2>
<h3>check your command</h3>
<table id="cart" class="table table-hover table-condensed">
    <thead>
    <tr>
        <th style="width:50%">Product</th>
        <th style="width:10%">Price</th>
        <th style="width:8%">Quantity</th>
        <th style="width:22%" class="text-center">Subtotal</th>
        <th style="width:10%"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="article" items="${articlesCart}">
        <tr>
            <td data-th="Product">
                <div class="row">
                    <div class="col-sm-2 hidden-xs"><img src="http://placehold.it/100x100" alt="..." class="img-responsive"/></div>
                    <div class="col-sm-10">
                        <h4 class="nomargin">Product: ${article.key.name}</h4>
                        <p>${article.key.description}</p>
                    </div>
                </div>
            </td>
            <td data-th="Price">$ ${article.key.price}</td>
            <td data-th="Quantity">
                <p>${article.value}</p>
            </td>
            <script>
                var priceU = ${article.value} * ${article.key.price};
                document.write("<td data-th=\"Subtotal\" class=\"text-center\">"+priceU+"$</td>");
            </script>
            <!--<td data-th="Subtotal" class="text-center">1.99$</td>-->
            <td class="actions" data-th="">

            </td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr class="visible-xs">
        <td class="text-center"><strong>Total 1.99</strong></td>
    </tr>
    <tr>
        <td><a href="/firstSpring/cart" class="btn btn-warning"><i class="fa fa-angle-left"></i>back</a></td>
        <td colspan="2" class="hidden-xs"></td>
        <td class="hidden-xs text-center"><strong>Total : ${priceTotal}$</strong></td>
        <td><a href="/firstSpring/cart/buyCommand" class="btn btn-success btn-block">Pay now<i class="fa fa-angle-right"></i></a></td>
        <td>


            <script src="https://www.paypalobjects.com/api/checkout.js"></script>

            <div id="paypal-button-container"></div>

            <script>

                paypal.Button.render({


                    env: 'sandbox', // sandbox | production

                    // PayPal Client IDs - replace with your own
                    // Create a PayPal app: https://developer.paypal.com/developer/applications/create
                    client: {
                        sandbox:    'AXBGK-LNNqmvwtZj2pn1atD8_l51x0tN91ohLDuYiad6dt-JnNDG-fvqYQNhuEWW2IQ_iehcwE_zNBAq',
                        production: 'EBFnuJsdSYgX78tZDA54pTTjDH4-EbMTXGVcBo98mPa82ITIYSvBEN_3YaoZ5e2BmDVHWCZFUmX7Jc1n'
                    },

                    // Show the buyer a 'Pay Now' button in the checkout flow
                    commit: true,

                    // payment() is called when the button is clicked
                    payment: function(data, actions) {

                        // Make a call to the REST api to create the payment
                        return actions.payment.create({
                            payment: {
                                transactions: [
                                    {
                                        amount: { total: '${priceTotal}', currency: 'USD' }
                                    }
                                ]
                            }
                        });
                    },

                    // onAuthorize() is called when the buyer approves the payment
                    onAuthorize: function(data, actions) {

                        // Make a call to the REST api to execute the payment
                        return actions.payment.execute().then(function() {
                            window.alert('Payment Complete!');
                            window.location.href = '/firstSpring/cart/buyCommand';
                        });
                    }

                }, '#paypal-button-container');
            </script>


        </td>
    </tr>
    </tfoot>
</table>
</body>
</html>