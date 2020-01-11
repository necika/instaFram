package view;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;






import javax.swing.SwingUtilities;









import controller.SoftverskaKompanijaController;
import Actions.AddNodeAction;
import GUI.Frame;
import Model.SoftverskaKompanija;



public class SoftverskaKompanijaView extends JPanel {

	private static final long serialVersionUID = 1884063759494311563L;
	
	private SoftverskaKompanija kompanija;
	private SoftverskaKompanija sk1;
	private SoftverskaKompanijaController kompanijaController;
	
	
	private JPanel pnlContent;
	private JLabel lblCompanyName;
	private JTextField tfCompanyName;
	private JLabel lblCity;
	private JTextField tfCity;
	private JLabel lblSifra;
	private JTextField tfSifra;
	private JLabel ime;
	private JLabel sifra;
	private JLabel grad;
	
	

	private JPanel pnlOK;
	private JButton btnOK;
	
	private JPanel pn1Cancel;
	private JButton btnCancel;

	public SoftverskaKompanijaView(SoftverskaKompanija kompanija) {
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

		lblCompanyName = new JLabel("Company name");
		tfCompanyName = new JTextField(20);
		//tfConpanyName.setText(c.getName);

		lblCity = new JLabel("		`	Company head office:");
		tfCity = new JTextField(20);

		lblSifra = new JLabel("Company id:");
		tfSifra = new JTextField(20);

		
		ime = new JLabel("Company name: ");
		

		pnlOK = new JPanel(new FlowLayout(FlowLayout.LEFT));
		btnOK = new JButton("OK");
		btnOK.setPreferredSize(new Dimension(60,35));
		btnOK.addActionListener(new ActionListener() {
		
		
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ok() == true){
					 sk1 = new SoftverskaKompanija(Frame.getInstance().getSk());
					AddNodeAction aNode = new AddNodeAction(sk1.getCompanyName(), sk1);
					aNode.actionPerformed(null);
					//Frame.getInstance().getLabel().setText(ime.getText()+" "+sk1.getCompanyName()+"        Company id:  "+sk1.getSifra()+"        Company head office:  "+sk1.getCity());
					//to u ovog gore c.setName(tfCompanyName.getText());
					//Frame.getInstance().getLabel().setText("Aktivan jezik je: "+ Locale.getDefault().getDisplayLanguage() );
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
			pnlContent.add(btnOK, new GridBagConstraints(1, 3, 1, 1, 1, 1, GridBagConstraints.NORTH,
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
			if (kompanijaController == null) {
				kompanijaController = new SoftverskaKompanijaController(kompanija, this);
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
			btnOK.setText(Frame.getInstance().getResourceBundle().getString("kompanija.btnOK"));
			lblCompanyName.setText(Frame.getInstance().getResourceBundle().getString("kompanija.name"));
			lblCity.setText(Frame.getInstance().getResourceBundle().getString("kompanija.city"));
			lblSifra.setText(Frame.getInstance().getResourceBundle().getString("kompanija.id"));
			//Frame.getInstance().getLabel().setText(Frame.getInstance().getResourceBundle().getString("statusbar.kompanija.ime")
				//	+sk1.getCompanyName()+"        "+Frame.getInstance().getResourceBundle().getString("kompanija.id")+sk1.getSifra()+
				//	"        "+Frame.getInstance().getResourceBundle().getString("kompanija.city")+sk1.getCity());
			
		}
		

}
