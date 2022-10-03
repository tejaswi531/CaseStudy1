package com.payment.service;
import java.nio.charset.StandardCharsets;
import java.util.List;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.payment.entity.PaymentDetails;
import com.payment.entity.UserDetails;
import com.payment.exception.ResourceNotFoundException;
import com.payment.repository.UserPaymentRepository;
import com.payment.repository.UserRepository;

@Service
public class PaymentServiceImpl implements PaymentService
{
	int id;


	
	@Autowired
	UserPaymentRepository userPayRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public List<PaymentDetails> getAll() {
		List<PaymentDetails> payDetails=userPayRepo.findAll();
		return payDetails;
	}
	
	@Override
	public String proceedToPay(PaymentDetails payment)
	{
		long pnrNo=payment.getPnrNo();
		List<UserDetails> det=userRepo.findAll();
		 for(UserDetails x:det) {
				if(x.getPnrNo()==pnrNo) {
					id=x.getId();
				}	
		}
		userRepo.findById(id)
					.orElseThrow(()->new ResourceNotFoundException("Cannot proceed the payment request as booking is not done with PNR Number : "+pnrNo));
		userPayRepo.save(payment); 
		
		return ("Your payment for PNR Number "+payment.getPnrNo()+" is Successful...!!!");
		 
	}
	
	@Override
	public String deletePayment(long pnrNo) {
		userPayRepo.deleteById(pnrNo);
		return "You payment for "+pnrNo+ " will be credited to your account within 7 days..";
	}
	
	//to update payment field in user details after successful payment
	@Override
	 public void updateUserPaymentDetails(long pnrNo)
	 {
		  List<UserDetails> details=userRepo.findAll();
		  for(UserDetails x:details) {
			 
				if(x.getPnrNo()==pnrNo) {
					x.setPayment("Successful");
					userRepo.save(x);
				}
		  }
	  }
	  
	
}
	
	
