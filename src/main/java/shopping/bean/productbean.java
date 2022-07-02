package shopping.bean;

import java.sql.Blob;

public class productbean {
	private String proname;
	private String prodesc;
	private String pphoto;
	private int catid;
	private Blob file;
	public Blob getFile() {
		return file;
	}
	public void setFile(Blob file) {
		this.file = file;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getPphoto() {
		return pphoto;
	}
	public void setPphoto(String pphoto) {
		this.pphoto = pphoto;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getProdesc() {
		return prodesc;
	}
	public void setProdesc(String prodesc) {
		this.prodesc = prodesc;
	}
	public int getProprice() {
		return proprice;
	}
	public void setProprice(int proprice) {
		this.proprice = proprice;
	}
	public int getProquantity() {
		return proquantity;
	}
	public void setProquantity(int proquantity) {
		this.proquantity = proquantity;
	}
	private int proprice;
	private int proquantity;
}
