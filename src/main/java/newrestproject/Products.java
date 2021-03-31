package newrestproject;

import java.util.List;

public class Products {
	
	private String type;
	private List<Pricing>  price;
	private Specification specs;
	private String brand;
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setPricing(List<Pricing> price) {
		this.price = price;
	}
	public void setSpecs(Specification specs) {
		this.specs = specs;
	}
}
