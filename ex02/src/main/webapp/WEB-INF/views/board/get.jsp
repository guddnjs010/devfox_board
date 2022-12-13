<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp" %>

<script type="text/javascript">
if('${result}' != ''){
	alert('댓글등록이 완료됐습니다.');	
}
</script>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시물 상세보기</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            게시물 상세보기
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                                 <div class="form-group">
                                     <label>BNO</label>
                                     <input class="form-control" name="bno" readonly="readonly" value='<c:out value= "${board.bno }"/>'>
                                </div>
                        	
                        		<div class="form-group">
                                     <label>Title</label>
                                     <input class="form-control" name="title" readonly="readonly" value='<c:out value= "${board.title }"/>'>
                                </div>
                                
                                <div class="form-group">
                                     <label>Content</label>
                                     <textarea rows="5" cols="50" class="form-control" name="content"><c:out value= "${board.content }"/></textarea>
                                </div>
                                
                                <div class="form-group">
                                     <label>Writer</label>
                                     <input class="form-control" name="writer" value='<c:out value= "${board.writer }"/>'>
                                </div>
                                
	                            <form id='actionForm' action="/board/list" method='get'>
	                            	<input type='hidden' name='pageNum' value = '${cri.pageNum}'>
	                            	<input type='hidden' name='amount' value = '${cri.amount}'>
	                            	<input type='hidden' name='bno' value = '${board.bno}'>
	                            	<input type='hidden' name='type' value = '${cri.type}'>
	                            	<input type='hidden' name='keyword' value = '${cri.keyword}'>
	                            </form>
                                
                                <button type="button" class="btn btn-default listBtn"><a href='/board/list'>목록으로돌아가기</a></button>
                                <button type="button" class="btn btn-default modBtn"><a href='/board/modify?bno=<c:out value= "${board.bno }"/>'>수정하기or삭제하기</a></button>
                                
                                <h3>댓글</h3>
                                <div>
                                <form action="/board/reply/register" method="post">
                                <input type='hidden' name='bno' value = '${board.bno}'>
                                <div class="form-group">
                                     <label>댓글내용</label>
                                     <textarea rows="5" cols="50" class="form-control" name="reply"></textarea>
                                </div>
                                <div class="form-group">
                                     <label>댓글작성자</label>
                                     <input class="form-control" name="replyer">
                                </div>
                                <button type="submit" class="btn btn-default">댓글달기</button>
                                </form>
                                </div>
                                <h2>댓글 목록</h2>
                                 <table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>RNO</th>
                                        <th>댓글작성자</th>
                                        <th>댓글 내용</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${replyList}" var ="replyList">
                                    <tr class="odd gradeX">
                                        <td>${replyList.rno }</td>
                                        <td>${replyList.replyer }</td>
                                        <td>${replyList.reply }</td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${replyList.replyDate }"/></td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${replyList.updateDate }"/></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>                         
                        		<script>
                        		var actionForm = $("#actionForm");
                        		
                        		$(".listBtn").click(function(e){
                        			e.preventDefault();
                        			actionForm.find("input[name='bno']").remove();
                        			actionForm.submit();
                        		});
                        		
                        		$(".modBtn").click(function(e){
                        			e.preventDefault();
                        			actionForm.attr("action","/board/modify");
                        			actionForm.submit();
                        		});
                        		
                        		
                        		</script>

                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

<%@include file="../includes/footer.jsp" %>