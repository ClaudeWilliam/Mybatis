package com.qjq.mybatis.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	public static SqlSession getsqlSession() throws IOException {
		String resource = "conf.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder()
				.build(reader);

		SqlSession session = factory.openSession(true);

		return session;

	}
}
