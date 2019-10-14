<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<title>${board.title}</title>
</head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style>
	.tableBox{
		width: 600px;
	}
</style>

<script>
	function action(path){
		location.href='/'+path;
	}
</script>
<body>

<div class='tableBox'>
	<b>${board.boardNo}번 제목 : ${board.title}</b>
	<hr> 
	작성 일 : ${board.createDate} 수정 일 : ${board.modifyDate}
	<br>
	<button onclick='action("delete?boardNo=${board.boardNo}")' class='btn btn-danger'>글 삭제</button>&nbsp;
	<button onclick='action("modify?boardNo=${board.boardNo}")' class='btn btn-success'>글 수정</button>&nbsp;
	<button onclick='action("")' class='btn btn-info'>리스트</button>
	<hr>
	${board.contents}
	<hr>
	<a href="/download?fileName=${board.attachment.fileName}&boardNo=${board.boardNo}">${board.attachment.originFileName}</a>
</div>
</body>
</html>