import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;

public class HomeAutomationApp {

    public static void main(String args[]) {
        // Set look and feel to Nimbus for better appearance
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Home Automation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 3, 20, 20)); // Grid layout with 2 rows and 3 columns
        panel.setBorder(new EmptyBorder(20, 20, 20, 20)); // Add padding

        JToggleButton light1 = createToggleButton("Light 1");
        JToggleButton light2 = createToggleButton("Light 2");
        JToggleButton tv = createToggleButton("TV");
        JToggleButton fan = createToggleButton("Fan");
        JToggleButton ledStrip = createToggleButton("LED Strip");

        // Add item listeners
        addToggleListener(light1, "L1");
        addToggleListener(light2, "L2");
        addToggleListener(tv, "TV");
        addToggleListener(fan, "Fan");
        addColorPickerListener(ledStrip, "LedStrip");

        panel.add(light1);
        panel.add(light2);
        panel.add(tv);
        panel.add(fan);
        panel.add(ledStrip);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void addToggleListener(JToggleButton button, String device) {
        button.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    button.setText(device + "\n ON");
                    button.setForeground(Color.WHITE);
                    button.setBackground(new Color(51, 153, 255));
                } else {
                    button.setText(device + "\n OFF");
                    button.setForeground(Color.BLACK);
                    button.setBackground(new Color(240, 240, 240));
                }
                // Simulate sending state to the server
                // sendStateToServer(device, itemEvent.getStateChange() == ItemEvent.SELECTED ? "ON" : "OFF");
            }
        });
    }

    private static void addColorPickerListener(JToggleButton button, String device) {
        button.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    Color color = JColorChooser.showDialog(button, "Choose Color", Color.WHITE);
                    if (color != null) {
                        button.setBackground(color);
                        // Simulate sending color to the server
                        // sendColorToServer(device, color);
                    }
                }
            }
        });
    }

    private static JToggleButton createToggleButton(String text) {
        JToggleButton button = new JToggleButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBorderPainted(false); // Remove border
        button.setFocusPainted(false);
        return button;
    }
}
