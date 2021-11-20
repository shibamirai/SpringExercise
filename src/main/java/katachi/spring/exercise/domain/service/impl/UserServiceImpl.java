package katachi.spring.exercise.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import katachi.spring.exercise.domain.model.User;
import katachi.spring.exercise.domain.service.UserService;
import katachi.spring.exercise.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public List<User> getUsers() {
		return userMapper.findAll();
	}
}
