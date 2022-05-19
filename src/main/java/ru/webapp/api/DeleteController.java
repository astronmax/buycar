package ru.webapp.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ru.webapp.service.*;

@RestController
@RequestMapping("/api/delete")
public class DeleteController {
    
    @Autowired
    private CarService carService;

    @Autowired
    private OfferService offerService;

    @Autowired
    private ReviewService reviewService;

    @DeleteMapping("/car/{id}")
    public void deleteCar(@PathVariable Long id, @RequestParam String password) {
        if (password.equals("none")) {
            carService.delete(id);
        }
    }

    @DeleteMapping("/offer/{id}")
    public void deleteOffer(@PathVariable Long id, @RequestParam String password) {
        if (password.equals("none")) {
            offerService.delete(id);
        }
    }

    @DeleteMapping("/review/{id}")
    public void deleteReview(@PathVariable Long id, @RequestParam String password) {
        if (password.equals("none")) {
            reviewService.delete(id);
        }
    }
}