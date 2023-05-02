/**
 * 
 */
package com.customer.rewards;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.customer.rewards.controller.RewardsController;
import com.customer.rewards.entity.Transaction;
import com.customer.rewards.model.Rewards;
import com.customer.rewards.repository.TransactionRepository;
import com.customer.rewards.service.RewardServiceImpl;
import com.customer.rewards.service.RewardsService;

/**
 * @author Welcome
 *
 */
@SpringBootTest
public class RewardsControllerTest {

	@InjectMocks
	RewardsController controller;

	@Mock
	private RewardsService service;

	@Mock
	RewardServiceImpl serviceImpl;

	@Mock
	TransactionRepository repository;

	@Mock
	Rewards rewards;

	@Mock
	Transaction transaction;

	@Mock
	List<Transaction> transactionList;

	@BeforeEach
	public void setUp() throws ParseException {

		rewards = Rewards.builder().customerId(1001L).previousMonthRewardPoints(120)
				.previousSecondMonthRewardPoints(150).previousThirdMonthRewardPoints(160).build();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("PST"));
		Date NOW = sdf.parse("2023-03-1 00:00:00");
		Date NOW1 = sdf.parse("2023-03-24 00:00:00");
		Timestamp time = new Timestamp(NOW.getTime());
		Timestamp time1 = new Timestamp(NOW1.getTime());

		transaction = new Transaction();
		transactionList = new ArrayList();
		transaction.setCustomerId(1001L);
		transaction.setTransId(10001L);
		transaction.setAmount(160.00);
		transactionList.add(transaction);
		Mockito.when(repository.findAllByCustomerId(1001L)).thenReturn(transactionList);
		Mockito.when(repository.findAllByCustomerIdAndDateBetween(1001L, time, time1)).thenReturn(transactionList);

		rewards.setCustomerId(1001L);
		rewards.setPreviousMonthRewardPoints(150);
		rewards.setPreviousSecondMonthRewardPoints(160);
		rewards.setPreviousThirdMonthRewardPoints(120);

	}

	@Test
	public void testGetRewardsByCustomerId() throws ParseException {

		Mockito.when(this.serviceImpl.getRewardsByCustomerId(1001L)).thenReturn(rewards);
		this.serviceImpl.getRewardsByCustomerId(1001L);
		// assertNotNull(rewards.getCustomerId());
		// assertThat(rewards.getCustomerId()).isEqualTo(1001L);
	}
}
