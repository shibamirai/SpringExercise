package katachi.spring.exercise.form;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserAddForm {

	@NotBlank
	private String name;

	private Integer teamId;
}
