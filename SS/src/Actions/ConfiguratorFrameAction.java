package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;
import javax.swing.tree.DefaultMutableTreeNode;

import GUI.ConfiguratorFrame;
import GUI.Frame;
import Model.Configurator;
import Model.ParametarProizvoda;
import Model.SoftverskaKompanija;
import Model.SoftverskiProizvod;
import Model.Workspace;

public class ConfiguratorFrameAction extends AbstractAction {

private ConfiguratorFrame cf;
	
public ConfiguratorFrameAction () {
		
		
		putValue(SHORT_DESCRIPTION,"Run configurator..");
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Stisnuto je dugme za pokretanje konfiguratora.");
		
		DefaultMutableTreeNode sel;
		sel = (DefaultMutableTreeNode) Frame.getInstance().getTree().getLastSelectedPathComponent();
		
		if(sel.getUserObject() instanceof SoftverskiProizvod){
			cf = new ConfiguratorFrame();
			
			cf.setVersion(((SoftverskiProizvod)sel.getUserObject()).getVerzija()); 
			cf.setVisible(true);
		}
	}

	public ConfiguratorFrame getCf() {
		return cf;
	}

	public void setCf(ConfiguratorFrame cf) {
		this.cf = cf;
	}
	

}
