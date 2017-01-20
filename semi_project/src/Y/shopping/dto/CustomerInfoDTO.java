package Y.shopping.dto;

public class CustomerInfoDTO {
	String id;
	String password;
	String qesList;
	String ans;
	String name;
	String gender;
	String email;
	String phoneNo;
	String adress;
	String postNo;
	public CustomerInfoDTO(){}
	public CustomerInfoDTO(String id, String password, String qesList, String ans, String name, String gender,
			String email, String phoneNo, String adress, String postNo) {
		super();
		this.id = id;
		this.password = password;
		this.qesList = qesList;
		this.ans = ans;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phoneNo = phoneNo;
		this.adress = adress;
		this.postNo = postNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQesList() {
		return qesList;
	}
	public void setQesList(String qesList) {
		this.qesList = qesList;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPostNo() {
		return postNo;
	}
	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}
	
}
