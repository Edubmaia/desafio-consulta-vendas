package com.devsuperior.dsmeta.dto;

public class SellerMinDTO {
	
	
	private String sellerName;
	private Double total;
	
	
	public SellerMinDTO(String sellerName, Double total) {
		this.sellerName = sellerName;
		this.total = total;
	}
	
	public String getSellerName() {
		return sellerName;
	}

	public Double getTotal() {
		return total;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public void setSum(Double sum) {
		this.total = sum;
	}
	
	
}


