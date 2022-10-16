package com.company;
import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class MyFrame extends JPanel implements ActionListener {
    public JFrame frame = new JFrame("Windows XP");
    public JPanel panel = new JPanel();
    int x = 20;
    public JLabel background = new JLabel(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/windowsbackground.jpeg"));
    ImageIcon scaledInternet = new ImageIcon(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/internet.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    ImageIcon scaledFileExp = new ImageIcon(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/fileexplorer.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    public JButton internetExp = new JButton(scaledInternet);
    public JButton fileExp = new JButton(scaledFileExp);
    ArrayList<JPanel> arrPan = new ArrayList<>();

    public void setFrame() {
        frame.setLayout(new BorderLayout());
        frame.add(background);
        frame.setSize(1600, 900);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(background);
        frame.setVisible(true);
    }

    public void setPanel() {
        frame.add(panel, BorderLayout.EAST);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setSize(75, 900);
        panel.add(internetExp);
        panel.add(fileExp);
        panel.setOpaque(false);
        internetExp.addActionListener(this);
        internetExp.setBackground(null);
        internetExp.setBorder(null);
        fileExp.addActionListener(this);
        fileExp.setBackground(null);
        fileExp.setBorder(null);
        //button array forloop?
    }

    public void createNewWindow() {
        Random rand = new Random();
        JPanel panel2 = new JPanel();
        panel2.setSize(500, 500);
        panel2.setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        panel2.setLocation(rand.nextInt(255), rand.nextInt(255));
        drawerFromArray();
        arrPan.add(panel2);
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == internetExp) {
            createNewWindow();
            //make if pressed, and then reorder array based on that
        }
    }
    public void drawerFromArray() {
            for (int i = 0; i < arrPan.size(); i++) {
                frame.add(arrPan.get(i));
                frame.pack();
                repaint();
            }
    }
}

