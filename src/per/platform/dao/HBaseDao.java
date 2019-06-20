package per.platform.dao;

import java.util.List;

import per.modal.Platform;
import per.op.hbase.HBaseDataOP;
import per.utils.Pack;

public class HBaseDao implements PlatformDao {

	private static final String tableName="";
	private static final String columnFamily="";
	@Override
	public boolean add(Platform plat) {
		HBaseDataOP op=new HBaseDataOP();
		//rowKey
		
		//
		//op.addRowRecord(tableName, rowKey, columnFamily, Pack.getPlatformKeys(), Pack.getPlatformValues(plat));
		return false;
	}

	@Override
	public boolean deleteData(Platform plat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateData(Platform plat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Platform loadOne(Platform plat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Platform> loadAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Platform> loadCondition(Platform plat) {
		// TODO Auto-generated method stub
		return null;
	}

}
