package per.op.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * function：
 * 1.获取链接对象Connection
 * 2.关闭资源 
 */
public class ConnectionUtil {
	
	//getConnection
	public static Connection getConnection(String dbname) {
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/"+dbname;
		String urlAdd="serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
		String user="root";
		String pass="sunyu";
		String driver="com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver).newInstance();
			System.out.println("驱动");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动问题");
		}
		
		try {
			con=DriverManager.getConnection(url, user, pass);
			System.out.println("connection");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("connection问题");
		}
		
		return con;
	}
	//close
		public static void close(Connection con) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("connection close error");
			}
		}
		public static void close(PreparedStatement state) {
			try {
				state.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("preparedstatement close error");
			}
		}
		public static void close(ResultSet result) {
			try {
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("resultSet close error");
			}
		}
}
