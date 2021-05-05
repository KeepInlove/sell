<html>
<#include "../common/header.ftl">
    <body>
    <div id="wrapper" class="toggled">
        <#--边栏-->
        <#include "../common/nav.ftl">
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix">
                    <#--订单-->
                    <div class="col-md-4 column">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>
                                    订单id
                                </th>
                                <th>
                                    订单总金额
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>${orderDTO.orderId}</td>
                                <td>${orderDTO.orderAmount}元</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <#--订单详情表数据-->
                    <div class="col-md-12 column">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>商品id</th>
                                <th>商品名称</th>
                                <th>价格</th>
                                <th>数量</th>
                                <th>总额</th>
                            </tr>
                            </thead>
                            <tbody>
                            <#list orderDTO.orderDetailList as orderDetail>
                                <tr>
                                    <td>${orderDetail.productId}</td>
                                    <td>${orderDetail.productName}</td>
                                    <td>${orderDetail.productPrice}</td>
                                    <td>${orderDetail.productQuantity}</td>
                                    <td>${orderDetail.productQuantity * orderDetail.productPrice}</td>
                                </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                    <#--操作-->
                    <div class="col-md-12 column">
                        <#if orderDTO.getOrderStatusEnum().message == "新订单">
                            <button onclick="finish('${orderDTO.orderId}')"  type="button" class="btn btn-default btn-primary">完成订单</button>
                            <button onclick="cancel('${orderDTO.orderId}')" type="button" class="btn btn-default btn-danger">取消订单</button>
                        </#if>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
    <script>
        function cancel(orderId) {
            var msg = "您要取消订单嘛？";
            if (confirm(msg)==true){
                location.href='/sell/seller/order/cancel?orderId='+orderId;
                console.log(orderId);
                return true;  //你也可以在这里做其他的操作
            }else{
                console.log("放弃取消订单");
                return false;
            }
        }
        function finish(orderId) {
            var msg = "您要完成订单嘛？";
            if (confirm(msg)==true){
                location.href='/sell/seller/order/finish?orderId='+orderId;
                console.log(orderId);
                return true;  //你也可以在这里做其他的操作
            }else{
                console.log("放弃完成订单");
                return false;
            }
        }
    </script>
</html>