package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.commons.io.IOUtils;



import Model.Configurator;

public class Wizard3Frame extends JPanel{

	JLabel odrediste;
	JTextField text;
	JButton browse;
	JButton odustani;
	JButton prethodni;
	JButton sledeci;
	private Configurator c;
	
	Wizard3Frame(Configurator c) {
		
		this.c = c;
		setLayout(new GridBagLayout());
		
		odrediste = new JLabel("Odrediste");
		text = new JTextField();
		browse = new JButton("Izaberi");
		odustani = new JButton("Odustani");
		prethodni = new JButton("Prethodni");
		sledeci = new JButton("Sledeci");
		
		add(odrediste, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(text, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(browse, new GridBagConstraints(2, 0, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
    	add(odustani, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    	add(prethodni, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.SOUTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
    	add(sledeci, new GridBagConstraints(2, 1, 1, 1, 0, 0, GridBagConstraints.SOUTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		
		
    	odustani.addActionListener(e -> System.exit(0));
    	prethodni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Wizard1Frame.getInstance().setPanelKojiSeMenja2();
				
			}
		});
    	
    	sledeci.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Wizard1Frame.getInstance().setPanelKojiSeMenja4();
				
				
				try {
					unZipedFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
			}
		});
		
    	browse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				uploadZipFile();
				
				
				
			}
		});
		
		
	}
	
	public void uploadZipFile() {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setAcceptAllFileFilterUsed(false);
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			
			text.setText(fc.getSelectedFile().getAbsolutePath());
			
			
		}
	}
	public void unZipedFile() throws IOException{
		File f = new File("temp/compressed.zip");
		FileOutputStream fos = new FileOutputStream(f);
		try {
			fos.write(c.getBytes());
		} finally {
			fos.close();
		}
		
		
		ZipFile zipFile = new ZipFile("temp/compressed.zip");
		//ZipFile zipFile = new ZipFile("C:/Users/Dusan/Desktop/BLABLA.zip");
		
		File outputDir = new File(text.getText()+ File.separatorChar + Wizard1Frame.getInstance().getTitle());
		try {
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				File entryDestination = new File(outputDir, entry.getName());
				if (entry.isDirectory()) {
					entryDestination.mkdirs();
				} else {
					entryDestination.getParentFile().mkdirs();
					InputStream in = zipFile.getInputStream(entry);
					OutputStream out = new FileOutputStream(entryDestination);
					
				
					IOUtils.copy(in, out);
					IOUtils.closeQuietly(in);
					out.close();
				}
			}
		} finally {
			zipFile.close();
		}	
		f.deleteOnExit();
	}
	public void initiComponents(){
		odrediste.setText(Wizard1Frame.getInstance().getBundle().getString("jezici.wizard3.odrediste"));
		browse.setText(Wizard1Frame.getInstance().getBundle().getString("jezici.wizard3.browse"));
		
		prethodni.setText(Wizard1Frame.getInstance().getBundle().getString("jezici.wizard2.previous"));
		sledeci.setText(Wizard1Frame.getInstance().getBundle().getString("jezici.wizard2.next"));
		odustani.setText(Wizard1Frame.getInstance().getBundle().getString("jezici.wizard2.exit"));
		
	}
	
}
