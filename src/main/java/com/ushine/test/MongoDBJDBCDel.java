package com.ushine.test;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoDBJDBCDel {
	public static void main(String[] args) {
	//	try {
			/*MongoClient mongoClient = new MongoClient("localhost",27017);
			MongoDatabase database = mongoClient.getDatabase("test");
			MongoCollection<Document> mongoCollection = database.getCollection("mycol");*/
			MongoClient mongoClient = new MongoClient("localhost",27017);
			MongoDatabase database = mongoClient.getDatabase("test");
			MongoCollection<Document> collection = database.getCollection("test");
			//删除符合条件的第一个文档  
	//		collection.deleteOne(Filters.eq("likes",300));
			//删除所有符合条件的文档  
			collection.deleteMany(Filters.eq("likes",100.0));
			FindIterable<Document> iterable = collection.find();
			MongoCursor<Document> mongoCursor = iterable.iterator();
			while(mongoCursor.hasNext()){
				System.out.println(mongoCursor.next());
			}
		/*} catch (Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}*/
	
	}
}
