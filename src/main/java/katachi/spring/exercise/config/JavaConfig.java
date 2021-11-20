package katachi.spring.exercise.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import katachi.spring.exercise.domain.model.User;
import katachi.spring.exercise.form.UserAddForm;

@Configuration
public class JavaConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		// プロパティ名が厳密に一致するもののみマッピングする
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		// 型が一致するもののみマッピングする
		modelMapper.getConfiguration().setFullTypeMatchingRequired(true);
		// ネストした型へのマッピング(UserAddForm.teamId -> User.team.id)
		modelMapper.typeMap(UserAddForm.class, User.class).addMappings(
				mapper -> mapper.map(
						src -> src.getTeamId(),
						(dest, v) -> dest.getTeam().setId((Integer)v)));
		return modelMapper;
	}

}
