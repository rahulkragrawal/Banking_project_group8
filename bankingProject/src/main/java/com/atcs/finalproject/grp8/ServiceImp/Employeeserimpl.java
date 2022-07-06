package com.atcs.finalproject.grp8.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.atcs.finalproject.grp8.Entity.employeeEntity;
import com.atcs.finalproject.grp8.Repo.employeeRepo1;
import com.atcs.finalproject.grp8.Services.employeSer;

@Component

public class Employeeserimpl implements employeSer  {
	@Autowired
	employeeRepo1 employeeRepoAuto;

	@Override
	public List<employeeEntity> getdata() {
		return employeeRepoAuto.findAll();
	}

	@Override
	public employeeEntity getdatabyid(int emp_id) {
		employeeEntity employeeEntityData= employeeRepoAuto.findById(emp_id).get();
		return employeeEntityData; 
		
	
	}

	@Override
	public List<employeeEntity> postdata(employeeEntity emp) {
		employeeRepoAuto.save(emp);
		return employeeRepoAuto.findAll();
		
	}

	@Override
	public List<employeeEntity> putdata(employeeEntity emp) {
		employeeRepoAuto.save(emp);
		return employeeRepoAuto.findAll();
		
	}

}
