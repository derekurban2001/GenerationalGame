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



public class Intersects{
	
	public static boolean Intersect(JLabel J1, JLabel J2) {
		
		//test horizontal intersection
													//										   //		
		if ((J1.getX() + J1.getWidth() > J2.getX()) && (J1.getX() < J2.getX() + J2.getWidth()) && J1.getY() < J2.getY() + J2.getHeight() && J1.getY() + J1.getHeight()  > J2.getY()  ) {
			return true;
		}
		else if ((J1.getY() > J2.getY() + J2.getHeight())&&(J1.getY() + J1.getHeight() < J2.getY())) {
			return true;
		}
		else {
			return false;
		}

	}
	
}
