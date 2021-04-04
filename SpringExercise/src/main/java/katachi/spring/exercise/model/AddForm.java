package katachi.spring.exercise.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddForm {

	@NotNull
	private int teamId;

	@NotBlank
	private String name;

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User toUser() {
		User user = new User();
		user.setName(name);
		user.setTeamId(teamId);
		return user;
	}
}
