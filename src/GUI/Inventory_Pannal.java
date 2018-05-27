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

import store.Stock;
import store.Store;

public class Inventory_Pannal extends JFrame {
	
	public Inventory_Pannal(String title) 
	{
		super (title);
		
		
		
		//create swing components
		JButton View_Sales_Log = new JButton("View Sales Log");
		JButton view_Manifest = new JButton("View Manifest");
		JButton Sale = new JButton("Sale");
		JTextField saleName = new JTextField(10);
		JTextField saleQuantity = new JTextField(10);
		JButton See_Inventroy = new JButton("See Inventory");
		JLabel Title = new JLabel("SuperMart Systems");
		
		JLabel errors = new JLabel("This is where errors will appear");
		
		JButton add_Item = new JButton("Add Item");
		JButton remove_Item = new JButton("Remove Item");
		JButton edit_Item = new JButton("Edit Item");

		JTextField remove = new JTextField(20);
		JTextField edit = new JTextField(20);
		
		
		//set layout
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		
		//add swing components to frame
		
				
		gc.weighty = 0.5;
		
				gc.gridx = 1;
				gc.gridy = 10;//at the lowest point in the panel
				add(errors, gc);
		
				gc.gridx = 2;
				gc.gridy = 1;
				add(View_Sales_Log, gc);
				
				gc.gridx = 0;
				gc.gridy = 1;
				add(view_Manifest, gc);
				
				gc.gridx = 1;
				gc.gridy = 0;
				add(Title, gc);
				
				gc.gridx = 0;
				gc.gridy = 2;
				add(Sale, gc);
				
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
				
				
				//gc.gridx = 1;
				//gc.gridy = 4;
				//add(remove, gc);
				
				gc.gridx = 1;
				gc.gridy = 5;
				add(edit, gc);
				
				saleName.setText("name");
				saleQuantity.setText("quantity");
				
				
				remove.setText("Infomation");
				edit.setText("name");
				
				
				//menu navigation
				View_Sales_Log.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						setVisible(false);
						JFrame frame = new Sales_Pannel("Sales Logs");
						frame.setSize(1000,1000);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
				
				See_Inventroy.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						setVisible(false);
						JFrame frame = new Inventory("Inventory");
						frame.setSize(1000,1000);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
				
				view_Manifest.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						setVisible(false);
						JFrame frame = new Manifest_Pannel("Manifest");
						frame.setSize(1000,1000);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
				
				
				//*************************************************************************************
				//functionality
				
				edit_Item.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						if (Stock.getItem(edit.getText()) != null)
						{
							System.out.print("it works!");
						}
						else 
						{
							System.out.print("failure");
						}
						if (Stock.getItem(edit.getText().toUpperCase()) == null)//if the item being searched doesn't exist
						{
							errors.setText("The item you want to edit doesnt exist!");
							
						}
						else
						{
							setVisible(false);
							JFrame frame = new editItemPanel("Edit Items", edit.getText());//pass on the items name
							frame.setSize(1000,1000);
							frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							frame.setVisible(true);
						}
					}
				});
				
				add_Item.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						//open a new window to make this work right
						setVisible(false);
						JFrame frame = new Add_Item_Pannel("Adding Item");
						frame.setSize(900,100);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
				
				remove_Item.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						//open a new window to make this work right
						setVisible(false);
						JFrame frame = new Remove_Item_Pannel("Removing Item");
						frame.setSize(900,100);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
				
				
				Sale.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						setVisible(false);
						JFrame frame = new sale_Pannel("Removing Item");
						frame.setSize(400,100);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
						//Store.Sale()
					}
				});
				
	}

}
