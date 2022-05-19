package ru.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.webapp.model.Car;
import ru.webapp.model.Offer;
import ru.webapp.service.CarService;
import ru.webapp.service.OfferService;
import ru.webapp.service.ReviewService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CarService carService;

    @Autowired
    private OfferService offerService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("isAdmin", true);

        Iterable<Car> cars = carService.getAll();
        model.addAttribute("cars", cars);

        Iterable<Offer> offers = offerService.getAll();
        model.addAttribute("offers", offers);

        return "admin";
    }

    @PostMapping("/cars/add")
    public String addCar(
            Model model,
            @RequestParam String name,
            @RequestParam String price,
            @RequestParam String type,
            @RequestParam String colors,
            @RequestParam String image) {
        
        if (name.isEmpty() || price.isEmpty() || type.isEmpty() 
                || image.isEmpty() || colors.isEmpty()) {
            model.addAttribute("error", true);
            return getIndex(model);
        }

        Car car = new Car(name, price, type, colors, image + ".png");
        carService.add(car);
        model.addAttribute("success", true);
        return getIndex(model);
    }

    @PostMapping("/cars/delete")
    public String deleteCar(Model model, @RequestParam(required = false) Long id) {
        if (id == null) {
            model.addAttribute("error", true);
            return getIndex(model);
        }

        carService.delete(id);
        model.addAttribute("success", true);
        return getIndex(model);
    }

    @PostMapping("/offers/delete")
    public String deleteOffer(Model model, @RequestParam(required = false) Long id) {
        if (id == null) {
            model.addAttribute("error", true);
            return getIndex(model);
        }

        offerService.delete(id);
        model.addAttribute("success", true);

        return getIndex(model);
    }

    @PostMapping("/reviews/delete")
    public String reviewOffer(Model model, @RequestParam(required = false) Long id) {
        if (id == null) {
            model.addAttribute("error", true);
            return getIndex(model);
        }

        reviewService.delete(id);
        model.addAttribute("success", true);
        return getIndex(model);
    }
}