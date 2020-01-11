package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;




import Actions.ConfiguratorFrameAction;


import Model.Configurator;
import Model.ParametarProizvoda;
import Model.SoftverskaKompanija;
import Model.SoftverskiProizvod;
import Model.Workspace;

public class MyToolBar extends JToolBar {
	
	private ConfiguratorFrameAction cfa;
	private OpenTree openTree = new OpenTree();
	private OutputStream os;
	
	private String s;
	private DefaultTreeModel treeModel;
	private File f;
	private ObjectOutputStream oos;
	private ObjectInputStream  ois;
	private JButton buttonOpen;
	private JToggleButton tglBtnBold;
	private JButton Buttonsave;
	
	public MyToolBar(){
		
		super(SwingConstants.HORIZONTAL);
		
		f = new File("save.txt");
	
		JButton buttonNew = new JButton();
		//buttonNew.setToolTipText("New");
		buttonNew.setIcon(new ImageIcon("Images11/new.jpg"));
		
		//add(buttonNew);

		//addSeparator();

		
		 buttonOpen = new JButton();
		buttonOpen.setToolTipText("Open tree");
		//samo skini sliku i promeni ovu..
		buttonOpen.setIcon(new ImageIcon("Images11/open.png"));
		add(buttonOpen);
		buttonOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(f.exists() == true){
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
						Frame.getInstance().setListakompanija((Workspace)ois.readObject());
					} catch (ClassNotFoundException | IOException e1) {
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
					if(Frame.getInstance().getListakompanija() != null) {
						for(SoftverskaKompanija sk : Frame.getInstance().getListakompanija().getChildren()){
							DefaultMutableTreeNode node = new DefaultMutableTreeNode("");
							node.setUserObject(sk);
							Frame.getInstance().getTreeModel().insertNodeInto(node, Frame.getInstance().getRoot(),Frame.getInstance().getRoot().getChildCount());
							for(SoftverskiProizvod sp : sk.getChildren()){
								DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("");
								node2.setUserObject(sp);
								Frame.getInstance().getTreeModel().insertNodeInto(node2, node,node.getChildCount());
								for(ParametarProizvoda pp : sp.getChildren()){
									DefaultMutableTreeNode node3 = new DefaultMutableTreeNode("");
									node3.setUserObject(pp);
									Frame.getInstance().getTreeModel().insertNodeInto(node3, node2,node2.getChildCount());
									for(ParametarProizvoda pp1 : sp.getChildren()){
										addNewParameter(pp1,node3);
									}
								}
							}
							
						}
					}
					

					
				}
			}
		});
				
		
		
		
	
		addSeparator();
		
		
		tglBtnBold=new JToggleButton();
		tglBtnBold.setToolTipText("Save tree");
		tglBtnBold.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				try {
					oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				try {
					oos.writeObject(Frame.getInstance().getListakompanija());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						oos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				
				
			}
		});
		
		//ubaci sliku samo i promeni ovu..
		tglBtnBold.setIcon(new ImageIcon("Images11/save.jpg"));
		add(tglBtnBold);
		
		addSeparator();
		
		JButton ButtonItalic=new JButton();
		ButtonItalic.setToolTipText("Save As");
		//ubaci sliku samo drugu
		ButtonItalic.setIcon(new ImageIcon("Images11/save_ass.jpg"));
		//add(ButtonItalic);
		
		//addSeparator();
		
		
		cfa = new ConfiguratorFrameAction();
		 Buttonsave=new JButton(cfa);
		Buttonsave.setToolTipText("Run configurator");
		//ubaci sliku samo drugu
		Buttonsave.setIcon(new ImageIcon("Images11/run1.png"));
		add(Buttonsave);
		
		
		addSeparator();
		
		JButton Buttonrun=new JButton();
		Buttonrun.setToolTipText("Print");
		//ubaci sliku samo drugu
		Buttonrun.setIcon(new ImageIcon("Images11/print1.png"));
		//add(Buttonrun);
		
		//addSeparator();

		//toolbar mi je ovde nepokretljiv
		setFloatable(false);
		setBackground(new Color(255,255,204));

	
}
	public void addNewParameter(ParametarProizvoda param,DefaultMutableTreeNode node){
		DefaultMutableTreeNode df = new DefaultMutableTreeNode();
		df.setUserObject(param);
		Frame.getInstance().getTreeModel().insertNodeInto(df,node, node.getChildCount());
		
		if(param.getChildren() != null){
			for(ParametarProizvoda parametar : param.getChildren())
				addNewParameter(parametar,df);
		}
		
	}
	public void initiComponents(){
		buttonOpen.setToolTipText(Frame.getInstance().getResourceBundle().getString("toolbar.open"));
		tglBtnBold.setToolTipText(Frame.getInstance().getResourceBundle().getString("toolbar.save"));
		Buttonsave.setToolTipText(Frame.getInstance().getResourceBundle().getString("toolbar.run"));

	}
	
}
