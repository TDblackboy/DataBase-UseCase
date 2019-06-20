package per.op.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import per.modal.Platform;
import per.utils.Pack;


public class MysqlOP {
	/*
	 * add
	 * delete
	 * update
	 * load(one,all)
	 */
	
	//没写完
	public static boolean addData(String dbname,String tableName,Platform plat) {
		boolean operation=false;
		//数据库
		String sql="select * from "+tableName+" where pname=?";
		Connection con=ConnectionUtil.getConnection(dbname);
		PreparedStatement state=null;
		ResultSet result=null;
		try {
			state=con.prepareStatement(sql);
			state.setString(1, plat.getPname());
			result=state.executeQuery();
			if(!result.next()) {
				state.close();
				sql="insert into "+dbname+"()"+" values()";
				state=con.prepareStatement(sql);
				state.executeUpdate();
				System.out.println("添加完成");
				operation=true;
				
			}else {
				System.out.println("已有学生，不可重复");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(result);
			ConnectionUtil.close(state);
			ConnectionUtil.close(con);
		}
		return operation;
	}

	public static boolean deleteData(String dbname,String tableName,Platform plat) {
		boolean operation=false;
		String sql="deleted from "+tableName+" where pname=?";
		Connection con=ConnectionUtil.getConnection(dbname);
		PreparedStatement state=null;
		try {
			state=con.prepareStatement(sql);
			state.setString(1, plat.getPname());
			state.executeUpdate();
			operation=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(state);
			ConnectionUtil.close(con);
		}
		return operation;
	}
	//没写完
	public static boolean uppdateData(String dbname,String tableName,Platform plat) {
		boolean operation=false;
		String sql="update from "+tableName+" set where pname=?";
		Connection con=ConnectionUtil.getConnection(dbname);
		PreparedStatement state=null;
		try {
			state=con.prepareStatement(sql);
			state.setString(1, plat.getPname());
			state.setString(1, plat.getPname());
			state.executeUpdate();
			operation=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(state);
			ConnectionUtil.close(con);
		}
		return operation;	
	}

	public static Platform loadOne(String dbname,String tableName,String pname) {
		Platform plat=null;
		String sql="select * from "+tableName+" where pname=?";
		Connection con=ConnectionUtil.getConnection(dbname);
		PreparedStatement state=null;
		ResultSet result=null;
		try {
			state=con.prepareStatement(sql);
			state.setString(1, pname);
			result=state.executeQuery();
			while(result.next()) {
				plat=Pack.packResult(result);
			}
			System.out.println("select");
		} catch (SQLException e) {
			System.out.println("查找失败");
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(result);
			ConnectionUtil.close(state);
			ConnectionUtil.close(con);
		}
		return plat;		
	}
	
	public static List<Platform> loadAll(String dbname,String tableName){
		List<Platform>lists=new ArrayList<Platform>();
		String sql="select * from "+tableName;
		Connection con=ConnectionUtil.getConnection(dbname);
		PreparedStatement state=null;
		ResultSet result=null;
		try {
			state=con.prepareStatement(sql);
			result=state.executeQuery();
			while(result.next()) {
				Platform plat=Pack.packResult(result);
				lists.add(plat);
			}
			System.out.println("select");
		} catch (SQLException e) {
			System.out.println("查找失败");
			e.printStackTrace();
		}finally {
			ConnectionUtil.close(result);
			ConnectionUtil.close(state);
			ConnectionUtil.close(con);
		}
		return lists;
	}
}
