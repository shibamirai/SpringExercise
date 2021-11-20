package katachi.spring.exercise.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class InputForm {

	private String name;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;

	private String gender;

	private String bloodType;

	private String[] subjects;

	private String note;
}
