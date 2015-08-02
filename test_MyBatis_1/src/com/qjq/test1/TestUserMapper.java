package com.qjq.test1;

import java.io.IOException;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.qjq.modle.User;
import com.qjq.mybatis.utils.MybatisUtils;

public class TestUserMapper {
	

	@Test
	public void testselectUserById() throws IOException {
		SqlSession session = MybatisUtils.getsqlSession();
		UserMapper maper = session.getMapper(UserMapper.class);
		User user = maper.selectById(4);
		System.out.println(user);

	}

}
