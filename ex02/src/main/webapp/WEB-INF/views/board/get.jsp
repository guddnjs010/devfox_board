<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp" %>

<script type="text/javascript">
if('${result}' != ''){
	alert('작업이 완료됐습니다.');	
}
$(document).ready(function(){
	
	$("#replyBtn").on("click", function(){
		
		let reply = $("textarea[name=reply]").val();
		if($.isEmptyObject(reply)){
			alert("댓글 내용을 입력해주세요");
			return false;
		}
	});
});


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
                                     <textarea rows="5" cols="50" class="form-control" name="content" readonly="readonly" ><c:out value= "${board.content }"/></textarea>
                                </div>
                                
                                <div class="form-group">
                                     <label>Writer</label>
                                     <input class="form-control" name="writer" readonly="readonly" value='<c:out value= "${board.writer }"/>'>
                                </div>
                                
	                            <form id='actionForm' action="/board/list" method='get'>
	                            	<input type='hidden' name='pageNum' value = '${cri.pageNum}'>
	                            	<input type='hidden' name='amount' value = '${cri.amount}'>
	                            	<input type='hidden' name='bno' value = '${board.bno}'>
	                            	<input type='hidden' name='type' value = '${cri.type}'>
	                            	<input type='hidden' name='keyword' value = '${cri.keyword}'>
	                            </form>
	                            
	                            
                                
                                <button type="button" class="btn btn-default listBtn">목록으로돌아가기</button>
                                
                                <button type="button" id="modify"class="btn btn-default modBtn">수정하기or삭제하기</button>
                                
                                <h3>댓글</h3>
                                <div>
                                <form id='replyForm' action="/replies/register" method="post">
                                <input type='hidden' name='bno' value = '${board.bno}'>
                                <input type='hidden' name='rno'>
                                <div class="form-group">
                                     <label>댓글내용</label>
                                     <textarea rows="5" cols="50" class="form-control" name="reply"></textarea>
                                </div>
                                <div class="form-group">
                                     <label>댓글작성자</label>
                                     <input class="form-control" readonly name="replyer" value="${user.userid }">
                                </div>
                                <button id="replyBtn" type="submit" class="btn btn-default">댓글달기</button>
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
                                        <td>
                                        	<span class="replyListRno">${replyList.rno }</span>
                                        	<input type='text' readonly name='rno' class="inputReplyListRno" value = '${replyList.rno}' style="display:none;">
                                        </td>
                                        <td>
                                        	<span class="replyListReplyer">${replyList.replyer }</span>
                                        	<input readonly class="form-control inputReplyListReplyer" name="replyer" value='${replyList.replyer }' style="display:none;">
                                        </td>
                                        <td>
                                        	<span class="replyListReply">${replyList.reply }</span>
                                        	<textarea rows="5" cols="50" class="form-control textReplyListReply" name="reply" style="display:none;">${replyList.reply }</textarea>
                                        </td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${replyList.replyDate }"/></td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${replyList.updateDate }"/></td>
                                        <td>
                                        	<button type="button" class="btn btn-default replyModifyBtn">수정하기</button>
                                        	<button type="button" class="btn btn-default replyRegistBtn" style="display:none;">수정완료</button>
                                        </td>
                                        <td>
                                        	<button type="button" class="btn btn-default replyRemoveBtn">삭제하기</button>
                                        	<button type="button" class="btn btn-default replyCancelBtn" style="display:none;">취소하기</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>                         
                        		<script>
                        		var actionForm = $("#actionForm");
                        		var replyForm = $("#replyForm");
                        		$(".listBtn").click(function(e){
                        			actionForm.find("input[name='bno']").remove();
                        			actionForm.submit();
                        		});
                        		
                        		$(".modBtn").click(function(e){
                        			actionForm.attr("action","/board/modify");
                        			actionForm.submit();
                        		});
                        		
                        		$("button.replyModifyBtn").click(function(e){
                        			$(this).parent().parent().find("span.replyListRno").hide();
                        			$(this).parent().parent().find("button.replyRemoveBtn").hide();
                        			$(this).parent().parent().find("span.replyListReplyer").hide();
                        			$(this).parent().parent().find("button.replyModifyBtn").hide();
                        			$(this).parent().parent().find("span.replyListReply").hide();
                        			
                        			$(this).parent().parent().find("input.inputReplyListRno").show();
                        			$(this).parent().parent().find("button.replyCancelBtn").show();
                        			$(this).parent().parent().find("input.inputReplyListReplyer").show();
                        			$(this).parent().parent().find("button.replyRegistBtn").show();
                        			$(this).parent().parent().find("textarea.textReplyListReply").show();
                        		
                        		});
                        		
                        		$("button.replyCancelBtn").click(function(e){
                        			$(this).parent().parent().find("span.replyListRno").show();
                        			$(this).parent().parent().find("button.replyRemoveBtn").show();
                        			$(this).parent().parent().find("span.replyListReplyer").show();
                        			$(this).parent().parent().find("button.replyModifyBtn").show();
                        			$(this).parent().parent().find("span.replyListReply").show();
                        			
                        			$(this).parent().parent().find("input.inputReplyListRno").hide();
                        			$(this).parent().parent().find("button.replyCancelBtn").hide();
                        			$(this).parent().parent().find("input.inputReplyListReplyer").hide();
                        			$(this).parent().parent().find("button.replyRegistBtn").hide();
                        			$(this).parent().parent().find("textarea.textReplyListReply").hide();
                        			
                        		});
                        		
                        		$("button.replyRegistBtn").click(function(e){
                        			replyForm.find("input[name='rno']").val($(this).parent().parent().find("input.inputReplyListRno").val());
                        			replyForm.find("input[name='replyer']").val($(this).parent().parent().find("input.inputReplyListReplyer").val())
                        			replyForm.find("textarea[name='reply']").val($(this).parent().parent().find("textarea.textReplyListReply").val())
                        			replyForm.attr("action", "/replies/modify").submit();
                        		});

                        		$("button.replyRemoveBtn").click(function(e){
                        			replyForm.find("input[name='rno']").val($(this).parent().parent().find("input.inputReplyListRno").val());
                        			replyForm.attr("action", "/replies/remove").submit();
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