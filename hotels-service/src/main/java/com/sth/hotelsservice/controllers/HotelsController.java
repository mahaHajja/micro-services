package com.sth.hotelsservice.controllers;


import com.sth.hotelsservice.Services.HotelsService;
import com.sth.hotelsservice.repositories.HotelsRepository;
import com.sth.hotelsservice.models.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RequestMapping("/hotels")
@RestController
public class HotelsController {

    @Autowired
    private HotelsRepository hRep;
    @Autowired
    private HotelsService hService;

    @GetMapping("")
    public List<Hotel> getAll() {
        return hRep.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Hotel> getHotel(@PathVariable String id) {
        return hRep.findById(id);
    }

    @PostMapping("/add")
    public String saveHotel(@RequestBody Hotel hotel) {
        hRep.save(hotel);
        return hotel.getName()+" is added";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteHotel(@PathVariable("id") String id) {
        hRep.deleteById(id);
        return "deleted";
    }

    @GetMapping("/offer/{uId}/{hId}/{from}/{to}")
    public String getOffer(@PathVariable String uId, @PathVariable String hId, @PathVariable long from, @PathVariable long to){
        return hService.getOffer(hId, uId, from, to);
    }
    //http://localhost:8082/hotels/offer/5d2b9cfba6f18c015086771b/5d2b9d0da6f18c2f807d54ac/1563260400000/1563519600000
    // 16/7 to 19/7
}
