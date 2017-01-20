package Y.shopping.dto;

public class ImgDTO {
	private String name;
	private String nickname;
	private String filePath;
	private String fileName;
	public ImgDTO(){}
	public ImgDTO(String name, String nickname, String filePath, String fileName) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.filePath = filePath;
		this.fileName = fileName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
