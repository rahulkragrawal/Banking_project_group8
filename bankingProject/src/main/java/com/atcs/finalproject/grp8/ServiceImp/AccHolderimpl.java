package com.atcs.finalproject.grp8.ServiceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atcs.finalproject.grp8.Entity.AccHolder;
import com.atcs.finalproject.grp8.Repo.AccholderRepo;
import com.atcs.finalproject.grp8.Services.AccHolderservices;

@Component

public class AccHolderimpl implements AccHolderservices {
	@Autowired
	AccholderRepo AccH_repo;

	@Override
	public List<AccHolder> getdata() {
		return AccH_repo.findAll();
	}

	@Override
	public AccHolder getdatabyid(int user_id) {
		AccHolder Acc_holder_data = AccH_repo.findById(user_id).get();
		return Acc_holder_data;

	}

	@Override

	public List<AccHolder> getdatabyage(int age) {
		List<AccHolder> Acc_holder_data;
		int k = 0;
		AccHolder o = new AccHolder();
		List<AccHolder> holder = new ArrayList<AccHolder>();

		Acc_holder_data = AccH_repo.findAll();
		for (AccHolder Acc_holder_data_itr : Acc_holder_data) {
			if (Acc_holder_data_itr.getAge() == age) {
				// k = p.getUser_id();
				// o = getdatabyid(k);
				holder.add(Acc_holder_data_itr);
			}
		}
		return holder;

	}

	@Override

	public List<AccHolder> getdatabyname(String user_name) {
		List<AccHolder> Acc_holder_data;
		AccHolder h;
		int k = 0;
		AccHolder o = new AccHolder();
		List<AccHolder> holder = new ArrayList<AccHolder>();
		Acc_holder_data = AccH_repo.findAll();
		for (AccHolder Acc_holder_data_itr : Acc_holder_data) {
			if (Acc_holder_data_itr.getUser_name().equals(user_name)) {
//				k = p.getUser_id();
//				o = getdatabyid(k);
				holder.add(Acc_holder_data_itr);
			}
		}
		return holder;
	}

	@Override

	public List<AccHolder> getdatabylocation(String location) {
		List<AccHolder> Acc_holder_data;
		AccHolder h;
		int k = 0;
		AccHolder o = new AccHolder();
		List<AccHolder> holder = new ArrayList<AccHolder>();

		Acc_holder_data = AccH_repo.findAll();

		for (AccHolder Acc_holder_data_itr : Acc_holder_data) {

			if (Acc_holder_data_itr.getLocation().equals(location)) {
				k = Acc_holder_data_itr.getUser_id();
				o = getdatabyid(k);
				holder.add(o);
			}
		}
		return holder;
	}

	@Override
	public List<AccHolder> postdata(AccHolder h) {
		if (h.getBalance() >= 500) {
			AccH_repo.save(h);
		}
		else {
			System.out.println("enter amount greater than 500");
		}
		return AccH_repo.findAll();
	}

	@Override
	public List<AccHolder> putdata(AccHolder h) {
		AccH_repo.save(h);
		return AccH_repo.findAll();

	}

	@Override
	public List<AccHolder> deletedata(int user_id) {
		AccH_repo.deleteById(user_id);
		return AccH_repo.findAll();

	}

	public AccHolder putbalance(int user_id, double balance) {
		double k = 0;
		AccHolder Acc_holder_data = getdatabyid(user_id);
		k = Acc_holder_data.getBalance() + balance;
		Acc_holder_data.setBalance(k);
		AccH_repo.save(Acc_holder_data);
		return Acc_holder_data;
	}

	@Override
	public List<AccHolder> putdataintrest() {
		List<AccHolder> Acc_holder_data;
		double final_amnt = 0;
		Acc_holder_data = AccH_repo.findAll();
		for (AccHolder o1 : Acc_holder_data) {
			double b1 = o1.getBalance();
			final_amnt = ((b1 * 5) / 100) + b1;
			o1.setBalance(final_amnt);
			AccH_repo.save(o1);
		}
		return Acc_holder_data;
	}

	@Override
	public double gettotal() {
		double total_amnt = 0;
		List<AccHolder> Acc_holder_data;
		Acc_holder_data = AccH_repo.findAll();
		for (AccHolder o1 : Acc_holder_data) {
			double b1 = o1.getBalance();
			total_amnt += b1;	
	}
		return total_amnt;
	}
}
