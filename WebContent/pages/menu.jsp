<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="../css/left.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/retrieval.js"></script>
</head>
<body>
<div class="nav">
<div class="nav-list">
	<div class="nav-tit">
		<a href="menu.jsp" target="showframe">
		<img src="../img/per.png">
		<span>首页</span>
		</a>
	</div>
	<div class="nav-tit">
		<a href="addData.jsp" target="showframe">
		<img src="../img/ent.png">
		<span>录入</span>
		</a>
	</div>
	<div class="nav-tit" id="ret">
		<!-- <a href="" target=""> -->
		<img src="../img/ret.png">
		<span>检索</span>
	</div>
	
	<div class="ret-list" id="ret-ul">
		<ul>
			<li><a href="..//QueryAll" target="showframe">全部检索</a></li>
			<li><a href="query-condition.jsp" target="showframe">条件检索</a></li>
		</ul>
	</div>
</div>
</div>
</body>
</html>