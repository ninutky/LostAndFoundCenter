package button;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class RoundedButton extends JButton {
	
	public RoundedButton() {
        super();
        decorate();
    }

    public RoundedButton(String text) {
        super(text);
        decorate();
    }

    public RoundedButton(Action action) {
        super(action);
        decorate();
    }

    public RoundedButton(Icon icon) {
        super(icon);
        decorate();
    }

    public RoundedButton(String text, Icon icon) {
        super(text, icon);
        decorate();
    }

    // 기본 모양에 있는 테두리 없앰, 불투명
    protected void decorate() {
        setBorderPainted(false);
        setOpaque(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        Graphics2D graphics = (Graphics2D) g;

        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // isArmed(): 누름, isRollover(): 올림
        if (getModel().isArmed()) {
            graphics.setColor(getBackground().darker());
        } else if (getModel().isRollover()) {
            graphics.setColor(getBackground().brighter());
        } else {
            graphics.setColor(getBackground());
        }

        // 가로, 세로 크기만큼 10의 둥글기
        graphics.fillRoundRect(0, 0, width, height, 10, 10);

        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

        int textX = (width - stringBounds.width) / 2;
        int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

        graphics.setColor(getForeground());
        graphics.setFont(getFont());
        graphics.drawString(getText(), textX, textY);
        graphics.dispose();

        super.paintComponent(g);
    }
}
