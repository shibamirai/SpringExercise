package katachi.spring.exercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import katachi.spring.exercise.model.Team;
import katachi.spring.exercise.model.User;
import katachi.spring.exercise.repository.TeamDao;
import katachi.spring.exercise.repository.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private TeamDao teamDao;

	public List<User> getUserList() {
		return userDao.selectAll();
	}

	public List<Team> getTeamList() {
		return teamDao.selectAll();
	}

	public boolean isExistUser(String name) {
		return userDao.countByName(name) > 0 ? true : false;
	}

	public boolean register(User user) {
		return userDao.insert(user) > 0 ? true : false;
	}

	public boolean delete(int id) {
		return userDao.delete(id) > 0 ? true : false;
	}
}
