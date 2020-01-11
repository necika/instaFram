package Actions;

import GUI.Frame;



import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class DeleteNodeAction extends AbstractAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6542745883328435119L;

	
	public DeleteNodeAction(){
		
	}
	public DeleteNodeAction(String ime){
		super(ime);
		putValue(SHORT_DESCRIPTION,"Delete currently node");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DefaultMutableTreeNode selectionNode = (DefaultMutableTreeNode) Frame.getInstance().getTree().getLastSelectedPathComponent();
		
		DefaultMutableTreeNode nodeParent = (DefaultMutableTreeNode) selectionNode.getParent();
		
		
		if (selectionNode != null && selectionNode.isRoot() == false) {
		
			Frame.getInstance().getTree().setSelectionPath (new TreePath(nodeParent.getPath()));
			Frame.getInstance().getModel().removeNodeFromParent(selectionNode);
		}
		
		
	}

}
