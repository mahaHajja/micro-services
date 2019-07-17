package com.sth.hotelsservice.Services;


import com.sth.hotelsservice.models.Booking;
import com.sth.hotelsservice.repositories.BookingRepository;
import com.sth.hotelsservice.repositories.HotelsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class HotelsService {
    @Autowired
    private HotelsRepository hotelsRepo;

    @Autowired
    private BookingRepository bookingRepo;


    public String getOffer(String hId, String uId, long mfrom, long mto) {  //ms
        List<Booking> bookings = bookingRepo.findByHotel(hId);

        Date from = new Date(mfrom);
        Date to = new Date(mto);
        if(bookings.size()!=0) {
            for (Booking booking : bookings) {
                Date bFrom = new Date(booking.getFrom());
                Date bTo = new Date(booking.getTo());
                if (((from.before(bTo) && from.after(bFrom)) || (from.equals(bFrom))) ||
                        ((to.before(bTo) && to.after(bFrom))) || (to.equals(bTo))) {
                    if (booking.getUser().getId() == uId) {
                        return "booked by u lol!";
                    } else {
                        return "oops! it's already booked :D!";
                    }
                }
            }
        }
        //if u got here, then no conflict

        long diffInMillies = Math.abs(to.getTime() - from.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        double price = hotelsRepo.findById(hId).get().getPricePerDay() * diff;

        return "AVAILABLE, cost for "+diff+" days is "+price+ "$";
    }

}
