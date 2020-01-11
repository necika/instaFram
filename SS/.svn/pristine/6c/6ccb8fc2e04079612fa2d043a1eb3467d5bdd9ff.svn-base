package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Model.Configurator;

public class Wizard4Frame extends JPanel{

	private JLabel	labelKraj;
	private JButton kraj;
	
	
	public Wizard4Frame() {
		
		setLayout(new GridBagLayout());
		
		labelKraj = new JLabel("Uspesno ste instalirali program.");
		kraj = new JButton("Kraj");
		
		add(labelKraj, new GridBagConstraints(0, 0, 1, 1, 100, 100, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(kraj, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.SOUTH,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		
		kraj.addActionListener(e -> System.exit(0));
		
		
	}
	public void initiComponents(){
		labelKraj.setText(Wizard1Frame.getInstance().getBundle().getString("jezici.wizard4.labelKraj"));
		
		kraj.setText(Wizard1Frame.getInstance().getBundle().getString("jezici.wizard4.kraj"));
		
	}
	
}
