package com.atcs.finalproject.grp8.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atcs.finalproject.grp8.Entity.AccHolder;
import com.atcs.finalproject.grp8.Entity.CurrentAcc;
import com.atcs.finalproject.grp8.Repo.currentRepo;
import com.atcs.finalproject.grp8.ServiceImp.AccHolderimpl;
import com.atcs.finalproject.grp8.ServiceImp.currentAccimpl;

@RestController
@RequestMapping("/currentacc")
public class CurrentAccController {
	@Autowired
	currentRepo currentRepoAuto;
	@Autowired
	currentAccimpl currentAccimplAuto;
	@Autowired
	AccHolderimpl AccHolderimplAuto;
	
	@GetMapping("/")
	public List<CurrentAcc> getdata(){
		return currentAccimplAuto.getdata() ;
	}
	@GetMapping("{id}")
	public CurrentAcc getdatabyid(@PathVariable("id")long Acc_noC) {
		return currentAccimplAuto.getdatabyid(Acc_noC);
	}
	@GetMapping("/mapeddata")
	public List<AccHolder> getdatabyid() {
		return AccHolderimplAuto.getdata();
	}
	@PostMapping("/")
	public List<CurrentAcc> postdata(@RequestBody CurrentAcc c){
		return currentAccimplAuto.postdata(c);
	}
	@PutMapping("/")
	public List<CurrentAcc> putdata(@RequestBody CurrentAcc c){
		return currentAccimplAuto.putdata(c); 
	}
	//JsonObjectSerializer json = new JsonObjectSerializer();
	@PutMapping("/deposit/{balance}")
	public double putdatabypin( @PathVariable("balance")double balance,@RequestBody CurrentAcc c ){
		
		return currentAccimplAuto.putdatabypin(balance,c); 
	}
	@PutMapping("/withdraw/{balance}")
	public double putdatabypinwithdraw( @PathVariable("balance")double balance,@RequestBody CurrentAcc c ){
		
		return currentAccimplAuto.putdatabypinwithdraw(balance,c); 
	}
	@DeleteMapping("/{id}")
	public List<CurrentAcc> deletedata(@PathVariable("id") long Acc_noC){
		return currentAccimplAuto.deletedata(Acc_noC);
	}

}
