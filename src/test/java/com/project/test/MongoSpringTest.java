package com.project.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

public class MongoSpringTest {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Before
	public void before(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mgo.xml"); 
		mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
	}
	
	@After
	public void after(){
		
	}
	
	@Test
	public void testAddUser(){
		long time1 = new Date().getTime();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < 100; i++) {
			Map<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("id", " "+i);
			hashMap.put("name", "lisi");
			list.add(hashMap);
			if(i%10==0){
				mongoTemplate.insert(list,"zh");
				list.removeAll(list);
			}
		}
		long time2 = new Date().getTime();
		System.out.println("---------------"+(time2-time1));
	}
}
