package com.jwt.hibernate.entity;

import java.util.Set;

public class Bank {

		private int bankId;
		private String name;
		private String address;
		private String ifscCode;
		private Set<Customer> customers;
		public int getBankId() {
			return bankId;
		}
		public void setBankId(int bankId) {
			this.bankId = bankId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getIfscCode() {
			return ifscCode;
		}
		public void setIfscCode(String ifscCode) {
			this.ifscCode = ifscCode;
		}
		public Set<Customer> getCustomers() {
			return customers;
		}
		public void setCustomers(Set<Customer> customers) {
			this.customers = customers;
		}
		
		
}
