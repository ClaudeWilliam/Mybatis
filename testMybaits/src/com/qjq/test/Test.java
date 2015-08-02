package com.qjq.test;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qjq.modle.User;

public class Test {
	public static void main(String[] args) throws IOException {
		String resource="conf.xml";
		//这个是用reader去吧配置文件读进去
		Reader reader = Resources.getResourceAsReader(resource);
		//InputStream stream =Test.class.getClassLoader().getResourceAsStream(resource);
		//System.out.println(stream);//这个是用流去实现的
		//创建一个sessionfactory来创建session
		SqlSessionFactory factory1=new SqlSessionFactoryBuilder().build(reader);
		//SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(stream);
		//创建一个session，session和dbutils的queryrunner一样的
		SqlSession session= factory1.openSession();
		String statement="com.qjq.test.userMapper.getUser";
		User user= session.selectOne(statement, 1);
		System.out.println(user);
		session.close();
	}
}
