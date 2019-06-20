package per.op.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

public class FSConnectionUtil {
	// 获取file system对象
	public static FileSystem getFileSystem() {
		// configuration
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://Kouri:9000");
		// file system
		FileSystem fs = null;
		try {
			fs = FileSystem.get(conf);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("filesystem capture failure.");
		}
		return fs;
	}

	// 关闭file system
	public static void close(FileSystem fs) {
		try {
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("fs close fail.");
		}
	}
}
