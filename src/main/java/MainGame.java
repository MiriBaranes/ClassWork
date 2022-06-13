import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MainGame extends BasicPanel {
    private static final String NO_WINNE = "No Winner";
    private int torn;
    private JLabel massage;
    private ArrayList<Button> buttonList;

    public MainGame() {
        super(0, 0, Const.W, Const.H, Color.black, "Game");
        this.torn = 0;
        this.buttonList = new ArrayList<>();
        this.massage = addJLabel("Play", 0, Const.H_TITLE_BUTTON,Const.W, Const.H_TITLE_BUTTON, 20, Color.red);
        addAllButton();
    }

    public String getType() {
        String type;
        if (this.torn % 2 == 0) {
            type = Const.X;
        } else {
            type = Const.O;
        }
        return type;
    }

    public void addAllButton() {
        int y = Const.H_TITLE_BUTTON;
        int x;
        for (int i = 0; i < Const.MAX_SIZE; i++) {
            y = y + Const.H_TITLE_BUTTON;
            x = 0;
            for (int j = 0; j < Const.MAX_SIZE; j++) {
                x += Const.H_TITLE_BUTTON;
                Button button = addButton(x, y, "-");
                buttonList.add(button);
                addActionListener(button);
            }
        }
    }

    public void addActionListener(Button button) {
        button.addActionListener(e -> {
            String type = getType();
            if (button.getLabel().equals("-")) {
                button.setLabel(type);
                String win = winnCheck();
                if (win != null && !win.equals(NO_WINNE)) {
                    this.massage.setText(win + " Is the Winner");
                } else if (win != null) {
                    this.massage.setText(win);
                } else {
                    this.torn++;
                    System.out.println(torn);
                    this.massage.setText(getType() + " torn");
                }
            } else {
                this.massage.setText("Cant! " + type + "Play Again");
            }
            repaint();
        });
    }

    public String win(int[] win1) {
        String win = null;
        if (Arrays.stream(buttonTypeList(win1)).allMatch(buttonList -> buttonList.equals(Const.X))) {
            win = Const.X;
        } else if (Arrays.stream(buttonTypeList(win1)).allMatch(buttonList -> buttonList.equals(Const.O))) {
            win =Const.O;
        }
        return win;
    }

    public String winnCheck() {
        String win = null;
        for (int i = 0; i < Const.WINN.length; i++) {
            win = win(Const.WINN[i]);
            if (win != null) {
                break;
            }
        }
        if (win == null && buttonList.stream().noneMatch(button -> button.getLabel().equals("-"))) {
            win = NO_WINNE;
        }
        return win;
    }

    public String[] buttonTypeList(int[] listIndex) {
        if (listIndex.length==Const.MAX_SIZE) {
            return new String[]{buttonList.get(listIndex[0]).getLabel(), buttonList.get(listIndex[1]).getLabel(), buttonList.get(listIndex[2]).getLabel()};
        }
        else return null;
    }
}
