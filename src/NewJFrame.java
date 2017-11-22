import i18n.GenericButton;
import i18n.LocaleHandler;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class NewJFrame extends JFrame {

    private GenericButton button;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new NewJFrame().setVisible(true));
    }

    public NewJFrame() {

        button = new GenericButton("initLabelHint");
        button.setBounds(100, 80, 80, 30);
        button.addActionListener(e -> LocaleHandler.setLocale(Locale.ITALY));

        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);
        add(button, null);
    }
}
