package frame;

import java.awt.*;
import javax.swing.*;

import ui.RoundedButton;

import java.awt.event.*;

public class main extends JFrame {
	JPanel p = new JPanel();
	JLabel l = new JLabel("최근 등록된 습득물");
	JLabel t = new JLabel("");

	Color c1 = new Color(0, 129, 86); // 배경(초록)
	Color c2 = new Color(239, 177, 28); // 글씨(노랑)
	Font f2 = new Font("KoPub돋움체 Medium", Font.PLAIN, 25);
	Font f3 = new Font("KoPub돋움체 Medium", Font.PLAIN, 20);

	RoundedButton bl = new RoundedButton("lost");
	RoundedButton bf = new RoundedButton("found");
	RoundedButton btn = new RoundedButton("등록하기");

	ImageIcon title = new ImageIcon(lost.class.getResource("../image/title.png"));

	public main() {
		p.setLayout(null);
		l.setFont(f2);
		l.setForeground(c2);
		l.setBounds(80, 630, 200, 35);
		p.add(l);
		t.setBounds(110, 130, 380, 58);
		t.setIcon(title);
		p.add(t);
		bl.setText("lost");
		bl.setFont(f3);

		bl.setLayout(null);
		bl.setBounds(140, 310, 150, 150); // 위치, 크기
		bl.addActionListener(e -> {
			dispose();
			new ListFrame().setVisible(true);
		});
		p.add(bl);

		bf.setText("found");
		bf.setFont(f3);

		bf.setLayout(null);
		bf.setBounds(310, 310, 150, 150);
		bf.addActionListener(e -> {
			dispose();
			new ListFrame().setVisible(true);
		});
		p.add(bf);

		getContentPane().add(p);
		p.setBackground(c1);
		btn.addActionListener(e -> {
			dispose();
			new Registration().setVisible(true);
		});

		btn.setText("등록하기");
		btn.setFont(f3);
		btn.setBounds(140, 499, 320, 58);
		p.add(btn);

		setTitle("lost & found");// 타이틀
		setSize(600, 900);// 프레임의 크기
		setResizable(false);// 창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);// 창이 가운데 나오게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// JFrame이 정상적으로 종료되게
	}

	public static void main(String[] args) {
		new main().setVisible(true);
	}
}