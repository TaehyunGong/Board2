<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="en">
<head>
<title>글 작성하기</title>
  <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
  <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
  <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
  <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
  <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
</head>

<script>
  $(document).ready(function() {
      $('#summernote').summernote({
    	  placeholder: 'placeholder',
          height: 200
      });
  });
</script>
  
<body>
  <div class="container">
             
<div class="row">
    <div class="col-md-12">
        <form action="/insertBoard" method="post" enctype="multipart/form-data">
	        <div class="page-header">
	            <input type="text" class="form-control" name='title' placeholder="제목입력">
	        </div>
	         
	        <textarea id="summernote" name='contents'></textarea >
	        
	        <label for="exampleFormControlFile1">첨부 파일</label>
	        <input type="file" name='file' class="form-control-file" id="exampleFormControlFile1">
	        
	        <button type="submit" class="btn btn-primary" style='float:right;'>글 작성</button>
        </form>
    </div>
</div>
     
</div>
</body>
</html>