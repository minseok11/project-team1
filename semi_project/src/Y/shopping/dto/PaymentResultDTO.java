package Y.shopping.dto;

public class PaymentResultDTO {
	int paymentNum;
	String code;
	String itemImgRoot;
	String name;
	int price;
	int cnt;
	String coupon;
	int itemCost;
	String deliveryCondi;
	public PaymentResultDTO(int paymentNum, String code, String itemImgRoot, String name, int price, int cnt,
			String coupon, int itemCost, String deliveryCondi) {
		super();
		this.paymentNum = paymentNum;
		this.code = code;
		this.itemImgRoot = itemImgRoot;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
		this.coupon = coupon;
		this.itemCost = itemCost;
		this.deliveryCondi = deliveryCondi;
	}
	public int getPaymentNum() {
		return paymentNum;
	}
	public void setPaymentNum(int paymentNum) {
		this.paymentNum = paymentNum;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getItemImgRoot() {
		return itemImgRoot;
	}
	public void setItemImgRoot(String itemImgRoot) {
		this.itemImgRoot = itemImgRoot;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public int getItemCost() {
		return itemCost;
	}
	public void setItemCost(int itemCost) {
		this.itemCost = itemCost;
	}
	public String getDeliveryCondi() {
		return deliveryCondi;
	}
	public void setDeliveryCondi(String deliveryCondi) {
		this.deliveryCondi = deliveryCondi;
	}
		
}

