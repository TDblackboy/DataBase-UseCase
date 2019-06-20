<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="per.modal.*" %>
<!DOCTYPE html>
<html>
<head></head>
<body>
<div class="box">
	<div class="header">
		<span class="pl">>>详情</span>
		<span class="pr"><a href="query-condition.jsp">>>go back</a></span>
	</div>
	<div class="content">
	<%
		Platform plat=(Platform)session.getAttribute("plat");
		if(plat!=null){
	%>
		<table class="" cellspacing="5px">
			<tr>
				<td class="td-tip">平台名称</td>
				<td class="td-con"><%=plat.getPname() %></td>
			</tr>
			<tr>
				<td class="td-tip">平台类型</td>
				<td class="td-con"><%=plat.getPleibie() %></td>
			</tr>
			<tr>
				<td class="td-tip">组织形式</td>
				<td class="td-con"><%=plat.getPzuzhi() %></td>
			</tr>
			<tr>
				<td class="td-tip">依托单位</td>
				<td class="td-con"><%=plat.getYname() %></td>
			</tr>
			<tr>
				<td class="td-tip">依托单位类型</td>
				<td class="td-con"><%=plat.getYleibie() %></td>
			</tr>
			<tr>
				<td class="td-tip">共建单位</td>
				<td class="td-con"><%=plat.getPgongjian() %></td>
			</tr>
			<tr>
				<td class="td-tip">平台主任/院长</td>
				<td class="td-con"><%=plat.getPyname() %></td>
			</tr>
			<tr>
				<td class="td-tip">填表人</td>
				<td class="td-con"><%=plat.getTname() %></td>
			</tr>
			<tr>
				<td class="td-tip">填表人所在部门</td>
				<td class="td-con"><%=plat.getTbumen() %></td>
			</tr>
			<tr>
				<td class="td-tip">填表人联系电话</td>
				<td class="td-con"><%=plat.getTtel() %></td>
			</tr>
			<tr>
				<td class="td-tip">填报时间</td>
				<td class="td-con"><%=plat.getTtime() %></td>
			</tr>
		</table>
		<%	
		}
		%>
	</div>
</div>
</body>
</html>