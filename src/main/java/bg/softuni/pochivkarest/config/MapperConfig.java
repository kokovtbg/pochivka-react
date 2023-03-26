package bg.softuni.pochivkarest.config;

import bg.softuni.pochivkarest.model.mapper.HotelMapper;
import bg.softuni.pochivkarest.model.mapper.UserMapper;
import bg.softuni.pochivkarest.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MapperConfig {
    private PasswordEncoder passwordEncoder;
    private TownRepository townRepository;

    @Autowired
    public MapperConfig(TownRepository townRepository) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.townRepository = townRepository;
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapper(passwordEncoder, this.townRepository);
    }

    @Bean
    public HotelMapper hotelMapper() {
        return new HotelMapper();
    }
}
