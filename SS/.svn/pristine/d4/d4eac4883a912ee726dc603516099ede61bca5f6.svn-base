package GUI;







import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.tree.DefaultMutableTreeNode;

import Actions.AboutFrameAction;
import Actions.DeleteNodeAction;
import Actions.EditNodeAction;
import Actions.SearchNodeAction;
import Model.ParametarProizvoda;
import Model.SoftverskaKompanija;
import Model.SoftverskiProizvod;
import Model.Workspace;


public class MyMenuBar extends JMenuBar {
	private JMenu file; 
	private JMenu language;
	JRadioButtonMenuItem srpski;
	JRadioButtonMenuItem engleski;
	JMenuItem jm1;
	JMenuItem jm5;
	JMenuItem jm3;
	JMenuItem jm2;
	
	public MyMenuBar(){
		Font a = new Font ("Andalus", Font.BOLD, 12);
		Font b = new Font ("Arabic",Font.PLAIN,12);
		Color crvena = new Color(204,51,0); 

		
		file = new JMenu("Node");
	
		//JMenu file = new JMenu("Node");
		language = new JMenu("Language");
		
		
		
		
		srpski = new JRadioButtonMenuItem("Serbian");
		srpski.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Locale.setDefault(new Locale("sr","RS"));
				

					Frame.getInstance().changeLanguage();
				
				
			}
		});
		
		
		
		engleski = new JRadioButtonMenuItem("English");
		engleski.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Locale.setDefault(new Locale("en","US"));
				Frame.getInstance().changeLanguage();
				
				
			}
		});
		
		ButtonGroup bg1=new ButtonGroup();
		bg1.add(engleski);
		bg1.add(srpski);
		language.add(engleski);
		language.add(srpski);
		
		
		
		add(file);
		
		
		
		
		jm1 = new JMenuItem(new EditNodeAction("Edit node"));
		
		
		file.add(jm1);
		jm1.setFont(a);
		jm1.setForeground(crvena);
		file.addSeparator();
		
		//jm1.setForeground(Color.red);
		

		

		
		
		
		
		jm2 = new JMenuItem(new DeleteNodeAction("Delete node"));
		
		
		
		file.add(jm2);
		jm2.setForeground(crvena);
		jm2.setFont(a);
		file.addSeparator();
		
		
		
		
		
		
		
		jm3 = new JMenuItem(new SearchNodeAction("Search node"));
		file.add(jm3);
		jm3.setFont(a);
		jm3.setForeground(crvena);
		file.addSeparator();
		
		
		
		
		
		jm5 = new JMenuItem("Exit");
		file.add(jm5);
		jm5.setForeground(crvena);
		jm5.setFont(a);
		
		jm5.addActionListener(e -> System.exit(0)); //izlazak na dugme exit
		
		
		
		
		add(language);
		
		
		
		
		
	}
	

	public void initComponents(){
		file.setText(Frame.getInstance().getResourceBundle().getString("node"));
		language.setText(Frame.getInstance().getResourceBundle().getString("language"));
		srpski.setText(Frame.getInstance().getResourceBundle().getString("srpski"));
		engleski.setText(Frame.getInstance().getResourceBundle().getString("engleski"));
		jm5.setText(Frame.getInstance().getResourceBundle().getString("node.exit"));
		jm1.setText(Frame.getInstance().getResourceBundle().getString("node.edit"));
		jm3.setText(Frame.getInstance().getResourceBundle().getString("node.search"));
		jm2.setText(Frame.getInstance().getResourceBundle().getString("node.delete"));
		
	}

}
