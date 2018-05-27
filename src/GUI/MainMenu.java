package GUI;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import exceptions.CSVFormatException;
import sun.misc.GC;

import store.Stock;
import store.Store;
import store.Item;


public class MainMenu extends JFrame 
{
	public MainMenu(String title)
	{
		super(title);
		
		
		
		//create swing components
		
		Container menu_content = getContentPane();
		
		JButton view_Inventory = new JButton("Edit Inventory");
		JButton View_Sales_Log = new JButton("View Sales Log");
		JButton view_Manifest = new JButton("View Manifest");
		JButton order_Stock = new JButton("Manage Stock");
		
		JButton import_CSV = new JButton("Import CSV's");
		
		JLabel Title = new JLabel("SuperMart Systems");
		
		
		
		//add swing components to frame
				//set layout
				setLayout(new GridBagLayout());
				
				GridBagConstraints gc = new GridBagConstraints();
		
				gc.weighty = 0.5;
				gc.weightx = 0.5;
				
				gc.gridx = 1;
				gc.gridy = 1;//top left?
				add(view_Inventory, gc);
				
				gc.gridx = 2;
				gc.gridy = 1;
				add(import_CSV, gc);
				
		
				gc.gridx = 3;
				gc.gridy = 1;//top left?
				add(View_Sales_Log, gc);
				
				gc.gridx = 2;
				gc.gridy = 2;//top left?
				add(view_Manifest, gc);
				
				//gc.gridx = 3;
				//gc.gridy = 2;//top left?
				//add(order_Stock, gc);
				
				
				gc.gridx = 2;
				gc.gridy = 0;//top left?
				add(Title, gc);
				
	
				//add Functionality to buttons
						
				view_Inventory.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						setVisible(false);
						JFrame frame = new Inventory_Pannal("Inventory Infomation");
						frame.setSize(1000,1000);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
				
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
				
				
				order_Stock.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						setVisible(false);
						JFrame frame = new Stock_Order_Pannel("Manage Stock");
						frame.setSize(1000,1000);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
				
				import_CSV.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						final String dir = System.getProperty("user.dir");
						
						try 
						{
							Item.importItemCSV(dir);
						} 
						catch (FileNotFoundException | CSVFormatException e1) 
						{
							e1.printStackTrace();
						}
						//import the CSV via this button when needed
					}
				});
				
				
		}
}
