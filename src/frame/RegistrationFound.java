package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RegistrationFound extends JFrame {

	public RegistrationFound() {
		var p = new JPanel();
		var l = new JLabel("µî·ÏÇÏ±â");
		var c1 = new Color(0, 129, 86);		// ¹è°æ
		var c2 = new Color(239, 177, 28);	// ±Û¾¾
		var f1 = new Font("KoPubµ¸¿òÃ¼ Bold", Font.PLAIN, 35);
		var f2 = new Font("KoPubµ¸¿òÃ¼ Medium", Font.PLAIN, 25);
		var f3 = new Font("KoPubµ¸¿òÃ¼ Medium", Font.PLAIN, 20);
		
		
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
		
		var tf1 = new JTextField();
		var tf2 = new JTextField();
		var tf3 = new JTextField();
		var tf4 = new JTextField(5);
		
		// ½Àµæ, ºÐ½Ç ¹öÆ°
		rb1.setSelected(true);
		rb1.setBounds(75, 150, 70, 30);
		rb2.setBounds(75, 200, 70, 30);
		rb1.setFont(f2);
		rb2.setFont(f2);
		rb1.setBorderPainted(false);
		rb2.setBorderPainted(false);
		rb1.setFocusable(false);
		rb2.setFocusable(false);
		rb1.setOpaque(false);
		rb2.setOpaque(false);
		
		jl1.setBounds(75, 265, 450, 45);
		jl2.setBounds(75, 365, 450, 45);
		jl3.setBounds(75, 465, 450, 45);
		jl4.setBounds(75, 565, 450, 45);
		jl1.setFont(f2);
		jl2.setFont(f2);
		jl3.setFont(f2);
		jl4.setFont(f2);
		
		jl1.setForeground(c2);
		jl2.setForeground(c2);
		jl3.setForeground(c2);
		jl4.setForeground(c2);
		
		
		tf1.setBounds(75, 310, 450, 40);
		tf2.setBounds(75, 410, 450, 40);
		tf3.setBounds(75, 510, 450, 40);
		tf4.setBounds(75, 610, 450, 40);
		
		tf1.setFont(f3);
		tf2.setFont(f3);
		tf3.setFont(f3);
		tf4.setFont(f3);
		
		// ±ÛÀÚ¼ö Á¦ÇÑ
		tf1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 6) ke.consume();
			}
		});
		
		getContentPane().add(p);
		p.setBackground(c1);
		
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

		setSize(600, 900);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new RegistrationFound().setVisible(true);

	}

}
