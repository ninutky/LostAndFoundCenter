package registration_get;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class MainDesign extends JFrame {

	public MainDesign() {
		JPanel p = new JPanel();
		JLabel l = new JLabel("µî·ÏÇÏ±â");
		Color c1 = new Color(0, 129, 86);
		Color c2 = new Color(239, 177, 28);
		Font f1 = new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 35);
		Font f2 = new Font("KoPubµ¸¿òÃ¼ Medium", Font.PLAIN, 25);

		l.setFont(f1);
		l.setForeground(c2);
		l.setBounds(75, 60, 135, 45);

		ButtonGroup group = new ButtonGroup();
		JRadioButton rb1 = new JRadioButton("½Àµæ");
		JRadioButton rb2 = new JRadioButton("ºÐ½Ç");
		rb1.setSelected(true);
		rb1.setBounds(75, 150, 70, 30);
		rb2.setBounds(75, 200, 70, 30);
		rb1.setFont(f2);
		rb2.setFont(f2);

		p.add(l);
		group.add(rb1);
		group.add(rb2);
		p.add(rb1);
		p.add(rb2);

		getContentPane().add(p);
		p.setBackground(c1);

		getContentPane().add(p);

		setSize(600, 900);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new MainDesign();

	}

}
