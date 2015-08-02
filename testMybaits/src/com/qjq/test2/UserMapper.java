package com.qjq.test2;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.qjq.modle.User;

public interface UserMapper {
	@Insert(value = { "insert into user(id,name,age) values(#{id},#{name},#{age})" })
	public int add(User user);

	@Delete(value = { "delete from user where id=#{id}" })
	public int deleteById(int id);

	@Select(value = { "select * from user where id=#{id}" })
	public User selectById(int id);

	@Select(value = { "select * from user" })
	public List<User> selects();

	@Update(value = { "update user set name=#{name},age=#{age} where id=#{id}" })
	public int update(User user);

}
