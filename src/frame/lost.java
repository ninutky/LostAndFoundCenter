package frame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class lost extends JFrame {
   JPanel p = new JPanel();
   Color c1 = new Color(0, 129, 86);
   ImageIcon btImage = new ImageIcon(lost.class.getResource("../image/bbtn.png")); // 뒤로가기 버튼
   JButton bback = new JButton(btImage); // 뒤로가기
   JButton bf = new JButton("found"); // 등록하기
   
   public lost() {
      p.setLayout(null);
      bf.setLayout(null);
      bback.setBorderPainted(false);
      bf.setBounds(400, 600, 100, 50); // 위치, 크기
      bf.addActionListener(e -> {
         dispose();
         new Registration().setVisible(true);
      });
      p.add(bf);

      bback.setBorderPainted(false);
      bback.setFocusPainted(false);
      bback.setBackground(c1);
      bback.setIcon(btImage);
      bback.setLayout(null);
      bback.setBounds(35, 40, 15, 25);
      bback.addActionListener(e -> {
         dispose();
         new main().setVisible(true);
      });
      p.add(bback);

      getContentPane().add(p);
      p.setBackground(c1);

      setSize(600, 900);// 프레임의 크기
      setResizable(false);// 창의 크기를 변경하지 못하게
      setLocationRelativeTo(null);// 창이 가운데 나오게
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// JFrame이 정상적으로 종료되게

   }

   public static void main(String[] args) {
      new lost().setVisible(true);

   }
}