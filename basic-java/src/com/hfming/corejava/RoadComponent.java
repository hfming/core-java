package com.hfming.corejava;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
/**
 * @version 1.01 2019-09-19
 * @author hfm
 *
 */
public class RoadComponent extends JComponent {
    private final int DOTSIZE = 2;
    private final int XDOTDIST = 1;
    private Road freeway;
    private BufferedImage buffer;
    private int row;
    private int xsize;
    private int ysize;

    public RoadComponent() {
        freeway = new Road();
        row = 0;
    }

    public void update(double slowdown, double arrival) {
        freeway.update(slowdown, arrival);
        Graphics g;
        if (buffer == null) {
            xsize = getWidth();
            ysize = getHeight();
            if (xsize == 0 || ysize == 0)
                return;
            buffer = new BufferedImage(xsize, ysize, BufferedImage.TYPE_INT_ARGB);
            g = buffer.getGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, xsize, ysize);
        } else
            g = buffer.getGraphics();

        if (row < ysize - 2 * DOTSIZE)
            row += DOTSIZE;
        else {
            g.copyArea(0, DOTSIZE, xsize, ysize - DOTSIZE, 0, -DOTSIZE);
        }
        freeway.paint(g, row, XDOTDIST, DOTSIZE);
        g.dispose();
        repaint();
    }

    public void paintComponent(Graphics g) {
        if (buffer != null)
            g.drawImage(buffer, 0, 0, null);
    }
}


