package com.au.hibernate.entiity;




import javax.persistence.*;



import java.util.*;

@Entity
@Table(name="Employee_Table")


public class Employee {

    @Id
    @Column(name ="Emp_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(name ="First_Name", length = 30)
    private String firstName;

    @Column(name ="Last_Name", length = 30)
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Address> addressList = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Emp_Course", joinColumns = @JoinColumn(name = "EmpId"), inverseJoinColumns = @JoinColumn(name="Session_Id"))
    private Collection<Course> course = new HashSet<>();

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public Collection<Course> getCourse() {
		return course;
	}

	public void setCourse(Collection<Course> course) {
		this.course = course;
	}

	public Employee() {
		super();
		
	}
    

}