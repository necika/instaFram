package GUI;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class CellRenderer extends DefaultTreeCellRenderer{

	public CellRenderer() {
	}
	
	@Override
	public Component getTreeCellRendererComponent(JTree tree, Object value,
			boolean sel, boolean expanded, boolean leaf, int row,
			boolean hasFocus) {
		// TODO Auto-generated method stub
		 super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,
				row, hasFocus);
		 
		 DefaultMutableTreeNode n = (DefaultMutableTreeNode) value;
		 if(n.getPath().length == 1){
			 setIcon(new ImageIcon("Images11/rsz_images.jpg"));
			 tree.setCellRenderer(this);
		 }
		 else if(n.getPath().length == 2){
			 setIcon(new ImageIcon("Images11/rsz_11images.jpg"));
			 tree.setCellRenderer(this);
		 }
		 else if(n.getPath().length == 3){
			 setIcon(new ImageIcon("Images11/rsz_2images.jpg"));
			 tree.setCellRenderer(this);
		 }
		 else {
			 setIcon(new ImageIcon("Images11/rsz_1download.jpg"));
			 tree.setCellRenderer(this);
			 }
		 
		 return this;
	}
	
	
	
	
}
