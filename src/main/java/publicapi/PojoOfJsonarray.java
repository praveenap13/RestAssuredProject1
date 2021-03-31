package publicapi;
/*
 * 
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
[
  {
    "firstName": "Amod",
    "lastName": "Mahajan",
    "gender": "Male",
    "age": 28,
    "salary": 10000.56,
    "married": false
  },
  {
    "firstName": "Animesh",
    "lastName": "Prashant",
    "gender": "Male",
    "age": 30,
    "salary": 20000.56,
    "married": true
  },
  {
    "firstName": "Kitty",
    "lastName": "Gupta",
    "gender": "Female",
    "age": 26,
    "salary": 30000.56,
    "married": false
  }
  ]
 */

public class PojoOfJsonarray {

	private String firstname;
	private String lastname;
	private String gender;
	private int age;
	private double salary;
	private boolean married;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	
}
