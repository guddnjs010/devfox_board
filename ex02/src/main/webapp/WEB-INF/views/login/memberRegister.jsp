<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/loginHeader.jsp" %>
<script>

$(document).ready(function(){
	$("input[name=userid]").on("change",function(){
		// 変更された時、重複チェックが　また行われるように
		$("input[name=userid]").prop("dataValue",false);
	});
	
	$("#registerBtn").on("click", function(){
		
		let userid = $("input[name=userid]").val();
		if($.isEmptyObject(userid)){
			alert("id를 입력해주세요");
			return;
		}
		
		
		//登録できるidならdataValueがtrue、重複idならfalse
		//重複チェックした場合、dataValue = true 値を入れる
		if(!$("input[name=userid]").prop("dataValue")){
			alert("id 중복검사를 해주세요");
			return false;
		}
		
		
		$("#registerMemberForm").submit();
	});
	
	
	$("#idCheck").on("click",function(){
		
		let userid = $("input[name=userid]").val();
		if($.isEmptyObject(userid)){
			alert("id를 입력해주세요");
			return;
		}
		
		
		$("input[name=userid]").prop("dataValue",false);
		
		$.ajax({
			url : '/login/checkId/'+userid,
			method : 'get',
			dataType : 'json',
			
			success : function(data){
				if(data){
					alert("등록가능한 아이디입니다.");
					
					$("input[name=userid]").prop("dataValue",true);
				}else{
					alert("이미 등록된 아이디 입니다.");
				}
				
			},
			error : function(){
				console.log('error');
			}
			
		});
	});
});

</script>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">회원가입</h3>
                    </div>
                    <div class="panel-body">
                        <form id='registerMemberForm' action="/login/memberRegister" method='post'>
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="ID" id="userid" name="userid" type="text" pattern="[0-9A-Za-z]{6,20}" autofocus>
                                    <button class="form-control" id="idCheck" type="button" >중복 확인</button>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="name" name="name" type="text">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="email" name="email" type="email">
                                </div>
                                
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="submit" id="registerBtn" class="btn btn-lg btn-success btn-block">회원가입 완료</button>
                            </fieldset>
                            
                        </form>
                        <a href="/login/login" class="btn btn-lg btn">뒤로가기</a>
                    </div>
                </div>
            </div>
        </div>

<%@include file="../includes/footer.jsp" %>