
public class FacultyModel {
	
	int id;
	String ssn;
	String name;
	int age;
	String gender;
	String rank;
	String res_spec;
	
	public FacultyModel(int id, String ssn, String name, int age, String gender, String rank, String res_spec) {
		this.id = id;
		this.ssn = ssn;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.rank = rank;
		this.res_spec = res_spec;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getRes_spec() {
		return res_spec;
	}

	public void setRes_spec(String res_spec) {
		this.res_spec = res_spec;
	}
	

}
