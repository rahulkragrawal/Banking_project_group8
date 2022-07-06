package com.atcs.finalproject.grp8.ServiceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atcs.finalproject.grp8.Entity.AccHolder;
import com.atcs.finalproject.grp8.Entity.CurrentAcc;
import com.atcs.finalproject.grp8.Repo.AccholderRepo;
import com.atcs.finalproject.grp8.Repo.currentRepo;
import com.atcs.finalproject.grp8.Services.currentAccservices;

@Component

public class currentAccimpl implements currentAccservices {
	@Autowired
	currentRepo current_repo_auto;
	@Autowired
	AccHolderimpl acc_holder_imp_auto;
	@Autowired
	AccholderRepo acc_holder_repo_auto;

	@Override
	public List<CurrentAcc> getdata() {
		// TODO Auto-generated method stub
		return current_repo_auto.findAll();
	}

	@Override
	public CurrentAcc getdatabyid(long Acc_noC) {
		CurrentAcc CurrentAccData = current_repo_auto.findById(Acc_noC).get();
		return CurrentAccData;

	}

	@Override
	public List<CurrentAcc> postdata(CurrentAcc c) {
		current_repo_auto.save(c);
		return current_repo_auto.findAll();

	}

	@Override
	public List<CurrentAcc> putdata(CurrentAcc c) {
		current_repo_auto.save(c);
		return current_repo_auto.findAll();

	}

	@Override
	public double  putdatabypin(double balance, CurrentAcc c) {
		CurrentAcc a = new CurrentAcc();
		AccHolder obj = new AccHolder();
		double q = 0;
		long k = c.getAcc_noc();

		System.out.println(current_repo_auto.existsByAcc_noC(k));
		if (current_repo_auto.existsByAcc_noC(k)) {
			a = getdatabyid(k);
			if (a.getPin() == c.getPin()) {
				System.out.println(balance);
				obj = acc_holder_imp_auto.getdatabyid(c.getUser_id().getUser_id());
				System.out.println(obj.getBalance());
				q = obj.getBalance() + balance;
				obj.setBalance(q);
				acc_holder_repo_auto.save(obj);

			}

		}

		return q;

	}

	@Override
	public List<CurrentAcc> deletedata(long Acc_noC) {
		current_repo_auto.deleteById(Acc_noC);
		return current_repo_auto.findAll();

	}

	@Override
	public double putdatabypinwithdraw(double balance, CurrentAcc c) {
		CurrentAcc a = new CurrentAcc();
		AccHolder obj = new AccHolder();
		double q = obj.getBalance();
		long k = c.getAcc_noc();
		double b=0;

		System.out.println(current_repo_auto.existsByAcc_noC(k));
		if (current_repo_auto.existsByAcc_noC(k)) {
			a = getdatabyid(k);
			// double b=obj.getBalance();
			if (a.getPin() == c.getPin()) {
				System.out.println("need to add"+balance);
				obj = acc_holder_imp_auto.getdatabyid(c.getUser_id().getUser_id());
				System.out.println("old bal"+obj.getBalance());
				//q = obj.getBalance() - balance;
				if(obj.getBalance() - balance>=500) {
					q=obj.getBalance() - balance; 	
				obj.setBalance(q);
				System.out.println("balance="+obj.getBalance());
				acc_holder_repo_auto.save(obj);
				}
				 b =obj.getBalance();
			}
		}
		return b;	
	}
}
