<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시물 수정하기or지우기</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            게시물 상세보기or지우기
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        <form>
                        <input type='hidden' name='pageNum' value='${cri.pageNum }'>
                        <input type='hidden' name='amount' value='${cri.amount }'>
                                 <div class="form-group">
                                     <label>BNO</label>
                                     <input class="form-control" name="bno" readonly="readonly" value='<c:out value= "${board.bno }"/>'>
                                </div>
                        	
                        		<div class="form-group">
                                     <label>Title</label>
                                     <input class="form-control" name="title" value='<c:out value= "${board.title }"/>'>
                                </div>
                                
                                <div class="form-group">
                                     <label>Content</label>
                                     <textarea rows="5" cols="50" class="form-control" name="content"><c:out value= "${board.content }"/></textarea>
                                </div>
                                
                                <div class="form-group">
                                     <label>Writer</label>
                                     <input class="form-control" readonly name="writer" value='<c:out value= "${board.writer }"/>'>
                                </div>
                                <button class="btn btn-default" data-oper='modify'>수정하기(modify)</button>
                                <button class="btn btn-danger" data-oper='remove'>삭제(remove)</button>
                                <button class="btn btn-info" data-oper='list'>목록으로 돌아가기(list)</button>
                        </form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
<script>
$(document).ready(function(){
	
	
	var formObj = $("form");
	
	$('.btn').click(function(e){
		
		//基本的に起こるscriptを防ぐ例えばbuttonのdefaultはsubmit
		e.preventDefault();
		
		var operation = $(this).data("oper");
		
		console.log(operation);
		
		if(operation === 'list'){
			formObj.attr("action", "/board/list");
			formObj.submit();
			
		}else if(operation === 'remove'){
			
			formObj.attr("action", "/board/remove")
			.attr("method", "post");
			formObj.submit();
		}else if(operation === 'modify'){
			
			formObj.attr("action", "/board/modify")
			.attr("method", "post");
			formObj.submit();
		}
	})
	
})
</script>        


<%@include file="../includes/footer.jsp" %>