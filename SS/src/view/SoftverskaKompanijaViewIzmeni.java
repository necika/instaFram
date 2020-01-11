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
import Actions.EditNodeAction;
import Actions.ModifyNodeAction;
import GUI.Frame;
import Model.SoftverskaKompanija;
import controller.SoftverskaKompanijaController;

public class SoftverskaKompanijaViewIzmeni extends JPanel{

	private static final long serialVersionUID = 1884063759494311563L;
	
	private SoftverskaKompanija kompanija;
	private SoftverskaKompanijaController kompanijaController;
	
	
	private JPanel pnlContent;
	private JLabel lblCompanyName;
	private JTextField tfCompanyName;
	private JLabel lblCity;
	private JTextField tfCity;
	private JLabel lblSifra;
	private JTextField tfSifra;
	
	

	private JPanel pnlIzmeni;
	private JButton btnIzmeni;
	
	

	public SoftverskaKompanijaViewIzmeni(SoftverskaKompanija kompanija) {
		initGUI();
		constructGUI();

		setSoftverskaKompanija(kompanija);
	}
	
	/*
	 * public void initGUI2(SoftverskaKompanija c){
	 * 		kopirati citav initGUI
	 * }
	 * */
	private void initGUI() {
		setLayout(new BorderLayout());

		pnlContent = new JPanel(new GridBagLayout());

		lblCompanyName = new JLabel("Company name:");
		tfCompanyName = new JTextField(20);
		//tfConpanyName.setText(c.getName);

		lblCity = new JLabel("    Company head office:");
		tfCity = new JTextField(20);

		lblSifra = new JLabel("Company id:");
		tfSifra = new JTextField(20);

		

		pnlIzmeni = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnIzmeni = new JButton("Modify");
		btnIzmeni.setPreferredSize(new Dimension(60,35));
		btnIzmeni.addActionListener(new ActionListener() {
		
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ok() == true){
					//SoftverskaKompanija sk1 = new SoftverskaKompanija(Frame.getInstance().getSk());
					ModifyNodeAction aNode = new ModifyNodeAction(kompanija.getCompanyName(), kompanija);
					aNode.actionPerformed(null);
					//Frame.getInstance().getLabel().setText("Ime kompanije:  "+kompanija.getCompanyName()+"        Sifra kompanije:  "+kompanija.getSifra()+"        Sediste kompanije:  "+kompanija.getCity());
					
				}
			}
		});
		
		
		
		
		
	}
		
		private void constructGUI() {
			pnlContent.add(lblCompanyName, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
			pnlContent.add(tfCompanyName, new GridBagConstraints(1, 0, 1, 1, 40, 0, GridBagConstraints.CENTER,
					GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
			pnlContent.add(lblCity, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
			pnlContent.add(tfCity, new GridBagConstraints(1, 1, 1, 1, 40, 0, GridBagConstraints.CENTER,
					GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
			pnlContent.add(lblSifra, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
					GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
			pnlContent.add(tfSifra, new GridBagConstraints(1, 2, 1, 1, 20, 0, GridBagConstraints.CENTER,
					GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
			pnlContent.add(btnIzmeni, new GridBagConstraints(1, 3, 1, 1, 1, 1, GridBagConstraints.NORTH,
					GridBagConstraints.NORTH, new Insets(5, 5, 5, 5), 0, 0));
			
			
			
			
			
			
			
			add(pnlContent);
			//add(btnOK, BorderLayout.SOUTH);
			//add(pn1Cancel,BorderLayout.SOUTH);
			pnlContent.setPreferredSize(new Dimension(500,412));
			pnlContent.setBackground(Color.WHITE);

		}
		
		public SoftverskaKompanija getSoftverskaKompanija() {
			return kompanija;
		}

		
		public void setSoftverskaKompanija(SoftverskaKompanija kompanija) {
			this.kompanija = kompanija;

			// Prilikom podešavanja novog modela, potrebno je onesposobiti postojeci
			// kontroler.
			kompanijaController = null;
			refreshView();
		}
		
		public void refreshView() {
			tfCompanyName.setText(kompanija.getCompanyName());
			tfCity.setText(kompanija.getCity());
			tfSifra.setText(kompanija.getSifra());
			
			
		}
	
		private boolean ok() {
			if(kompanijaController == null) {
				SoftverskaKompanijaView skv = new SoftverskaKompanijaView(kompanija);
				kompanijaController = new SoftverskaKompanijaController(kompanija, skv);
				 
				
			}
			String companyName = tfCompanyName.getText();
			String city = tfCity.getText();
			String sifra = tfSifra.getText();
			

			String message = kompanijaController.updateSoftverskaKompanija(companyName, city, sifra);

			Window parent = SwingUtilities.getWindowAncestor(this);
			// Kako biste prikazali warning dijalog ako je ažuriranje modela prošlo
			// neuspešno?
			JOptionPane.showMessageDialog(parent, message);
			
			if(message == "Model uspesno azuriran")
				return true;
			else
				return false;
		}
		public void initComponents(){
			btnIzmeni.setText(Frame.getInstance().getResourceBundle().getString("kompanijaIzmeni.izmeni"));
			lblCompanyName.setText(Frame.getInstance().getResourceBundle().getString("kompanijaIzmeni.name"));
			lblCity.setText(Frame.getInstance().getResourceBundle().getString("kompanijaIzmeni.city"));
			lblSifra.setText(Frame.getInstance().getResourceBundle().getString("kompanijaIzmeni.id"));
			
		}
}
