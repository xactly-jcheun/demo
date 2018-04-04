package com.xactly.demo.service;

import com.xactly.demo.domain.Restaurant;
import com.xactly.demo.repository.RestaurantRepository;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
  private static final Logger log = LoggerFactory.getLogger(RestaurantService.class);

  @Autowired private RestaurantRepository restaurantRepository;

  public RestaurantService() {}

  public Restaurant createRestaurant(Restaurant restaurant) {
    return restaurantRepository.save(restaurant);
  }

  public Restaurant getRestaurant(long id) {
    return restaurantRepository.findOne(id);
  }

  public void updateRestaurant(Restaurant restaurant) {
    restaurantRepository.save(restaurant);
  }

  public void deleteRestaurant(Long id) {
    restaurantRepository.delete(id);
  }

  public Page<Restaurant> getAllRestaurants(Integer page, Integer size) {
    return restaurantRepository.findAll(new PageRequest(page, size));
  }
}
