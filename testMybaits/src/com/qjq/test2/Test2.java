package com.qjq.test2;

import java.io.IOException;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.qjq.modle.User;
import com.qjq.mybatis.utils.MybatisUtils;

public class Test2 {
	@Test
	public void testgetAll() throws IOException {
		SqlSession session = MybatisUtils.getsqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.selects();
		session.commit();
		session.close();
		System.out.println(list);
	}

	@Test
	public void testgetUser() throws IOException {
		SqlSession session = MybatisUtils.getsqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.selectById(1);
		session.commit();
		session.close();
		System.out.println(user);

	}

	@Test
	public void testdeleteUser() throws IOException {
		SqlSession session = MybatisUtils.getsqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		int delete = mapper.deleteById(6);
		System.out.println(delete);
		session.commit();
		session.close();
	}

	@Test
	public void testupdateUser() throws IOException {
		SqlSession session = MybatisUtils.getsqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		int update = mapper.update(new User(4, "wst", 21));
		session.commit();
		session.close();
		System.out.println(update);

	}

	@Test
	public void testaddUser() throws IOException {
		SqlSession session = MybatisUtils.getsqlSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		int insert = mapper.add(new User(5, "cn", 20));
		session.commit();
		session.close();
		System.out.println(insert);
	}
}
