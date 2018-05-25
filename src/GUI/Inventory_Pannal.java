package GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Inventory_Pannal extends JFrame {

	public Inventory_Pannal(String title) 
	{
		super (title);
		
		
		
		//create swing components
		JButton View_Sales_Log = new JButton("View Sales Log");
		JButton view_Manifest = new JButton("View Manifest");
		JButton Search_List = new JButton("Sale");
		JTextField search = new JTextField(10);
		JButton See_Inventroy = new JButton("See Inventory");
		JLabel Title = new JLabel("SuperMart Systems");
		
		JButton add_Item = new JButton("Add Item");
		JButton remove_Item = new JButton("Remove Item");
		JButton edit_Item = new JButton("Edit Item");
		JTextField add = new JTextField(20);
		JTextField remove = new JTextField(20);
		JTextField edit = new JTextField(20);
		//set layout
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		
		//add swing components to frame
		
				
				gc.weighty = 10;
		
				gc.gridx = 2;
				gc.gridy = 1;
				add(View_Sales_Log, gc);
				
				gc.gridx = 0;
				gc.gridy = 1;
				add(view_Manifest, gc);
				
				gc.gridx = 1;
				gc.gridy = 0;
				add(Title, gc);
				
				gc.gridx = 1;
				gc.gridy = 2;
				add(search, gc);
				
				gc.gridx = 2;
				gc.gridy = 2;
				add(Search_List, gc);
				
				gc.gridx = 1;
				gc.gridy = 1;
				add(See_Inventroy, gc);
				
				gc.gridx = 0;
				gc.gridy = 3;
				add(add_Item, gc);
				
				gc.gridx = 0;
				gc.gridy = 4;
				add(remove_Item, gc);
				
				gc.gridx = 0;
				gc.gridy = 5;
				add(edit_Item, gc);
				
				gc.gridx = 1;
				gc.gridy = 3;
				add(add, gc);
				
				gc.gridx = 1;
				gc.gridy = 4;
				add(remove, gc);
				
				gc.gridx = 1;
				gc.gridy = 5;
				add(edit, gc);
				search.setText("What was sold?");
				
				add.setText("name, manufacture cost, sell cost, reorder point, reorder amount");
				remove.setText("name, manufacture cost, sell cost, reorder point, reorder amount");
				edit.setText("name, manufacture cost, sell cost, reorder point, reorder amount");
				
				
				View_Sales_Log.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						JFrame frame = new Sales_Pannel("Sales Logs");
						frame.setSize(500,500);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
				
				See_Inventroy.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						JFrame frame = new Inventory("Inventory");
						frame.setSize(500,500);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
				
				view_Manifest.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						JFrame frame = new Manifest_Pannel("Manifest");
						frame.setSize(500,500);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
				
				
				
	}

}
