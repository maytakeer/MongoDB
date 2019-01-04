package com.ushine.test;


import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;


public class MongoDBJDBCUpdate {
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost",27017);
		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = database.getCollection("mycol");
		//更新文档   将文档中likes=100的文档修改为likes=200  
		collection.updateMany(Filters.eq("likes",200), new Document("$set",new Document("likes",300)));
		//检索查看结果
		FindIterable<Document> iterable = collection.find();
		MongoCursor<Document> mongoCursor = iterable.iterator();
		while(mongoCursor.hasNext()){
			System.out.println(mongoCursor.next());
		}
	}
}
