package com.hendisantika.entity;

import java.io.Serializable;
import java.util.Date;

public class Lottery implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private long id;

	private String topThree;
	
	private int topThreePrice;
	
	private String tod;
	
	private int todPrice;
	
	private String topTwo;
	
	private int topTwoPrice;
	
	private String underTwo;
	
	private int underTwoPrice;
	
	private String run;
	
	private int runPrice;
	
	private String underRun;
	
	private int underRunPrice;
	
	private Date createDate;
	 
	private Date updateDate;
	
	private int groupLottery;
	
	public int getUnderRunPrice() {
		return underRunPrice;
	}

	public void setUnderRunPrice(int underRunPrice) {
		this.underRunPrice = underRunPrice;
	}

	public String getUnderRun() {
		return underRun;
	}

	public void setUnderRun(String underRun) {
		this.underRun = underRun;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTopThree() {
		return topThree;
	}

	public void setTopThree(String topThree) {
		this.topThree = topThree;
	}

	public int getTopThreePrice() {
		return topThreePrice;
	}

	public void setTopThreePrice(int topThreePrice) {
		this.topThreePrice = topThreePrice;
	}

	public String getTod() {
		return tod;
	}

	public void setTod(String tod) {
		this.tod = tod;
	}

	public int getTodPrice() {
		return todPrice;
	}

	public void setTodPrice(int todPrice) {
		this.todPrice = todPrice;
	}

	public String getTopTwo() {
		return topTwo;
	}

	public void setTopTwo(String topTwo) {
		this.topTwo = topTwo;
	}

	public int getTopTwoPrice() {
		return topTwoPrice;
	}

	public void setTopTwoPrice(int topTwoPrice) {
		this.topTwoPrice = topTwoPrice;
	}

	public String getUnderTwo() {
		return underTwo;
	}

	public void setUnderTwo(String underTwo) {
		this.underTwo = underTwo;
	}

	public int getUnderTwoPrice() {
		return underTwoPrice;
	}

	public void setUnderTwoPrice(int underTwoPrice) {
		this.underTwoPrice = underTwoPrice;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public int getRunPrice() {
		return runPrice;
	}

	public void setRunPrice(int runPrice) {
		this.runPrice = runPrice;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getGroupLottery() {
		return groupLottery;
	}

	public void setGroupLottery(int groupLottery) {
		this.groupLottery = groupLottery;
	}

	
}

