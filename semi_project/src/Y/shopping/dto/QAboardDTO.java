package Y.shopping.dto;

public class QAboardDTO {
	int num;
	int refNum;
	String title;
	String content;
	String id;
	String qaList;
	public QAboardDTO(){}
	public QAboardDTO(int num, int refNum, String title, String content, String id, String qaList) {
		super();
		this.num = num;
		this.refNum = refNum;
		this.title = title;
		this.content = content;
		this.id = id;
		this.qaList = qaList;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getRefNum() {
		return refNum;
	}
	public void setRefNum(int refNum) {
		this.refNum = refNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQaList() {
		return qaList;
	}
	public void setQaList(String qaList) {
		this.qaList = qaList;
	}
	
	
}
