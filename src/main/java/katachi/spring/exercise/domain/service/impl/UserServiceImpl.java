package katachi.spring.exercise.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import katachi.spring.exercise.domain.model.Team;
import katachi.spring.exercise.domain.model.User;
import katachi.spring.exercise.domain.service.UserService;
import katachi.spring.exercise.repository.TeamMapper;
import katachi.spring.exercise.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Autowired
	TeamMapper teamMapper;

	@Override
	public List<User> getUsers() {
		return userMapper.findAll();
	}

	@Override
	public List<Team> getTeams() {
		return teamMapper.findAll();
	}

	@Override
	public boolean isExist(String userName) {
		if (userMapper.count(userName) > 0) {
			return false;
		}
		return true;
	}

	@Override
	public void register(User user) {
		userMapper.insertOne(user);
	}
}
