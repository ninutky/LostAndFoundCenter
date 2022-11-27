package frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ui.RoundedButton;

public class DialogMsg extends JFrame {
	static JFrame f;
	static JPanel p;
	
	public DialogMsg(String msg) {
		Color c1 = new Color(0, 129, 86); // 초록
		Color c2 = new Color(239, 177, 28); // 노랑
		Font f3 = new Font("KoPub돋움체 Medium", Font.PLAIN, 20);
		Font f4 = new Font("KoPub돋움체 Medium", Font.PLAIN, 15);
		p = new JPanel();
		// 프레임
		f = new JFrame("");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		// Dialog
        JDialog d = new JDialog(f, "");

        // 글자
        JLabel l = new JLabel(msg);
        l.setFont(f3);
        d.getContentPane().add(l).setBounds(60, 30, 180, 30);
        d.getContentPane().setLayout(null);
        d.setSize(300, 170);
        d.setVisible(true);
        d.setLocationRelativeTo(null);
        
        // 버튼
        RoundedButton btn = new RoundedButton("확인");
        d.getContentPane().add(btn);
        btn.setBounds(110, 90, 70, 30);
		btn.setFont(f4);
		btn.addActionListener(e -> {
			d.dispose();
		});
        
		getContentPane().add(p);
	}
	
	public static void showMessageDialog(String text) {
		new DialogMsg(text);
	}

}
