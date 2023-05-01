package com.customer.rewards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.rewards.entity.Customer;
import com.customer.rewards.model.Rewards;
import com.customer.rewards.repository.CustomerRepository;
import com.customer.rewards.service.RewardsService;

/**
 * @author Welcome
 *
 */
@RestController
@RequestMapping("/customers")
public class RewardsController {

	@Autowired
	RewardsService rewardsService;

	@Autowired
	CustomerRepository customerRepository;

	@GetMapping(value = "/{customerId}/rewards", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rewards> getRewardsByCustomerId(@PathVariable("customerId") Long customerId) {
		Customer customer = customerRepository.findByCustomerId(customerId);
		if (customer == null) {
			throw new RuntimeException("Invalid / Missing customer Id ");
		}
		Rewards customerRewards = rewardsService.getRewardsByCustomerId(customerId);
		return new ResponseEntity<>(customerRewards, HttpStatus.OK);
	}

}
