package katachi.spring.exercise.repository.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import katachi.spring.exercise.model.Team;
import katachi.spring.exercise.repository.TeamDao;

@Repository
public class TeamDaoJdbc implements TeamDao {

	@Autowired
	JdbcTemplate jdbc;

	private final String SELECT_ALL = "SELECT team_id, name FROM team";

	/* EX10 */
	@Override
	public List<Team> selectAll() throws DataAccessException {
		List<Map<String, Object>> records = jdbc.queryForList(SELECT_ALL);

		List<Team> teamList = new ArrayList<>();

		for (Map<String, Object>map : records) {
			Team team = new Team();
			team.setTeamId((Integer)map.get("team_id"));
			team.setName((String)map.get("name"));

			teamList.add(team);
		}
		return teamList;
	}

}
