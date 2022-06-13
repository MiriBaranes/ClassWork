import javax.swing.*;

public class WindowPlay extends JFrame {

    public WindowPlay(int w, int h) {
        this.setSize(w, h);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(new MainGame());
    }

    public static void main(String[] args) {
        WindowPlay basicJFrame=new WindowPlay(Const.W,Const.H);
    }


}

