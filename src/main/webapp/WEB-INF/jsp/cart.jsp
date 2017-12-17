<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/importTags.jsp"%>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>${title}</title>
    <style>
        .table>tbody>tr>td, .table>tfoot>tr>td{
            vertical-align: middle;
        }
        @media screen and (max-width: 600px) {
            table#cart tbody td .form-control{
                width:20%;
                display: inline !important;
            }
            .actions .btn{
                width:36%;
                margin:1.5em 0;
            }

            .actions .btn-info{
                float:left;
            }
            .actions .btn-danger{
                float:right;
            }

            table#cart thead { display: none; }
            table#cart tbody td { display: block; padding: .6rem; min-width:320px;}
            table#cart tbody tr td:first-child { background: #333; color: #fff; }
            table#cart tbody td:before {
                content: attr(data-th); font-weight: bold;
                display: inline-block; width: 8rem;
            }



            table#cart tfoot td{display:block; }
            table#cart tfoot td .btn{display:block;}

        }
    </style>
</head>
<body>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<h1>Cart</h1>
<h2>Your Command</h2>
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
                <input type="number" id="qty" class="form-control text-center" value=${article.value}>
            </td>
            <script>
                var priceU = ${article.value} * ${article.key.price};
                document.write("<td data-th=\"Subtotal\" class=\"text-center\">"+priceU+"$</td>");
            </script>
            <!--<td data-th="Subtotal" class="text-center">1.99$</td>-->
            <td class="actions" data-th="">
                <a href="/firstSpring/cart/delete/${article.key.id}">
                    <button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>
                </a>
                <a href="javascript:var qty = document.getElementById('qty').value; window.location = '/firstSpring/cart/update/${article.key.id}/'+qty">
                    <button class="btn btn-info btn-sm"><i class="fa fa-refresh"></i></button>

                </a>
            </td>
        </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        <tr class="visible-xs">
            <td class="text-center"><strong>Total 1.99</strong></td>
        </tr>
        <tr>
            <td><a href="/firstSpring/home" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
            <td colspan="2" class="hidden-xs"></td>
            <td class="hidden-xs text-center"><strong>Total : ${priceTotal}$</strong></td>
            <td><a href="/firstSpring/cart/checkout" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
        </tr>
        </tfoot>
    </table>
</body>
</html>