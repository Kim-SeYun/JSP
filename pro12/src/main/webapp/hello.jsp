<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선언문</title>
</head>
<body>
<% // 스크립트릿 : 모든 자바코드 가능
	out.print("변수값 : " +name);
	out.print("getName()호출 : " +getName());
	String test = "스크립트릿 안에 변수선언";
%>
</body>
<%!
   	// 선언문 : 변수 또는 메소드 선언 외 자바코드가 올 수 없음
    // 선언문에 선언된 변수 또는 메소드는 클래스 멤버이다.
    public String name = "듀크"; // 필드 변수
    public String getName(){
    	return name;
    }
    class Test{
    		
    }
   /* out.print(name); */ 
 %>
</html>