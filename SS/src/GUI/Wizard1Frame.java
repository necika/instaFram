package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;

import Actions.ConfiguratorFrameAction;
import Model.Configurator;
import Model.SoftverskiProizvod;

public class Wizard1Frame extends JFrame{
	
	public static Wizard1Frame instance = null;
	private Configurator c;
	private File f;
	private ObjectInputStream ois;
	private Wizard1 w1;
	private Wizard2Frame w2;
	private Wizard3Frame w3;
	JPanel panelKojiSeMenja;
	private Wizard4Frame w4;
	private ResourceBundle bundle;
	
	private MenuBarWizard mbw;
	
	
	
	public Wizard1Frame() {
		Locale.setDefault(new Locale("en","US"));
		bundle = ResourceBundle.getBundle("languages.jezici", Locale.getDefault());
		
		init();
	    
	   
	}



	public void setPanelKojiSeMenja1() {
		panelKojiSeMenja.removeAll();
		panelKojiSeMenja.add(w1);
		revalidate();
		repaint();
	}
	
	public void setPanelKojiSeMenja2() {
		panelKojiSeMenja.removeAll();
		panelKojiSeMenja.add(w2);
		revalidate();
		repaint();
	}
	public void setPanelKojiSeMenja3() {
		panelKojiSeMenja.removeAll();
		panelKojiSeMenja.add(w3);
		revalidate();
		repaint();
	}
	public void setPanelKojiSeMenja4() {
		panelKojiSeMenja.removeAll();
		panelKojiSeMenja.add(w4);
		revalidate();
		repaint();
	}

	public Configurator getC() {
		return c;
	}




	public void setC(Configurator c) {
		this.c = c;
	}
	
	public void init() {
		
		
		JMenuBar jmb = new JMenuBar();
		mbw = new MenuBarWizard();
		jmb.add(mbw);
		
		setJMenuBar(jmb);
		
		
		
		
		f = new File("Setup.txt");
		
		try {
			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			c = (Configurator)ois.readObject();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		w1 = new Wizard1(c);
		w3 = new Wizard3Frame(c);
		w4 = new Wizard4Frame();
		setResizable(false);
		//setModal(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon("Images11/Logo1.jpg").getImage());
		DefaultMutableTreeNode sel;
		sel = (DefaultMutableTreeNode) Frame.getInstance().getTree().getLastSelectedPathComponent();
		
		Toolkit kit = Toolkit.getDefaultToolkit();
	    Dimension screenSize = kit.getScreenSize();
	    int screenHeight = screenSize.height;
	    int screenWidth = screenSize.width;
	    setSize(450, 500);
	    setTitle(c.getNameProduct() +"   "+c.getVersion());
	    
	     panelKojiSeMenja = new JPanel();
	    
	   // panelKojiSeMenja.setPreferredSize(new Dimension(450,500));
	    //panelKojiSeMenja.add(w1);
	    w2 = new Wizard2Frame(c);
	    setPanelKojiSeMenja1();
	   // setPanelKojiSeMenja2();
	    add(panelKojiSeMenja);
	   // setPanelKojiSeMenja2();
	    
	}
	
	
	
	
	public static Wizard1Frame getInstance() {
		if(instance == null)
			instance = new Wizard1Frame();
		
		
		
		return instance;
	}
	public void changeLanguage(){
		bundle = ResourceBundle.getBundle("languages.jezici", Locale.getDefault());
		
		
		mbw.initComponents();
		w1.initComponents();
		w2.initComponents();
		w3.initiComponents();
		w4.initiComponents();
		
	}



	public ResourceBundle getBundle() {
		return bundle;
	}



	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}
	
	
}
