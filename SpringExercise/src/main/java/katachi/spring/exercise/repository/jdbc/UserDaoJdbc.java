package katachi.spring.exercise.repository.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import katachi.spring.exercise.model.User;
import katachi.spring.exercise.repository.UserDao;

@Repository
public class UserDaoJdbc implements UserDao {

	@Autowired
	JdbcTemplate jdbc;

	private final String SELECT_ALL = "SELECT user.id as id, user.name as name, team.name as teamname FROM user"
			+ " JOIN team ON user.team_id = team.team_id";
	private final String COUNT_BY_NAME = "SELECT COUNT(*) FROM user WHERE name = ?";
	private final String INSERT = "INSERT INTO user(team_id, name) VALUES(?, ?)";

	@Override
	public List<User> selectAll() throws DataAccessException {
		List<Map<String, Object>> records = jdbc.queryForList(SELECT_ALL);

		List<User> userList = new ArrayList<>();

		for (Map<String, Object>map : records) {
			User user = new User();
			user.setId((Integer)map.get("id"));
			user.setTeamName((String)map.get("teamname"));
			user.setName((String)map.get("name"));

			userList.add(user);
		}
		return userList;
	}

	@Override
	public int countByName(String name) throws DataAccessException {
		return jdbc.queryForObject(COUNT_BY_NAME, Integer.class, name);
	}

	@Override
	public int insert(User user) throws DataAccessException {
		return jdbc.update(INSERT, user.getTeamId(), user.getName());
	}

}
