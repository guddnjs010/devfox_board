<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/loginHeader.jsp" %>
<script type="text/javascript">
if('${result}' != ''){
	alert('회원가입이 완료됐습니다');
}
if('${failMsg}' != ''){
	alert('${failMsg}');
}
if('${idSearchMsg}' != ''){
	alert('회원님의 ID는 ${idSearchMsg} 입니다.');
}
if('${passwordSearchMsg}' != ''){
	alert('회원님의 비밀번호는 ${passwordSearchMsg} 입니다.');
}
</script>


        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">로그인or회원가입</h3>
                    </div>
                    <div class="panel-body">
                        <form id="memberForm" action="/login/loginProcess" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="ID" name="userid" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password">
                                </div>

                                <!-- Change this to a button or input when using this as a form -->
                                <button type="submit" class="btn btn-lg btn-success btn-block">LOGIN Button</button>
                            </fieldset>
                        </form>
                        <h1></h1>
                        <a href="/login/memberRegister" class="btn btn-lg btn-success btn-block">회원가입</a>
                        <a href="/login/idSearch" class="btn btn-default">ID찾기</a>
                        <a href="/login/passwordSearch" class="btn btn-default">비밀번호찾기</a>
                    </div>
                </div>
            </div>
        </div>

<%@include file="../includes/footer.jsp" %>