package Hwang.dto;

public class BIDTO {
	int buyNum;
	int totalprice;
	String name;
	String code;
	String itemimgroot;
	int cnt;
	public BIDTO() {
		super();
	}
	public BIDTO(int buyNum, int totalprice, String name, String code, String itemimgroot,int cnt) {
		super();
		this.buyNum=buyNum;
		this.totalprice = totalprice;
		this.name = name;
		this.code=code;
		this.itemimgroot = itemimgroot;
		this.cnt=cnt;
	}
	
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
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
