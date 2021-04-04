package katachi.spring.exercise.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import katachi.spring.exercise.model.User;

public interface UserDao {

	public List<User> selectAll() throws DataAccessException;
	public int countByName(String name) throws DataAccessException;
	public int insert(User user) throws DataAccessException;
}
