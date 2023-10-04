package app004_drawing;

import javax.swing.*;
import java.awt.*;

public class GraphPlotter extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final double SCALE = 50.0;

    public GraphPlotter() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGraph(g);
    }

    private void drawGraph(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);

        double minX = -Math.PI;
        double maxX = Math.PI;
        double xIncrement = 0.1;

        int prevX = 0;
        int prevY = (int) (Math.sin(minX) * SCALE + HEIGHT / 2);

        for (double x = minX + xIncrement; x <= maxX; x += xIncrement) {
            int currentX = (int) (x * SCALE + WIDTH / 2);
            int currentY = (int) (-Math.sin(x) * SCALE + HEIGHT / 2);

            g2d.drawLine(prevX, prevY, currentX, currentY);

            prevX = currentX;
            prevY = currentY;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Graph Plotter");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GraphPlotter graphPlotter = new GraphPlotter();
                frame.add(graphPlotter);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
