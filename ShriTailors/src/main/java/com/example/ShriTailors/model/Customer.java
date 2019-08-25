package com.example.ShriTailors.model;
//this is my model class

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name="customers")
@ApiModel(description="Details about the contact")
public class Customer
{
	/*@Id
    @GeneratedValue(generator = "customer_generator")
    @SequenceGenerator(
            name = "customer_generator",
            sequenceName = "customer_sequence",
            initialValue = 1
    )
     private Long custId;*/
     
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "custId", updatable = false, nullable = false)
    private UUID custId;
	
	
	
	
	@NotBlank
	private String custName;
	
	@NotNull(message = "Please enter id")
	@ApiModelProperty(notes="The person's phone number")
	private Long custMobile;

/*	public UUID getCustId() {
		return custId;
	}

	public void setCustId(UUID custId) {
		this.custId = custId;
	}
*/
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Long getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(Long custMobile) {
		this.custMobile = custMobile;
	}
	
	
	
}