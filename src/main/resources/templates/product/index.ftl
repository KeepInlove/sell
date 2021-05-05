<!DOCTYPE html>
<html>
<#include "../common/header.ftl">
<body>

<div id="wrapper" class="toggled">
    <#--边栏-->
    <#include "../common/nav.ftl">
    <#--主要内容区域-->
    <div id="page-content-wrapper">
        <div class="container-fluid ">

            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/product/save">
                        <div class="form-group">
                            <label>名称:</label>
                            <input  name="productName" type="text" class="form-control" value="${(productInfo.productName)!''}" />
                        </div>
                        <div class="form-group">
                            <label>价格:</label>
                            <input  name="productPrice" type="text" class="form-control" value="${(productInfo.productPrice)!''}" />
                        </div>
                        <div class="form-group">
                            <label>库存:</label>
                            <input  name="productStock" type="number" class="form-control" value="${(productInfo.productStock)!''}" />
                        </div>
                        <div class="form-group">
                            <label>描述:</label>
                            <input  name="productDescription" type="text" class="form-control" value="${(productInfo.productDescription)!''}" />
                        </div>
                        <div class="form-group">
                            <label>图片:</label>
                            <img width="100px" height="100px" src="${(productInfo.productIcon)!''}"  alt="" name="productIcon"  />
                            <input  name="productIcon" type="text" class="form-control" value="${(productInfo.productIcon)!''}" />
                        </div>
                        <div class="form-group">
                            <label>类目:</label>
                            <select name="categoryType"class="form-control">
                                <#list categoryList as category>
                                    <option value="${category.categoryType}"
                                   <#if (productInfo.categoryType)?? &&productInfo.categoryType==category.categoryType>
                                    selected
                                    </#if>
                                    >${category.categoryName}
                                    </option>
                                </#list>
                            </select>
                        </div>
                        <input hidden type="text" name="productId" value="${(productInfo.productId)!''}">
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
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