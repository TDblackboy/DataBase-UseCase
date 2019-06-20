package per.platform.dao;

import java.util.List;

import per.modal.Platform;

//这个接口 - 关联 - 前台 ; JSP和ServLet 中封装的对象object

public interface PlatformDao {
	boolean add(Platform plat);
	boolean deleteData(Platform plat);
	boolean updateData(Platform plat);
	
	Platform loadOne(Platform plat);
	List<Platform> loadAll();
	List<Platform>loadCondition(Platform plat);
}
