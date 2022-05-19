package ru.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.webapp.model.Car;
import ru.webapp.model.Offer;
import ru.webapp.model.Review;
import ru.webapp.service.CarService;
import ru.webapp.service.OfferService;
import ru.webapp.service.ReviewService;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private CarService carService;

    @Autowired
    private OfferService offerService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/")
    public String getCatalog(Model model) {
        model.addAttribute("isCatalog", true);
        model.addAttribute("cars", carService.getAll());
        return "catalog";
    }

    @GetMapping("/about")
    public String getAbout(Model model) {
        model.addAttribute("isAbout", true);
        return "about";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        return "login";
    }

    @GetMapping("/error")
    public String getError(Model model) {
        return "error";
    }

    @GetMapping("/offer")
    public String getOffer(Model model, @RequestParam(required = false) String car) {
        model.addAttribute("isOffer", true);
        model.addAttribute("car", car);
        model.addAttribute("title", "Оформление заявки | BuyCar");
        return "offer";
    }

    @GetMapping("/tradein")
    public String getTradein(Model model) {
        model.addAttribute("isTradein", true);
        model.addAttribute("title", "Trade-In | BuyCar");
        return "offer";
    }

    @PostMapping("/offer/add")
    public String addOffer(
            Model model,
            @RequestParam(required = false) String car,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String tradein) {

        if ((name.isEmpty() || phone.isEmpty())
                || (car == null && tradein == null)
                || (!(car == null) && !(tradein == null))) {

            model.addAttribute("error", true);
            return getOffer(model, null);
        }

        Offer offer = new Offer(name, phone, car, tradein);
        offerService.add(offer);
        model.addAttribute("success", true);
        return getOffer(model, null);
    }

    @GetMapping("/search")
    public String getSearch(Model model, @RequestParam String carName) {
        List<Car> cars = carService.getByName(carName);
        model.addAttribute("isCatalog", true);
        model.addAttribute("cars", cars);
        return "catalog";
    }

    @GetMapping("/reviews")
    public String getReviews(Model model) {
        model.addAttribute("isReviews", true);
        Iterable<Review> reviews = reviewService.getAll();
        model.addAttribute("reviews", reviews);

        return "review";
    }

    @PostMapping("/reviews/add")
    public String addReview(
            Model model,
            @RequestParam String name,
            @RequestParam String body) {

        if (body.length() > 255) {
            model.addAttribute("error", true);
            model.addAttribute("errorText", "Ошибка. Максимальная длина отзыва - 255 символов.");
            return getReviews(model);
        }

        if (name.isEmpty() || body.isEmpty()) {
            model.addAttribute("error", true);
            model.addAttribute("errorText", "Заполните поля");
            return getReviews(model);
        }

        Review review = new Review(name, body);
        reviewService.add(review);
        model.addAttribute("success", true);
        return getReviews(model);
    }
}