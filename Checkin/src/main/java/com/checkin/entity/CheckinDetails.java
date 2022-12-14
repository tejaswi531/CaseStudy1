package com.checkin.entity;

import java.time.LocalDate;
import java.util.Random;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document (collection = "checkInDetails")
public class CheckinDetails {
	
	
    @Id
	@NotNull
	private long pnrNo;
    
    @NotNull
	private int seatNo;

	@NotNull
	@Size(min = 3, message = "Name should be minimum of 3 characters")
	private String name;

	@NotNull(message = "Flight number cannot be null")
	@Max(value = 99999, message = "Flight number cannot exceed 5 digits")
	private int flightNo;

	@NotNull
	private String startPoint;

	@NotNull
	private String endPoint;

	@NotNull
	@Size(max = 7, message = "Departure Time should be maximum of 7 characters")
	private String deptTime;

	private LocalDate flightDate;

	private String duration;
	
	@NotNull
	@Size(max = 6, message = "Either male,female or other ")
	private String sex;

	@NotNull
	@Size(min = 2, message = "Class type should be minimum of 2 characters")
	private String classType;

	@NotNull
	private String payment;
	

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public long getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(long pnrNo) {
		this.pnrNo = pnrNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}

	public String getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getDeptTime() {
		return deptTime;
	}

	public void setDeptTime(String deptTime) {
		this.deptTime = deptTime;
	}

	public LocalDate getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(LocalDate date) {
		this.flightDate = date;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	

	public CheckinDetails(@NotNull long pnrNo, @NotNull int seatNo,
			@NotNull @Size(min = 3, message = "Name should be minimum of 3 characters") String name,
			@NotNull(message = "Flight number cannot be null") @Max(value = 99999, message = "Flight number cannot exceed 5 digits") int flightNo,
			@NotNull String startPoint, @NotNull String endPoint,
			@NotNull @Size(max = 7, message = "Departure Time should be maximum of 7 characters") String deptTime,
			LocalDate flightDate, String duration,
			@NotNull @Size(max = 6, message = "Either male,female or other ") String sex,
			@NotNull @Size(min = 2, message = "Class type should be minimum of 2 characters") String classType,
			@NotNull String payment) {
		super();
		this.pnrNo = pnrNo;
		this.seatNo = seatNo;
		this.name = name;
		this.flightNo = flightNo;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.deptTime = deptTime;
		this.flightDate = flightDate;
		this.duration = duration;
		this.sex = sex;
		this.classType = classType;
		this.payment = payment;
	}

	
	@Override
	public String toString() {
		return "CheckinDetails [pnrNo=" + pnrNo + ", seatNo=" + seatNo + ", name=" + name + ", flightNo=" + flightNo
				+ ", startPoint=" + startPoint + ", endPoint=" + endPoint + ", deptTime=" + deptTime + ", flightDate="
				+ flightDate + ", duration=" + duration + ", sex=" + sex + ", classType=" + classType
				+ ", payment=" + payment + "]";
	}

	public CheckinDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void setSeatNo() {		
		Random num = new Random();
	      int res;
	      for ( int i = 1; i <= 5; i++ ) {
	         res = 1 + num.nextInt( 10 );
	         this.seatNo=res;
	      }
	    
	   }

	
}
