package shopping.dto;

public class ImgUploadDTO {
	String imgNum;
	String imgLoot;
	int boardNum;
	public ImgUploadDTO(){}
	public ImgUploadDTO(String imgNum, String imgLoot, int boardNum) {
		super();
		this.imgNum = imgNum;
		this.imgLoot = imgLoot;
		this.boardNum = boardNum;
	}
	public String getImgNum() {
		return imgNum;
	}
	public void setImgNum(String imgNum) {
		this.imgNum = imgNum;
	}
	public String getImgLoot() {
		return imgLoot;
	}
	public void setImgLoot(String imgLoot) {
		this.imgLoot = imgLoot;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	
}
