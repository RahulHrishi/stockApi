package com.bodmas.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_ARTEXP")
public class ExpEntity {

	
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
	 
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="user_name")
    private String userName;
    
    @Column(name="exp_string")
    private String expString;
    
    @Column(name="output", nullable=false, length=200)
    private String output;

	

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getExpString() {
		return expString;
	}

	public void setExpString(String expString) {
		this.expString = expString;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [id=" + id + ", userName=" + userName + ", expString=" + expString + ", output=" + output
				+ "]";
	}


    

}