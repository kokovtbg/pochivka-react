package bg.softuni.pochivkarest.web.rest;

import bg.softuni.pochivkarest.model.dto.HotelViewDTO;
import bg.softuni.pochivkarest.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class HotelDetailControllerREST {
    private final HotelService hotelService;

    @Autowired
    public HotelDetailControllerREST(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotel-detail-rest/{id}")
    public ResponseEntity<HotelViewDTO> hotelDetail(@PathVariable(name = "id") long id) {
        HotelViewDTO hotelViewDTO = this.hotelService.findById(id);
        return ResponseEntity.ok(hotelViewDTO);
    }
}
