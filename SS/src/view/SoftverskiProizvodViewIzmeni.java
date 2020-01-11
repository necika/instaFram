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

import Actions.AddNodeAction;
import Actions.ModifyNodeAction;
import GUI.Frame;
import Model.SoftverskiProizvod;
import controller.SoftverskiProizvodController;

public class SoftverskiProizvodViewIzmeni extends JPanel{
private static final long serialVersionUID = 1884063759494311563L;
	
	
	private SoftverskiProizvod proizvod;
	private SoftverskiProizvodController proizvodController;

	
	private JPanel pnlContent;
	private JLabel lblName;
	private JTextField tfName;
	private JLabel lblVerzija;
	private JTextField tfVerzija;
	private JLabel lblOznaka;
	private JTextField tfOznaka;
	private JLabel lblLogo;
	private JButton btnUploadLogo;
	private JButton btnDeleteLogo;

	private JPanel pnlIzmeni;
	private JButton btnIzmeni;

	public SoftverskiProizvodViewIzmeni(SoftverskiProizvod proizvod) {
		initGUI();
		constructGUI();

		setProizvod(proizvod);
	}
	
	
	private void initGUI() {
		setLayout(new BorderLayout());

		pnlContent = new JPanel(new GridBagLayout());
		pnlContent.setBackground(Color.WHITE);

		lblName= new JLabel("Ime proizvoda:");
		tfName = new JTextField(20);

		lblVerzija = new JLabel("Verzija proizvoda:");
		tfVerzija = new JTextField(20);
		
		lblOznaka = new JLabel("Oznaka proizvoda:");
		tfOznaka = new JTextField(20);

		lblLogo = new JLabel();
		lblLogo.setPreferredSize(new Dimension(126,85));
		lblLogo.setBorder(BorderFactory.createLoweredBevelBorder());

		btnUploadLogo = new JButton("Postavi logo");
		btnUploadLogo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				uploadLogo();
			}
		});

		btnDeleteLogo = new JButton("Poništi logo");
		btnDeleteLogo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				deletePhoto();
			}
		});

		pnlIzmeni = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnIzmeni = new JButton("Izmeni");
		btnIzmeni.setBackground(Color.YELLOW);
		btnIzmeni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(ok() == true){
					
					ModifyNodeAction aNode = new ModifyNodeAction(proizvod.getName(), proizvod);
					aNode.actionPerformed(null);
					//Frame.getInstance().getLabel().setText("Ime proizvoda:  "+proizvod.getName()+"        Oznaka proizvoda:  "+proizvod.getOznaka()+"        Verzija proizvoda:  "+proizvod.getVerzija());
				}
			}
		});
	}
	
	private void constructGUI() {
		pnlContent.add(lblName, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfName, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblVerzija, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfVerzija, new GridBagConstraints(1, 1, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(lblOznaka, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(tfOznaka, new GridBagConstraints(1, 2, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		
		pnlContent.add(lblLogo, new GridBagConstraints(0, 3, 2, 1, 100, 100, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(15, 5, 5, 5), 0, 0));
		pnlContent.add(btnDeleteLogo, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		pnlContent.add(btnUploadLogo, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		

		pnlIzmeni.add(btnIzmeni);
		

		add(pnlContent, BorderLayout.CENTER);
		add(btnIzmeni, BorderLayout.SOUTH);

	}

	public SoftverskiProizvod getProizvod() {
		return proizvod;
	}
	
	public void setProizvod(SoftverskiProizvod proizvod) {
		this.proizvod = proizvod;

		// Prilikom podešavanja novog modela, potrebno je invalidirati postojeći
		// kontroler.
		proizvodController = null;
		refreshView();
	}
	
	public void refreshView() {
		tfName.setText(proizvod.getName());
		tfVerzija.setText(proizvod.getVerzija());
		tfOznaka.setText(proizvod.getOznaka());
		Icon icon = null;
		if (proizvod.getLogo() != null) {
			icon = new ImageIcon(proizvod.getLogo());
		}
		lblLogo.setIcon(icon);
	}
	
	//nisam siguran za 158, da li ide null?
	private void uploadLogo() {
		JFileChooser fc = new JFileChooser();
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			ImageIcon icon = new ImageIcon(fc.getSelectedFile().getAbsolutePath());
			lblLogo.setIcon(icon);
		}
	}

	private void deletePhoto() {
		lblLogo.setIcon(null);
	}
	private boolean ok() {
		if (proizvodController == null) {
			SoftverskiProizvodView spw = new SoftverskiProizvodView(proizvod);
			proizvodController = new SoftverskiProizvodController(proizvod, spw);
		}
		String name = tfName.getText();
		String verzija = tfVerzija.getText();
		String oznaka = tfOznaka.getText();
		Image logo = null;
		if (lblLogo.getIcon() != null) {
			logo = ((ImageIcon) lblLogo.getIcon()).getImage();
		}

		String message = proizvodController.updateProizvod(name,verzija,logo,oznaka);

		Window parent = SwingUtilities.getWindowAncestor(this);
		
		JOptionPane.showMessageDialog(parent, message);
		if(message == "Model uspesno azuriran")
			return true;
		else
			return false;
	}

}
