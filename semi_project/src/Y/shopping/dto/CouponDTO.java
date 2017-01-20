package Y.shopping.dto;

public class CouponDTO {
	String name;
	int discount;
	public CouponDTO(){}
	public CouponDTO(String name, int discount) {
		super();
		this.name = name;
		this.discount = discount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
}
