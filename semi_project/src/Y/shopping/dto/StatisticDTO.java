package Y.shopping.dto;

public class StatisticDTO {
	int year_month;
	int totalRetailPrice;
	int totalSales;
	public StatisticDTO(){}
	public StatisticDTO(int year_month, int totalRetailPrice, int totalSales) {
		super();
		this.year_month = year_month;
		this.totalRetailPrice = totalRetailPrice;
		this.totalSales = totalSales;
	}
	public int getYear_month() {
		return year_month;
	}
	public void setYear_month(int year_month) {
		this.year_month = year_month;
	}
	public int getTotalRetailPrice() {
		return totalRetailPrice;
	}
	public void setTotalRetailPrice(int totalRetailPrice) {
		this.totalRetailPrice = totalRetailPrice;
	}
	public int getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}
	
}
