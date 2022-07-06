package com.atcs.finalproject.grp8.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atcs.finalproject.grp8.Entity.ManagerEntity;

import com.atcs.finalproject.grp8.Repo.managerRepo;
import com.atcs.finalproject.grp8.Services.Managerservice;

@Component
public class ManagerSerimpl implements Managerservice {
	@Autowired
	managerRepo managerRepoAuto;

	@Override
	public List<ManagerEntity> getdata() {
		return managerRepoAuto.findAll();
	}

	@Override
	public ManagerEntity getdatabyid(int manager_id) {
		ManagerEntity ManagerEntityData= managerRepoAuto.findById(manager_id).get();
		return ManagerEntityData;
	}

	@Override
	public List<ManagerEntity> postdata(ManagerEntity mh) {
		managerRepoAuto.save(mh);
		return managerRepoAuto.findAll();
	}

	@Override
	public List<ManagerEntity> putdata(ManagerEntity mh) {
		managerRepoAuto.save(mh);
		return managerRepoAuto.findAll();
	
	}

}
