package GUI;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Actions.AboutFrameAction;

public class MyMenuBar2 extends JMenuBar {
	
	JMenu help;
	JMenuItem about;
	AboutFrameAction aboutframe;
	
	
	public MyMenuBar2(){
		
		help=new JMenu("Help");
		
		aboutframe = new AboutFrameAction();
		about = new JMenuItem(aboutframe);
		
		add(help);
		add(about);
	}
	
	public void initComponents(){
		help.setText(Frame.getInstance().getResourceBundle().getString("help"));
		aboutframe.initAction();
		
	}

}
