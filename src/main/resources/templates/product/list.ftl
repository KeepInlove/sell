<!DOCTYPE html>
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
                            <a href="#">商品列表</a>
                        </li>
                    </ul>

                    <table class="table table-bordered table-hover table-condensed ">
                        <thead>
                        <tr>
                            <th>商品id</th>
                            <th>商品名称</th>
                            <th>图片</th>
                            <th>单价</th>
                            <th>库存</th>
                            <th>描述</th>
                            <th>类目</th>
                            <th>创建时间</th>
                            <th>修改时间</th>
                            <th colspan="2">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list productInfoPage.content as productInfo>
                            <tr>
                                <td>${productInfo.productId}</td>
                                <td>${productInfo.productName}</td>
                                <td><img src="${productInfo.productIcon}" width="100px" height="80px"></td>
                                <td>${productInfo.productPrice}</td>
                                <td>${productInfo.productStock}</td>
                                <td width="100px">${productInfo.productDescription}</td>
                                <td>${productInfo.categoryType}</td>
                                <td>${productInfo.createTime}</td>
                                <td>${productInfo.updateTime}</td>
                                <td><a href="/sell/seller/product/index?productId=${productInfo.productId}"  type="button" class="btn btn-default btn-primary">修改</a> </td>
                                <td>
                                    <#if productInfo.getProductStatusEnum().message == "在售">
                                        <button onclick="off_sale('${productInfo.productId}')" class="btn btn-default btn-danger">下架</button>
                                    <#else>
                                        <button onclick="on_sale('${productInfo.productId}')" class="btn btn-default btn-success">上架</button>
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
                            <li><a href="/sell/seller/product/list?page=${currentPage-1}&size=${size}">上一页</a></li>
                        </#if>
                        <#list 1..productInfoPage.getTotalPages() as index>
                            <#if currentPage==index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else>
                                <li><a href="/sell/seller/product/list?page=${index}&size=${size}">${index}</a></li>
                            </#if>
                        </#list>
                        <#if currentPage gte productInfoPage.getTotalPages()>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else>
                            <li><a href="/sell/seller/product/list?page=${currentPage+1}&size=${size}">下一页</a></li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    function off_sale(productId) {
        var msg = "您确定要下架商品吗？";
        if (confirm(msg)==true){
            location.href='/sell/seller/product/offSale?productId='+productId;
            console.log(productId);
            return true;  //你也可以在这里做其他的操作
        }else{
            console.log("取消下架");
            return false;
        }
    }
    function on_sale(productId) {
        var msg = "您确定要上架商品吗？";
        if (confirm(msg)==true){
            location.href='/sell/seller/product/onSale?productId='+productId;
            console.log(productId);
            return true;  //你也可以在这里做其他的操作
        }else{
            console.log("取消下架");
            return false;
        }
    }
</script>
</html>