package katachi.spring.exercise.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import katachi.spring.exercise.domain.model.User;

@Mapper
public interface UserMapper {

	public List<User> findAll();
	public void insertOne(User user);
	public int count(String name);
}
