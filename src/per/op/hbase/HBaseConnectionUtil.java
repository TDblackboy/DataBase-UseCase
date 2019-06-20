package per.op.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Table;

public class HBaseConnectionUtil {
	//获取hbase数据库的链接
	public static Connection getHBaseConnection() {
		// 配置对象-configuration
		Configuration conf = HBaseConfiguration.create();// 链接HBase - 根据hbase-site.xml,中的配置信息
		conf.set("hbase.zookeeper.quorum", "Kouri");// zookeeeper，主机名
		conf.set("hbase.zookeeper.property.clientPort", "2182");// 端口 - 默认2181？
		conf.set("hbase.rootdir", "hdfs://Kouri:9000/hbase");
		// 连接
		Connection connection = null;
		try {
			connection = ConnectionFactory.createConnection(conf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// 关闭table
	public static void close(Table table) {
		try {
			table.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 关闭admin
	public static void close(Admin admin) {
		try {
			admin.close();
		} catch (IOException e) {
			System.out.println("admin关闭失败");
			e.printStackTrace();
		}
	}

	// 关闭connection
	public static void close(Connection connection) {
		try {
			connection.close();
		} catch (IOException e) {
			System.out.println("connection关闭失败");
			e.printStackTrace();
		}
	}
}
