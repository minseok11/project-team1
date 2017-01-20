package Y.shopping.dto;

public class BuyDTO {
	int buyNum;
	int totalPrice;
	String id;
	String code;
	public BuyDTO(){}
	public BuyDTO(int buyNum, int totalPrice, String id, String code) {
		super();
		this.buyNum = buyNum;
		this.totalPrice = totalPrice;
		this.id = id;
		this.code = code;
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
