package shopping.dto;

public class SupplierDTO {
	String supplier;
	String manager;
	String contect;
	String code;
	public SupplierDTO(){}
	public SupplierDTO(String supplier, String manager, String contect, String code) {
		super();
		this.supplier = supplier;
		this.manager = manager;
		this.contect = contect;
		this.code = code;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getContect() {
		return contect;
	}
	public void setContect(String contect) {
		this.contect = contect;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
