package com.Jacob.savetravels.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

//co coded with megan 

@Entity
@Table(name = "travel")
public class Travel {

	// attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Expense name is required")
	private String  expense;
	
	@NotBlank(message = "vendor name is required")
	private String  vendor;
	
	@NotBlank(message = "description name is required")
	private String  description;
	
	@Min(1)
	@NotNull
	private Integer amount;
	
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

	

	public Travel() {}

	public Travel(@NotEmpty(message = "Expense Name is required") String expense,
			@NotEmpty(message = "Vendor is required") String vendor,
			@NotNull(message = "Amount is required") Integer amount,
			@NotEmpty(message = "Description is required") String description) {
		super();
		this.expense = expense;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.createdAt = new Date();
	}
	
	
}
