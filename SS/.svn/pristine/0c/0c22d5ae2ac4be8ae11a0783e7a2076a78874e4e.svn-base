package Actions;


import GUI.Frame;





import java.awt.event.ActionEvent;
import java.util.Enumeration;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class SearchNodeAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3898869595366375887L;


	public SearchNodeAction(String ime){
		super(ime);
		putValue(SHORT_DESCRIPTION,"Search node");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Izbacuje novo textfield polje za unos 
		String string1 = JOptionPane.showInputDialog(Frame.getInstance(), "");
		if (string1 == null) {
			return;
		}
		
		
		
				// Prolazak kroz stablo
				
		DefaultTreeModel model = Frame.getInstance().getModel();
		@SuppressWarnings("unchecked")
		Enumeration<DefaultMutableTreeNode> en = ((DefaultMutableTreeNode) model
				.getRoot()).breadthFirstEnumeration(); //// breadthFirstEnumeration oznacava iteraciju
		
		boolean foundNode = false;
		while (en.hasMoreElements()) {
			DefaultMutableTreeNode trenutni = en.nextElement();
			if (trenutni.getUserObject().toString().equalsIgnoreCase(string1)) {
				// Ako ga nadjemo, selektuj ga.
				Frame.getInstance().getTree()
						.setSelectionPath(new TreePath(trenutni.getPath()));
				Frame.getInstance().getTree()
						.scrollPathToVisible(new TreePath(trenutni.getPath()));
				foundNode = true;
				break;
			}
		}

		if (!foundNode) {
			JOptionPane.showMessageDialog(Frame.getInstance(),
					"Node sa imenom "+"'"+string1+"'"+" ne postoji.", "", JOptionPane.WARNING_MESSAGE);

		}
		
	}

}
