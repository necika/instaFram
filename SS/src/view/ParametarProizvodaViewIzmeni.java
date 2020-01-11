package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Actions.AddNodeAction;
import Actions.ModifyNodeAction;
import GUI.Frame;
import Model.ParametarProizvoda;
import Model.SoftverskaKompanija;
import controller.ParametarProizvodaController;
import controller.SoftverskaKompanijaController;

public class ParametarProizvodaViewIzmeni extends JPanel{
	private static final long serialVersionUID = 1884063759494311563L;

	private ParametarProizvoda parametar;
	private ParametarProizvodaController parametarController;

	
	private JPanel pnlContent;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblVrednost;
	private JTextField tfVrednost;
	

	private JPanel pnlIzmeni;
	private JButton btnIzmeni;

	public ParametarProizvodaViewIzmeni(ParametarProizvoda parametar) {
		initGUI();
		constructGUI();

		setParametarProizvoda(parametar);
	}

	private void initGUI() {
		setLayout(new BorderLayout());

		pnlContent = new JPanel(new GridBagLayout());
		pnlContent.setBackground(Color.WHITE);

		lblName = new JLabel("Ime parametra:");
		tfName = new JTextField(20);

		lblVrednost = new JLabel("Vrednost Parametra:");
		tfVrednost = new JTextField(20);



		pnlIzmeni = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnIzmeni = new JButton("Izmeni");
		btnIzmeni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(ok() == true){
					
					ModifyNodeAction mNode = new ModifyNodeAction(parametar.getName(), parametar);
					mNode.actionPerformed(null);
					//Frame.getInstance().getLabel().setText("Ime parametra proizvoda:  "+parametar.getName()+"        Vrednost parametra proizvoda:  "+parametar.getVrednost());
				}
			}
		});
	}

	private void constructGUI() {
		pnlContent.add(lblName, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfName, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblVrednost, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfVrednost, new GridBagConstraints(1, 1, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		

		pnlIzmeni.add(btnIzmeni);
		pnlIzmeni.setBackground(Color.WHITE);
		

		add(pnlContent, BorderLayout.CENTER);
		add(pnlIzmeni, BorderLayout.SOUTH);

	}

	public ParametarProizvoda getParametarProizvoda() {
		return parametar;
	}

	
	
	
	public void setParametarProizvoda(ParametarProizvoda parametar) {
		this.parametar = parametar;

		// Prilikom podešavanja novog modela, potrebno je invalidirati postojeći
		// kontroler.
		parametarController = null;
		refreshView();
	}

	/**
	 * Osvežavanje prikaza na osnovu trenutnih podataka iz modela.
	 */
	public void refreshView() {
		tfName.setText(parametar.getName());
		tfVrednost.setText(parametar.getVrednost());
		
	
	}

	

	

	private boolean ok() {
		if (parametarController == null) {
			ParametarProizvodaView ppv = new ParametarProizvodaView(parametar);
			parametarController = new ParametarProizvodaController(parametar, ppv);
		}
		String name = tfName.getText();
		String vrednost = tfVrednost.getText();
		

		String message = parametarController.updateProizvod(name, vrednost);

		Window parent = SwingUtilities.getWindowAncestor(this);
		// Kako biste prikazali warning dijalog ako je ažuriranje modela prošlo
		// neuspešno?
		JOptionPane.showMessageDialog(parent, message);
		if(message == "Model uspesno azuriran")
			return true;
		else
			return false;
	}

}