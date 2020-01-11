package GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

public class OpenTree {
	
	private BufferedReader in;
	private LineNumberReader ln;
	private String line;
	private String root;
	private String filename = "inputstream.txt";
	private DefaultMutableTreeNode top;
	private JTree tree;
	private String encoding = "UTF-8";
	
	public OpenTree() {
		//getRootNode();
		top = new DefaultMutableTreeNode(root);
		//createNodes(top);
		
		tree = new JTree(top);
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		
	}
	/*public void readFile(){
		    try {
		        in = new BufferedReader(new FileReader("C:\\Users\\Marina\\Desktop\\neco\\inputstream.txt"));
		        //in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filename), encoding));

		        while ((line = in.readLine()) != null) {
		            System.out.println(line);
		        }
		        in.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	
	public void getRootNode(){
		try {
			in = new BufferedReader(new FileReader("C:\\Users\\Marina\\Desktop\\neco\\inputstream.txt"));
			//in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filename), encoding));

			ln = new LineNumberReader(in);
			
			if(ln.getLineNumber() == 0){
				root = ln.readLine();
			}
			in.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	private int countOccurrences(String haystack, char needle) {
	    int count = 0;
	    for (int i = 0; i < haystack.length(); i++) {
	        if (haystack.charAt(i) == needle) {
	            count++;
	        }
	    }
	    return count;
	}
	
	private void createNodes(DefaultMutableTreeNode top) {
	    DefaultMutableTreeNode category = null;     // Level 1 in Hierarchy
	    DefaultMutableTreeNode subCategory = null;  // Level 2 in Hierarchy
	    DefaultMutableTreeNode leaf = null;         // Level 3 in Hierarchy    

	    try {
	        in = new BufferedReader(new FileReader("C:\\Users\\Marina\\Desktop\\neco\\inputstream.txt"));
	        //in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("inputstream.txt"), encoding));

	        while ((line = in.readLine()) != null) {
	            if (countOccurrences(line, '\t') == 1) {
	                category = new DefaultMutableTreeNode(line);
	                top.add(category);
	            } else if (countOccurrences(line, '\t') == 2) {
	                subCategory = new DefaultMutableTreeNode(line);
	                category.add(subCategory);
	            } else if (countOccurrences(line, '\t') == 3) {
	                leaf = new DefaultMutableTreeNode(line);
	                subCategory.add(leaf);
	            } //continue the else...if - if you have more levels
	        }
	        in.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}*/
	public JTree getTree(){
		return tree;
	}
}
