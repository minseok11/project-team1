package shopping.dto;

public class BoardDTO {
	int boardNum;
	String title;
	String content;
	String id;
	String code;
	public BoardDTO(){}
	public BoardDTO(int boardNum, String title, String content, String id, String code) {
		super();
		this.boardNum = boardNum;
		this.title = title;
		this.content = content;
		this.id = id;
		this.code = code;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
