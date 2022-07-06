package com.atcs.finalproject.grp8.ServiceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atcs.finalproject.grp8.Entity.AccHolder;
import com.atcs.finalproject.grp8.Entity.BranchDetail;
import com.atcs.finalproject.grp8.Repo.AccholderRepo;
import com.atcs.finalproject.grp8.Repo.branchRepo;
import com.atcs.finalproject.grp8.Services.BranchService;

@Component

public class branchserviceimp implements BranchService {
	@Autowired
	branchRepo branch_repo_auto;
	@Autowired
	AccholderRepo accholder_repo_auto;

	@Override
	public List<BranchDetail> postdata(BranchDetail branch_detail_data) {
		// TODO Auto-generated method stub
		branch_repo_auto.save(branch_detail_data);
		return branch_repo_auto.findAll();
	}

	@Override
	public List<BranchDetail> getdata() {
		// TODO Auto-generated method stub
		return branch_repo_auto.findAll();
	}

	@Override
	public BranchDetail getdatabyid(int branch_id) {
		// TODO Auto-generated method stub
		 BranchDetail b= branch_repo_auto.findById(branch_id).get();
		return b;
	}
	
	public AccHolder getdatabyidbranch(int user_id) {
		// TODO Auto-generated method stub
		AccHolder AccHolderData = accholder_repo_auto.findById(user_id).get();
		return AccHolderData;

	}

	@Override
	public List<AccHolder> getdatabybranchid(int branch_id) {
		// TODO Auto-generated method stub
		List<AccHolder> AccHolderData;
//		AccHolder h;
//		int k = 0;
//		AccHolder o = new AccHolder();
		List<AccHolder> holder = new ArrayList<AccHolder>();
		int r;
		AccHolderData = accholder_repo_auto.findAll();
		for (AccHolder Holer_data : AccHolderData) {
			r= Holer_data.getBranch_id().getBranch_id();	
			if (r == branch_id) {
//				k = Holer_data.getUser_id();
//				o = getdatabyidbranch(k);
				holder.add(Holer_data);
			}
		}
		return holder;
	}


	@Override
	public List<BranchDetail> putdata(BranchDetail bh) {
		// TODO Auto-generated method stub
		branch_repo_auto.save(bh);
		return branch_repo_auto.findAll();
		
		
	}

	@Override
	public List<BranchDetail> deletedata(int branch_id) {
		// TODO Auto-generated method stub
		branch_repo_auto.deleteById(branch_id);
		return branch_repo_auto.findAll();
		
	}

}
