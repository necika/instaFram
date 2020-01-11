package Model;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;





public class SoftverskaKompanija implements Serializable{
	private String companyName;
	private String city;
	private String sifra;
	
	private SoftverskaKompanija parent;
	private ArrayList<SoftverskiProizvod> children = new ArrayList<SoftverskiProizvod>();
	
	
	
	
	public SoftverskaKompanija(String companyName, String city, String sifra ) {
		setCompanyName(companyName);
		setCity(city);
		setSifra(sifra);
	}
	public SoftverskaKompanija(SoftverskaKompanija s){
		companyName = s.companyName;
		city = s.city;
		sifra = s.sifra;
	}
	
	
	public SoftverskaKompanija(String companyName,String City, String Sifra,SoftverskaKompanija parent) {
		this.companyName = companyName;
		this.sifra = Sifra;
		this.parent = parent;
		this.city = City;
	}

	public SoftverskaKompanija getParent() {
		return parent;
	}




	public void setParent(SoftverskaKompanija parent) {
		this.parent = parent;
	}




	public ArrayList<SoftverskiProizvod> getChildren() {
		return children;
	}




	public void setChildren(ArrayList<SoftverskiProizvod> children) {
		this.children = children;
	}

	
	
	


	public String getCity() {
		return city;
	}




	public void setCity(String City) {
		
		this.city = City;
	}




	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		
		this.companyName = companyName;
	}
	
	public String getSifra() {
		return sifra;
	}
	
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public void addProizvod(SoftverskiProizvod p){
		children.add(p);
	}
	
	public String toString() {
		return this.companyName;
	}
		
}