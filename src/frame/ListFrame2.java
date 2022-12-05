package frame;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import ui.RoundedButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.sql.SQLException;
import java.awt.Component;

public class ListFrame2 extends JFrame implements MouseListener {
	// UI
	Color c1 = new Color(0, 129, 86); // 배경 (초록)
	Color c2 = new Color(239, 177, 28); // 글씨 (노랑)
	Font f3 = new Font("KoPub돋움체 Medium", Font.PLAIN, 20);
	Font f4 = new Font("KoPub돋움체 Medium", Font.PLAIN, 15);

	// 뒤로가기 버튼
	ImageIcon btImage = new ImageIcon(lost.class.getResource("../image/bbtn.png"));
	JButton bback = new JButton(btImage);

	RoundedButton btn = new RoundedButton("등록하기");

	private JTextField search;
	private JPanel tablePanel = new JPanel();
	private Object[][] ob = { { "텀블러", "급식실", "2022년 11월 7일" }, { "지갑", "매점", "2022년 11월 4일" },
			{ "무선 이어폰", "강당", "2022년 11월 7일" }, { "스마트 워치", "응용 3실", "2022년 11월 5일" },
			{ "USB", "응용 2실", "2022년 11월 1일" }, { "담요", "응용 2실", "2022년 11월 13일" } };
	private String[] headers = { "물건 이름", "장소", "날짜" };
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel(headers, 0);
	JScrollPane scrollPane;

	// 테이블 안에 있는 텍스트 가운데 정렬
	public void tableCellCenter(JTable t) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);

		TableColumnModel tcm = t.getColumnModel();

		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}

	public ListFrame2() {
		model = new DefaultTableModel(ob, headers); // 데이터 저장[][], 컬럼명
		table = new JTable(model);
		// 테이블
		table.setBounds(0, 10, 798, 100);
		table.setRowHeight(50);
		table.setFont(f4);
		tableCellCenter(table);
		table.setPreferredScrollableViewportSize(new Dimension(800, 500));

		tablePanel.add(table);
		tablePanel.setBackground(c1);

		tablePanel.setLayout(null);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(100, 100, 800, 372);
		tablePanel.add(scrollPane);

		// 검색 기능
		search = new JTextField();
		search.setBounds(100, 28, 800, 52);
		search.setColumns(10);
		search.setFont(f3);
		search.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String val = search.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<TableModel>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});

		tablePanel.add(search);
		getContentPane().add(tablePanel);

		TableColumnModel columnModels = table.getColumnModel();
		columnModels.getColumn(0).setPreferredWidth(150);
		columnModels.getColumn(1).setPreferredWidth(200);
		columnModels.getColumn(2).setPreferredWidth(250);

		table.addMouseListener(this);
		table.getTableHeader().setReorderingAllowed(false); // 이동 X
		table.getTableHeader().setResizingAllowed(false); // 크기 조절 X
		table.setEnabled(false);

		// 뒤로가기 버튼
		bback.setBorderPainted(false);
		bback.setFocusPainted(false);
		bback.setBackground(c1);
		bback.setIcon(btImage);
		bback.setLayout(null);
		bback.setBounds(35, 40, 15, 25);
		bback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new main().setVisible(true);

			}
		});
		tablePanel.add(bback);

		// 등록하기 버튼
		btn.setText("등록하기");
		btn.setFont(f3);
		btn.setBounds(700, 490, 190, 40);
		btn.addActionListener(e -> {
			dispose();
			new Registration().setVisible(true);
		});
		tablePanel.add(btn);

		setSize(1000, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ListFrame2().setVisible(true);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 1) {
		} // 클릭

		// 더블 클릭
		if (e.getClickCount() == 2) {
//			int row = table.getSelectedRow(); // 행
//			int col = table.getSelectedColumn(); // 열
//			for (int i = 0; i < table.getColumnCount(); i++) {
//				System.out.print("클릭됨");
//			}
//			System.out.println();
			new Information2().setVisible(true);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
