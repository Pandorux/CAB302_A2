package GUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BaseFrame //this initializes the frame
{
	public static void main(String[] args) {
		
			SwingUtilities.invokeLater(new Runnable()
			{
				public void run()
				{
					JFrame frame = new MainMenu("SuperMart Systems");
					frame.setSize(1000,1000);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				}
			});
	}
}
