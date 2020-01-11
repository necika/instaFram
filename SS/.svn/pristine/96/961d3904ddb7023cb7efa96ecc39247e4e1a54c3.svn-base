package Actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.tree.DefaultMutableTreeNode;

import view.ParametarProizvodaViewIzmeni;
import view.SoftverskaKompanijaView;
import view.SoftverskaKompanijaViewIzmeni;
import view.SoftverskiProizvodView;
import view.SoftverskiProizvodViewIzmeni;
import GUI.Frame;
import Model.ParametarProizvoda;
import Model.SoftverskaKompanija;
import Model.SoftverskiProizvod;
import Model.Workspace;

public class EditNodeAction extends AbstractAction { 
	
	private int a = 0;
	private SoftverskaKompanija sk = new SoftverskaKompanija("","", "");
	private SoftverskaKompanijaViewIzmeni skViewIzmeni = new SoftverskaKompanijaViewIzmeni(sk);
	
	public EditNodeAction(String ime){
		super(ime);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		DefaultMutableTreeNode selectonNode = (DefaultMutableTreeNode) Frame.getInstance().getTree().getLastSelectedPathComponent();
		
		
		
		  if (selectonNode.getUserObject() instanceof SoftverskaKompanija) {
			 
				Frame.getInstance().getPanelCenterSouth().removeAll();
				SoftverskaKompanija sk = (SoftverskaKompanija) selectonNode.getUserObject();
				SoftverskaKompanijaViewIzmeni skView = new SoftverskaKompanijaViewIzmeni(sk);
				Frame.getInstance().getPanelCenterSouth().add(skView);
				skView.revalidate();
				skView.repaint();	
				
				a = 1;
			}
		  else if(selectonNode.getUserObject() instanceof SoftverskiProizvod){
			  	Frame.getInstance().getPanelCenterSouth().removeAll();
				SoftverskiProizvod sp = (SoftverskiProizvod) selectonNode.getUserObject();
				SoftverskiProizvodViewIzmeni skView = new SoftverskiProizvodViewIzmeni(sp);
				Frame.getInstance().getPanelCenterSouth().add(skView);
				skView.revalidate();
				skView.repaint();
				
				a = 2;
		  }
		  else if(selectonNode.getUserObject() instanceof Workspace){
			  return;
		  }
		  
		  else {
			  Frame.getInstance().getPanelCenterSouth().removeAll();
				ParametarProizvoda pp = (ParametarProizvoda) selectonNode.getUserObject();
				ParametarProizvodaViewIzmeni ppView = new ParametarProizvodaViewIzmeni(pp);
				Frame.getInstance().getPanelCenterSouth().add(ppView);
				ppView.revalidate();
				ppView.repaint();
				
				a = 3;
		  }
			  
		
		
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}
	
	public void provera() {
		if(getA() == 1)
			skViewIzmeni.initComponents();
			
	}
	
	
	

	
	
	

}
