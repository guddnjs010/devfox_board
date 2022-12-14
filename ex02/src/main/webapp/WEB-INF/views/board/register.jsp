<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp" %>

<%

	HttpSession sessionAttr = request.getSession();
%>
<script type="text/javascript">

$(document).ready(function(){
    <%
	if(null == sessionAttr.getAttribute("user")) {
	%>
	alert("로그인 후 이용해 주세요.");
	location.href="/login/login";
	<%
	}
    %>
    
    $("#registerBtn").on("click", function(){
    	
    	let title = $("input[name=title]").val();
		if($.isEmptyObject(title)){
			alert("제목을 입력해주세요");
			return false;
		}
    	let content = $("textarea[name=content]").val();
		if($.isEmptyObject(content)){
			alert("내용을 입력해주세요");
			return false;
		}
		$("#registerForm").submit();
    	
    });

});


</script>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시물을 등록하세요</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            게시물 등록
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<form action="/board/register" id="registerForm" method="post">
                        	
                        		<div class="form-group">
                                     <label>Title</label>
                                     <input class="form-control" name="title">
                                </div>
                                
                                <div class="form-group">
                                     <label>Content</label>
                                     <textarea rows="5" cols="50" class="form-control" name="content"></textarea>
                                </div>

                                     <input type="hidden" class="form-control" name="writer" value="${user.userid }">

                                <button id="registerBtn" type="submit" class="btn btn-default">Submit Button</button>
                                <button type="reset" class="btn btn-default">Reset Button</button>
                        	
                        	</form>
                        	
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->


<%@include file="../includes/footer.jsp" %>