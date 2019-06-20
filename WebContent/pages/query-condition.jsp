<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="per.modal.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/query-accurate.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/retrieval-condition.js"></script>
<script type="text/javascript" src="../js/ul-tree.js"></script>
<title>PLATFORM</title>
</head>
<body>
<div class="condition">
	<div class="content">
	
		<div class="header">
			<p>平台 >>检索</p>
		</div>
		
		<!-- <div class="box">
			
			<div class="block">
				<div class="title">
					<p>分类浏览</p>
				</div>
				<div class="category">
					<p>类似中国知网的分类目录-(树形结构)么有做成</p>
					<div class="category-ul"> 
					<ul class="cate-ul">
						<li class="cate-ul-li">平台类型
							<ul class="cate-ul-ul">
								<li class="cate-ul-ul-li"><a>重点实验室</a></li>
								<li class="cate-ul-ul-li"><a>工程技术研究中心</a></li>
								<li class="cate-ul-ul-li"><a>产业技术研究院</a></li>
							</ul>
						</li>
						<li class="cate-ul-li">平台级别
							<ul class="cate-ul-ul">
								<li class="cate-ul-ul-li"><a>国家级</a></li>
								<li class="cate-ul-ul-li"><a>省级</a></li>
								<li class="cate-ul-ul-li"><a>国家级&省级</a></li>
							</ul>
						</li>
						<li class="cate-ul-li">服务经济行业
							<ul class="cate-ul-ul">
								<li class="cate-ul-ul-li">信息设备制造
									<ul class="cate-ul-ul-ul">
										<li class="cate-ul-ul-ul-li"><a>计算机制造</a></li>
										<li class="cate-ul-ul-ul-li"><a>通讯设备制造</a></li>
									</ul>
								</li>
								<li class="cate-ul-ul-li"><a>互联网</a></li>
							</ul>
						</li>
						<li class="cate-ul-li">主要学课
							<ul class="cate-ul-ul">
								<li class="cate-ul-ul-li"><a>天文学</a></li>
								<li class="cate-ul-ul-li"><a>心理学</a></li>
							</ul>
						</li>
					</ul> 
				    </div> 
				</div>
			</div>
			 -->
			<div class="block">
				<div class="title">
					<p>检索条件</p>
				</div>
				<div class="syn">
					<form action="..//QueryConditionServlet" method="post">
						<table class="syn-table" cellspacing="10">
							<tr>
								<td class="syn-table-img">
									<a href="javascript:void(0);" class="syn-plus"><img src="../img/plus2.png" border="1px"></a>
									<a href="javascript:void(0);" class="syn-minus"><img src="../img/minus2.jpg" border="1px"></a>
								</td>
								<td>
									<select name="pcondition" class="syn-table-select">
										<option value="pname">平台名称</option>
										<option value="pyname">院长/主任</option>
										<option value="yname">依托单位</option>
										<option value="pgongjian">共建单位</option>
									</select>
								</td>
								<td>
									<input type="text" name="pctext" >
								</td>
							</tr>
						</table>
						<!-- <td><button>检索</button></td> -->
						<input type="submit" value="检索" class="submit">
					</form>    
				</div>
			</div>
			
			<div class="block">
				<div class="title">
					<p>检索结果</p>
				</div>
				<div class="result">
					<table class="result-table" border="1px">
						<tr>
							<td class="t1">平台名称</td>
							<td class="t1">平台类型</td>
							<td class="t2">服务的主要经济行业</td>
							<td class="t3">平台详情</td>
						</tr>
				<%
					List<Platform>plats=(List)session.getAttribute("plats");
					if(plats!=null){
						for(Platform plat:plats){
					
				%>
					<tr>
						<td><%=plat.getPname() %></td>
						<td><%=plat.getPleibie() %></td>
						<td><%=plat.getPeconomy() %></td>
						<td><a href="..//QueryOneServlet?pname=<%=plat.getPname()%>"><img alt="click" src="../img/click.jpg" class="click-img"></a></td>
					</tr>
				<%		}
					}	
				%> 
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>