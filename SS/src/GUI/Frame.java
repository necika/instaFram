package GUI;





import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.Timer;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import Actions.AddNodeAction;
import Actions.DeleteNodeAction;
import Actions.EditNodeAction;
import Actions.SearchNodeAction;
import Model.ParametarProizvoda;
import Model.SoftverskaKompanija;
import Model.SoftverskiProizvod;
import Model.Workspace;
import view.ParametarProizvodaView;
import view.SoftverskaKompanijaView;
import view.SoftverskaKompanijaViewIzmeni;
import view.SoftverskiProizvodView;
@SuppressWarnings("serial")
public class Frame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1203725186300525380L;
	private static Frame instance = null;
	private JTree tree;
	private DefaultTreeModel treeModel;
	private Workspace listakompanija = new Workspace();
	private SoftverskaKompanija sk;
	private SoftverskiProizvod sp;
	private ParametarProizvoda pp;
	private String imeStatusBara;
	private SoftverskaKompanijaView skView;
	private SoftverskiProizvodView spView;
	private ParametarProizvodaView ppView;
	private SoftverskaKompanijaViewIzmeni skViewIzmeni;
	private ResourceBundle bundle;
	private JPanel panelleft;
	private MyMenuBar menu;
	private MyMenuBar2 menu2;
	private JButton buttonDelete;
	private JButton buttonEdit;
	private JButton buttonSearch;
	private String a;
	private String stisnutoEdit;
	private EditNodeAction edit;
	private JLabel autor;
	private JLabel jezik;
	private JLabel datum;
	private String datum1;
	private JLabel labeldatum;
	private String trenutnoVreme;
	private DefaultMutableTreeNode root;
	private DefaultMutableTreeNode  product = new DefaultMutableTreeNode();
	private LanguageFrame languageFrame = new LanguageFrame();
	private DefaultMutableTreeNode selectonNode;
	private JTextField tfVersion = new JTextField(20);
	private JTextField tfWelcome = new JTextField(100);
	private MyToolBar toolbar1;
	
	private JLabel label;

	private JPanel panelCenterSouth;
	
	private Frame(){
		Locale.setDefault(new Locale("en","US"));
		bundle = ResourceBundle.getBundle("languages.jezici", Locale.getDefault());
		
		
		initialise();
		
		//SaveTree sTree = new SaveTree();
	}

	private void initialise(){
		Color plava = new Color(255,255,204); 
		
		Color plava1 = new Color(153,153,153); 
		
		
		
		
		sk = new SoftverskaKompanija("","","");
		sp = new SoftverskiProizvod("", "", null, "");
		pp = new ParametarProizvoda("", "");
		edit = new EditNodeAction("");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setTitle("InstaFram");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
	
	    setIconImage(new ImageIcon("Images11/Logo1.jpg").getImage());

	    
	    JMenuBar jmb = new JMenuBar();
	    JPanel jp = new JPanel();
	   
	 
	       
	  
	    
	    JButton jmbCenter = new JButton();
        menu =  new MyMenuBar();
        menu2 = new MyMenuBar2();
        
        
        
        
        
        jmb.add(menu);
       
        
        
        jmb.add(menu2);
       
       
        
        
        setJMenuBar(jmb);
        
        
        
         toolbar1=new MyToolBar();
        //dodajemo u Frame naš Toolbar, klasa BorderLayout se odnosi na rad sa prostorim rasporedom
        
        add(toolbar1, BorderLayout.NORTH);
        toolbar1.setBackground(plava);
        
        
        
        
        panelleft=new JPanel(new BorderLayout());
        panelleft.setPreferredSize(new Dimension(140,100));
        
     
        
        //IMPLEMENTIRANJE STABLA -------------------------
        
        
      
        
         initTree();
         DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
         tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				  selectonNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
					
				  if(selectonNode == null)
					  return;
				  
				  if (selectonNode.getUserObject() instanceof SoftverskaKompanija) {
					 
						panelCenterSouth.removeAll();
						sp = new SoftverskiProizvod("","",null,"");
						spView = new SoftverskiProizvodView(sp);
						panelCenterSouth.add(spView);
						revalidate();
						repaint();
						a = "SoftverskaKompanija";
						
					}
					
					else if (selectonNode.getUserObject() instanceof SoftverskiProizvod) {
						panelCenterSouth.removeAll();
						pp = new ParametarProizvoda("","");
						ppView = new ParametarProizvodaView(pp);
						panelCenterSouth.add(ppView);
						revalidate();
						repaint();
						a = "SoftverskiProizvod";
						product = selectonNode;
						
						
						
					}
					else if (selectonNode.getUserObject() instanceof ParametarProizvoda) {
						
						panelCenterSouth.removeAll();
						pp = new ParametarProizvoda("",null);
						ppView = new ParametarProizvodaView(pp);
						panelCenterSouth.add(ppView);
						revalidate();
						repaint();
						a = "ParametarProizvoda";
					}
					else if (selectonNode.getUserObject() instanceof Workspace){
						panelCenterSouth.removeAll();
						sk = new SoftverskaKompanija("","","");
						
						
						skView = new SoftverskaKompanijaView(sk);
						panelCenterSouth.add(skView);
					
						revalidate();
						repaint();
						
						a = "Workspace";
					}
				
			}
		});	
			
         
		 
		 panelleft.add(new JScrollPane(tree));			
		 
		 
		 
		 
		 //glavni desni, u kome se nalaze ova 3
		 JPanel panelcenter=new JPanel(new BorderLayout(20,20));
		 panelcenter.setBackground(Color.WHITE);
		 
		 //na ovaj su prikaceni dugmici
		 JPanel panelCenterNorth = new JPanel();
		 panelcenter.add(panelCenterNorth,BorderLayout.NORTH);
		// panelCenterNorth.setBackground(Color.WHITE);
		 panelCenterNorth.setPreferredSize(new Dimension(300,50));
		 
		 //dugmici za unos,pretragu i brisanje node
		
		
		 
		 buttonEdit = new JButton(new EditNodeAction("Edit node"));
		 panelCenterNorth.add(buttonEdit,BorderLayout.CENTER);
		 buttonDelete = new JButton(new DeleteNodeAction("Delete node"));
		 panelCenterNorth.add(buttonDelete,BorderLayout.CENTER);
		 buttonSearch = new JButton(new SearchNodeAction("Search node"));
		 panelCenterNorth.add(buttonSearch,BorderLayout.CENTER);

		
		 
		 //ovde se nalaz za unos podatak o kompaniji,proizvodu..
		 panelCenterSouth = new JPanel();
		 
		 panelcenter.add(panelCenterSouth);
		 panelCenterSouth.setBackground(Color.WHITE);
		 panelCenterSouth.setPreferredSize(new Dimension(300,500));
		 
		 
		 
		 JSplitPane splitpane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panelleft,panelcenter);
		 add(splitpane,BorderLayout.CENTER);
		 splitpane.setBackground(plava);
		 splitpane.setDividerLocation(150);
		 splitpane.setOneTouchExpandable(true);
		 
		 
		 //STATUS BAR
		 
		 autor = new JLabel("Author: ");
		 jezik = new JLabel("Language: ");
		 datum = new JLabel("Date: ");
		 
		 
		 
		  labeldatum = new JLabel("");
		  
		  Timer now = new Timer(0, new ActionListener() {
				 
				@Override
	            public void actionPerformed(ActionEvent e) {
	                Date today = new java.util.Date();
	                trenutnoVreme = DateFormat.getDateTimeInstance().format(today);
	                labeldatum.setText(trenutnoVreme);
	                labeldatum.setToolTipText(trenutnoVreme);
	                
	 
	            }
	        });
		  now.start();
		 
		 
		 label = new JLabel(autor.getText()+" "+"Nemanja Salipurevic"+"                      "+jezik.getText()+"	"+Locale.getDefault().getDisplayLanguage()+
				 			"                    "+datum.getText()+"  "+labeldatum.getText());
		
		 //Status panel
		 JPanel panel2 = new JPanel();
	     add(panel2,BorderLayout.SOUTH);
	     panel2.setPreferredSize(new Dimension(60,60));
	     
	     JPanel panel21=new JPanel();
	     panel21.setPreferredSize(new Dimension(4000,10));
	     panel21.setBackground(plava1);
	     
		 
		 panel2.add(panel21,BorderLayout.NORTH);
		 panel2.add(label,BorderLayout.SOUTH);
        
       
		  
	}
	private void initTree() {
		
		
		root = new DefaultMutableTreeNode(listakompanija); 
		root.setUserObject(listakompanija);
		treeModel = new DefaultTreeModel(root);
		
		treeModel.setAsksAllowsChildren(true);
		tree = new JTree(treeModel) {
		
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
		
			@Override
			public boolean isPathEditable(TreePath path) {
				// Svi se mogu menjati sem korenskog node-a
				if (path != null) {
					DefaultMutableTreeNode tn = (DefaultMutableTreeNode) path.getLastPathComponent();
					if (!tn.isRoot()) {
						return true;
					} else {
						return false;
					}
				}
				return false;
			}
				
		};
		tree.setEditable(true);
		tree.setCellRenderer(new CellRenderer());
		
		tree.getSelectionModel().setSelectionMode(
		TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		
		tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
			
			

			@Override
			public void valueChanged(TreeSelectionEvent arg0) {
				
				
							
			}
		});
		
		
	} 
	public static Frame getInstance() {
		if(instance == null)
			instance = new Frame();
		
		
		
		return instance;
	}
public void changeLanguage(){
		
		bundle = ResourceBundle.getBundle("languages.jezici", Locale.getDefault());
	    toolbar1.initiComponents();
		menu.initComponents();
		menu2.initComponents();
		buttonDelete.setText(Frame.getInstance().getResourceBundle().getString("btn.delete"));
		buttonEdit.setText(Frame.getInstance().getResourceBundle().getString("btn.edit"));
		buttonSearch.setText(Frame.getInstance().getResourceBundle().getString("btn.search"));
		
		label.setText(Frame.getInstance().getResourceBundle().getString("frame.autor")+" "+"Nemanja Salipurevic"+"                    "+
				Frame.getInstance().getResourceBundle().getString("frame.language")+"	"+Locale.getDefault().getDisplayLanguage()+
				"                     "+Frame.getInstance().getResourceBundle().getString("frame.date")+"  "+labeldatum.getText());
		
		
		
		
		if(a == "Workspace"){
			skView.initComponents();
			
		}
		if(a == "SoftverskaKompanija"){
			spView.initComponents();
			
		}
		if(a == "SoftverskiProizvod" || a == "ParametarProizvoda")
			ppView.initComponents();
		
		 
		
		
	}
	

	public JPanel getPanelCenterSouth() { 
		return panelCenterSouth;
	}
	public JTree getTree(){
		return tree;
	}
	public DefaultTreeModel getModel(){
		return treeModel;
	}

	public SoftverskaKompanija getSk() {
		return sk;
	}

	public void setSk(SoftverskaKompanija sk) {
		this.sk = sk;
	}

	public SoftverskiProizvod getSp() {
		return sp;
	}

	public void setSp(SoftverskiProizvod sp) {
		this.sp = sp;
	}

	public ParametarProizvoda getPp() {
		return pp;
	}

	public void setPp(ParametarProizvoda pp) {
		this.pp = pp;
	}
	public String getImeStatusBara() {
		return imeStatusBara;
	}

	public void setImeStatusBara(String imeStatusBara) {
		this.imeStatusBara = imeStatusBara;
	}

	public SoftverskaKompanijaView getSkView() {
		return skView;
	}

	public void setSkView(SoftverskaKompanijaView skView) {
		this.skView = skView;
	}

	public SoftverskiProizvodView getSpView() {
		return spView;
	}

	public void setSpView(SoftverskiProizvodView spView) {
		this.spView = spView;
	}

	public ParametarProizvodaView getPpView() {
		return ppView;
	}

	public void setPpView(ParametarProizvodaView ppView) {
		this.ppView = ppView;
	}

	

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public ResourceBundle getResourceBundle() {
		return bundle;
	}

	public void setBandle(ResourceBundle bundle) {
		this.bundle = bundle;
	}

	public MyMenuBar getMenu() {
		return menu;
	}

	public void setMenu(MyMenuBar menu) {
		this.menu = menu;
	}

	public String getStisnutoEdit() {
		return stisnutoEdit;
	}

	public void setStisnutoEdit(String stisnutoEdit) {
		this.stisnutoEdit = stisnutoEdit;
	}

	public EditNodeAction getEdit() {
		return edit;
	}

	public void setEdit(EditNodeAction edit) {
		this.edit = edit;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}

	public DefaultTreeModel getTreeModel() {
		return treeModel;
	}

	public void setTreeModel(DefaultTreeModel treeModel) {
		this.treeModel = treeModel;
	}

	public DefaultMutableTreeNode getRoot() {
		return root;
	}

	public void setRoot(DefaultMutableTreeNode root) {
		this.root = root;
	}

	public DefaultMutableTreeNode getProduct() {
		return product;
	}

	public void setProduct(DefaultMutableTreeNode product) {
		this.product = product;
	}

	public DefaultMutableTreeNode getSelectonNode() {
		return selectonNode;
	}

	public void setSelectonNode(DefaultMutableTreeNode selectonNode) {
		this.selectonNode = selectonNode;
	}

	public JTextField getTfVersion() {
		return tfVersion;
	}

	public void setTfVersion(JTextField tfVersion) {
		this.tfVersion = tfVersion;
	}

	public JTextField getTfWelcome() {
		return tfWelcome;
	}

	public void setTfWelcome(JTextField tfWelcome) {
		this.tfWelcome = tfWelcome;
	}

	public JPanel getPanelleft() {
		return panelleft;
	}

	public void setPanelleft(JPanel panelleft) {
		this.panelleft = panelleft;
	}

	public Workspace getListakompanija() {
		return listakompanija;
	}

	public void setListakompanija(Workspace listakompanija) {
		this.listakompanija = listakompanija;
	}
	
	
	
	
	
	
}
