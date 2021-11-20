package katachi.spring.exercise.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class InputForm {

	@NotBlank
	private String name;

	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;

	@NotBlank
	private String gender;

	@NotBlank
	private String bloodType;

	@Size(min=1)
	private String[] subjects;

	@NotBlank
	@Size(max=100)
	private String note;
}
