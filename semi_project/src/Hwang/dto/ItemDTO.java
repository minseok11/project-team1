package Hwang.dto;

public class ItemDTO {
	String code;
	int price;
	int inventory;
	String name;
	int retailPrice;
	String itemImgRoot;
	String categoryList;
	String supplier;
	
	public ItemDTO(){}
	
	public ItemDTO(String code, int price, int inventory, String name, int retailPrice,
			String itemImgRoot, String categoryList, String supplier) {
		super();
		this.code = code;
		this.price = price;
		this.inventory = inventory;
		this.name = name;
		this.retailPrice = retailPrice;
		this.itemImgRoot = itemImgRoot;
		this.categoryList = categoryList;
		this.supplier=supplier;
	}
		
	public ItemDTO(int price, String name, String itemImgRoot, String categoryList) {
		this.price = price;
		this.name = name;
		this.itemImgRoot = itemImgRoot;
		this.categoryList = categoryList;
	}

	public String getSupplier(){
		return supplier;
	}
	public void setSupplier(String supplier){
		this.supplier=supplier;
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
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(int retailPrice) {
		this.retailPrice = retailPrice;
	}
	public String getItemImgRoot() {
		return itemImgRoot;
	}
	public void setItemImgRoot(String itemImgRoot) {
		this.itemImgRoot = itemImgRoot;
	}
	public String getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(String categoryList) {
		this.categoryList = categoryList;
	}
	
}
