<html>
        <#include "../common/header.ftl">
        <body>

        <div id="wrapper" class="toggled">
            <#--边栏-->
            <#include "../common/nav.ftl">
            <#--主要内容区域-->
            <div id="page-content-wrapper">
                <div class="container-fluid">

                    <div class="row clearfix">

                        <#--订单列表-->
                        <div class="col-md-12 column">

                            <ul class="breadcrumb">
                                <li>
                                    <a href="#">订单列表</a>
                                </li>
                            </ul>

                            <table class="table table-bordered table-hover ">
                                <thead>
                                <tr>
                                    <th>订单id</th>
                                    <th>姓名</th>
                                    <th>手机号</th>
                                    <th>地址</th>
                                    <th>金额</th>
                                    <th>支付状态</th>
                                    <th>订单状态</th>
                                    <th>创建时间</th>
                                    <th colspan="2">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list orderDTOPage.content as orderDTO>
                                    <tr>
                                        <td>${orderDTO.orderId}</td>
                                        <td>${orderDTO.buyerName}</td>
                                        <td>${orderDTO.buyerPhone}</td>
                                        <td>${orderDTO.buyerAddress}</td>
                                        <td>${orderDTO.orderAmount}</td>
                                        <td>${orderDTO.getPayStatusEnum().message}</td>
                                        <td>${orderDTO.getOrderStatusEnum().message}</td>
                                        <td>${orderDTO.createTime}</td>
                                        <td><a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}"  type="button" class="btn btn-default btn-success">详情</a> </td>
                                        <td>
                                            <#if orderDTO.getOrderStatusEnum().message == "新订单">
                                                <button onclick="cancel('${orderDTO.orderId}')" class="btn btn-default btn-danger">取消</button>
                                            </#if>
                                        </td>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>
                        </div>
                        <#--分页-->
                        <div class="col-md-12 column">
                            <ul class="pagination pull-right">
                                <#if currentPage lte 1>
                                    <li class="disabled"><a href="#">上一页</a></li>
                                <#else>
                                    <li><a href="/sell/seller/order/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                                </#if>
                                <#list 1..orderDTOPage.getTotalPages() as index>
                                    <#if currentPage==index>
                                        <li class="disabled"><a href="#">${index}</a></li>
                                    <#else>
                                        <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                                    </#if>
                                </#list>
                                <#if currentPage gte orderDTOPage.getTotalPages()>
                                    <li class="disabled"><a href="#">下一页</a></li>
                                <#else>
                                    <li><a href="/sell/seller/order/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                                </#if>
                            </ul>
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
        </script>
</html>
