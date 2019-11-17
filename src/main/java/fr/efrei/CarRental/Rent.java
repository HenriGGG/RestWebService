package fr.efrei.CarRental;

public class Rent {
	private String plateNumber;
	private String beginDate;
	private String endDate;
	
	public Rent () {
		super();
	}
	
	public Rent (String plateNumber, String beginDate, String endDate)
	{
		this.setplateNumber(plateNumber);
		this.setBeginDate(beginDate);
		this.setEndDate(endDate);
	}
	
	public String getplateNumber() {
		return plateNumber;
	}

	public void setplateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Rent [Car plateNumber=" + plateNumber + ", BeginDate=" + beginDate + ", EndDate=" + endDate +"]";
	}
}