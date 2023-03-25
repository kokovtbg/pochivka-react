package bg.softuni.pochivkarest.model.mapper;

import bg.softuni.pochivkarest.model.dto.UserRegisterDTO;
import bg.softuni.pochivkarest.model.entity.Town;
import bg.softuni.pochivkarest.model.entity.User;
import bg.softuni.pochivkarest.model.enums.TownEnum;
import bg.softuni.pochivkarest.repository.TownRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserMapper {
//    private final PasswordEncoder passwordEncoder;
    private final TownRepository townRepository;

    @Autowired
    public UserMapper(TownRepository townRepository) {
//        this.passwordEncoder = passwordEncoder;
        this.townRepository = townRepository;
    }

    public void userRegisterDTOToUser(UserRegisterDTO userRegisterDTO, User user) {
        user.setUsername(userRegisterDTO.getUsername());
        user.setEmail(userRegisterDTO.getEmail());
        user.setFirstName(userRegisterDTO.getFirstName());
        user.setLastName(userRegisterDTO.getLastName());
//        String encodedPass = this.passwordEncoder.encode(userRegisterDTO.getPassword());
        user.setPassword(userRegisterDTO.getPassword());
        user.setTelephone(userRegisterDTO.getTelephone());
        String userRegisterDTOTown = userRegisterDTO.getTown();
        TownEnum townEnum = null;
        if (userRegisterDTOTown != null && !userRegisterDTOTown.equals("noTown")) {
            townEnum = TownEnum.valueOf(userRegisterDTOTown);
        }
        Town town = this.townRepository.findByName(townEnum);
        user.setTown(town);
    }
}
