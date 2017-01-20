package Hwang.dto;

public class InterestDTO {
	String code;
	String id;
	public InterestDTO(){}
	public InterestDTO(String code, String id) {
		this.code = code;
		this.id = id;
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
