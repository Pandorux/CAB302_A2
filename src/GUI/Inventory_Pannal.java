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
		
		
		
		//set layout
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		
		
		
		//create swing components
		String line = "\n";
		String extend = "\t\t\t\t\t";
		//Container menu_content = getContentPane();
		
		//JButton view_Inventory = new JButton("View Inventory");
		JButton View_Sales_Log = new JButton("View Sales Log");
		JButton view_Manifest = new JButton("View Manifest");
		//JButton order_Stock = new JButton("Order Stock");
		JButton Search_List = new JButton("Order Stock");
		JTextField search = new JTextField(10);
		JButton See_Inventroy = new JButton("See Inventory");
		JLabel Title = new JLabel("SuperMart Systems");
		
		
		//set layout
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		
		//add swing components to frame
		
				
		gc.weighty = 10;
				gc.gridx = 2;
				gc.gridy = 1;//top right?
				add(View_Sales_Log, gc);
				
				gc.gridx = 0;
				gc.gridy = 1;//top left?
				add(view_Manifest, gc);
				
				//gc.gridx = 1;
				//gc.gridy = 1;//top mid?
				//add(order_Stock, gc);
				
				gc.gridx = 1;
				gc.gridy = 0;//top left?
				add(Title, gc);
				
				gc.gridx = 1;
				gc.gridy = 2;
				add(search, gc);
				
				gc.gridx = 2;
				gc.gridy = 2;
				add(Search_List, gc);
				
				//Container c = getContentPane();
				
				gc.gridx = 0;
				gc.gridy = 2;
				add(See_Inventroy, gc);
				
				
				search.setText("Order Here");
				
				
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
				
				/*
				order_Stock.addActionListener(new ActionListener()
				{
					
					public void actionPerformed(ActionEvent e) 
					{
						JFrame frame = new Stock_Order_Pannel("Order Stock");
						frame.setSize(500,500);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				});
			*/
	}

}
