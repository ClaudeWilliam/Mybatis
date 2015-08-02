package com.qjq.test;

import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.qjq.modle.User;
import com.qjq.mybatis.utils.MybatisUtils;

public class TestUserMapper {
	@Test
	public void test() throws IOException {
		SqlSession session = MybatisUtils.getsqlSession();
		String statement = "com.qjq.test.Usermapper.selectUserById";
		User user = session.selectOne(statement, 1);
		System.out.println(user);
		session.close();
	}

	@Test
	public void testselectUser() throws IOException {
		SqlSession session = MybatisUtils.getsqlSession();
		String statement = "com.qjq.test.Usermapper.selectUsers";
		List<User> users = session.selectList(statement);
		session.close();
		System.out.println(users);

	}

	

}
