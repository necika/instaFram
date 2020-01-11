package controller;

import java.awt.Image;

import view.ParametarProizvodaView;
import Model.ParametarProizvoda;



public class ParametarProizvodaController {
	private ParametarProizvoda parametar;
	private ParametarProizvodaView parametarView;

	public ParametarProizvodaController(ParametarProizvoda parametar, ParametarProizvodaView parametarView) {
		setParametarProizvoda(parametar);
		setParametarProizvodaView(parametarView);
	}

	public String updateProizvod(String name,String vrednost) {
		if (name == null) {
			return "Unesite ime parametra";
		}
		name = name.trim();
		if (name.isEmpty()) {
			return "Unesite ime parametra";
		}

		if (vrednost == null) {
			return "Unesite vrednost parametra";
		}
		vrednost = vrednost.trim();
		if (vrednost.isEmpty()){
			return "Unesite vrednost parametra";
		}

		parametar.setName(name);
		parametar.setVrednost(vrednost);
		

		parametarView.refreshView();

		return "Model uspesno azuriran";
	}

	public ParametarProizvoda getStudent() {
		return parametar;
	}

	private void setParametarProizvoda(ParametarProizvoda parametar) {
		if (parametar == null) {
			throw new NullPointerException();
		}
		this.parametar = parametar;
	}

	public ParametarProizvodaView getParametarProizvodaView() {
		return parametarView;
	}

	private void setParametarProizvodaView(ParametarProizvodaView parametarView) {
		if (parametarView == null) {
			throw new NullPointerException();
		}
		this.parametarView = parametarView;
	}
}
