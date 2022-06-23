package com.hendisantika.entity;

import java.io.Serializable;
import java.util.Date;


public class History  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private int sumTopThreePrice;
	
	private int sumTodPrice;
	
	private int sumTopTwoPrice;
	
	private int sumUnderTwoPrice;
	
	private int  sumRunPrice;
	
	private int  sumUnderRunPrice;
	
	private int  sumPrice;
	
	private String  createBy;
	
	private Date createDate;
	
	private Date updateDate; 
	
	private String saveFrom;
	
	private int groupLottery;
	
	
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public int getSumUnderRunPrice() {
		return sumUnderRunPrice;
	}

	public void setSumUnderRunPrice(int sumUnderRunPrice) {
		this.sumUnderRunPrice = sumUnderRunPrice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSumTopThreePrice() {
		return sumTopThreePrice;
	}

	public void setSumTopThreePrice(int sumTopThreePrice) {
		this.sumTopThreePrice = sumTopThreePrice;
	}

	public int getSumTodPrice() {
		return sumTodPrice;
	}

	public void setSumTodPrice(int sumTodPrice) {
		this.sumTodPrice = sumTodPrice;
	}

	public int getSumTopTwoPrice() {
		return sumTopTwoPrice;
	}

	public void setSumTopTwoPrice(int sumTopTwoPrice) {
		this.sumTopTwoPrice = sumTopTwoPrice;
	}

	public int getSumUnderTwoPrice() {
		return sumUnderTwoPrice;
	}

	public void setSumUnderTwoPrice(int sumUnderTwoPrice) {
		this.sumUnderTwoPrice = sumUnderTwoPrice;
	}

	public int getSumRunPrice() {
		return sumRunPrice;
	}

	public void setSumRunPrice(int sumRunPrice) {
		this.sumRunPrice = sumRunPrice;
	}

	public int getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
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

	public String getSaveFrom() {
		return saveFrom;
	}

	public void setSaveFrom(String saveFrom) {
		this.saveFrom = saveFrom;
	}

	public int getGroupLottery() {
		return groupLottery;
	}

	public void setGroupLottery(int groupLottery) {
		this.groupLottery = groupLottery;
	}
	
}

