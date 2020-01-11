package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Model.Configurator;

public class Wizard1 extends JPanel{

	private JLabel text;
	private JButton odustani;
	private JButton sledece;
	
	
	public Wizard1(Configurator c) {
		
		text = new JLabel();
		
		odustani = new JButton("Odustani");
		sledece = new JButton("Sledece");
		

		JPanel glavni = new JPanel();
		
		setLayout(new GridBagLayout());
		
		text.setText(c.getWelcome());
		
		
		add(text, new GridBagConstraints(0, 0, 1, 1, 100, 100, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
    	add(odustani, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    	add(sledece, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.SOUTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		
    	sledece.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Wizard1Frame.getInstance().setPanelKojiSeMenja2();
				System.out.println(Wizard1Frame.getInstance().getC().getNameProduct());
				
			}
		});
		
		
		
		
	   	 
	}
	public void initComponents() {
		odustani.setText(Wizard1Frame.getInstance().getBundle().getString("jezici.wizard1.odustani"));
		sledece.setText(Wizard1Frame.getInstance().getBundle().getString("jezici.wizard1.sledeci"));
		
	}
	
}
