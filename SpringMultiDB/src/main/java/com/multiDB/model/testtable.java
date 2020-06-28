package com.multiDB.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class testtable {

	private String name;
	@Id
	private int id;


	public testtable() {

	}

	public testtable(String name, int id) {
		this.name = name;
		this.id = id;

	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}


}
