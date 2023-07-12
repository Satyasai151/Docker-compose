package com.info.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
public class Product {
	@Id
	@GeneratedValue
	private Integer prodId;
	private String prodCode;
	private Double prodCost;
	private String prodVender;
	private Double prodGst;
	private Double prodDis;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Integer prodId, String prodCode, Double prodCost, String prodVender, Double prodGst,
			Double prodDis) {
		super();
		this.prodId = prodId;
		this.prodCode = prodCode;
		this.prodCost = prodCost;
		this.prodVender = prodVender;
		this.prodGst = prodGst;
		this.prodDis = prodDis;
	}
	public Integer getProdId() {
		return prodId;
	}
	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public Double getProdCost() {
		return prodCost;
	}
	public void setProdCost(Double prodCost) {
		this.prodCost = prodCost;
	}
	public String getProdVender() {
		return prodVender;
	}
	public void setProdVender(String prodVender) {
		this.prodVender = prodVender;
	}
	public Double getProdGst() {
		return prodGst;
	}
	public void setProdGst(Double prodGst) {
		this.prodGst = prodGst;
	}
	public Double getProdDis() {
		return prodDis;
	}
	public void setProdDis(Double prodDis) {
		this.prodDis = prodDis;
	}
	
	


}
