package com.devsuperior.dsvendas.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleSumDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3580951287510671401L;
	
	
	private String sellerName;
	private Double sum;
	
	
	/*
	public SaleSumDTO(Seller seller, Double sum) {
		this.sellerName = seller.getName();
		this.sum = sum;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	*/
	

}
