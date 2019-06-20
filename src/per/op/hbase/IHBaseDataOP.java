package per.op.hbase;

import java.util.List;
import java.util.Map;

public interface IHBaseDataOP {
	
	/*
	 * 增 - 单行插入put
	 * table name+行键+列簇（一个的）+列+值
	 */
	public void addRowRecord(String tableName, String rowKey,String columnFamily, String[] fields, String[] values) ;
	/*
	 * 查 - 一行
	 * table name+rowKey+列簇+列 
	 * return ：键值对数组 - List<Map<String,String>> （一行对一个list<map>,一行包括好多cell，一个cell对应一个map）
	 */
	public List<Map<String,String>>  getColumn(String tableName, String rowKey,String columnFamily, String column);

}
