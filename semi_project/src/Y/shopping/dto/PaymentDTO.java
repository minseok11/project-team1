package Y.shopping.dto;

public class PaymentDTO {
	int paymentNum;
	int itemCost;
	int retailPrice;
	String condition;
	String coupon;
	String id;
	String code;
	int deliveryNo;
	int year_month;
	int cnt;
	public PaymentDTO(){}
	public PaymentDTO(int paymentNum, int itemCost, int retailPrice, String condition, String coupon, String id,
			String code, int deliveryNo, int year_month, int cnt) {
		super();
		this.paymentNum = paymentNum;
		this.itemCost = itemCost;
		this.retailPrice = retailPrice;
		this.condition = condition;
		this.coupon = coupon;
		this.id = id;
		this.code = code;
		this.deliveryNo = deliveryNo;
		this.year_month = year_month;
		this.cnt = cnt;
	}
	public int getPaymentNum() {
		return paymentNum;
	}
	public void setPaymentNum(int paymentNum) {
		this.paymentNum = paymentNum;
	}
	public int getItemCost() {
		return itemCost;
	}
	public void setItemCost(int itemCost) {
		this.itemCost = itemCost;
	}
	public int getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(int retailPrice) {
		this.retailPrice = retailPrice;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
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
	public int getDeliveryNo() {
		return deliveryNo;
	}
	public void setDeliveryNo(int deliveryNo) {
		this.deliveryNo = deliveryNo;
	}
	public int getYear_month() {
		return year_month;
	}
	public void setYear_month(int year_month) {
		this.year_month = year_month;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
