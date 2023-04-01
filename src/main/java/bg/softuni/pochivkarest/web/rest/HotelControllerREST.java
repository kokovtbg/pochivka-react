package bg.softuni.pochivkarest.web.rest;

import bg.softuni.pochivkarest.model.dto.HotelAddDTO;
import bg.softuni.pochivkarest.model.dto.HotelViewDTO;
import bg.softuni.pochivkarest.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class HotelControllerREST {
    private final HotelService hotelService;

    @Autowired
    public HotelControllerREST(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotel-detail-rest/{id}")
    public ResponseEntity<HotelViewDTO> hotelDetail(@PathVariable(name = "id") long id) {
        HotelViewDTO hotelViewDTO = this.hotelService.findById(id);
        return ResponseEntity.ok(hotelViewDTO);
    }

    @PostMapping("/hotel-add-rest/{username}")
    public HotelViewDTO hotelAdd(@RequestBody HotelAddDTO hotelAddDTO,
                                 @PathVariable String username) {
        return hotelService.register(hotelAddDTO, username);
    }
}
