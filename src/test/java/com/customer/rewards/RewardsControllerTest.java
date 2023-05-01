/**
 * 
 */
package com.customer.rewards;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.customer.rewards.controller.RewardsController;
import com.customer.rewards.entity.Customer;
import com.customer.rewards.repository.TransactionRepository;

/**
 * @author Welcome
 *
 */
@ExtendWith(MockitoExtension.class)
public class RewardsControllerTest {

	@InjectMocks
	RewardsController rewardsController;

    @Mock
    TransactionRepository repo;
    
    @Test
    public void testCustomer() {
    	
    }
    
}
