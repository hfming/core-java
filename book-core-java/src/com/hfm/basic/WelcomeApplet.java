package com.hfm.basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 此applet显示作者的问候语。
 *
 * @author Cay Horstmann
 * @version 1.22 2007-04-08
 */
public class WelcomeApplet extends JApplet {

    @Override
    public void init() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setLayout(new BorderLayout());

                JLabel label = new JLabel(getParameter("greeting"), SwingConstants.CENTER);
                label.setFont(new Font("Serif", Font.BOLD, 18));
                add(label, BorderLayout.CENTER);

                JPanel panel = new JPanel();

                JButton cayButton = new JButton("Cay Horstmann");
                cayButton.addActionListener(makeAction("http://www.horstmann.com"));
                panel.add(cayButton);

                JButton garyButton = new JButton("Gary Cornell");
                garyButton.addActionListener(makeAction("mailto:gary_cornell@apress.com"));
                panel.add(garyButton);

                add(panel, BorderLayout.SOUTH);
            }
        });
    }

    private ActionListener makeAction(final String urlString) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    getAppletContext().showDocument(new URL(urlString));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
