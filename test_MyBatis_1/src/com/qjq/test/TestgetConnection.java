package com.qjq.test;

import java.io.IOException;
import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;

import com.qjq.mybatis.utils.MybatisUtils;


public class TestgetConnection {
	public static void main(String[] args) throws IOException {
		SqlSession session=MybatisUtils.getsqlSession();
		Connection connection= session.getConnection();
		System.out.println(connection);
	}
}
