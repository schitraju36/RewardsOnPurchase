/**
 * 
 */
package com.customer.rewards.model;

/**
 * @author Welcome
 *
 */
public class Rewards {
	
	private long customerId;
	private long previousMonthRewardPoints;
    private long previousSecondMonthRewardPoints;
    private long previousThirdMonthRewardPoints;
    private long totalRewards;
 
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public long getPreviousMonthRewardPoints() {
		return previousMonthRewardPoints;
	}
	public void setPreviousMonthRewardPoints(long previousMonthRewardPoints) {
		this.previousMonthRewardPoints = previousMonthRewardPoints;
	}
	public long getPreviousSecondMonthRewardPoints() {
		return previousSecondMonthRewardPoints;
	}
	public void setPreviousSecondMonthRewardPoints(long previousSecondMonthRewardPoints) {
		this.previousSecondMonthRewardPoints = previousSecondMonthRewardPoints;
	}
	public long getPreviousThirdMonthRewardPoints() {
		return previousThirdMonthRewardPoints;
	}
	public void setPreviousThirdMonthRewardPoints(long previousThirdMonthRewardPoints) {
		this.previousThirdMonthRewardPoints = previousThirdMonthRewardPoints;
	}
	public long getTotalRewards() {
		return totalRewards;
	}
	public void setTotalRewards(long totalRewards) {
		this.totalRewards = totalRewards;
	}
    
}
