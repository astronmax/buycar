/**
 * Class describes Car entity
 */

package ru.webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;   // name of the car
    private String price;  // car price
    private String type;   // car type
    private String colors;   // car colors
    private String image;  // path to file with image for car

    public Car() {
    }

    public Car(String name, String price, String type, String colors, String image) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.image = image;
        this.colors = colors;
    }

    // name setter and getter

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // price setter and getter

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return this.price;
    }

    // type setter and getter

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    // image setter and getter

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return this.image;
    }

    // colors setter and getter

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getColors() {
        return this.colors;
    }

    // ID getter
    public Long getId() {
        return this.id;
    }
}