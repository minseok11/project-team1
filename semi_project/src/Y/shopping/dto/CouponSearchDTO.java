package Y.shopping.dto;

public class CouponSearchDTO {
	int createNum;
	String name;
	String id;
	int discount;
	String used;
	String usedate;
	public CouponSearchDTO(){}
	public CouponSearchDTO(int createNum, String name, String id, int discount, String used, String usedate) {
		super();
		this.createNum = createNum;
		this.name = name;
		this.id = id;
		this.discount = discount;
		this.used = used;
		this.usedate = usedate;
	}
	public int getCreateNum() {
		return createNum;
	}
	public void setCreateNum(int createNum) {
		this.createNum = createNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
	}
	public String getUsedate() {
		return usedate;
	}
	public void setUsedate(String usedate) {
		this.usedate = usedate;
	}
	
}
