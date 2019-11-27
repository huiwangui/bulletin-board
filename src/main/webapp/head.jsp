<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- js 版本号设置-->
<c:set var="version" value="1.0.5.10"></c:set>

<!------------------------------------------------------------ 公共部分 -------------------------------------------------------->
<!-- loading -->
<div class="modal fade" id="loading" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop='static'>
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="tip_myModalLabel">提示</h4>
            </div>
            <div class="modal-body">
                请求处理中，请稍候。。。
            </div>
        </div>
    </div>
</div>

