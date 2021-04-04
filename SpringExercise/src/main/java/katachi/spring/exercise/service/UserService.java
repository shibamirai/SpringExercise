package katachi.spring.exercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import katachi.spring.exercise.model.User;
import katachi.spring.exercise.repository.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public List<User> getUserList() {
		return userDao.selectAll();
	}

}
