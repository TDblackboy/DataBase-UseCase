package per.platform.dao;

import java.util.List;

import per.modal.Platform;
import per.op.mysql.MysqlOP;

public class MysqlDao implements PlatformDao {
	
	private static final String dbname="";
	private static final String tableName="";
	@Override
	public boolean add(Platform plat) {
		boolean ok=false;
		if(MysqlOP.addData(dbname, tableName, plat)) {
			ok=true;
		}
		return ok;
	}

	@Override
	public boolean deleteData(Platform plat) {
		return false;
	}

	@Override
	public boolean updateData(Platform plat) {
		return false;
	}

	@Override
	public Platform loadOne(Platform plat) {
		return null;
	}

	@Override
	public List<Platform> loadAll() {
		return null;
	}

	@Override
	public List<Platform> loadCondition(Platform plat) {
		return null;
	}

}
