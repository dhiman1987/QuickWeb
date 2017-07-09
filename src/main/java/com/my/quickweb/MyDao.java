package com.my.quickweb;

public class MyDao {

	private MyDs dataSource;
	
	public MyDao(MyDs dataSource) {
		this.dataSource = dataSource;
	}
	public void setDataSource(MyDs dataSource) {
		this.dataSource = dataSource;
	}
	public String getDbName() {
		return this.dataSource.getName();
	}
}
