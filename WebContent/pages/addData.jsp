<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>信息录入</title>
<link rel="stylesheet" href="../css/standard.css">
<link rel="stylesheet" href="../css/entry.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/submit-entry.js"></script>
<script type="text/javascript" src="../js/linkage2.js"></script>
<script type="text/javascript" src="../js/linkage3.js"></script>
<script type="text/javascript" src="../js/organization.js"></script>
<script type="text/javascript" src="../js/gongjiandanwei.js"></script>
</head>
<body>
<div class="container">
	<div class="box">
		<div class="header">
			<p>平台信息 >>填报</p>
		</div>
		<form action="..//AddDataServlet" method="post">
		<div class="block">
			<div class="title"><p>基础信息</p></div>
			<div class="content">
				<div class="d1">
					<div class="ddd1">
					<label>平台名称：</label>
					<input type="text" name="pname" id="in1">
					</div>
				</div>
				<!-- <div class="d2">
					<label>平台编号：</label>
					<input type="text" name="pbianhao" id="in1" readonly="readonly">
				</div> -->
				<div class="d3">
					<div class="dd3">
					<label>批准年月：</label>
					<input type="date" name="pnianyue" id="in2">
					</div>
				</div>
				<div class="d4">
					<label>批准文号：</label>
					<input type="text" name="pwenhao" id="in1">
				</div>
				<div class="d5">
					<div class="dd5">
					<label>平台类型：</label>
					<select name="pleibie">
						<option value="重点实验室">重点实验室</option>
						<option value="工程技术研究中心">工程技术研究中心</option>
						<option value="产业技术研究院">产业技术研究院</option>
					</select>
					</div>
				</div>
				<div class="d6">
					<label>技术领域：</label>
					<input type="text" name="pjishu" id="in1">
				</div>
				<div class="d7">
					<div class="dd7">
					<label>平台级别：</label>
					<input type="checkbox" name="pjibie" value="国家级">国家级
					<input type="checkbox" name="pjibie" value="省级">省级
					</div>
				</div>
				<div class="d8">
					<label>所在县市：</label>
					<input type="text" name="pxianshi" placeholder="标准行政区划" id="in1">
				</div>
				<div class="d9">
					<div class="ddd9-1">
						<label>平台组织形式：</label>
						<select name="org1" id="pz">
							<option value="内设机构相对独立">内设机构相对独立</option>
							<option value="独立法人">独立法人</option>
						</select>
					</div>
					<div class="ddd9-2">
						<label>法人类型：</label>
						<select name="org1x" id="pz1-1">
							<option value="企业法人">企业法人</option>
							<option value="事业法人">事业法人</option>
							<option value="社团法人">社团法人</option>
						</select>
					</div>
					<div class="ddd9-3">
						<select name="org2" id="pz2">
							<option value="多单位联合共建">多单位联合共建</option>
							<option value="依托单位独立自建">依托单位独立自建</option>
						</select>
					</div>
					<div class="ddd9-4">
						<label>京津冀共建：</label>
						<input type="radio" name="org3" value="是">是
						<input type="radio" name="org3" value="否">否
					</div>
				</div>
				<div class="d10">
					<div class="d1011">
					<label>服务主要经济行业：</label>
					<select id="economy_a" name="a"></select>
					<select id="economy_b" name="b"></select>
					<select id="economy_c" name="c"></select>
					</div>
				</div>
				<div class="d11">
					<div class="d1011">
					<label>所属的主要学课：</label>
					<select id="lesson_x" name="x"></select>
					<select id="lesson_y" name="y"></select>
					<select id="lesson_z" name="z"></select>
					</div>
				</div>
			</div>
			</div>
			<div class="block">
				<div class="title"><p>依托单位</p></div>
				<div class="content">
					<div class="d12">
						<div class="ddiv">
						<label>单位名称：</label>
						<input type="text" name="yname" id="in1">
						</div>
					</div>
					<div class="d13">
						<div class="ddiv">
						<label>单位组织机构代码：</label>
						<input type="text" name="yma" placeholder="社会信用代码" id="in1">
						</div>
					</div>
					<div class="d14">
						<div class="ddiv">
						<label>单位法人代表姓名：</label>
						<input type="text" name="yrname" id="in1">
						</div>
					</div>
					<div class="d1516">
					<div class="d15">
						<label>办公电话：</label>
						<input type="text" name="ytel" id="in1">
					</div>
					<div class="d16">
						<label>单位类型：</label>
						<select name="yleibie">
							<option value="企业">企业</option>
							<option value="科研机构">科研机构</option>
							<option value="高等院校">高等院校</option>
							<option value="检测机构">检测机构</option>
							<option value="医疗机构">医疗机构</option>
							<option value="政府机构">政府机构</option>
							<option value="社团组织">社团组织</option>
							<option value="其他">其他</option>
						</select>
					</div>
					</div>
				</div>
			</div>
			<div class="block">
				<div class="title"><p>共建单位</p></div>
				<div class="content">
					<div class="d17">
						<div class="dd17">
						<table id="div-table">
							<tr>
								<td>共建单位名称：</td>
								<td><input type="text" name="pgongjian"></td>
								<td><img src="${pageContext.request.contextPath}/img/plus2.png" id="div-add"></td>
							</tr>						
						</table>
						</div>
					</div>
				</div>
			</div>
			<div class="block">
				<div class="title"><p>平台主任（院长）</p></div>
				<div class="content">
					<div class="dleft">
						<div class="dpadding">
						<label>姓名：</label>
						<input type="text" name="pyname" id="in1">
						</div>
					</div>
					<div class="dright">
						<div class="dpadding">
						<label>性别：</label>
						<input type="radio" name="pysex" value="男">男
						<input type="radio" name="pysex" value="女">女
						</div>
					</div>
					<div class="dleft">
						<div class="dpadding">
						<label>出生年月：</label>
						<input type="date" name="pybirth">
						</div>
					</div>
					<div class="dright">
						<div class="dpadding">
						<label>职称：</label>
						<input type="text" name="pyzhicheng" id="in1">
						</div>
					</div>
					<div class="dleft">
						<div class="dpadding">
						<label>所学专业：</label>
						<input type="text" name="pyzhuangye" id="in1">
						</div>
					</div>
					<div class="dright">
						<div class="dpadding">
						<label>学历：</label>
						<input type="text" name="pyxueli" id="in1">
						</div>
					</div>
						<div class="dleft">
						<div class="dpadding">
						<label>办公电话：</label>
						<input type="text" name="pytel" id="in1">
						</div>
					</div>
					<div class="dright">
						<div class="dpadding">
						<label>学位：</label>
						<input type="text" name="pyxuewei" id="in1">
						</div>
					</div>
				
					<div class="dlast">
						<div class="dpadding">
						<label>E-mail&nbsp;&nbsp;：</label>
						<input type="text" name="pymail" id="in1">
						</div>
					</div>
				</div>
			</div>
			<div class="block">
				<div class="title"><p>平台通讯</p></div>
				<div class="content">
					<div class="tongxun">
					<div class="d2left">
						<label>平台网站名称：</label>
						<input type="text" name="pwangzhan" id="in1">
					</div>
					<div class="d2right">
						<label>网址：</label>
						<input type="text" name="pwangzhi" id="in1">
					</div>
					<div class="d2left">
						<label>平台通讯地址：</label>
						<input type="text" name="ptongxun" id="in1">
					</div>
					<div class="d2right">
						<label>邮编：</label>
						<input type="text" name="pyoubian" id="in1">
					</div>
					</div>
				</div>
			</div>
			<div class="block">
				<div class="title"><p>填表人</p></div>
				<div class="content">
					<div class="divx">
						<div class="div1">
						<label>姓名：</label>
						<input type="text" name="tname" id="in1">
						</div>
					</div>
					<div class="divleft">
						<div class="divt">
						<label>所在部门：</label>
						<input type="text" name="tbumen" id="in1">
						</div>
					</div>
					<div class="divright">
						<div class="divt">
						<label>联系电话：</label>
						<input type="text" name="ttel" id="in1">
						</div>
					</div>
					<div class="divleft">
						<div class="divt">
						<label>E-mail&nbsp;&nbsp;：</label>
						<input type="text" name="tmail" id="in1">
						</div>
					</div>
					<div class="divright">
						<div class="divt">
						<label>填报时间：</label>
						<input type="date" name="ttime " id="date2">
						</div>
					</div>
				</div>
			</div>
			<div class="sub">
				<input type="submit" value="提交" id="submitx">
			</div>
		</form>
	</div>
</div>
</body>
</html>