package Actions;



import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import view.ParametarProizvodaView;
import view.SoftverskaKompanijaView;
import GUI.Frame;
import Model.ParametarProizvoda;
import Model.SoftverskaKompanija;
import Model.SoftverskiProizvod;
import Model.Workspace;



public class AddNodeAction extends AbstractAction  {

	private Object o;

	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = -5299870960205906449L;
	


	public AddNodeAction (String ime,Object novi){
		
		super(ime);
		this.o = novi;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		
		DefaultMutableTreeNode selectionNode = (DefaultMutableTreeNode) Frame.getInstance().getTree().getLastSelectedPathComponent();
		
		if(selectionNode != null){
			
			DefaultMutableTreeNode node = new DefaultMutableTreeNode();
				
				if(selectionNode.getUserObject() instanceof SoftverskaKompanija){
					node.setUserObject((SoftverskiProizvod) o);
					
					SoftverskaKompanija nadredjeni = (SoftverskaKompanija) selectionNode.getUserObject();
					SoftverskiProizvod sk = new SoftverskiProizvod ((SoftverskiProizvod) o);
					
					
					nadredjeni.addProizvod(sk);
					node.setUserObject(sk);
					
					
				
				Frame.getInstance().getModel().insertNodeInto(node, selectionNode, selectionNode.getChildCount());
				Frame.getInstance().getTree().setSelectionPath(new TreePath(node.getPath()));
				Frame.getInstance().getTree().scrollPathToVisible(new TreePath(node.getPath()));
				}
				else if(selectionNode.getUserObject() instanceof SoftverskiProizvod){
					node.setUserObject((ParametarProizvoda) o);
					
					SoftverskiProizvod nadredjeni = (SoftverskiProizvod) selectionNode.getUserObject();
					ParametarProizvoda sk =new ParametarProizvoda ((ParametarProizvoda) o);
					
					nadredjeni.addParametar(sk);
					node.setUserObject(sk);
					
					
				
				Frame.getInstance().getModel().insertNodeInto(node, selectionNode, selectionNode.getChildCount());
				Frame.getInstance().getTree().setSelectionPath(new TreePath(node.getPath()));
				Frame.getInstance().getTree().scrollPathToVisible(new TreePath(node.getPath()));
				}
				else if(selectionNode.getUserObject() instanceof ParametarProizvoda){
					node.setUserObject((ParametarProizvoda) o);
					
					ParametarProizvoda nadredjeni = (ParametarProizvoda) selectionNode.getUserObject();
					ParametarProizvoda pp = new ParametarProizvoda((ParametarProizvoda) o);
					
					nadredjeni.addParametar(pp);
					node.setUserObject(pp);
					
					
					Frame.getInstance().getModel().insertNodeInto(node, selectionNode, selectionNode.getChildCount());
					Frame.getInstance().getTree().setSelectionPath(new TreePath(node.getPath()));
					Frame.getInstance().getTree().scrollPathToVisible(new TreePath(node.getPath()));
				}
				else if(selectionNode.getUserObject() instanceof Workspace){
						
						node.setUserObject((SoftverskaKompanija) o);
						
						Workspace nadredjeni = (Workspace) selectionNode.getUserObject();
						SoftverskaKompanija sk =new SoftverskaKompanija ((SoftverskaKompanija) o);
						
						nadredjeni.addCompany(sk);
						node.setUserObject(sk);
						
						
						
					
					Frame.getInstance().getModel().insertNodeInto(node, selectionNode, selectionNode.getChildCount());
					Frame.getInstance().getTree().setSelectionPath(new TreePath(node.getPath()));
					Frame.getInstance().getTree().scrollPathToVisible(new TreePath(node.getPath()));
				}
				
			
		
			
		}
		
		
	}
	

}