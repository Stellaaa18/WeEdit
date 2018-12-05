package com.test.pojo;

public class TestPojo {
	private int id;
	private String testUserName;
	private String testPassword;
	private String testAge;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTestUserName() {
		return testUserName;
	}
	public void setTestUserName(String testUserName) {
		this.testUserName = testUserName;
	}
	public String getTestPassword() {
		return testPassword;
	}
	public void setTestPassword(String testPassword) {
		this.testPassword = testPassword;
	}
	public String getTestAge() {
		return testAge;
	}
	public void setTestAge(String testAge) {
		this.testAge = testAge;
	}
	
	public TestPojo() {
		super();
	}
	
	public TestPojo(int id, String testUserName, String testPassword, String testAge) {
		super();
		this.id = id;
		this.testUserName = testUserName;
		this.testPassword = testPassword;
		this.testAge = testAge;
	}
	
	@Override
	public String toString() {
		return "TestPojo [id=" + id + ", testUserName=" + testUserName + ", testPassword=" + testPassword + ", testAge="
				+ testAge + "]";
	}

}
