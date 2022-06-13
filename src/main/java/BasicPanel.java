import javax.swing.*;
import java.awt.*;

public class BasicPanel extends JPanel {

    public BasicPanel(int x, int y, int w, int h, Color color,String title) {
        this.setBounds(x, y, w, h);
        this.setBackground(color);
        this.addJLabel(title,0,0,w,Const.H_TITLE_BUTTON,30,Color.red);
        init();
    }

    public Button addButton(int x, int y, String title) {
        Button button = new Button(title);
        button.setBounds(x, y, Const.H_TITLE_BUTTON, Const.H_TITLE_BUTTON);
        this.add(button);
        return button;
    }

    public void init() {
        this.setLayout(null);
        this.setDoubleBuffered(true);
        this.setVisible(true);
    }

    public JLabel addJLabel(String title, int x, int y, int w, int h, int size, Color color) {
        JLabel jLabel = new JLabel(title, SwingConstants.CENTER);
        jLabel.setFont(new Font("ariel", Font.BOLD, size));
        jLabel.setForeground(color);
        jLabel.setBounds(x, y, w, h);
        this.add(jLabel);
        return jLabel;
    }
}
