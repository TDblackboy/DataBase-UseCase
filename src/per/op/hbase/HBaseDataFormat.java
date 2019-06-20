package per.op.hbase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;

public class HBaseDataFormat {
	// 将查询结果集中cell 转化为map<key,value>
	// 格式化输出"一行/一行中的某一列"的结果集 - 提取每一个cell：byte数据
	public static List<Map<String, String>> formatCell(Result result) {
		List<Map<String, String>> listMap = null;
		if (result != null) {
			listMap = new ArrayList<Map<String, String>>();
			Cell[] cells = result.rawCells();
			for (Cell cel : cells) {
				Map<String, String> map = new HashMap<String, String>();
				// 一个cell - 行键值，列簇，列名，列值
				String rowValue = new String(CellUtil.cloneRow(cel));
				String family = new String(CellUtil.cloneFamily(cel));
				String column = new String(CellUtil.cloneQualifier(cel));
				String value = new String(CellUtil.cloneValue(cel));
				//
				map.put("rowValue", rowValue);
				map.put("family", family);
				map.put("column", column);
				map.put("value", value);
				//
				listMap.add(map);
			}
		}
		return listMap;
	}
}
