package qc.veko.easyswing.guihelper;

import qc.veko.easyswing.engine.EasyPanel;

import javax.swing.*;
import java.awt.*;

public class EasyLoadingBar extends JComponent {

    private EasyPanel panel;
    private Color backColor;
    private Color barColor;
    private double pointOnBar;
    private int pourcentage;

    public EasyLoadingBar(EasyPanel panel, int minX, int minY, int maxX, int maxY, Color backColor, Color barColor) {
        this.backColor = backColor;
        this.barColor = barColor;
        this.panel = panel;
        setBounds( minX, minY, maxX, maxY);
    }

    public EasyLoadingBar setBarPoint(int point, int maxPoint) {
        int widthOfBar = this.getWidth() - this.getX();
        pointOnBar = (point / maxPoint) * widthOfBar;
        pourcentage = (point / maxPoint) * 100;
        repaint();
        return this;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1,1);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(backColor);
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        g.setColor(barColor);
        g.fillRect(this.getX(), this.getY(), (int) pointOnBar, this.getHeight());
    }

}
