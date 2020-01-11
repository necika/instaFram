package view;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.ParametarProizvodaController;
import Actions.AddNodeAction;
import GUI.Frame;
import Model.ParametarProizvoda;
import Model.SoftverskiProizvod;


public class ParametarProizvodaView extends JPanel {

	private static final long serialVersionUID = 1884063759494311563L;

	private ParametarProizvoda parametar;
	private ParametarProizvodaController parametarController;

	
	private JPanel pnlContent;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblVrednost;
	private JTextField tfVrednost;
	

	private JPanel pnlOK;
	private JButton btnOK;

	public ParametarProizvodaView(ParametarProizvoda parametar) {
		initGUI();
		constructGUI();

		setParametarProizvoda(parametar);
	}

	private void initGUI() {
		setLayout(new BorderLayout());

		pnlContent = new JPanel(new GridBagLayout());
		pnlContent.setBackground(Color.WHITE);

		lblName = new JLabel("Parameter name:");
		tfName = new JTextField(20);

		lblVrednost = new JLabel("Parameter value:");
		tfVrednost = new JTextField(20);



		pnlOK = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(ok() == true){
					ParametarProizvoda sk1 = new ParametarProizvoda(Frame.getInstance().getPp());
					AddNodeAction aNode = new AddNodeAction(sk1.getName(), sk1);
					aNode.actionPerformed(null);
					//Frame.getInstance().getLabel().setText("Ime parametra proizvoda:  "+sk1.getName()+"        Vrednost parametra proizvoda:  "+sk1.getVrednost());
					//Frame.getInstance().getLabel().setText("Aktivan jezik je: "+ Locale.getDefault().getDisplayLanguage() );
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
		

		pnlOK.add(btnOK);
		pnlOK.setBackground(Color.WHITE);

		add(pnlContent, BorderLayout.CENTER);
		add(pnlOK, BorderLayout.SOUTH);

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
			parametarController = new ParametarProizvodaController(parametar, this);
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
	public void initComponents(){
		btnOK.setText(Frame.getInstance().getResourceBundle().getString("parametar.ok"));
		lblName.setText(Frame.getInstance().getResourceBundle().getString("parametar.name"));
		lblVrednost.setText(Frame.getInstance().getResourceBundle().getString("parametar.value"));
		
		
	}
	
}