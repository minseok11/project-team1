package Hwang.dto;

public class CustomerDTO {
	private String id;
	private String password;
	private String qeslist;
	private String ans;
	private String name;
	private String gender;
	private String email;
	private String phoneno;
	private String adress;
	private String postno;
	
	public CustomerDTO() {}

	public CustomerDTO(String id, String password, String qeslist, String ans, String name, String gender, String email,
			String phoneno, String adress, String postno) {
		this.id = id;
		this.password = password;
		this.qeslist = qeslist;
		this.ans = ans;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phoneno = phoneno;
		this.adress = adress;
		this.postno = postno;
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

	public String getQeslist() {
		return qeslist;
	}

	public void setQeslist(String qeslist) {
		this.qeslist = qeslist;
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

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPostno() {
		return postno;
	}

	public void setPostno(String postno) {
		this.postno = postno;
	}
}
