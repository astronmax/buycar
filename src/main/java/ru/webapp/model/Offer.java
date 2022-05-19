/**
 * Class describes offer entity
 */

package ru.webapp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;       // client's name
    private String phone;      // client's phone
    private String car;        // car that client wants to buy
    private String tradein;    // client's car for trade-in
    private LocalDate date;    // offer's date

    public Offer() {
    }

    public Offer(String name, String phone, String car, String tradein) {
        this.name = name;
        this.phone = phone;
        this.car = car;
        this.tradein = tradein;
        this.date = LocalDate.now();
    }

    // name setter and getter

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // phone setter and getter

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return this.phone;
    }

    // car setter and getter

    public void setCar(String car) {
        this.car = car;
    }

    public String getCar() {
        return this.car;
    }

    // tradein setter and getter

    public void setTradein(String tradein) {
        this.tradein = tradein;
    }

    public String getTradein() {
        return this.tradein;
    }

    // date setter and getter

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return this.date;
    }

    // ID getter
    public Long getId() {
        return this.id;
    }
}