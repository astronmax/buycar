package ru.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

import ru.webapp.model.Review;
import ru.webapp.model.ReviewRepository;

@Service
public class ReviewService implements WebService<Review> {

    @Autowired
    private ReviewRepository repo;

    @Override
    public Iterable<Review> getAll() {
        return repo.findAll();
    }

    @Override
    public Review getById(Long id) {
        var opt = repo.findById(id);
        if (opt.isPresent()) {
            return opt.get();
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Review> getByName(String name) {
        List<Review> reviews = new ArrayList<>();
        for (Review review : repo.findAll()) {
            if (review.getName().contains(name)) {
                reviews.add(review);
            }
        }

        return reviews;
    }

    @Override
    public void add(Review review) {
        repo.save(review);
    }
}