package frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class ListFrame extends JFrame {
	public ListFrame() {
		Color c1 = new Color(0, 129, 86); // ¹è°æ (ÃÊ·Ï)
		Color c2 = new Color(239, 177, 28); // ±Û¾¾ (³ë¶û)
		Font f4 = new Font("KoPubµ¸¿òÃ¼ Medium", Font.PLAIN, 15);
		JPanel tablePanel = new JPanel();
		String[][] data = new String[][] {{"1","2","3"},{"4","5","6"}};
		String[] headers = new String[] {"Name","Age","Note"};
		JTable table = new JTable(data, headers);
		table.setRowHeight(50);
		table.setFont(f4);
		table.setAlignmentX(0);	// Á¤·Ä
		table.setSize(800, 600);
		table.setPreferredScrollableViewportSize(new Dimension(800, 600));
		tablePanel.add(table);
		tablePanel.setBackground(c1);
		getContentPane().add(new JScrollPane(table));
		getContentPane().setBackground(c1);
		setSize(600, 900);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ListFrame().setVisible(true);

	}

}
