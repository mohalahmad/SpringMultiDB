package com.multiDB.repository2;

import org.springframework.data.repository.CrudRepository;
import com.multiDB.model2.testtable2;

public interface testtable2Repository extends CrudRepository<testtable2, String> {
	public testtable2 findByid2(int id);

}
