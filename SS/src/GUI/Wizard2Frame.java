package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Model.Configurator;

public class Wizard2Frame extends JPanel{

	JLabel text;
	JButton odustani;
	JButton prethodni;
	JButton sledeci;
	
	
	
	public Wizard2Frame(Configurator c) {
		text = new JLabel();
		odustani = new JButton("Odustani");
		prethodni = new JButton("Prethodni");
		sledeci = new JButton("Sledeci");
		
		
		
		setLayout(new GridBagLayout());
		
		
		text.setText(c.getLicence());
		
		add(text, new GridBagConstraints(0, 0, 1, 1, 100, 100, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
    	add(odustani, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    	add(prethodni, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.SOUTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    	add(sledeci, new GridBagConstraints(2, 1, 1, 1, 0, 0, GridBagConstraints.SOUTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
	    
    	odustani.addActionListener(e -> System.exit(0));
    	prethodni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Wizard1Frame.getInstance().setPanelKojiSeMenja1();
				
			}
		});
    	
    	sledeci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Wizard1Frame.getInstance().setPanelKojiSeMenja3();
				
			}
		});
    	
	}
	public void initComponents() {
		odustani.setText(Wizard1Frame.getInstance().getBundle().getString("jezici.wizard2.exit"));
		prethodni.setText(Wizard1Frame.getInstance().getBundle().getString("jezici.wizard2.previous"));
		sledeci.setText(Wizard1Frame.getInstance().getBundle().getString("jezici.wizard2.next"));
	}
	
}
