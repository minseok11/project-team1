package Y.shopping.dto;

public class DeliveryDTO {
	int deliveryNo;
	String name;
	String phoneNo;
	String postNo;
	String deliveryLoc;
	String deliveryCondi;
	String id;
	public DeliveryDTO(){}
	public DeliveryDTO(int deliveryNo, String name, String phoneNo, String postNo, String deliveryLoc,
			String deliveryCondi, String id) {
		super();
		this.deliveryNo = deliveryNo;
		this.name = name;
		this.phoneNo = phoneNo;
		this.postNo = postNo;
		this.deliveryLoc = deliveryLoc;
		this.deliveryCondi = deliveryCondi;
		this.id = id;
	}
	public int getDeliveryNo() {
		return deliveryNo;
	}
	public void setDeliveryNo(int deliveryNo) {
		this.deliveryNo = deliveryNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPostNo() {
		return postNo;
	}
	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}
	public String getDeliveryLoc() {
		return deliveryLoc;
	}
	public void setDeliveryLoc(String deliveryLoc) {
		this.deliveryLoc = deliveryLoc;
	}
	public String getDeliveryCondi() {
		return deliveryCondi;
	}
	public void setDeliveryCondi(String deliveryCondi) {
		this.deliveryCondi = deliveryCondi;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
