package com.groupeisi;

import com.groupeisi.dto.RoleDto;
import com.groupeisi.dto.UserDto;
import com.groupeisi.services.RolesService;
import com.groupeisi.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class AdminAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminAppApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RolesService rolesService, UserService userService){
		return args -> {
			Stream.of("Role_Tester","Role_Ing","Role_Control_Arch").forEach(nom->{
				RoleDto roleDto = new RoleDto();
				roleDto.setNom(nom);
				rolesService.createRoles(roleDto);

				UserDto userDto = new UserDto();
				userDto.setNom("Ba");
				userDto.setPrenom("Diaryatou");
				userDto.setEmail("mariamabousso@groupeisi.com");
				userDto.setPassword("diary");
				userDto.setEtat(1);
				userService.createUsers(userDto);


			});

		};
	}
}
