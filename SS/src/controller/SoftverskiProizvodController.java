package controller;

import java.awt.Image;





import view.SoftverskiProizvodView;
import Model.SoftverskiProizvod;



public class SoftverskiProizvodController {

	private SoftverskiProizvod proizvod;
	private SoftverskiProizvodView proizvodView;
	
	
	public SoftverskiProizvodController(SoftverskiProizvod proizvod, SoftverskiProizvodView proizvodView) {
		setProizvod(proizvod);
		setProizvodView(proizvodView);
	}
	
	
	public String updateProizvod(String name, String verzija, Image photo,String oznaka) {
		if (name == null) {
			return "Unesite ime proizvoda";
		}
		name = name.trim();
		if (name.isEmpty()) {
			return "Unesite ime proizvoda";
		}

		if (verzija == null) {
			return "Unesite verziju proizvoda";
		}
		verzija = verzija.trim();
		if (verzija.isEmpty()) {
			return "Unesite verziju proizvoda";
		}
		if (oznaka == null) {
			return "Unesite oznaku proizvoda";
		}
		oznaka = oznaka.trim();
		if (oznaka.isEmpty()) {
			return "Unesite oznaku proizvoda";
		}
		

		proizvod.setName(name);
		proizvod.setVerzija(verzija);
		proizvod.setLogo(photo);
		proizvod.setOznaka(oznaka);
		

		proizvodView.refreshView();

		return "Model uspesno azuriran";
	}
	
	
	public SoftverskiProizvod getProizvod() {
		return proizvod;
	}

	private void setProizvod(SoftverskiProizvod proizvod) {
		if (proizvod == null) {
			throw new NullPointerException();
		}
		this.proizvod = proizvod;
	}

	public SoftverskiProizvodView getProizvodView() {
		return proizvodView;
	}

	private void setProizvodView(SoftverskiProizvodView proizvodView) {
		if (proizvodView == null) {
			throw new NullPointerException();
		}
		this.proizvodView = proizvodView;
	}
	
}
