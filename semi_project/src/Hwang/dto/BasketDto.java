package Hwang.dto;

public class BasketDto {
	int buyNum;
	int totalPrice;
	String id;
	String code;
	int cnt;
	public BasketDto(){}
	public BasketDto(int buyNum, int totalPrice, String id, String code,int cnt) {
		super();
		this.buyNum = buyNum;
		this.totalPrice = totalPrice;
		this.id = id;
		this.code = code;
		this.cnt=cnt;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
