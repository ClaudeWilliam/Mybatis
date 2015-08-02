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
		//�������readerȥ�������ļ�����ȥ
		Reader reader = Resources.getResourceAsReader(resource);
		//InputStream stream =Test.class.getClassLoader().getResourceAsStream(resource);
		//System.out.println(stream);//���������ȥʵ�ֵ�
		//����һ��sessionfactory������session
		SqlSessionFactory factory1=new SqlSessionFactoryBuilder().build(reader);
		//SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(stream);
		//����һ��session��session��dbutils��queryrunnerһ����
		SqlSession session= factory1.openSession();
		String statement="com.qjq.test.userMapper.getUser";
		User user= session.selectOne(statement, 1);
		System.out.println(user);
		session.close();
	}
}
