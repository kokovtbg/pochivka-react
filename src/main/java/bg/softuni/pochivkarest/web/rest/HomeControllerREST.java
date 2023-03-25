package bg.softuni.pochivkarest.web.rest;

import bg.softuni.pochivkarest.model.dto.HotelSearchDTO;
import bg.softuni.pochivkarest.model.dto.HotelViewDTO;
import bg.softuni.pochivkarest.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")
@RestController
public class HomeControllerREST {
    private final HotelService hotelService;

    @Autowired
    public HomeControllerREST(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/search-rest")
    public ResponseEntity<List<HotelViewDTO>> postSearch(@RequestBody HotelSearchDTO hotelDTO) {

        List<HotelViewDTO> hotelList = this.hotelService
                .getAllByNameAndAccommodationAndCategoryAndComfort(hotelDTO);

        return ResponseEntity.ok(hotelList);
    }
}
