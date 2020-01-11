package Model;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;

public class SoftverskiProizvod implements Serializable{
	private String name;
	private String verzija;
	private Image logo;
	private String oznaka;
	
	private SoftverskiProizvod parent;
	private ArrayList<ParametarProizvoda> children = new ArrayList<ParametarProizvoda>();
	

	public SoftverskiProizvod(String name,String verzija,String oznaka ) {
		this.name = name;
		
		this.verzija = verzija;
		this.oznaka = oznaka;
	}
	public SoftverskiProizvod(SoftverskiProizvod s) {
		this.name = s.name;
		this.verzija = s.verzija;
		this.oznaka = s.oznaka;
	}
	public SoftverskiProizvod(String name, String verzija, Image logo,String oznaka ) {
		setName(name);
		setVerzija(verzija);
		setLogo(logo);
		setOznaka(oznaka);
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		
		this.name = name;
	}



	public SoftverskiProizvod getParent() {
		return parent;
	}



	public void setParent(SoftverskiProizvod parent) {
		this.parent = parent;
	}



	public ArrayList<ParametarProizvoda> getChildren() {
		return children;
	}



	public void setChildren(ArrayList<ParametarProizvoda> children) {
		this.children = children;
	}
	
	
	public String getVerzija() {
		return verzija;
	}



	public void setVerzija(String verzija) {
		this.verzija = verzija;
	}



	public Image getLogo() {
		return logo;
	}



	public void setLogo(Image logo) {
		this.logo = logo;
	}



	public String getOznaka() {
		return oznaka;
	}



	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}
	public void addParametar(ParametarProizvoda p){
		children.add(p);
	}


	public String toString() {
		return this.name;
	}
	
	
	
}
