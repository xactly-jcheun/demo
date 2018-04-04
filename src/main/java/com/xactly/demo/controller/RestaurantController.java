package com.xactly.demo.controller;

import com.xactly.demo.domain.Restaurant;
import com.xactly.demo.service.RestaurantService;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/restaurants")
public class RestaurantController {

  @Autowired private RestaurantService restaurantService;

  @RequestMapping(value = "", method = RequestMethod.POST)
  public void createRestaurant(
      @RequestBody Restaurant restaurant,
      HttpServletRequest request,
      HttpServletResponse response) {
    Restaurant createdRestaurant = this.restaurantService.createRestaurant(restaurant);
    response.setHeader(
        "Location",
        request.getRequestURL().append("/").append(createdRestaurant.getId()).toString());
  }

  @RequestMapping(value = "", method = RequestMethod.GET)
  public @ResponseBody Page<Restaurant> getAllRestaurant(
      @RequestParam(value = "page", required = true, defaultValue = "0") Integer page,
      @RequestParam(value = "size", required = true, defaultValue = "10") Integer size) {
    return this.restaurantService.getAllRestaurants(page, size);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public @ResponseBody Restaurant getRestaurant(@PathVariable("id") long id) {
    return this.restaurantService.getRestaurant(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void getAllRestaurant(@PathVariable("id") long id) {
    this.restaurantService.deleteRestaurant(id);
  }
}
