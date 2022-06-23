package com.hendisantika.entity;

import java.io.Serializable;
import java.util.Date;

public class UserLotter implements Serializable{
	
	    private static final long serialVersionUID = 1L;

		private long id;
		
		private String name;
		
		private String sureName;
		
		private String userLogin;
		
		private String password;
		
		private Date createDate;
		 
		private Date updateDate;
		
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

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSureName() {
			return sureName;
		}

		public void setSureName(String sureName) {
			this.sureName = sureName;
		}

		public String getUserLogin() {
			return userLogin;
		}

		public void setUserLogin(String userLogin) {
			this.userLogin = userLogin;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}


}
		
