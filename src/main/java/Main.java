import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.CENTER);
        layout.setAlignOnBaseline(true);
        JButton button = new JButton("click me");
        JTextArea texts = new JTextArea();
        button.addActionListener((event) -> LineStickerCatcher.catchLineSticker(texts));
        JPanel panel = new JPanel();
        panel.add(button);
        frame.setLayout(layout);
        frame.add(panel);
        frame.add(texts);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
