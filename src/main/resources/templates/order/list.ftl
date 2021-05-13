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
                                    <button style="margin-left: 800px" class="btn btn-default btn-primary " onclick="playSong()">开启提示</button>
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
        <#--弹窗-->
        <div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h4 class="modal-title" id="myModalLabel">
                            提醒
                        </h4>
                    </div>
                    <div class="modal-body">
                        您有新的订单啦
                    </div>
                    <div class="modal-footer">
                        <button onclick="javascript:document.getElementById('notice').pause()" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button onclick="location.reload()" type="button" class="btn btn-primary">查看新的订单</button>
                    </div>
                </div>
            </div>
        </div>
        <audio id="notice" loop="loop">
            <source src="/sell/mp3/song.mp3" type="audio/mpeg" />
        </audio>
        </body>
        <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script>
            function playSong() {
                let audioPlay = document.getElementById('notice')
                audioPlay.play()
                setTimeout(() => {
                    audioPlay.pause()
                    audioPlay.load()
                }, 1000)
            }
            var webSocket=null
            if ('WebSocket'in window){
                webSocket=new WebSocket('ws://ysell.natapp1.cc/sell/webSocket');
            }else {
                alert("该浏览器不支持WebSocke!!")
            }
            webSocket.onopen=function (event) {
                console.log('建立连接');
            };
            webSocket.onclose=function (event) {
                console.log('连接关闭');
            };
            webSocket.onmessage=function (event) {
                // console.log('收到消息'+event.data);
            // 弹窗提醒,播放通知
                $("#myModal").modal('show');
                // document.getElementById('notice').play();
                document.getElementById('notice').play();

            };
            webSocket.onerror=function () {
                alert('WebSocket通信发生错误')
            };
            window.onbeforeunload=function () {
                webSocket.close();
            };
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
