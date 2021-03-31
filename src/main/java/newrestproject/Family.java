package newrestproject;

public class Family {
	/*
	 * familyhead:"
	 * familyi\
	 */
	private String familyHead;
	private String familyIncome;
	private Address address;
	private FamilyMemberAge memberage;
	public void setFamilyMemberAge(FamilyMemberAge age) {
		memberage=age;
	}
	public void setAddress(Address address) {
		this.address=address;
		
		
	}
	public void setfamilyHead(String familyHead) {
		this.familyHead=familyHead;
	}
	public String getFamilyHead() {
		return familyHead;
	}
	public void setfamilyIncome(String familyIncome) {
		this.familyIncome=familyIncome;
	}
	
	public String getFamilyIncome() {
		return familyIncome;
	}

}
