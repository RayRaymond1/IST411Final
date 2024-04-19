package psu.edu.Final.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_records")
public class Employee {
	
	//define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="start_salary")
	private int salary;
	
	@Column(name="signed_contract")
	private char signedContract;
	
	@Column(name="ssn")
	private String ssn;
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="emergency_name")
	private String emergencyName;
	
	@Column(name="emergency_number")
	private String emergencyNumber;
	
	//define constructor
	public Employee()
	{
		
	}

	public Employee(int empId, String firstName, String lastName, LocalDate startDate, int salary, char signedContract,
			String ssn, LocalDate birthDate, String phoneNumber, String emergencyName, String emergencyNumber) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.startDate = startDate;
		this.salary = salary;
		this.signedContract = signedContract;
		this.ssn = ssn;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.emergencyName = emergencyName;
		this.emergencyNumber = emergencyNumber;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getStartDate() {
	    return startDate;
	}

	public void setStartDate(LocalDate startDate) {
	    this.startDate = startDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public char getSignedContract() {
		return signedContract;
	}

	public void setSignedContract(char signedContract) {
		this.signedContract = signedContract;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmergencyName() {
		return emergencyName;
	}

	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}

	public String getEmergencyNumber() {
		return emergencyNumber;
	}

	public void setEmergencyNumber(String emergencyNumber) {
		this.emergencyNumber = emergencyNumber;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", startDate="
				+ startDate + ", salary=" + salary + ", signedContract=" + signedContract + ", ssn=" + ssn
				+ ", birthDate=" + birthDate + ", phoneNumber=" + phoneNumber + ", emergencyName=" + emergencyName
				+ ", emergencyNumber=" + emergencyNumber + "]";
	}


	

}
