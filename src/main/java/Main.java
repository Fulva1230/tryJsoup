import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout layout = new FlowLayout();
        JButton button = new JButton("click me");
        JTextArea texts = new JTextArea();
        button.addActionListener((event)->LineStickerCatcher.catchLineSticker(texts));
        frame.setLayout(layout);
        frame.add(button);
        frame.add(texts);
        frame.setVisible(true);
    }
}
