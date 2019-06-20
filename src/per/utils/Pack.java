package per.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.bson.Document;

import per.modal.Platform;

public class Pack {
	
	//pack request to platform
	public static Platform packRequest(HttpServletRequest request) {
		Platform platform=new Platform();
		//1
			platform.setPname(request.getParameter("pname"));
			platform.setPnianyue(request.getParameter("pnianyue"));
			platform.setPwenhao(request.getParameter("pwenhao"));
			platform.setPleibie(request.getParameter("pleibie"));
			platform.setPjishu(request.getParameter("pjishu"));
			//==================
			String []jibie=request.getParameterValues("pjibie");
			if(jibie!=null) {
				String pjibie=jibie[0];
				for(int i=1;i<jibie.length;i++) {
					pjibie=pjibie+jibie[i];
				}
				platform.setPjibie(pjibie);
			}else {
				platform.setPjibie(null);
			}
			
			//==================
			platform.setPxianshi(request.getParameter("pxianshi"));
			
			//组织形式
			String pz1=request.getParameter("org1");
			String pz2=request.getParameter("org2");
			String pz3=request.getParameter("org3");
			if(pz1.equals("独立法人")) {
				String pz1x=request.getParameter("org1x");
				platform.setPzuzhi(pz1+pz1x+pz2+pz3);
			}else {   
				platform.setPzuzhi(pz1+pz2+pz3);
			}
			//
			platform.setPeconomy(request.getParameter("a")+request.getParameter("b")+request.getParameter("c"));
			platform.setPlesson(request.getParameter("x")+request.getParameter("y")+request.getParameter("z"));
		//2
			platform.setYname(request.getParameter("yname"));
			platform.setYma(request.getParameter("yma"));
			platform.setYrname(request.getParameter("yrname"));
			platform.setYtel(request.getParameter("ytel"));
			platform.setYleibie(request.getParameter("yleibie"));
		//3共建单位
			String []pgongjian=request.getParameterValues("pgongjian");
			if(pgongjian!=null) {
				String ggdw=pgongjian[0];
				for(int i=1;i<pgongjian.length;i++) {
					ggdw=ggdw+=pgongjian[i];
				}
				platform.setPgongjian(ggdw);
			}else {
				platform.setPgongjian(null);
			}
		//4
			platform.setPyname(request.getParameter("pyname"));
			platform.setPysex(request.getParameter("pysex"));
			platform.setPybrith(request.getParameter("pybrith"));
			platform.setPyzhicheng(request.getParameter("pyzhicheng"));
			platform.setPyzhuanye(request.getParameter("pyzhuanye"));
			platform.setPyxueli(request.getParameter("pyxueli"));
			platform.setPyxuewei(request.getParameter("pyxuewei"));
			platform.setPytel(request.getParameter("pytel"));
			platform.setPymail(request.getParameter("pymail"));
		//5
			platform.setPwangzhan(request.getParameter("pwangzhan"));
			platform.setPwangzhi(request.getParameter("pwangzhi"));
			platform.setPtongxun(request.getParameter("ptongxun"));
			platform.setPyoubian(request.getParameter("pyoubain"));
		//6
			platform.setTname(request.getParameter("tname"));
			platform.setTbumen(request.getParameter("tbumen"));
			platform.setTtel(request.getParameter("ttel"));
			platform.setTmail(request.getParameter("tmail"));
			platform.setTtime(request.getParameter("ttime"));
			
			
		return platform;
	}	
	//pack 检索条件
	public static Platform packCondition(HttpServletRequest request) {
		return null;
		
	}

	/*
	 * MongoDB - document
	 * pack platform to document 
	 */
	public static Platform packDocument(Document document) {
		Platform platform=new Platform();
		platform.setPid(Integer.parseInt(document.getString("pid")));
		platform.setPname(document.getString("pname"));
		platform.setPnianyue(document.getString("pnianyue"));
		platform.setPwenhao(document.getString("pwenhao"));
		platform.setPleibie(document.getString("pleibie"));
		platform.setPjishu(document.getString("pjishu"));
		platform.setPjibie(document.getString("pjibie"));
		platform.setPxianshi(document.getString("pxianshi"));
		platform.setPzuzhi(document.getString("pzuzhi"));
		platform.setPeconomy(document.getString("peconomy"));
		platform.setPlesson(document.getString("plesson"));
		platform.setYname(document.getString("yname"));
		platform.setYma(document.getString("yma"));
		platform.setYrname(document.getString("yrname"));
		platform.setYtel(document.getString("ytel"));
		platform.setYleibie(document.getString("yleibie"));
		platform.setPgongjian(document.getString("pgongjian"));
		platform.setPyname(document.getString("pyname"));
		platform.setPysex(document.getString("pysex"));
		platform.setPybrith(document.getString("pybrith"));
		platform.setPyzhicheng(document.getString("pyzhicheng"));
		platform.setPyzhuanye(document.getString("pyzhuanye"));
		platform.setPyxueli(document.getString("pyxueli"));
		platform.setPyxuewei(document.getString("pyxuewei"));
		platform.setPytel(document.getString("pytel"));
		platform.setPymail(document.getString("pymail"));
		platform.setPwangzhan(document.getString("pwangzhan"));
		platform.setPwangzhi(document.getString("pwangzhi"));
		platform.setPtongxun(document.getString("ptongxun"));
		platform.setPyoubian(document.getString("pyoubian"));
		platform.setTname(document.getString("tname"));
		platform.setTbumen(document.getString("tbumen"));
		platform.setTtel(document.getString("ttel"));
		platform.setTmail(document.getString("tmail"));
		platform.setTtime(document.getString("ttime"));
		return platform;
	}
	
	//key - value 必须一一对应
	//get platform keys:String[]
	public static String[] getPlatformKeys() {
		String keys[]= {
				"pid","pname","pnianyue","pwenhao","pleibie","pjishu","pjibie","pxianshi","pzuzhi","peconomy","plesson",
				"yname","yma","yrname","ytel","yleibie",
				"pgongjian",
				"pyname","pysex","pybrith","pyzhicheng","pyzhuanye","pyxueli","pyxuewei","pytel","pymail",
				"pwangzhan","pwangzhi","ptongxun","pyoubian",
				"tname","tbumen","ttel","tmail","ttime"
		};
		return keys;
	}
	//get platform values:String[]
	public static String[] getPlatformValues(Platform platform) {
		int size=35;
		String values[]=new String[size];
		values[0]=String.valueOf(platform.getPid());
		values[1]=platform.getPname();
		values[2]=platform.getPnianyue();
		values[3]=platform.getPwenhao();
		values[4]=platform.getPleibie();
		values[5]=platform.getPjishu();
		values[6]=platform.getPjibie();
		values[7]=platform.getPxianshi();
		values[8]=platform.getPzuzhi();
		values[9]=platform.getPeconomy();
		values[10]=platform.getPlesson();
		values[11]=platform.getYname();
		values[12]=platform.getYma();
		values[13]=platform.getYrname();
		values[14]=platform.getYtel();
		values[15]=platform.getYleibie();
		values[16]=platform.getPgongjian();
		values[17]=platform.getPyname();
		values[18]=platform.getPysex();
		values[19]=platform.getPybrith();
		values[20]=platform.getPyzhicheng();
		values[21]=platform.getPyzhuanye();
		values[22]=platform.getPyxueli();
		values[23]=platform.getPyxuewei();
		values[24]=platform.getPytel();
		values[25]=platform.getPymail();
		values[26]=platform.getPwangzhan();
		values[27]=platform.getPwangzhi();
		values[28]=platform.getPtongxun();
		values[29]=platform.getPyoubian();
		values[30]=platform.getTname();
		values[31]=platform.getTbumen();
		values[32]=platform.getTtel();
		values[33]=platform.getTmail();
		values[34]=platform.getTtime();		
		
		return values;
	}


	/*
	 * mySql - result
	 * pack result to platform
	 */
	public static Platform packResult(ResultSet result) {
		Platform platform=new Platform();
		try {
			platform.setPid(result.getInt("pid"));
			platform.setPname(result.getString("pname"));
			platform.setPnianyue(result.getString("pnianyue"));
			platform.setPwenhao(result.getString("pwenhao"));
			platform.setPleibie(result.getString("pleibie"));
			platform.setPjishu(result.getString("pjishu"));
			platform.setPjibie(result.getString("pjibie"));
			platform.setPxianshi(result.getString("pxianshi"));
			platform.setPzuzhi(result.getString("pzuzhi"));
			platform.setPeconomy(result.getString("peconomy"));
			platform.setPlesson(result.getString("plesson"));
			platform.setYname(result.getString("yname"));
			platform.setYma(result.getString("yma"));
			platform.setYrname(result.getString("yrname"));
			platform.setYtel(result.getString("ytel"));
			platform.setYleibie(result.getString("yleibie"));
			platform.setPgongjian(result.getString("pgongjian"));
			platform.setPyname(result.getString("pyname"));
			platform.setPysex(result.getString("pysex"));
			platform.setPybrith(result.getString("pybrith"));
			platform.setPyzhicheng(result.getString("pyzhicheng"));
			platform.setPyzhuanye(result.getString("pyzhuanye"));
			platform.setPyxueli(result.getString("pyxueli"));
			platform.setPyxuewei(result.getString("pyxuewei"));
			platform.setPytel(result.getString("pytel"));
			platform.setPymail(result.getString("pymail"));
			platform.setPwangzhan(result.getString("pwangzhan"));
			platform.setPwangzhi(result.getString("pwangzhi"));
			platform.setPtongxun(result.getString("ptongxun"));
			platform.setPyoubian(result.getString("pyoubian"));
			platform.setTname(result.getString("tname"));
			platform.setTbumen(result.getString("tbumen"));
			platform.setTtel(result.getString("ttel"));
			platform.setTmail(result.getString("tmail"));
			platform.setTtime(result.getString("ttime"));
		} catch (SQLException e) {
			System.out.println("结果集有误");
			e.printStackTrace();
		}
		return platform;
	}
}
