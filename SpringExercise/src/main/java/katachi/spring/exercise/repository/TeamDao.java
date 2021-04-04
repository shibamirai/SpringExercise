package katachi.spring.exercise.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import katachi.spring.exercise.model.Team;

public interface TeamDao {

	public List<Team> selectAll() throws DataAccessException;
}
