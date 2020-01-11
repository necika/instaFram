package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

public class LanguageFrame extends JDialog{
	
	private JRadioButtonMenuItem srpski;
	private JRadioButtonMenuItem engleski;
	
	private ResourceBundle bundle1;
	private JLabel jb1;
	private JButton button;
	
	public LanguageFrame() {
		
		setResizable(false);
		setModal(true);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
	    Dimension screenSize = kit.getScreenSize();
	    int screenHeight = screenSize.height;
	    int screenWidth = screenSize.width;
	    setSize(400, 200);

	    setIconImage(new ImageIcon("Images11/Logo1.jpg").getImage());
	    setTitle("Choose language");
	    setLocationRelativeTo(null);
	    
	    JPanel jp1 = new JPanel();
	    jp1.setPreferredSize(new Dimension(200,80));
	    add(jp1,BorderLayout.NORTH);
	
	    jb1 = new JLabel();
	    jb1.setText("Please choose your language: ");
	    jp1.add(jb1,BorderLayout.SOUTH);
	
	    srpski = new JRadioButtonMenuItem("Serbian");
		srpski.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Locale.setDefault(new Locale("sr","RS"));
				

					promeniJezik();
					Frame.getInstance().changeLanguage();
				
			}
		});
	 
		engleski = new JRadioButtonMenuItem("English");
		engleski.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Locale.setDefault(new Locale("en","US"));
				promeniJezik();
				Frame.getInstance().changeLanguage();
				
				
			}
		});
		
		ButtonGroup bg1=new ButtonGroup();
		bg1.add(engleski);
		bg1.add(srpski);
		
		JPanel jp2 = new JPanel();
		add(jp2);
		
		
		jp2.add(engleski,BorderLayout.CENTER);
		jp2.add(srpski,BorderLayout.NORTH);
	
		JPanel panelcic = new JPanel();
		panelcic.setPreferredSize(new Dimension(100,50));
		
		add(panelcic,BorderLayout.SOUTH);
		button = new JButton("Close");
		
		panelcic.add(button,BorderLayout.CENTER);
		button.addActionListener(e -> setVisible(false));
	}
	
	
	
	public void promeniJezik(){
		bundle1 = ResourceBundle.getBundle("languages.jezici", Locale.getDefault() );
		setTitle(getBundle1().getString("jezici.frame.naslov"));
		jb1.setText(getBundle1().getString("jezici.frame.label"));
		engleski.setText(getBundle1().getString("jezici.frame.engleski"));
		srpski.setText(getBundle1().getString("jezici.frame.srpski"));
		button.setText(getBundle1().getString("jezici.frame.button"));
		
	}

	public ResourceBundle getBundle1() {
		return bundle1;
	}

	public void setBundle1(ResourceBundle bundle1) {
		this.bundle1 = bundle1;
	}
	
	

}
