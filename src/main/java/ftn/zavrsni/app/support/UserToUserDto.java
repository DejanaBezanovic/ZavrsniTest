package ftn.zavrsni.app.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ftn.zavrsni.app.model.User;
import ftn.zavrsni.app.web.dto.UserDto;


@Component
public class UserToUserDto implements Converter<User, UserDto>{

	@Override
	public UserDto convert(User source) {
		UserDto target = new UserDto();
		
		target.setId(source.getId());
		target.setUsername(source.getUsername());
		
		return target;
	}

	
}
