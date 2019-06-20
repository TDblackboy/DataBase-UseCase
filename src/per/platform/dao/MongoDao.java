package per.platform.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import per.modal.Platform;
import per.op.mongo.MongoOP;
import per.utils.Pack;

public class MongoDao implements PlatformDao{

	//属性：数据库，集合
	private static final String dbName="platform";
	private static final String collectionName="infor";

	//方法
	public boolean add(Platform plat) {
		boolean ok=false;
		MongoOP.insertOne(dbName, collectionName, Pack.getPlatformKeys(), Pack.getPlatformValues(plat));
		ok=true;
		return ok;
	}

	public boolean deleteData(Platform plat) {
		String key="pname";
		String value=plat.getPname();
		//
		MongoOP.deleted(dbName, collectionName, key, value);
		return true;
	}

	public boolean updateData(Platform plat) {
		//平台名称（pName）不可修改，且唯一，
		//？！可尝试让pId唯一？，待定。。。。
		//暂时用pName
		String key="pname";
		String value=plat.getPname();
		//
		MongoOP.update(dbName, collectionName, key, value, Pack.getPlatformKeys(), Pack.getPlatformValues(plat));
		return true;
	}

	public Platform loadOne(Platform plat) {
		//查询条件
		String key="pname";
		String value=plat.getPname();
		//
		Document doc=MongoOP.findOne(dbName, collectionName, key, value);
		//处理数据格式document->platform
		Platform resultPlat=Pack.packDocument(doc);
		System.out.println("已查找到一个符合条件的platform");
		return resultPlat;
	}

	public List<Platform> loadAll() {
		List<Document> docs=MongoOP.findAll(dbName, collectionName);
		List<Platform> plats=new ArrayList<Platform>();
		for(Document doc:docs) {
			Platform plat=Pack.packDocument(doc);
			plats.add(plat);
		}
		return plats;
	}
	
	public List<Platform> loadCondition(Platform plat) {
		return null;
	}
}
