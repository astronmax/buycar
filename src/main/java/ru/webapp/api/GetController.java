package ru.webapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.webapp.model.*;
import ru.webapp.service.*;

@RestController
@RequestMapping("/api/get")
public class GetController {
    
    @Autowired
    private CarService carService;

    @Autowired
    private OfferService offerService;

    @Autowired
    private ReviewService reviewService;
    
    @GetMapping("/cars")
    public Iterable<Car> getAllCars() {
        return carService.getAll();
    }

    @GetMapping("/cars/{id}")
    public Car getCar(@PathVariable Long id) {
        return carService.getById(id);
    }

    @GetMapping("/offers")
    public ResponseEntity<Iterable<Offer>> getAllOffers(@RequestParam String password) {
        if (password.equals("none")) {
            return new ResponseEntity<>(offerService.getAll(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/offers/{id}")
    public ResponseEntity<Offer> getOffer(@PathVariable Long id, @RequestParam String password) {
        if (password.equals("none")) {
            return new ResponseEntity<>(offerService.getById(id), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/reviews")
    public Iterable<Review> getAllReviews() {
        return reviewService.getAll();
    }

    @GetMapping("/reviews/{id}")
    public Review getReview(@PathVariable Long id) {
        return reviewService.getById(id);
    }
}
