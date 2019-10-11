<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<title>${board.title}</title>
</head>

<style>
	.tableBox{
		width: 600px;
	}
</style>
<body>

<div class='tableBox'>
	<b>${board.boardNo}번 제목 : ${board.title}</b>
	<hr> 
	작성 일 : ${board.createDate} 수정 일 : ${board.modifyDate}
	<hr>
	${board.contents}
</div>
</body>
</html>