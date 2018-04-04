package com.xactly.demo.repository;

import com.xactly.demo.domain.Restaurant;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant, Long> {}
