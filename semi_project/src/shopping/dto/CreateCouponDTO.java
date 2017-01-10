package shopping.dto;

public class CreateCouponDTO {
	int createNum;
	String name;
	String id;
	String used;
	String usedate;
	public CreateCouponDTO() {}
	public CreateCouponDTO(int createNum, String name, String id, String used, String usedate) {
		super();
		this.createNum = createNum;
		this.name = name;
		this.id = id;
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
