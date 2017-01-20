package Y.shopping.dto;

public class CategoryDTO {
	String categoryList;
	public CategoryDTO(){}
	public CategoryDTO(String categoryList) {
		super();
		this.categoryList = categoryList;
	}
	public String getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(String categoryList) {
		this.categoryList = categoryList;
	}
}
