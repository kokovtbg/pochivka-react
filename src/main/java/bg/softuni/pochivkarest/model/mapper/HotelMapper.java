package bg.softuni.pochivkarest.model.mapper;

import bg.softuni.pochivkarest.model.dto.*;
import bg.softuni.pochivkarest.model.entity.Comfort;
import bg.softuni.pochivkarest.model.entity.Hotel;
import bg.softuni.pochivkarest.model.entity.Room;
import bg.softuni.pochivkarest.model.entity.User;
import bg.softuni.pochivkarest.model.enums.RoomType;
import bg.softuni.pochivkarest.model.enums.Season;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HotelMapper {

    public HotelViewDTO hotelToHotelViewDTO(Hotel hotel, HotelViewDTO hotelViewDTO) {
        hotelViewDTO.setId(hotel.getId());
        hotelViewDTO.setName(hotel.getName());
        hotelViewDTO.setWebsite(hotel.getWebsite());
        hotelViewDTO.setInformation(hotel.getInformation());
        hotelViewDTO.setCategory(hotel.getCategory());
        hotelViewDTO.setAccommodation(hotel.getAccommodation());
        hotelViewDTO.setImages(hotel.getImages());
        List<RoomDTO> roomDTOs = new ArrayList<>();
        Arrays.stream(RoomType.values()).forEach(rt -> Arrays.stream(Season.values()).forEach(s -> {
            RoomDTO roomDTO = new RoomDTO(rt, s, BigDecimal.ZERO);
            roomDTOs.add(roomDTO);
        }));
        List<Room> rooms = hotel.getRooms();
        rooms.forEach(r -> roomDTOs.forEach(rDto -> {
            if (rDto.getRoomType().equals(r.getRoomType()) && rDto.getSeason().equals(r.getSeason())) {
                rDto.setPrice(r.getPrice());
            }
        }));
        hotelViewDTO.setRooms(roomDTOs);
        User owner = hotel.getOwner();
        UserHotelDTO userHotelDTO = new UserHotelDTO();
        userHotelDTO.setUsername(owner.getUsername());
        userHotelDTO.setEmail(owner.getEmail());
        userHotelDTO.setTelephone(owner.getTelephone());
        hotelViewDTO.setOwner(userHotelDTO);
        TownDTO townDTO = new TownDTO();
        townDTO.setName(hotel.getTown().getName());
        hotelViewDTO.setTown(townDTO);

        List<Comfort> hComforts = hotel.getComforts();
        List<ComfortDTO> comfortDTOs = new ArrayList<>();
        hComforts.forEach(c -> {
            ComfortDTO comfortDTO = new ComfortDTO();
            comfortDTO.setName(c.getName());
            comfortDTOs.add(comfortDTO);
        });
        hotelViewDTO.setComforts(comfortDTOs);
        BigDecimal minPrice = rooms.stream()
                .map(Room::getPrice)
                .min(Comparator.naturalOrder())
                .orElse(BigDecimal.ZERO);
        hotelViewDTO.setLowestPrice(minPrice);

        return hotelViewDTO;
    }
}
