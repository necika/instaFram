package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class ParametarProizvoda implements Serializable{
	private String name;
	private String vrednost;
	
	private ParametarProizvoda parent;
	private ArrayList<ParametarProizvoda> children = new ArrayList<ParametarProizvoda>();
	
	
	public ParametarProizvoda(ParametarProizvoda s) {
		this.name = s.name;
		this.vrednost = s.vrednost;
	}
	public ParametarProizvoda(String name,String vrednost) {
		this.name = name;
		this.vrednost = vrednost;
		
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		
		this.name = name;
	}



	public ParametarProizvoda getParent() {
		return parent;
	}



	public void setParent(ParametarProizvoda parent) {
		this.parent = parent;
	}
	
	
	public String getVrednost() {
		return vrednost;
	}





	public void setVrednost(String vrednost) {
		this.vrednost = vrednost;
	}





	public ArrayList<ParametarProizvoda> getChildren() {
		return children;
	}





	public void setChildren(ArrayList<ParametarProizvoda> children) {
		this.children = children;
	}
	public void addParametar(ParametarProizvoda p){
		children.add(p);
	}




	public String toString() {
		return this.name;
	}
	
	
}

