package Y.shopping.dto;

public class SupplierDTO {
	String supplier;
	String manager;
	String contect;
	public SupplierDTO(){}
	public SupplierDTO(String supplier, String manager, String contect) {
		super();
		this.supplier = supplier;
		this.manager = manager;
		this.contect = contect;
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
	
}
