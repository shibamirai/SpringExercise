package katachi.spring.exercise.domain.service;

import java.util.List;

import katachi.spring.exercise.domain.model.Team;
import katachi.spring.exercise.domain.model.User;

public interface UserService {

	public List<User> getUsers();
	public List<Team> getTeams();
	public boolean isExist(String userName);
	public void register(User user);
}
