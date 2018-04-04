package com.xactly.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurant_seq")
  @SequenceGenerator(name = "restaurant_seq", sequenceName = "restaurant_seq", allocationSize = 1)
  private long id;

  @Column(nullable = false)
  private String name;

  @Column() private String description;

  @Column() private String city;

  @Column() private Integer rating;

  public Restaurant() {}

  public Restaurant(String name, String description, int rating) {
    this.name = name;
    this.description = description;
    this.rating = rating;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  @Override
  public String toString() {
    return String.format(
        "Restaurant[id=%d, name=%s, description=%s, city=%s, rating=%s]",
        id, name, description, city, rating);
  }
}
