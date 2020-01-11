package Actions;





import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardEndHandler;

import GUI.AboutFrame;
import GUI.Frame;

public class AboutFrameAction extends AbstractAction {
	
	public AboutFrameAction () {
		
		putValue(NAME,"About");
		putValue(MNEMONIC_KEY,KeyEvent.VK_A);
		putValue(SHORT_DESCRIPTION,"Nesto o projektu InstaFram.");
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_MASK));
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Stisnuli ste dugme About.");
		AboutFrame Af = new AboutFrame();
		Af.setVisible(true);
	}

	public void initAction(){
		putValue(NAME, Frame.getInstance().getResourceBundle().getString("about"));
		putValue(MNEMONIC_KEY,Integer.parseInt(Frame.getInstance().getResourceBundle().getString("about.mnemonic")));
		putValue(ACCELERATOR_KEY,KeyStroke.getKeyStroke(Integer.parseInt(Frame.getInstance().getResourceBundle().getString("about.mnemonic")),KeyEvent.CTRL_MASK));
	}
}
