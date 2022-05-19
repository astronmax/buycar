package ru.webapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ru.webapp.model.*;
import ru.webapp.service.*;

@RestController
@RequestMapping("/api/add")
public class AddController {
    
    @Autowired
    private CarService carService;

    @Autowired
    private OfferService offerService;

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/car")
    public Boolean addCar(@RequestBody Car car, @RequestParam String password) {
        if (password.equals("none")) {
            carService.add(car);
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/offer")
    public Boolean addOffer(@RequestBody Offer offer, @RequestParam String password) {
        if (password.equals("none")) {
            offerService.add(offer);
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/review")
    public Boolean addReview(@RequestBody Review review, @RequestParam String password) {
        if (password.equals("none")) {
            reviewService.add(review);
            return true;
        } else {
            return false;
        }
    }
}