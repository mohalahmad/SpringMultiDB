package com.multiDB.controller;

import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import com.multiDB.model.*;
import com.multiDB.model2.testtable2;
import com.multiDB.repository.testtableRepository;
import com.multiDB.repository2.testtable2Repository;

@Controller
public class MainController {

	
	@Autowired
	private testtableRepository testrepo1;
	
	@Autowired
	private testtable2Repository testrepo2;
	
	@Bean
	public void printall() {
//		List<testtable> a2 = (List<testtable>) testrepo1.findAll();
		System.out.println("------hiiiiiiiiiiii------------------------");
//		for (int i = 0; i < a2.size(); i++) {
//			System.out.println(a2.get(i));
//
//		}
		
		testtable 	t1 = new testtable();
//		t1.setid(77);
//		t1.setname("hhhhhhhh");
//		testrepo1.save(t1);
		t1 = testrepo1.findByid(1);
		System.out.println(t1.getname());

		System.out.println("-------------------------------");

	}
	
	
	
	@Bean
	public void printall2() {
//		List<testtable2> a2 = (List<testtable2>) testrepo2.findAll();
		System.out.println("------22222222222222------------------------");
//		for (int i = 0; i < a2.size(); i++) {
//			System.out.println(a2.get(i));
//
//		}
		
		testtable2 t2 = new testtable2();
//		t2.setid2(77);
//		t2.setname2("hhhhhhhh");
//		testrepo2.save(t2);
		t2 = testrepo2.findByid2(1);
		System.out.println(t2.getname2());
//		System.out.println(testrepo2.findByid2(1));

		System.out.println("-------------------------------");

	}

	@PreDestroy
	public void onShutDown() {
		System.out.println("ALL DONE ...");
	}

}