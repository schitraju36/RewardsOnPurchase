/**
 * 
 */
package com.customer.rewards.repository;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.customer.rewards.entity.Transaction;

/**
 * @author Welcome
 *
 */
@Repository
@Transactional
public interface TransactionRepository extends CrudRepository<Transaction,Long> { 
	
	public List<Transaction> findAllByCustomerId(Long customerId);
	
	public List<Transaction> findAllByCustomerIdAndDateBetween(Long customerId, Timestamp from,Timestamp to);
}
