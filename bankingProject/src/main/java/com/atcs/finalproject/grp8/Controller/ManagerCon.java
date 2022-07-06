package com.atcs.finalproject.grp8.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.atcs.finalproject.grp8.Entity.ManagerEntity;
import com.atcs.finalproject.grp8.Entity.employeeEntity;
import com.atcs.finalproject.grp8.Repo.managerRepo;
import com.atcs.finalproject.grp8.ServiceImp.Employeeserimpl;
import com.atcs.finalproject.grp8.ServiceImp.ManagerSerimpl;

@RestController
@RequestMapping("/manager")

public class ManagerCon {
	@Autowired
	managerRepo managerRepoAuto;
	@Autowired
	ManagerSerimpl ManagerSerimplAuto;
	@Autowired
	Employeeserimpl EmployeeserimplAuto;
	
	
	@GetMapping("/")
	public List<ManagerEntity> getdata(){
		return ManagerSerimplAuto.getdata() ;
	}
	@GetMapping("{id}")
	public ManagerEntity getdatabyid(@PathVariable("id")int manager_id) {
		return ManagerSerimplAuto.getdatabyid(manager_id);
	}
	@GetMapping("/mapeddata")
	public List<employeeEntity> getdatabyid() {
		return EmployeeserimplAuto.getdata();
	}
	
	@PostMapping("/")
	public List<ManagerEntity> postdata(@RequestBody ManagerEntity mh){
		return ManagerSerimplAuto.postdata(mh);
	}
	@PutMapping("/")
	public List<ManagerEntity> putdata(@RequestBody ManagerEntity mh){
		return ManagerSerimplAuto.putdata(mh); 
	}
	

}
