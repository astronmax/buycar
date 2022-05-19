/**
 * Class describes Review entity
 */

package ru.webapp.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;     // name of reviewer
    private String body;     // review's date
    private LocalDate date;  // review's date

    public Review() {
    }

    public Review(String name, String body) {
        this.name = name;
        this.body = body;
        this.date = LocalDate.now();
    }

    // name setter and getter

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // body setter and getter

    public void setBody(String body) {
        this.body = body;
    }

    public String getBody() {
        return this.body;
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
