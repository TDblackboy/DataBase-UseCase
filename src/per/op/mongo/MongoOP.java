package per.op.mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoOP {
	//获取集合 - 须认证
	public static MongoClient getClientByLogin(String user,String pass,String dbname){
		//连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址  
		//1.链接地址 -[ip+port]
        //ServerAddress()两个参数分别为 服务器地址 和 端口  
        ServerAddress serverAddress = new ServerAddress("localhost",27017);  
        List<ServerAddress> addrs = new ArrayList<ServerAddress>();  
        addrs.add(serverAddress);  
        //2.mongoDB凭据 -[用户名 数据库名称 密码]
        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码  
        MongoCredential credential = MongoCredential.createScramSha1Credential(user, dbname, pass.toCharArray());  
        List<MongoCredential> credentials = new ArrayList<MongoCredential>();  
        credentials.add(credential);
        //3.创建Mongo客户端 - 通过连接认证获取MongoDB连接  
        MongoClient mongoClient = new MongoClient(addrs,credentials); 
       
        return mongoClient;
	}
	//值建立链接 ，没有断开链接，释放资源，不好
/*	//返回一个集合 - 无认证{用户-密码}
	//MongoDB无需预定义数据库和集合,在使用的时候会自动创建
    public static MongoCollection<Document> getCollection(String dbname,String collectionName){
        //实例化一个mongo客户端,服务器地址：localhost(本地)，端口号：27017
        MongoClient  mongoClient=new MongoClient("localhost",27017);
        //实例化一个mongo数据库
        MongoDatabase mongoDatabase = mongoClient.getDatabase(dbname);
        //获取数据库中某个集合
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        return collection;
    }*/
    
    //创建集合
    public static void createCollection(String dbname,String collectionName) {
    	MongoClient  mongoClient=new MongoClient("localhost",27017);
    	try {
    		MongoDatabase mongoDatabase = mongoClient.getDatabase(dbname);
            mongoDatabase.createCollection(collectionName);
            System.out.println("创建集合"+collectionName);
    	}catch(Exception e) {
    		 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    	}finally {
    		mongoClient.close();
    	}
    }
    
    //插入数据 - keys[]:values[],一一对应
    //没有文档嵌入文档，可重写一个方法
    //插入文档  
    /** 
    * 1. 创建文档 org.bson.Document 参数为key-value的格式 
    * 2. 创建文档集合List<Document> 
    * 3. 将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 
    * 	 插入单个文档可以用 mongoCollection.insertOne(Document) 
    * */
	public static void insertOne(String dbname,String collectionName,String keys[],String values[]) {
		MongoClient  mongoClient=new MongoClient("localhost",27017);   
		try{
	         MongoDatabase mongoDatabase = mongoClient.getDatabase(dbname);
	         MongoCollection<Document> collection=mongoDatabase.getCollection(collectionName);   
	         //实例化一个文档,文档内容为{key:value}，如果还有其他字段，可以继续追加append
	         Document doc=new Document();
	         for(String key:keys) {
	             int i=0;
	             doc.append(key, values[i++]);
	         }
	         collection.insertOne(doc);
	         System.out.println("插入成功"); 
	     }catch(Exception e){
	             System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	     }finally {
	        mongoClient.close();
	     }
	}
/*	//插入多条数据
	public static void insertMary() {
         List<Document> documents = new ArrayList<Document>(); 
        //将doc加入到documents列表中
        documents.add(doc); 
        //将documents插入集合
        collection.insertMany(documents);  
	}*/
	
	/*
	 * 删除 - 一条数据
	 * deleteOne(),deleteMary()
	 * 删除哪个：conditionKey - conditionValue 传参最好选属性唯一的。
	 * */
	public static void deleted(String dbname,String collectionName,String conditionKey,String conditionValue) {
		MongoClient  mongoClient=new MongoClient("localhost",27017);
    	try {
    		MongoDatabase mongoDatabase = mongoClient.getDatabase(dbname);
            MongoCollection<Document> collection=mongoDatabase.getCollection(collectionName);
            //
            collection.deleteOne(Filters.eq(conditionKey, conditionValue));
            System.out.println("删除"+conditionKey);
    	}catch(Exception e) {
    		 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    	}finally {
    		mongoClient.close();
    	}
	}
	/*修改
	 *修改哪个：conditionKey - conditionValue
	 *修改成什么：keys[] - values[]
	 */
	public static void update(String dbname,String collectionName,String conditionKey,String conditionValue,String keys[],String values[]) {
		MongoClient  mongoClient=new MongoClient("localhost",27017); 
		try{
			MongoDatabase mongoDatabase = mongoClient.getDatabase(dbname);
			MongoCollection<Document> collection=mongoDatabase.getCollection(collectionName);   
			//
			//这个document是新的
			Document newDoc=new Document();
			for(String key:keys) {
				int i=0;
				newDoc.append(key, values[i++]);
			}
			//这个document是操作 - 不知道
			Document opDoc=new Document("$set",newDoc);
			//匹配，并，修改
			collection.updateOne(Filters.eq(conditionKey, conditionValue), opDoc);
			//
			System.out.println("更新"+conditionKey);
		}catch(Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}finally {
			mongoClient.close();
		}
		
	}
	//查寻 - 所有
    public static List<Document> findAll(String dbname,String collectionName){
    	//
    	List<Document>docs=new ArrayList<Document>();
    	//
    	MongoClient  mongoClient=new MongoClient("localhost",27017);   
    	try{
        	MongoDatabase mongoDatabase = mongoClient.getDatabase(dbname);
	        MongoCollection<Document> collection=mongoDatabase.getCollection(collectionName);  
	        /** 
	         * 1. 获取迭代器FindIterable<Document>  - find()
	         * 2. 获取游标MongoCursor<Document> 
	         * 3. 通过游标遍历检索出的文档集合 
	         * */  
	        FindIterable<Document> iterable=collection.find();
	        MongoCursor<Document> cursor=iterable.iterator();
            //MongoCursor<Document>  cursor= collection.find().iterator();
	        Document doc=null;
            while(cursor.hasNext()){
                //System.out.println(cursor.next().toJson());
            	doc=cursor.next();
            	System.out.println(doc);
            	docs.add(doc);
            }
            System.out.println("已查找全部");
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }finally {
        	mongoClient.close();
        }
    	return docs;
    }
    //条件查询
    /*
     * 查找哪个：conditionKey-conditionValue,key最好也是属性值唯一的，防止找到多条相同的
     * 返回结果：document
     */
    public static Document findOne(String dbname,String collectionName,String conditionKey,String conditionValue) {
    	//这个文档是结果
    	Document doc=null;
    	//
    	MongoClient  mongoClient=new MongoClient("localhost",27017);
    	try {
    		MongoDatabase mongoDatabase = mongoClient.getDatabase(dbname);
            MongoCollection<Document> collection=mongoDatabase.getCollection(collectionName);
            //
            //这个document是条件文档
            Document loadDoc=new Document(conditionKey,conditionValue);
            //
            FindIterable<Document> iterable=collection.find(loadDoc);
	        MongoCursor<Document> cursor=iterable.iterator();
	        while(cursor.hasNext()){
            	doc=cursor.next();
            	System.out.println(doc);
            }
    	}catch(Exception e) {
    		 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    	}finally {
    		mongoClient.close();
    	}
    	return doc;
    }
}
