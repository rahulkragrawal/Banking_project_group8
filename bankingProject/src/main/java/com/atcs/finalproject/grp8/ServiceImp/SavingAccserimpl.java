package com.atcs.finalproject.grp8.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atcs.finalproject.grp8.Entity.AccHolder;
import com.atcs.finalproject.grp8.Entity.CurrentAcc;
import com.atcs.finalproject.grp8.Entity.SavingAcc;
import com.atcs.finalproject.grp8.Repo.AccholderRepo;
import com.atcs.finalproject.grp8.Repo.currentRepo;
import com.atcs.finalproject.grp8.Repo.savingRepo;
import com.atcs.finalproject.grp8.Services.SavingService;

@Component

public class SavingAccserimpl  implements SavingService{
	@Autowired
	savingRepo savingRepoAuto;
	@Autowired
	AccHolderimpl AccHolderimplAuto;
	@Autowired
	AccholderRepo AccholderRepoAuto;
	

	@Override
	public List<SavingAcc> getdata() {
		return savingRepoAuto.findAll();
	}

	@Override
	public SavingAcc getdatabyid(long Acc_noS) {
		SavingAcc s= savingRepoAuto.findById( Acc_noS).get();
		return s;
	}

	@Override
	public List<SavingAcc> postdata(SavingAcc s) {
		savingRepoAuto.save(s);
		return savingRepoAuto.findAll();
	}

	@Override
	public List<SavingAcc> putdata(SavingAcc s) {
		savingRepoAuto.save(s);
		return savingRepoAuto.findAll();
		
	}

	@Override
	public List<SavingAcc> deletedata(long Acc_noS) {
		savingRepoAuto.deleteById(Acc_noS);
		return savingRepoAuto.findAll();		
	}
	
	@Override
	public double  putdatabypin(double balance, SavingAcc c) {
		SavingAcc savingAccObj = new SavingAcc();
		AccHolder obj = new AccHolder();
		double q = 0;
		long getAccountNo = c.getAcc_noS();
		if (savingRepoAuto.existsByAcc_noS(getAccountNo)) {
			savingAccObj = getdatabyid(getAccountNo);
			if (savingAccObj.getPin_S() == c.getPin_S()) {
				obj = AccHolderimplAuto.getdatabyid(c.getUser_id().getUser_id());
				q = obj.getBalance() + balance;
				obj.setBalance(q);
				AccholderRepoAuto.save(obj);
			}
		}
		return q;
	}
	
	@Override
	public double putdatabypinwithdraw(double balance, SavingAcc c) {
		SavingAcc savingAccObj = new SavingAcc();
		AccHolder obj = new AccHolder();
		double q = obj.getBalance();
		long getAccountNo = c.getAcc_noS();
		double return_balanace=0;
		if (savingRepoAuto.existsByAcc_noS(getAccountNo)) {
			savingAccObj = getdatabyid(getAccountNo);
			// double return_balanace=obj.getBalance();
			if (savingAccObj.getPin_S() == c.getPin_S()) {
				obj = AccHolderimplAuto.getdatabyid(c.getUser_id().getUser_id());
				//q = obj.getBalance() - balance;
				if(obj.getBalance() - balance>=500) {
					q=obj.getBalance() - balance; 				
				obj.setBalance(q);
				AccholderRepoAuto.save(obj);
				}
				 return_balanace =obj.getBalance();
			}
		}
		return return_balanace;	
	}
}
