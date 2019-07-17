package com.sth.hotelsservice.controllers;


import com.sth.hotelsservice.Services.HotelsService;
import com.sth.hotelsservice.models.Booking;
import com.sth.hotelsservice.repositories.HotelsRepository;
import com.sth.hotelsservice.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/bookings")
public class BookingsController {

    @Autowired
    private HotelsRepository hRep;
    @Autowired
    private BookingRepository bRep;
    @Autowired
    private HotelsService hService;

    @GetMapping("/init")
    public String initialize(){

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate=null;
        Date secondDate=null;
        try {
            firstDate = sdf.parse("06/24/2017");
            secondDate = sdf.parse("06/30/2017");
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        Booking b = new Booking(hRep.findById("5d2b9d0da6f18c2f807d54ac").get(), , firstDate.getTime(), secondDate.getTime());
        return "nth";
    }

}
