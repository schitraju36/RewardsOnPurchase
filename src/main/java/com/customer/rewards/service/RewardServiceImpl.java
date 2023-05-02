/**
 * 
 */
package com.customer.rewards.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.rewards.constants.Constants;
import com.customer.rewards.entity.Transaction;
import com.customer.rewards.model.Rewards;
import com.customer.rewards.repository.TransactionRepository;

/**
 * @author Welcome
 *
 */
@Service
public class RewardServiceImpl implements RewardsService {

	@Autowired
	TransactionRepository transactionRepository;

	public RewardServiceImpl(TransactionRepository repo) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Rewards getRewardsByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
		Timestamp lastMonthTimestamp = getDateBasedOnOffSetDays(Constants.daysInMonth);
		Timestamp lastSecondMonthTimestamp = getDateBasedOnOffSetDays(2 * Constants.daysInMonth);
		Timestamp lastThirdMonthTimestamp = getDateBasedOnOffSetDays(3 * Constants.daysInMonth);

		List<Transaction> lastMonthTransactions = transactionRepository.findAllByCustomerIdAndDateBetween(customerId,
				lastMonthTimestamp, Timestamp.from(Instant.now()));
		List<Transaction> lastSecondMonthTransactions = transactionRepository.findAllByCustomerIdAndDateBetween(customerId,
				lastSecondMonthTimestamp, lastMonthTimestamp);
		List<Transaction> lastThirdMonthTransactions = transactionRepository.findAllByCustomerIdAndDateBetween(customerId,
				lastThirdMonthTimestamp, lastSecondMonthTimestamp);

		Long lastMonthRewardPoints = getRewardsPerMonth(lastMonthTransactions);
		Long lastSecondMonthRewardPoints = getRewardsPerMonth(lastSecondMonthTransactions);
		Long lastThirdMonthRewardPoints = getRewardsPerMonth(lastThirdMonthTransactions);

		Rewards customerRewards = new Rewards();
		customerRewards.setCustomerId(customerId);
		customerRewards.setPreviousMonthRewardPoints(lastMonthRewardPoints);
		customerRewards.setPreviousSecondMonthRewardPoints(lastSecondMonthRewardPoints);
		customerRewards.setPreviousThirdMonthRewardPoints(lastThirdMonthRewardPoints);
		customerRewards
				.setTotalRewards(lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints);

		return customerRewards;
	}

	private Long getRewardsPerMonth(List<Transaction> transactions) {
		return transactions.stream().map(transaction -> calculateRewards(transaction))
				.collect(Collectors.summingLong(r -> r.longValue()));
	}

	private Long calculateRewards(Transaction t) {
		long totalPoints = 0;
		if (t.getAmount() <= 50) {
			totalPoints += 0;
		} else if (t.getAmount() > 50 && t.getAmount() <= 100) {
			totalPoints += (t.getAmount() - 50);
		} else {
			totalPoints += ((t.getAmount() - 50) + (t.getAmount() - 100));
		}
		return totalPoints;
	}

	public Timestamp getDateBasedOnOffSetDays(int days) {
		return Timestamp.valueOf(LocalDateTime.now().minusDays(days));
	}

}
