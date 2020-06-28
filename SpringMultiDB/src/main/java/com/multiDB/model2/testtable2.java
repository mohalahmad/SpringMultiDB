package com.multiDB.model2;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity

public class testtable2 {

	private String name2;
	@Id
	private int id2;


	public testtable2() {

	}

	public testtable2(String name2, int id2) {
		this.name2 = name2;
		this.id2 = id2;

	}

	public String getname2() {
		return name2;
	}

	public void setname2(String name2) {
		this.name2 = name2;
	}

	public int getid2() {
		return id2;
	}

	public void setid2(int id2) {
		this.id2 = id2;
	}


}
