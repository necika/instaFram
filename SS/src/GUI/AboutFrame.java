package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class AboutFrame extends JDialog{
	
	public AboutFrame() {
		
		
		setResizable(false);
		setModal(true);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
	    Dimension screenSize = kit.getScreenSize();
	    int screenHeight = screenSize.height;
	    int screenWidth = screenSize.width;
	    setSize(450, 500);

	    setIconImage(new ImageIcon("Images11/Logo1.jpg").getImage());
	    setTitle("About InstaFram");
	    setLocationRelativeTo(null);
	    
	    
		
		JTextArea Southtext = new JTextArea("O InstaFramu :\n\n"
   		+ " InstaFram je softverski alat koji donosi rešenja iz domena softverske \n"
   		+ " proizvodnje, i kao takav, on ima veliki broj vrlina, ali i mana.\n"
   		+ " Svrha ovog dokumenta je da što bolje predstavi kao i upozna zainteresovane\n"
   		+ " strane sa mogućnostima InstaFrama.\n"
   		+ " Zainteresovane strane su softverske kompanije koje žele da reše problem\n"
   		+ " instalacije na duži period.\n\n"
   		+ " Karakteristike InstaFrama: \n\n"
   		+ " 1. Domen problema: Instalacija softverskih proizvoda\n u različitim konfiguracijama i oblicima.\n"
		+ " 2. Dostupna instalacija na različitim platformama\n"
   		+ " 3. Dostupno help dugme kao pomoć pri korištenju\n\n");	
	
		Southtext.setPreferredSize(new Dimension(450,240));
		Southtext.setLineWrap(true);
		Southtext.setEditable(true); 
		
		JScrollPane scrollPaneText = new JScrollPane(Southtext, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scrollPaneText,BorderLayout.SOUTH);
	    
		
		
	    JPanel jpEast = new JPanel();
	    jpEast.setPreferredSize(new Dimension(250,265));
	    jpEast.setBackground(Color.white);
	    add(jpEast,BorderLayout.EAST);
	    jpEast.add(new JLabel(new ImageIcon("Images11/Logo1.jpg")),BorderLayout.EAST);
	   
	   
	
	   
	  
	   JTextArea WestNorthText = new JTextArea("O autoru:\n\n"
	   		+ "IME:\nNemanja Salipurevic\n\n"
	   		+ "ZANIMANJE :\nStudent\n\n"
	   		+ "FAKULTET :\nFakultet tehnickih nauka Novi Sad\n\n"
	   		+ "BROJ INDEKSA :\nRA227-2016\n\n"
			+ "DATUM I MESTO RODJENJA :\n11.3.1997.god, Milici\n\n");
	   		
	   WestNorthText.setPreferredSize(new Dimension(230,280));
	   //WestNorthText.setLineWrap(true);
	   WestNorthText.setEditable(false); 
	
	   
	   JScrollPane scrollPaneText1 = new JScrollPane(WestNorthText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	   add(scrollPaneText1);
	 
		
		
		
		
	   
	    
	  
	    
	    
	}
	

}
