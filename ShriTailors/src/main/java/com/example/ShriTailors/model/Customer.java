package com.example.ShriTailors.model;
//this is my model class

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
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

	private String password;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns=@JoinColumn(name="custId"),inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles;
	
	
	//Getter and Setters
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}