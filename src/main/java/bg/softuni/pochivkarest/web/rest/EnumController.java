package bg.softuni.pochivkarest.web.rest;

import bg.softuni.pochivkarest.model.enums.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class EnumController {

    @GetMapping("/accommodation")
    public ResponseEntity<List<Accommodation>> getAllAccommodation() {
        return ResponseEntity.ok(Arrays.stream(Accommodation.values()).toList());
    }

    @GetMapping("/comfort")
    public ResponseEntity<List<ComfortEnum>> getAllComforts() {
        return ResponseEntity.ok(Arrays.stream(ComfortEnum.values()).toList());
    }

    @GetMapping("/category")
    public ResponseEntity<List<HotelCategory>> getAllCategories() {
        return ResponseEntity.ok(Arrays.stream(HotelCategory.values()).toList());
    }

    @GetMapping("/town")
    public ResponseEntity<List<TownEnum>> getAllTowns() {
        return ResponseEntity.ok(Arrays.stream(TownEnum.values()).toList());
    }

    @GetMapping("/room")
    public List<RoomType> getAllRoomTypes() {
        return Arrays.stream(RoomType.values()).toList();
    }

    @GetMapping("/season")
    public List<Season> getAllSeasons() {
        return Arrays.stream(Season.values()).toList();
    }
}
