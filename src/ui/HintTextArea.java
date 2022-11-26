package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextArea;

public class HintTextArea extends JTextArea {

	Font gainFont = new Font("KoPubµ¸¿òÃ¼ Medium", Font.PLAIN, 20);

	public HintTextArea(final String hint) {
		setText(hint);
		setFont(gainFont);
		setForeground(Color.GRAY);

		this.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (getText().equals(hint)) {
					setText("");
					setFont(gainFont);
				} else {
					setText(getText());
					setFont(gainFont);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (getText().equals(hint) || getText().length() == 0) {
					setText(hint);
					setFont(gainFont);
					setForeground(Color.GRAY);
				} else {
					setText(getText());
					setFont(gainFont);
					setForeground(Color.BLACK);

				}
			}
		});
	}
}
