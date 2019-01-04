package com.ushine.test;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBJDBCInsert {
	public static void main(String[] args) {
		try {
			//连接到MongoDB服务
			MongoClient mongoClient = new MongoClient("localhost",27017);
			
			//连接到数据库
			MongoDatabase database = mongoClient.getDatabase("test");
			System.out.println("Connect to database successfully");
			//创建集合
			/*database.createCollection("test");
			System.out.println("集合创建成功");*/
			//获取集合
			MongoCollection<Document> collection = database.getCollection("test");
//			System.out.println(collection.listIndexes());
			//插入文档
			/**
			 * 1.创建文档 org.bson.Document 参数为key-value的格式
			 * 2.创建文档集合List<Document>
			 * 3.将文档集合插入数据库集合中 mongoCollection.insertMany(List<Document>) 插入单个文档可以用 mongoCollection.insertOne(Document) 
			 */
			Document document = new Document("title","MongoDB").
					append("description", "database")	.append("likes", 100).append("by", "Fly");
			List<Document> documents = new ArrayList<Document>();
			documents.add(document);
			collection.insertMany(documents);
			System.out.println("插入文档成功");
			
		} catch (Exception e) {
			System.out.println(e.getClass().getName()+": "+e.getMessage());
		}
	
	}
}
