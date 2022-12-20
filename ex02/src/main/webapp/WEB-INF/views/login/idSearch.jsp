<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/loginHeader.jsp" %>
<script>
if('${failMsg}' != ''){
	alert('${failMsg}');
}


</script>
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">ID찾기</h3>
                    </div>
                    <div class="panel-body">
                        <form id='idSearchForm' action="/login/idSearchAction" method='post'>
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="name" id="name" name="name" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="email" name="email" type="email">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password">
                                </div>
                                
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="submit" id="idSearchBtn" class="btn btn-lg btn-success btn-block">ID찾기</button>
                            </fieldset>
                            
                        </form>
                        <a href="/login/login" class="btn btn-lg btn">뒤로가기</a>
                    </div>
                </div>
            </div>
        </div>

<%@include file="../includes/footer.jsp" %>