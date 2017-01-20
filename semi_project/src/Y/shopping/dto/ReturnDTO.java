package Y.shopping.dto;

public class ReturnDTO {
	int returnNo;
	String id;
	String code;
	String reason;
	String returnCondi;
	int paymentNum;
	public ReturnDTO(int returnNo, String id, String code, String reason, String returnCondi, int paymentNum) {
		super();
		this.returnNo = returnNo;
		this.id = id;
		this.code = code;
		this.reason = reason;
		this.returnCondi = returnCondi;
		this.paymentNum = paymentNum;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getReturnNo() {
		return returnNo;
	}
	public void setReturnNo(int returnNo) {
		this.returnNo = returnNo;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
