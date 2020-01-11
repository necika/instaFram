package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Workspace implements Serializable{

	
	private ArrayList<SoftverskaKompanija> children;
	
	
	public Workspace() {
		children = new ArrayList<SoftverskaKompanija>();
	}
	public ArrayList<SoftverskaKompanija> getChildren(){
		return children;
	}
	public void setChildren(ArrayList<SoftverskaKompanija> children) {
		this.children = children;
	}
	public boolean addCompany(SoftverskaKompanija kompanija){
		return children.add(kompanija);
	}
	public boolean deleteCompany(SoftverskaKompanija kompanija){
		return children.remove(kompanija);
	}
	
	@Override
	public String toString() {
		return "Workspace";
	}
	
	
	
	
}
