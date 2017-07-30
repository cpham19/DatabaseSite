
public class ProjectModel {
	
	int projectNum;
	String sponsorName;
	String startingDate;
	String endingDate;
	
	public ProjectModel(int projectNum, String sponsorName, String startingDate, String endingDate) {
		this.projectNum = projectNum;
		this.sponsorName = sponsorName;
		this.startingDate = startingDate;
		this.endingDate = endingDate;
	}


	public int getProjectNum() {
		return projectNum;
	}

	public void setProjectNum(int projectNum) {
		this.projectNum = projectNum;
	}

	public String getSponsorName() {
		return sponsorName;
	}

	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}

	public String getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}

	public String getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(String endingDate) {
		this.endingDate = endingDate;
	}
	
}
