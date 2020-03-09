import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.MatteBorder;
import javax.swing.JSeparator;

public class GUI extends JFrame {
	
	JLabel jLabel;
	boolean direction = true;
	Thread RunThingy = new Thread(new runThingy());
	
	JLabel jLabel_1 = new JLabel("");
	JLabel jLabel_2 = new JLabel("");
	private final JLabel jLabel_3 = new JLabel("");
	private final JLabel jLabel_4 = new JLabel("");
	private final JLabel jLabel_5 = new JLabel("");
	private final JLabel jLabel_6 = new JLabel("");
	private final JLabel jLabel_7 = new JLabel("");
	private final JLabel jLabel_8 = new JLabel("");
	private final JLabel jLabel_9 = new JLabel("");
	private final JLabel jLabel_10 = new JLabel("");
	private final JLabel jLabel_11 = new JLabel("");
	
	//player(s) 1,2,3,4, Jlabels
	private JPanel contentPane;
	private JLabel jPlayer1Label;
	private JLabel jPlayer2Label = new JLabel("Player2");
	private JLabel jPlayer3Label = new JLabel("Player3");
	private JLabel jPlayer4Label = new JLabel("Player 4");

	


	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public class runThingy implements Runnable{
		@Override
		public void run(){
			while(true) {
				try {
					Thread.sleep(10);
				}
				catch(Exception ex) {};
				if(jLabel.getX()+jLabel.getWidth() < -1) {
					jLabel.setLocation(668, 417);
				}
				jLabel.setLocation(jLabel.getX()-1, 417);
				
				if(jLabel_1.getX()+jLabel_1.getWidth() < -1) {
					jLabel_1.setLocation(668, 417);
				}
				jLabel_1.setLocation(jLabel_1.getX()-1,417);
				
				if(jLabel_2.getX()+jLabel_2.getWidth()<-1) {
					jLabel_2.setLocation(668, 417);
				}
				jLabel_2.setLocation(jLabel_2.getX()-1, 417);
				
				
				if(jLabel_3.getX()+jLabel_3.getWidth() < -1) {
					jLabel_3.setLocation(668, 297);
				}
				jLabel_3.setLocation(jLabel_3.getX()-1, 297);
				
				
				if(jLabel_4.getX()+jLabel_4.getWidth() < -1) {
					jLabel_4.setLocation(668, 297);
				}
				jLabel_4.setLocation(jLabel_4.getX()-1, 297);
				
				
				if(jLabel_5.getX()+jLabel_5.getWidth() < -1) {
					jLabel_5.setLocation(668, 297);
				}
				jLabel_5.setLocation(jLabel_5.getX()-1, 297);
				
				
				if(jLabel_6.getX()+jLabel_6.getWidth() < -1) {
					jLabel_6.setLocation(668, 177);
				}
				jLabel_6.setLocation(jLabel_6.getX()-1, 177);
				
				
				if(jLabel_7.getX()+jLabel_7.getWidth() < -1) {
					jLabel_7.setLocation(668, 177);
				}
				jLabel_7.setLocation(jLabel_7.getX()-1, 177);
				
				
				if(jLabel_8.getX()+jLabel_8.getWidth() < -1) {
					jLabel_8.setLocation(668, 177);
				}
				jLabel_8.setLocation(jLabel_8.getX()-1, 177);
				
				
				if(jLabel_9.getX()+jLabel_9.getWidth() < -1) {
					jLabel_9.setLocation(668, 70);
				}
				jLabel_9.setLocation(jLabel_9.getX()-1, 70);
				
				
				if(jLabel_10.getX()+jLabel_10.getWidth() < -1) {
					jLabel_10.setLocation(668, 70);
				}
				jLabel_10.setLocation(jLabel_10.getX()-1, 70);
				
				
				if(jLabel_11.getX()+jLabel_11.getWidth() < -1) {
					jLabel_11.setLocation(668, 70);
				}
				jLabel_11.setLocation(jLabel_11.getX()-1, 70);
				
				
				//intersections player 1
				if(Intersects.Intersect(jPlayer1Label, jLabel)) {
					Respawn.death(jPlayer1Label);
				}
				
				if(Intersects.Intersect(jPlayer1Label, jLabel_1)) {
					Respawn.death(jPlayer1Label);
				}
				
				if(Intersects.Intersect(jPlayer1Label, jLabel_2)) {
					Respawn.death(jPlayer1Label);
				}
				
				if(Intersects.Intersect(jPlayer1Label, jLabel_3)) {
					Respawn.death(jPlayer1Label);
				}
				
				if(Intersects.Intersect(jPlayer1Label, jLabel_4)) {
					Respawn.death(jPlayer1Label);
				}
				
				if(Intersects.Intersect(jPlayer1Label, jLabel_5)) {
					Respawn.death(jPlayer1Label);
				}
				
				if(Intersects.Intersect(jPlayer1Label, jLabel_6)) {
					Respawn.death(jPlayer1Label);
				}
				
				if(Intersects.Intersect(jPlayer1Label, jLabel_7)) {
					Respawn.death(jPlayer1Label);
				}
				
				if(Intersects.Intersect(jPlayer1Label, jLabel_8)) {
					Respawn.death(jPlayer1Label);
				}
				
				if(Intersects.Intersect(jPlayer1Label, jLabel_9)) {
					Respawn.death(jPlayer1Label);
				}
				
				if(Intersects.Intersect(jPlayer1Label, jLabel_10)) {
					Respawn.death(jPlayer1Label);
				}
				
				if(Intersects.Intersect(jPlayer1Label, jLabel_11)) {
					Respawn.death(jPlayer1Label);
				}
				
				
				
				//intersections player 2
				if(Intersects.Intersect(jPlayer2Label, jLabel)) {
					Respawn.death(jPlayer2Label);
				}
				
				if(Intersects.Intersect(jPlayer2Label, jLabel_1)) {
					Respawn.death(jPlayer2Label);
				}
				
				if(Intersects.Intersect(jPlayer2Label, jLabel_2)) {
					Respawn.death(jPlayer2Label);
				}
				
				if(Intersects.Intersect(jPlayer2Label, jLabel_3)) {
					Respawn.death(jPlayer2Label);
				}
				
				if(Intersects.Intersect(jPlayer2Label, jLabel_4)) {
					Respawn.death(jPlayer2Label);
				}
				
				if(Intersects.Intersect(jPlayer2Label, jLabel_5)) {
					Respawn.death(jPlayer2Label);
				}
				
				if(Intersects.Intersect(jPlayer2Label, jLabel_6)) {
					Respawn.death(jPlayer2Label);
				}
				
				if(Intersects.Intersect(jPlayer2Label, jLabel_7)) {
					Respawn.death(jPlayer2Label);
				}
				
				if(Intersects.Intersect(jPlayer2Label, jLabel_8)) {
					Respawn.death(jPlayer2Label);
				}
				
				if(Intersects.Intersect(jPlayer2Label, jLabel_9)) {
					Respawn.death(jPlayer2Label);
				}
				
				if(Intersects.Intersect(jPlayer2Label, jLabel_10)) {
					Respawn.death(jPlayer2Label);
				}
				
				if(Intersects.Intersect(jPlayer2Label, jLabel_11)) {
					Respawn.death(jPlayer2Label);
				}
				
				
				//intersections player 3
				if(Intersects.Intersect(jPlayer3Label, jLabel)) {
					Respawn.death(jPlayer3Label);
				}
				
				if(Intersects.Intersect(jPlayer3Label, jLabel_1)) {
					Respawn.death(jPlayer3Label);
				}
				
				if(Intersects.Intersect(jPlayer3Label, jLabel_2)) {
					Respawn.death(jPlayer3Label);
				}
				
				if(Intersects.Intersect(jPlayer3Label, jLabel_3)) {
					Respawn.death(jPlayer3Label);
				}
				
				if(Intersects.Intersect(jPlayer3Label, jLabel_4)) {
					Respawn.death(jPlayer3Label);
				}
				
				if(Intersects.Intersect(jPlayer3Label, jLabel_5)) {
					Respawn.death(jPlayer3Label);
				}
				
				if(Intersects.Intersect(jPlayer3Label, jLabel_6)) {
					Respawn.death(jPlayer3Label);
				}
				
				if(Intersects.Intersect(jPlayer3Label, jLabel_7)) {
					Respawn.death(jPlayer3Label);
				}
				
				if(Intersects.Intersect(jPlayer3Label, jLabel_8)) {
					Respawn.death(jPlayer3Label);
				}
				
				if(Intersects.Intersect(jPlayer3Label, jLabel_9)) {
					Respawn.death(jPlayer3Label);
				}
				
				if(Intersects.Intersect(jPlayer3Label, jLabel_10)) {
					Respawn.death(jPlayer3Label);
				}
				
				if(Intersects.Intersect(jPlayer3Label, jLabel_11)) {
					Respawn.death(jPlayer3Label);
				}
				//intersections player 4
				if(Intersects.Intersect(jPlayer4Label, jLabel)) {
					Respawn.death(jPlayer4Label);
				}
				
				if(Intersects.Intersect(jPlayer4Label, jLabel_1)) {
					Respawn.death(jPlayer4Label);
				}
				
				if(Intersects.Intersect(jPlayer4Label, jLabel_2)) {
					Respawn.death(jPlayer4Label);
				}
				
				if(Intersects.Intersect(jPlayer4Label, jLabel_3)) {
					Respawn.death(jPlayer4Label);
				}
				
				if(Intersects.Intersect(jPlayer4Label, jLabel_4)) {
					Respawn.death(jPlayer4Label);
				}
				
				if(Intersects.Intersect(jPlayer4Label, jLabel_5)) {
					Respawn.death(jPlayer4Label);
				}
				
				if(Intersects.Intersect(jPlayer4Label, jLabel_6)) {
					Respawn.death(jPlayer4Label);
				}
				
				if(Intersects.Intersect(jPlayer4Label, jLabel_7)) {
					Respawn.death(jPlayer4Label);
				}
				
				if(Intersects.Intersect(jPlayer4Label, jLabel_8)) {
					Respawn.death(jPlayer4Label);
				}
				
				if(Intersects.Intersect(jPlayer4Label, jLabel_9)) {
					Respawn.death(jPlayer4Label);
				}
				
				if(Intersects.Intersect(jPlayer4Label, jLabel_10)) {
					Respawn.death(jPlayer4Label);
				}
				
				if(Intersects.Intersect(jPlayer4Label, jLabel_11)) {
					Respawn.death(jPlayer4Label);
				}
				
			}
		}
	}
	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//create the bus
		jLabel = new JLabel("");
		jLabel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		
		//create the button to move the player
		JButton jButton = new JButton("Move1");
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jPlayer1Label.setLocation(jPlayer1Label.getX(), jPlayer1Label.getY()-20);
				
			}
		});
		jButton.setBounds(55, 527, 89, 23);
		contentPane.add(jButton);
		
		JButton btnNewButton_1 = new JButton("Move2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jPlayer2Label.setLocation(jPlayer2Label.getX(), jPlayer2Label.getY()-20);	
			}
			
		});
		btnNewButton_1.setBounds(198, 527, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton_2 = new JButton("Move3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jPlayer3Label.setLocation(jPlayer3Label.getX(), jPlayer3Label.getY()-20);	
			}
		});
		btnNewButton_2.setBounds(359, 527, 89, 23);
		contentPane.add(btnNewButton_2);
		
		
		JButton btnNewButton = new JButton("Move4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jPlayer4Label.setLocation(jPlayer4Label.getX(), jPlayer4Label.getY()-20);	
			}
		});
		btnNewButton.setBounds(532, 527, 89, 23);
		contentPane.add(btnNewButton);
		
		
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setFont(new Font("Tahoma", Font.BOLD, 66));
		jLabel.setBounds(532, 403, 89, 40);
		contentPane.add(jLabel);
		
		jPlayer1Label = new JLabel("Ya Boi");
		jPlayer1Label.setBorder(new LineBorder(Color.RED));
		jPlayer1Label.setFont(new Font("Tahoma", Font.BOLD, 11));
		jPlayer1Label.setForeground(Color.PINK);
		jPlayer1Label.setBounds(70, 468, 47, 48);
		contentPane.add(jPlayer1Label);
		

		jPlayer2Label.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.PINK));
		jPlayer2Label.setBounds(212, 468, 46, 48);
		contentPane.add(jPlayer2Label);
		

		jPlayer3Label.setBorder(new LineBorder(Color.GREEN));
		jPlayer3Label.setBounds(373, 468, 46, 48);
		contentPane.add(jPlayer3Label);
		
		
		jPlayer4Label.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.MAGENTA));
		jPlayer4Label.setBounds(550, 468, 46, 48);
		contentPane.add(jPlayer4Label);
		

		jLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_1.setFont(new Font("Tahoma", Font.BOLD, 66));
		jLabel_1.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		jLabel_1.setBounds(269, 403, 89, 40);
		contentPane.add(jLabel_1);
		

		jLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_2.setFont(new Font("Tahoma", Font.BOLD, 66));
		jLabel_2.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		jLabel_2.setBounds(55, 403, 89, 40);
		contentPane.add(jLabel_2);
		jLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_3.setFont(new Font("Tahoma", Font.BOLD, 66));
		jLabel_3.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		jLabel_3.setBounds(438, 297, 89, 40);
		
		contentPane.add(jLabel_3);
		jLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_4.setFont(new Font("Tahoma", Font.BOLD, 66));
		jLabel_4.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		jLabel_4.setBounds(198, 297, 89, 40);
		
		contentPane.add(jLabel_4);
		jLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_5.setFont(new Font("Tahoma", Font.BOLD, 66));
		jLabel_5.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		jLabel_5.setBounds(0, 297, 89, 40);
		
		contentPane.add(jLabel_5);
		jLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_6.setFont(new Font("Tahoma", Font.BOLD, 66));
		jLabel_6.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		jLabel_6.setBounds(532, 177, 89, 40);
		
		contentPane.add(jLabel_6);
		jLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_7.setFont(new Font("Tahoma", Font.BOLD, 66));
		jLabel_7.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		jLabel_7.setBounds(269, 177, 89, 40);
		
		contentPane.add(jLabel_7);
		jLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_8.setFont(new Font("Tahoma", Font.BOLD, 66));
		jLabel_8.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		jLabel_8.setBounds(29, 177, 89, 40);
		
		contentPane.add(jLabel_8);
		jLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_9.setFont(new Font("Tahoma", Font.BOLD, 66));
		jLabel_9.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		jLabel_9.setBounds(532, 70, 89, 40);
		
		contentPane.add(jLabel_9);
		jLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_10.setFont(new Font("Tahoma", Font.BOLD, 66));
		jLabel_10.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		jLabel_10.setBounds(269, 70, 89, 40);
		
		contentPane.add(jLabel_10);
		jLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel_11.setFont(new Font("Tahoma", Font.BOLD, 66));
		jLabel_11.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		jLabel_11.setBounds(0, 70, 89, 40);
		
		contentPane.add(jLabel_11);
		
		try {
			//new PhidgetHandler(jPlayer1Label);
		}
		catch(Exception ex){};
		RunThingy.start();
	}
}