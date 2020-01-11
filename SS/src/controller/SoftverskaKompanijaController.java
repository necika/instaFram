package controller;










import view.SoftverskaKompanijaView;
import Model.SoftverskaKompanija;

public class SoftverskaKompanijaController {

	private SoftverskaKompanija kompanija;
	private SoftverskaKompanijaView kompanijaView;
	
	
	
	public SoftverskaKompanijaController(SoftverskaKompanija kompanija, SoftverskaKompanijaView kompanijaView) {
		setSoftverskaKompanija(kompanija);
		setSoftverskaKompanijaView(kompanijaView);
	}
	
	
	public String updateSoftverskaKompanija(String companyName, String city, String sifra) {
		if (companyName == null) {
			return "Unesite ime Softverske kompanije";
		}
		companyName = companyName.trim();
		if (companyName.isEmpty()) {
			return "Unesite ime Softverske kompanije";
		}

		
		if (city == null) {
			return "Unesite grad u kome je sediste Softverske kompanije";
		}
		city = city.trim();
		if (city.isEmpty()) {
			return "Unesite grad u kome je sediste Softverske kompanije";
		}
		
		
		if (sifra == null) {
			return "Unesite sifru Softverske kompanije";
		}
		sifra = sifra.trim();
		if (sifra.isEmpty()) {
			return "Unesite sifru Softverske kompanije";
		}
		

		kompanija.setCompanyName(companyName);
		kompanija.setCity(city);
		kompanija.setSifra(sifra);

		kompanijaView.refreshView();

		return "Model uspesno azuriran";
	}
	
	
	public SoftverskaKompanija getSoftverskaKompanija() {
		return kompanija;
	}

	private void setSoftverskaKompanija(SoftverskaKompanija kompanija) {
		if (kompanija == null) {
			throw new NullPointerException();
		}
		this.kompanija = kompanija;
	}

	public SoftverskaKompanijaView getSoftverskaKompanijaView() {
		return kompanijaView;
	}

	private void setSoftverskaKompanijaView(SoftverskaKompanijaView kompanijaView) {
		if (kompanijaView == null) {
			throw new NullPointerException();
		}
		this.kompanijaView = kompanijaView;
	}
	
	
	
}
