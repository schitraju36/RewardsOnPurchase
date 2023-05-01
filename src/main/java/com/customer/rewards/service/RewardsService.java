package com.customer.rewards.service;

import com.customer.rewards.model.Rewards;

/**
 * @author Welcome
 *
 */
public interface RewardsService {

	 public Rewards getRewardsByCustomerId(Long customerId);
}
