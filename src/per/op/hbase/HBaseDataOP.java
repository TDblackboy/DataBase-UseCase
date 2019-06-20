package per.op.hbase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;


public class HBaseDataOP implements IHBaseDataOP{

	@Override
	public void addRowRecord(String tableName, String rowKey,String columnFamily, String[] fields, String[] values) {
		Connection con=HBaseConnectionUtil.getHBaseConnection();
		Table table=null;
		//获取table对象
		try {
			table=con.getTable(TableName.valueOf(tableName));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("table获取失败");
		}
		//获取put对象-根据row
		Put put=new Put(Bytes.toBytes(rowKey));
			//i从哪开始？，0,1？，没有设置rowKey
		for(int i=0;i<fields.length;i++) {
			//加一列columnFamily，column，value
			put.addColumn(Bytes.toBytes(columnFamily),Bytes.toBytes(fields[i]), Bytes.toBytes(values[i]));
		}
		//table加put
		try {
			table.put(put);
			System.out.println(tableName+"添加数据成功");
		} catch (IOException e) {
			System.out.println("添加失败");
			e.printStackTrace();
		}
		HBaseConnectionUtil.close(table);
		HBaseConnectionUtil.close(con);
	}

	@Override
	public List<Map<String,String>>  getColumn(String tableName, String rowKey,String columnFamily, String column) {
		List<Map<String,String>> listMap=new ArrayList<Map<String,String>>();
		Connection con=HBaseConnectionUtil.getHBaseConnection();
		Table table=null;
		try {
			table=con.getTable(TableName.valueOf(tableName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//一行的get对象 
		Get get=new Get(Bytes.toBytes(rowKey));
		try {
			Result result = table.get(get);
			listMap = HBaseDataFormat.formatCell(result);
			// listMap=HBaseDataFormat.formatCell(table.get(get));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listMap;
	}

	/*@Override
	public int countRows(String tableName) {
		int rows=0;
		Connection con=HBaseConnectionUtil.getHBaseConnection();
		Table table=null;
		try {
			table=con.getTable(TableName.valueOf(tableName));//表
			Scan scan=new Scan();//scan操作
			ResultScanner results=table.getScanner(scan);
			for(Result re:results) {
				rows+=1;
			}
		} catch (IOException e) {
			System.out.println("error");
			e.printStackTrace();
		}
		HBaseConnectionUtil.close(table);
		HBaseConnectionUtil.close(con);
		return rows;
	}*/

}
