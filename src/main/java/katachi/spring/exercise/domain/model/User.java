package katachi.spring.exercise.domain.model;

import lombok.Data;

@Data
public class User {

	private Integer id;
	private String name;
	private Team team;
}
