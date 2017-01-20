package Y.shopping.dto;

public class ReturnItemDTO {
	int returnNo;
	String reason;
	String returnCondi;
	int paymentNum;
	public ReturnItemDTO(){}
	public ReturnItemDTO(int returnNo, String reason, String returnCondi, int paymentNum) {
		super();
		this.returnNo = returnNo;
		this.reason = reason;
		this.returnCondi = returnCondi;
		this.paymentNum = paymentNum;
	}
	public int getReturnNo() {
		return returnNo;
	}
	public void setReturnNo(int returnNo) {
		this.returnNo = returnNo;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getReturnCondi() {
		return returnCondi;
	}
	public void setReturnCondi(String returnCondi) {
		this.returnCondi = returnCondi;
	}
	public int getPaymentNum() {
		return paymentNum;
	}
	public void setPaymentNum(int paymentNum) {
		this.paymentNum = paymentNum;
	}
	
}
