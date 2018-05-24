package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Inventory extends JFrame 
{
	public Inventory (String title)
	{
		super (title);
		
		//set layout
		setLayout(new BorderLayout());
		
		//maKE BUTTONS
		JTextArea inv = new JTextArea();
		JButton quit = new JButton("Back");
		
		//swing stuff to a container
		Container c = getContentPane();
		
		c.add(inv, BorderLayout.CENTER);
		c.add(quit, BorderLayout.SOUTH);
		
		inv.setEditable(false);//user cant edit the inventory here
		
		quit.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				JFrame frame = new Inventory_Pannal("Inventory Infomation");
				frame.setSize(500,500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		
		
	}
}
