package shopping.bean;

public class loginbean {
	private String uname;
	private String uemail;
	private String ucontact;
	private String upass;
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUcontact() {
		return ucontact;
	}
	public void setUcontact(String ucontact) {
		this.ucontact = ucontact;
	}
	@Override
	public String toString() {
		return "loginbean [ uname=" + uname + ", uemail=" + uemail + ", ucontact=" + ucontact
				+ ", upass=" + upass + ", getUpass()=" + getUpass()  + ", getUname()="
				+ getUname() + ", getUemail()=" + getUemail() + ", getUcontact()=" + getUcontact() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
