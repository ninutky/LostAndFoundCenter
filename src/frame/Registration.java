package frame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.html.ImageView;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DatePickerSettings.DateArea;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import ui.HintTextArea;
import ui.HintTextField;
import ui.RoundedButton;

public class Registration extends JFrame {
	Db db = new Db();

	JPanel p = new JPanel();
	JLabel l = new JLabel("등록하기");

	ButtonGroup group = new ButtonGroup();
	JRadioButton rb1 = new JRadioButton("습득");
	JRadioButton rb2 = new JRadioButton("분실");

	JLabel jl1 = new JLabel("습득 날짜");
	JLabel jl2 = new JLabel("습득물");
	JLabel jl3 = new JLabel("습득 장소");
	JLabel jl4 = new JLabel("기타 (물건의 특징 등)");

	// 날짜 선택
	DatePickerSettings dateSettings = new DatePickerSettings();
	DatePicker datePicker = new DatePicker(dateSettings);
	HintTextField tf1 = new HintTextField("예) 에어팟, 검정색 카드");
	HintTextField tf2 = new HintTextField("예) 응용3실, 체육관");
	HintTextArea tf3 = new HintTextArea("예) 강아지 스티커가 붙어 있어요");

	boolean check;

	// 사진 첨부 버튼
	RoundedButton btnNewButton = new RoundedButton("사진첨부");

	String filename = "";

	// 뒤로가기 버튼
	ImageIcon btImage = new ImageIcon(lost.class.getResource("../image/bbtn.png"));
	JButton bback = new JButton(btImage);

	Color c1 = new Color(0, 129, 86); // 배경 (초록)
	Color c2 = new Color(239, 177, 28); // 글씨 (노랑)
	Font f1 = new Font("KoPub돋움체 Bold", Font.PLAIN, 35);
	Font f2 = new Font("KoPub돋움체 Medium", Font.PLAIN, 25);
	Font f3 = new Font("KoPub돋움체 Medium", Font.PLAIN, 20);
	Font f4 = new Font("KoPub돋움체 Medium", Font.PLAIN, 15);

	public Registration() {
		// TODO 날짜 선택 제한
		// TODO 디비 연동
		// TODO 로그인 구현
		// TODO 수정 구현

		Db db = new Db();

		dateSettings.setColor(DateArea.BackgroundMonthAndYearMenuLabels, c2);
		dateSettings.setColor(DateArea.BackgroundMonthAndYearNavigationButtons, c2);
		dateSettings.setColor(DateArea.BackgroundOverallCalendarPanel, c2);
		dateSettings.setColor(DateArea.BackgroundTodayLabel, c2);

		dateSettings.setAllowEmptyDates(false);
		dateSettings.setFontValidDate(f4);
		dateSettings.setFontCalendarWeekdayLabels(f4);
		dateSettings.setFontCalendarDateLabels(f4);
		dateSettings.setFontCalendarWeekNumberLabels(f4);
		dateSettings.setFontClearLabel(f4);
		dateSettings.setFontInvalidDate(f4);
		dateSettings.setFontMonthAndYearMenuLabels(f4);
		dateSettings.setFontMonthAndYearNavigationButtons(f4);
		dateSettings.setColorBackgroundWeekdayLabels(c1, true);
		dateSettings.setFontTodayLabel(f4);
		dateSettings.setFontValidDate(f3); // TextField
		dateSettings.setFontVetoedDate(f4);

		p.setLayout(null);
		l.setFont(f1);
		l.setForeground(c2);
		l.setBounds(75, 105, 135, 45);

		// 습득, 분실 버튼
		rb1.setSelected(true);
		rb1.setBounds(60, 195, 200, 30);
		rb1.setBorderPainted(false);
		rb1.setFont(f2);
		rb1.setFocusable(false);
		rb1.setOpaque(false);
		rb1.setIcon(new ImageIcon(lost.class.getResource("../image/radiobtn_click.png")));

		rb2.setBounds(60, 250, 200, 30);
		rb2.setFont(f2);
		rb2.setBorderPainted(false);
		rb2.setFocusable(false);
		rb2.setOpaque(false);
		rb2.setIcon(new ImageIcon(lost.class.getResource("../image/radiobtn.png")));

		// Label
		jl1.setBounds(75, 315, 450, 45);
		jl1.setFont(f2);
		jl1.setForeground(c2);

		jl2.setFont(f2);
		jl2.setBounds(75, 395, 450, 45);
		jl2.setForeground(c2);

		jl3.setFont(f2);
		jl3.setBounds(75, 495, 450, 45);
		jl3.setForeground(c2);

		jl4.setBounds(75, 595, 450, 45);
		jl4.setFont(f2);
		jl4.setForeground(c2);

		// 습득 버튼 눌렀을 때
		rb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jl1.setText("습득 날짜");
				jl2.setText("습득물");
				jl3.setText("습득 장소");
				check = false;
				rb1.setIcon(new ImageIcon(lost.class.getResource("../image/radiobtn_click.png")));
				rb2.setIcon(new ImageIcon(lost.class.getResource("../image/radiobtn.png")));
			}
		});
		// 분실 버튼 눌렀을 때
		rb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jl1.setText("분실 날짜");
				jl2.setText("분실물");
				jl3.setText("분실 장소");
				check = true;
				rb1.setIcon(new ImageIcon(lost.class.getResource("../image/radiobtn.png")));
				rb2.setIcon(new ImageIcon(lost.class.getResource("../image/radiobtn_click.png")));

			}
		});

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

		tf1.setBounds(75, 440, 450, 40);
		tf1.setFont(f3);
		tf2.setToolTipText("");

		tf2.setBounds(75, 540, 450, 40);
		tf2.setFont(f3);

		tf3.setBounds(75, 640, 450, 100);
		tf3.setFont(f3);
		tf3.setLineWrap(true);

		datePicker.getComponentDateTextField().setFont(f3);
		datePicker.setBounds(75, 355, 450, 40);

		// 글자수 제한
		tf1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 25)
					ke.consume();
			}
		});
		tf2.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextField src = (JTextField) ke.getSource();
				if (src.getText().length() >= 25)
					ke.consume();
			}
		});
		tf3.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				JTextArea src = (JTextArea) ke.getSource();
				if (src.getText().length() >= 100)
					ke.consume();
			}
		});

		getContentPane().add(p);
		p.setBackground(c1);
		p.add(l);

		p.add(bback);
		group.add(rb1);
		group.add(rb2);
		p.add(rb1);
		p.add(rb2);

		p.add(jl1);
		p.add(jl2);
		p.add(jl3);
		p.add(jl4);
		p.add(tf1);
		p.add(tf2);
		p.add(datePicker);
		p.add(tf3);

		// 사진 첨부 버튼
		btnNewButton.setBounds(320, 775, 95, 30);
		btnNewButton.setFont(f4);

		// 기본 사진
		JLabel lbl = new JLabel();
		lbl.setBackground(new Color(255, 255, 255));
		ImageIcon icon = new ImageIcon(lost.class.getResource("../image/white.png"));
		lbl.setIcon(icon);
		lbl.setBounds(320, 105, 200, 200);

		// 기본 사진 비율 맞추기
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		lbl.setIcon(changeIcon);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// 파일 열어 사진 가져오기
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String filename = f.getAbsolutePath();
				Image getAbsolutePath = null;
				ImageIcon icon = new ImageIcon(filename);

				// 사진 비율 맞추기
				Image img = icon.getImage();
				Image changeImg = img.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon changeIcon = new ImageIcon(changeImg);
				lbl.setIcon(changeIcon);

			}
		});

		p.add(lbl);
		p.add(btnNewButton);

		// 등록하기 버튼
		RoundedButton btnNewButton_1 = new RoundedButton("등록하기");
		btnNewButton_1.setBounds(430, 775, 95, 30);
		btnNewButton_1.setFont(f4);
		btnNewButton.paintComponents(getGraphics());
		btnNewButton_1.addActionListener(e -> {

			if (tf1.getText().equals("예) 에어팟, 검정색 카드"))
				DialogMsg.showMessageDialog("물건을 입력해주세요.");
			else if (tf2.getText().equals("예) 응용3실, 체육관"))
				DialogMsg.showMessageDialog("장소를 입력해주세요.");
			else if (tf3.getText().equals("예) 강아지 스티커가 붙어 있어요"))
				DialogMsg.showMessageDialog("기타를 입력해주세요.");
			else if (lbl.getIcon().equals(changeIcon))
				DialogMsg.showMessageDialog("사진을 등록해주세요.");
			else {
				DialogMsg.showMessageDialog("글이 등록되었습니다.");
				Db.insertItem(check, tf1.getText(), tf2.getText(), datePicker.getComponentDateTextField().getText(),
						tf3.getText());
				dispose();
			}

		});

		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		p.add(btnNewButton_1);

		setTitle("Lost & Found");
		setSize(600, 900);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Registration().setVisible(true);

	}

}