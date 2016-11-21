import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class Interface extends JFrame {
	// Initiate some buttons usable in entire class
	JButton jbtPlaceBet;
	JButton jbtHit;
	JButton jbtStay;
	JButton jbtQuit;
	
	public Interface() {
		// Get screen dimension info with Toolkit and set variables to anchor panels
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		// Player panel anchors
		int playerXPosLeft = 0;
		int playerYPosTop = dim.height;
		int playerXPosRight = dim.width;
		int playerYPosBottom = dim.height / 2;
		// Dealer panel anchors
		int dealerXPosLeft = 0;
		int dealerYPosTop = dim.height / 2;
		int dealerXPosRight = dim.width;
		int dealerYPosBottom = 0;
		
		
		// Create full screen window
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("**BLACKJACK**");
		
		// Create panels to hold info for player and dealer
		JPanel panel1 = new JPanel();
		this.add(panel1);
		JPanel playerPanel = new JPanel();
		playerPanel.setLayout(new GridLayout(playerXPosLeft, playerYPosTop, playerXPosRight, playerYPosBottom));
		JPanel dealerPanel = new JPanel();
		dealerPanel.setLayout(new GridLayout(dealerXPosLeft, dealerYPosTop, dealerXPosRight, dealerYPosBottom));
		panel1.add(playerPanel);
		panel1.add(dealerPanel);
		
		// Set up some buttons
		jbtHit = new JButton("HIT");
		jbtStay = new JButton("STAY");
		jbtQuit = new JButton("QUIT");
		jbtPlaceBet	= new JButton("PLACE BET");
		
		ListenForButton lForButton = new ListenForButton();
		
		// Add buttons and listeners to panel
		jbtHit.addActionListener(lForButton);
		playerPanel.add(jbtHit);
		jbtStay.addActionListener(lForButton);
		playerPanel.add(jbtStay);
		jbtQuit.addActionListener(lForButton);
		jbtQuit.setLocation(0, 0);
		panel1.add(jbtQuit);
		jbtPlaceBet.addActionListener(lForButton);
		panel1.add(jbtPlaceBet);
		
	}
	
	// Listener Class
	private class ListenForButton implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == jbtHit) {
				System.out.println("HIT button clicked\n");
				// TODO: Implement button actions
				
			}
			
			if(e.getSource() == jbtStay) {
				System.out.println("STAY button clicked\n");
				// TODO: Implement button actions
				
			}
			
			if(e.getSource() == jbtQuit) {
				System.out.println("QUIT button clicked\n");
				// TODO: Implement button actions
				
			}
			
			if(e.getSource() == jbtPlaceBet) {
				System.out.println("PLACE BET button clicked\n");
				// TODO: Implement button actions
				
			}
			
		}
		
	}

}
