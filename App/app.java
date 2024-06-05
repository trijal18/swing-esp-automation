import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import java.awt.GridLayout;

import post.*;



public class app {

    public static void main(String args[]) {
        JFrame frame = new JFrame("Home Automation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel to hold the toggle buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1, 30, 30)); 

        // Toggle buttons for various devices
        JToggleButton light1 = createToggleButton("Light 1");
        JToggleButton light2 = createToggleButton("Light 2");
        JToggleButton tv = createToggleButton("TV");
        JToggleButton fan = createToggleButton("Fan");
        JToggleButton ledStrip = createToggleButton("LED Strip");

        // Add individual item listeners to toggle buttons
        light1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    light1.setOpaque(true);
                    //light1.setBackground(new Color(153, 255, 153));                    System.out.println("Light 1 is turned ON");
                    light1.setText("Light 1\n ON");
                    POST postRequest = new POST("L1", "ON");
                    postRequest.sendPostRequest();

                } else {
                    light1.setOpaque(false);
                    //System.out.println("Light 1 is turned OFF");
                    light1.setText("Light 1\n OFF");
                    POST postRequest = new POST("L1", "OFF");
                    postRequest.sendPostRequest();
                }
            }
        });

        light2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    light2.setOpaque(true);
                    //light2.setBackground(Color.GREEN);
                    //System.out.println("Light 2 is turned ON");
                    light2.setText("Light 2 ON");
                    POST postRequest = new POST("L2", "ON");
                    postRequest.sendPostRequest();
                } else {
                    light2.setOpaque(false);
                    //System.out.println("Light 2 is turned OFF");
                    light2.setText("Light 2\n OFF");
                    POST postRequest = new POST("L2", "OFF");
                    postRequest.sendPostRequest();
                }
            }
        });

        tv.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    tv.setOpaque(true);
                    //tv.setBackground(Color.GREEN);
                    //System.out.println("TV is turned ON");
                    tv.setText("TV\n ON");
                    POST postRequest = new POST("TV", "ON");
                    postRequest.sendPostRequest();
                } else {
                    tv.setOpaque(false);
                    //System.out.println("TV is turned OFF");
                    tv.setText("TV\n OFF");
                    POST postRequest = new POST("TV", "OFF");
                    postRequest.sendPostRequest();
                }
            }
        });

        fan.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    fan.setOpaque(true);
                    //fan.setBackground(Color.GREEN);
                    //System.out.println("Fan is turned ON");
                    fan.setText("Fan\n ON");
                    POST postRequest = new POST("Fan", "ON");
                    postRequest.sendPostRequest();
                } else {
                    fan.setOpaque(false);
                    //System.out.println("Fan is turned OFF");
                    fan.setText("Fan\n OFF");
                    POST postRequest = new POST("Fan", "OFF");
                    postRequest.sendPostRequest();
                }
            }
        });

        ledStrip.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == ItemEvent.SELECTED) {
                    JColorChooser colorChooser= new JColorChooser();
                    Color color=JColorChooser.showDialog(ledStrip, "Choose Colour", null);
                    ledStrip.setOpaque(true);
                    ledStrip.setBackground(color);
                    //System.out.println("LED Strip color: "+color);
                    POST postRequest = new POST("LedStrip", color.toString());
                    postRequest.sendPostRequest();

                } 
            }
        });

        // Add buttons to the panel
        panel.add(light1);
        panel.add(light2);
        panel.add(tv);
        panel.add(fan);
        panel.add(ledStrip);

        // Set panel background color
        panel.setBackground(new Color(240, 240, 240)); // Light gray background

        // Add the panel to the frame
        frame.add(panel);

        frame.pack(); // Adjust frame size based on contents
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

    // Method to create toggle buttons with customized appearance
    private static JToggleButton createToggleButton(String text) {
        JToggleButton button = new JToggleButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
        button.setForeground(Color.black); // Set text color
        button.setOpaque(false); // Set opacity to false by default
        button.setBackground(new Color(51, 153, 255)); // Light blue background
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createEmptyBorder(10, 20, 10, 20))); // Add border and padding
        button.setFocusPainted(false); // Remove focus border
        return button;
    }
}
