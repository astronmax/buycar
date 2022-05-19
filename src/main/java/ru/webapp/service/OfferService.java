package ru.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

import ru.webapp.model.Offer;
import ru.webapp.model.OfferRepository;

@Service
public class OfferService implements WebService<Offer> {

    @Autowired
    private OfferRepository repo;

    @Override
    public Iterable<Offer> getAll() {
        return repo.findAll();
    }

    @Override
    public Offer getById(Long id) {
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
    public List<Offer> getByName(String name) {
        List<Offer> offers = new ArrayList<>();
        for (Offer offer : repo.findAll()) {
            if (offer.getName().contains(name)) {
                offers.add(offer);
            }
        }

        return offers;
    }

    @Override
    public void add(Offer offer) {
        repo.save(offer);
    }
}