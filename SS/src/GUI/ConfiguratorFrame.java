package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
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
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.sound.midi.Patch;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import Model.Configurator;
import Model.ParametarProizvoda;
import Model.SoftverskaKompanija;
import Model.SoftverskiProizvod;
import Model.Workspace;

public class ConfiguratorFrame extends JDialog{
	
	private JLabel labelZip;
	private JLabel labelWelcome;
	private JLabel labelVersion;
	private JLabel labelLicence;
	
	private JTextField tfZip;
	private JTextField tfWelcome;

	private JTextArea tfLicence;
	private JFileChooser fc;
	private JTree treeConf;
	
	private JTextField tfVersion ;
	private ObjectOutputStream oos;
	private FileInputStream ois;
	private File file;
	private Properties prop;
	private Configurator c;
	private ObjectOutputStream os;
	private FileInputStream fis;
	private byte[] upisBajtova;
	
	public void setVersion(String pro){
		tfVersion.setText(pro);
	}
	
	public ConfiguratorFrame(){
		
		
		c = new Configurator();
		
		setLayout(new BorderLayout());
		
		setResizable(false);
		setModal(true);
	
		Toolkit kit = Toolkit.getDefaultToolkit();
    	Dimension screenSize = kit.getScreenSize();
    	int screenHeight = screenSize.height;
    	int screenWidth = screenSize.width;
    	setSize(500, 400);

    	setIconImage(new ImageIcon("Images11/Logo1.jpg").getImage());
    	setTitle("InstaFram configurator");
    	setLocationRelativeTo(null);
    
    
    	
    
    	
    	JPanel leviPanel = new JPanel();
    	leviPanel.setPreferredSize(new Dimension(150,400));
    	
    	
    	JScrollPane scrollPane = new JScrollPane(leviPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    	add(scrollPane,BorderLayout.WEST);
    	
    	
    	JPanel desniPanel = new JPanel(new GridBagLayout());
    	
    	desniPanel.setPreferredSize(new Dimension(330,300));
    	
    	JPanel desniPanel2 = new JPanel();
    	
    	desniPanel2.setPreferredSize(new Dimension(330,400));
    	
    	desniPanel2.add(desniPanel,BorderLayout.NORTH);
    	
    	
    	
    	labelZip = new JLabel("Izvor(.zip): ");
    	labelWelcome = new JLabel("Welcome text: ");
    	labelLicence = new JLabel("Licence: ");
    	labelVersion = new JLabel("Version");
    	tfZip = new JTextField(100);
    	
    	tfLicence = new JTextArea();
    	tfVersion = new JTextField(20);
    	tfWelcome = new JTextField(100);
    	DefaultTreeModel treeModelConf = new DefaultTreeModel(Frame.getInstance().getProduct());

    	
    	JButton butoncic = new JButton("Browse");
		butoncic.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				insertFile();
			}
		});
    	JButton export = new JButton("Export");
    	JButton cancel = new JButton("Cancel");
    	
    	cancel.addActionListener(e -> setVisible(false));
    	export.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					extractFile();
					
					
				//	Configurator c1 = new Configurator();
					c.setLicence(tfLicence.getText());
					//c.setWelcome(tfWelcome.getText());
					c.setVersion(tfVersion.getText());
					c.setProp(prop);
					c.setWelcome(tfWelcome.getText());
					c.setBytes(upisBajtova);
					
					SoftverskiProizvod sp = (SoftverskiProizvod) Frame.getInstance().getProduct().getUserObject();
					c.setNameProduct(sp.getName());
					
					makeSetup();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
    	
    	
    	desniPanel.add(labelZip, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    	desniPanel.add(tfZip, new GridBagConstraints(0, 1, 1, 1, 30, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
    	desniPanel.add(labelWelcome, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    	desniPanel.add(tfWelcome, new GridBagConstraints(0, 3, 1, 1, 30, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
    	desniPanel.add(labelLicence, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    	desniPanel.add(tfLicence, new GridBagConstraints(0, 5, 1, 1, 30, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
    	desniPanel.add(labelVersion, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    	desniPanel.add(tfVersion, new GridBagConstraints(0, 7, 1, 1, 30, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
    	desniPanel.add(butoncic, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    	
    	
    	
    	
    	
    JPanel exportPanel = new JPanel();	
    exportPanel.add(export);
    
	add(desniPanel2,BorderLayout.EAST);
	desniPanel2.add(exportPanel,BorderLayout.SOUTH);
	desniPanel2.add(cancel,BorderLayout.SOUTH);
	
	
	
	
	
	if(Frame.getInstance().getSelectonNode().getUserObject() instanceof SoftverskiProizvod){
		treeConf = new JTree(treeModelConf);
    	leviPanel.add(treeConf);
    	/*if(treeModelConf.getRoot() instanceof SoftverskiProizvod){
    		setVersion(((SoftverskiProizvod)treeModelConf.getRoot()).getVerzija());
    	}*/
    	treeConf.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
	}
	else{
		DefaultTreeModel treeModelConf1 = new DefaultTreeModel(null);
		JTree treeConf1 = new JTree(treeModelConf1);
		//setVersion(Frame.getInstance()());
		leviPanel.add(treeConf1);
		
	}
	}
	private void insertFile(){
		 fc = new JFileChooser();
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			fc.showSaveDialog(null);
			tfZip.setText(fc.getSelectedFile().getAbsolutePath());
		}
	}
	private void extractFile(){
		DefaultMutableTreeNode sNode = (DefaultMutableTreeNode) treeConf.getLastSelectedPathComponent();
		if(sNode == null){
			System.out.println("Molimo vas oznacite neki parametar");
			return;
			
		}
		
		 prop = new Properties();
		TreePath[] ss = treeConf.getSelectionPaths();
		try {
		for(int i = 0;i < ss.length;i++){
			treeConf.getSelectionPath().getLastPathComponent();
			DefaultMutableTreeNode ll = new DefaultMutableTreeNode();
			ll = (DefaultMutableTreeNode) ss[i].getLastPathComponent();
			ll.getUserObject();
			ParametarProizvoda pp = new ParametarProizvoda("","");
			pp = (ParametarProizvoda) ll.getUserObject();
			prop.put(pp.getName(),pp.getVrednost());
			
		}
		
		file = new File("properties.ini");
		FileOutputStream fileOut = new FileOutputStream(file);
		prop.store(fileOut, null);
		fileOut.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}

	public String getTfVersion() {
		return tfVersion.getText();
	}
	
	private void makeSetup()  {
		
		
		File fajl = new File("Setup.txt");
		try {
			os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fajl)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		File fajlZip = new File(tfZip.getText());
		
		try {
			 fis = new FileInputStream(fajlZip);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<Byte> bytes = new ArrayList<Byte>();
		
		byte [] nizBajtova = new byte[16];
		
		int read = 0;
		
		try {
			while((read = fis.read(nizBajtova)) != -1) {
				for(int i = 0; i < read; i++) {
					bytes.add(nizBajtova[i]);
				}
			}
			
			upisBajtova = new byte[bytes.size()];
			for (int i = 0; i < bytes.size(); i++) {
				upisBajtova[i] = bytes.get(i);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		c.setBytes(upisBajtova);
		
		try {
			os.writeObject(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
	}
	
	
	
	
	
}
