package frame;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Intro extends JFrame {
	private Image background = new ImageIcon(Intro.class.getResource("../image/intro.png")).getImage();
	
	public Intro() {
		setTitle("lost & found");
		setSize(600, 900);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try{

			Thread.sleep(2000);

		}catch(InterruptedException ie){

			System.out.println(ie.getMessage());

		}

		setVisible(false);
	}
	
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
	}
	
	public static void main(String[] args) {
		new Intro();
		new main().setVisible(true);;

	}

}
