package com.ushine.test;


import org.bson.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndDeleteOptions;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.ushine.entity.TestBean;

public class MongoDBJDBCFind {
	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost",27017);
		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection<Document> collection = database.getCollection("col");
		//检索所有文档
		/**
		 * 1.获取迭代器FindIterable<Document>
		 * 2.获取游标MongCursor<Document>
		 * 3.通过游标遍历检索出的文档集合
		 */
		FindIterable<Document> findIterable = collection.find();
		MongoCursor<Document> iterator = findIterable.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
	
	
}
