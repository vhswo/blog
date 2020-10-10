<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	
	<c:if test="${sessionScope.principal.id == post.userId }">
		<br /><br />
		<a href="/post?cmd=updateForm" class="btn btn-warning">수정</a>
		<button onclick="postDelete(${post.id})" class="btn btn-danger">삭제</button>
	</c:if>
	
	<br /> <br />
	<h6 class="m-2">
		작성자 : <i> ${post.userId }</i> 조회수 : <i>${post.readCount }</i>
	</h6>
	<br />
	<h3 class="m-2">
		<b>${post.title}</b>
	</h3>
	<hr />
	<div class="form-group">
		<div class="m-2"> ${post.content }</div>
	</div>

	<hr />
</div>

<script>


	function postDelete(id) {

		fetch("http://localhost:8080/post?cmd=deleteProc");
		.then(function(res){
			//3초 뒤 실행	
			//res = > Promise 객체(다운받은 데이터)
			//res.text();
			//res.json();
			return res.text();
		})
		.then(function(res){
			alert(res);
		});
		
		
		console.log("1");
		console.log("2");
		console.log("3");
		console.log("4");
		
	}


</script>

<%@ include file="../layout/footer.jsp"%>