package bg.softuni.pochivkarest.repository;

import bg.softuni.pochivkarest.model.entity.Room;
import bg.softuni.pochivkarest.model.enums.RoomType;
import bg.softuni.pochivkarest.model.enums.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByHotelIdAndRoomTypeAndSeason(long id, RoomType roomType, Season season);
}
