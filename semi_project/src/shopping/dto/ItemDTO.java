package shopping.dto;

public class ItemDTO {
	String code;
	int price;
	int inventory;
	String name;
	int retailPrice;
	String category;
	String ItemImgRoot;
	String categoryList;
	public ItemDTO(){}
	public ItemDTO(String code, int price, int inventory, String name, int retailPrice, String category,
			String itemImgRoot, String categoryList) {
		super();
		this.code = code;
		this.price = price;
		this.inventory = inventory;
		this.name = name;
		this.retailPrice = retailPrice;
		this.category = category;
		ItemImgRoot = itemImgRoot;
		this.categoryList = categoryList;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getItemImgRoot() {
		return ItemImgRoot;
	}
	public void setItemImgRoot(String itemImgRoot) {
		ItemImgRoot = itemImgRoot;
	}
	public String getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(String categoryList) {
		this.categoryList = categoryList;
	}
	
}
