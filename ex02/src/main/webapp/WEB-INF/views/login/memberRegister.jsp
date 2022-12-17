<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp" %>
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
                                    <input class="form-control" placeholder="ID" name="userid" type="text" autofocus>
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
                                
                            </fieldset>
                            <button type="submit" class="btn btn-lg btn-success btn-block">회원가입 완료</button>
                        </form>
                        <a href="/login/login" class="btn btn-lg btn">뒤로가기</a>
                    </div>
                </div>
            </div>
        </div>

<%@include file="../includes/footer.jsp" %>