package com.multiDB.repository;

import org.springframework.data.repository.CrudRepository;
import com.multiDB.model.testtable;

public interface testtableRepository extends CrudRepository<testtable, String> {
	public testtable findByid(int id);

}
