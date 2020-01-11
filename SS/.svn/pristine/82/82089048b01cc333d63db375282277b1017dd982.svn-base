package Actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import GUI.Frame;
import Model.SoftverskaKompanija;

public class ModifyNodeAction extends AbstractAction {
	Object novi;
	
	public ModifyNodeAction(String name, Object o) {
		super(name);
		this.novi = o;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		DefaultMutableTreeNode sel = (DefaultMutableTreeNode) Frame
				.getInstance().getTree().getLastSelectedPathComponent();
		
		if(sel != null) {
			Frame.getInstance().getModel().nodeChanged(sel);
		}
	}

}
