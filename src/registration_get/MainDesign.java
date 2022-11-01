package registration_get;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainDesign extends JFrame {

	public MainDesign() {
		var p = new JPanel();
		var l = new JLabel("µî·ÏÇÏ±â");
		var c1 = new Color(0, 129, 86);		// ¹è°æ
		var c2 = new Color(239, 177, 28);	// ±Û¾¾
		var f1 = new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 35);
		var f2 = new Font("KoPubµ¸¿òÃ¼ Medium", Font.PLAIN, 25);
		
		p.setLayout(null);
		l.setFont(f1);
		l.setForeground(c2);
		l.setBounds(75, 60, 135, 45);

		var group = new ButtonGroup();
		var rb1 = new JRadioButton("½Àµæ");
		var rb2 = new JRadioButton("ºÐ½Ç");
		
		var jl1 = new JLabel("½Àµæ¹°");
		var jl2 = new JLabel("½Àµæ Àå¼Ò");
		var jl3 = new JLabel("½Àµæ ³¯Â¥");
		var jl4 = new JLabel("±âÅ¸ (¹°°ÇÀÇ Æ¯Â¡ µî)");
		var tf1 = new JTextField(20);
		var tf2 = new JTextField(20);
		var tf3 = new JTextField(20);
		var tf4 = new JTextField(20);
		rb1.setSelected(true);
		rb1.setBounds(75, 150, 70, 30);
		rb2.setBounds(75, 200, 70, 30);
		rb1.setFont(f2);
		rb2.setFont(f2);
		
		jl1.setBounds(75, 260, 0, 0);
		jl2.setBounds(75, 360, 0, 0);
		jl3.setBounds(75, 460, 0, 0);
		jl4.setBounds(75, 560, 0, 0);
		tf1.setBounds(75, 300, 100, 30);
		tf2.setBounds(75, 400, 100, 30);
		tf3.setBounds(75, 500, 100, 30);
		tf4.setBounds(75, 600, 100, 30);
		
		p.add(l);
		group.add(rb1);
		group.add(rb2);
		p.add(rb1);
		p.add(rb2);
		
		p.add(jl1);
		p.add(tf1);
		p.add(jl2);
		p.add(tf2);
		p.add(jl3);
		p.add(tf3);
		p.add(jl4);
		p.add(tf4);

		getContentPane().add(p);
		p.setBackground(c1);

		setSize(600, 900);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new MainDesign().setVisible(true);

	}

}
