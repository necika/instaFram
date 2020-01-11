package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;

public class MenuBarWizard extends JMenuBar {
	private JMenu language;
	JRadioButtonMenuItem srpski;
	JRadioButtonMenuItem engleski;
	
	public MenuBarWizard(){
		
		language = new JMenu("Jezik");
		srpski = new JRadioButtonMenuItem("Srpski",true);
		
		
		srpski.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Locale.setDefault(new Locale("sr","RS"));
				

					Wizard1Frame.getInstance().changeLanguage();
				
				
			}
		});
		
		
		
		engleski = new JRadioButtonMenuItem("Engleski");
		engleski.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Locale.setDefault(new Locale("en","US"));
				Wizard1Frame.getInstance().changeLanguage();
				
				
			}
		});
		
		ButtonGroup bg1=new ButtonGroup();
		bg1.add(engleski);
		bg1.add(srpski);
		language.add(engleski);
		language.add(srpski);
		
		add(language);
	}
	public void initComponents(){
		language.setText(Wizard1Frame.getInstance().getBundle().getString("jezici.wizard1.language"));
		srpski.setText(Wizard1Frame.getInstance().getBundle().getString("jezici.frame.srpski"));
		engleski.setText(Wizard1Frame.getInstance().getBundle().getString("jezici.frame.engleski"));
		
	}
}
