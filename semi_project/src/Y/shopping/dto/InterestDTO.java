package Y.shopping.dto;

public class InterestDTO {
	int num;
	String code;
	String id;
	public InterestDTO(){}
	public InterestDTO(int num, String code, String id) {
		super();
		this.num = num;
		this.code = code;
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
