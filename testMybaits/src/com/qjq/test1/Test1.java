package com.qjq.test1;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.qjq.modle.User;
import com.qjq.mybatis.utils.MybatisUtils;

public class Test1 {
	// 用Mybatis的XML来实现CRUD
	@Test
	public void insertUser() throws IOException {
		// 实现了插入
		String statement = "com.qjq.test1.userMapper.insertUser";
		SqlSession session = MybatisUtils.getsqlSession();
		int insert = session.insert(statement, new User(0, "haha", 16));
		System.out.println(insert);
		session.commit();
		session.close();
	}

	@Test
	public void updateUser() throws IOException {
		//
		String statement = "com.qjq.test1.userMapper.updateUser";
		SqlSession session = MybatisUtils.getsqlSession();
		int update = session.update(statement, new User(2, "qjq", 20));
		System.out.println(update);
		session.commit();
		session.close();
	}

	@Test
	public void deleteUser() throws IOException {
		String statement = "com.qjq.test1.userMapper.deleteUser";
		SqlSession session = MybatisUtils.getsqlSession();
		int delete = session.delete(statement, 5);
		System.out.println(delete);
		session.commit();
		session.close();

	}

	@Test
	public void selectUsers() throws IOException {
		String statement = "com.qjq.test1.userMapper.getAllUser";
		SqlSession session = MybatisUtils.getsqlSession();
		List<User> list = session.selectList(statement);
		session.commit();
		session.close();
		System.out.println(list);

	}
}
