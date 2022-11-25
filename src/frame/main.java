package frame;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class main extends JFrame {
   JPanel p = new JPanel();
   JLabel l = new JLabel("최근 등록된 습득물");
   JLabel t = new JLabel("");
   
   Color c1 = new Color(0, 129, 86); // 배경
   Color c2 = new Color(239, 177, 28); // 글씨
   Font f2 = new Font("KoPub돋움체 Medium", Font.PLAIN, 25);

   JButton bl = new JButton("lost");
   JButton bf = new JButton("found");

   ImageIcon title = new ImageIcon(lost.class.getResource("../image/title.png"));
   
   public main() {
      p.setLayout(null);
      l.setFont(f2);
      l.setForeground(c2);
      l.setBounds(87, 560, 160, 35);
      p.add(l);
      t.setBounds(110, 130, 380, 58);
      t.setIcon(title);
      p.add(t);

      bl.setLayout(null);
      bl.setBounds(140, 350, 150, 150); // 위치, 크기
      bl.addActionListener(e -> {
         dispose();
         new lost().setVisible(true);
      });
      p.add(bl);

      bf.setLayout(null);
      bf.setBounds(310, 350, 150, 150);
      bf.addActionListener(e -> {
         dispose();
         new Registration().setVisible(true);
      });
      p.add(bf);

      getContentPane().add(p);
      p.setBackground(c1);

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