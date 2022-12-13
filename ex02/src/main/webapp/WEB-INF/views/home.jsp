<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="./includes/header.jsp" %>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
						<h1>
							Hello world!  
						</h1>
						
						<P>  The time on the server is ${serverTime}. </P>
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->


<%@include file="./includes/footer.jsp" %>