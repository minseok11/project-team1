package Hwang.dto;

public class IIDTO {
	int price;
	String name;
	String itemimgroot;
	String code;
	public IIDTO() {
		super();
	}
	public IIDTO(int price, String name, String itemimgroot, String code) {
		super();
		this.price = price;
		this.name = name;
		this.itemimgroot = itemimgroot;
		this.code=code;
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItemimgroot() {
		return itemimgroot;
	}
	public void setItemimgroot(String itemimgroot) {
		this.itemimgroot = itemimgroot;
	}
	
	
}
