// Файл RecursiveH.java
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class RecursiveH extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int DELAY = 500; // Задержка между появлением каждой буквы H

    public RecursiveH() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.white);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawH(g, WIDTH / 2, HEIGHT / 2, Math.min(WIDTH, HEIGHT) / 4); // Рисуем центральную H
        drawCornerH(g, 0, 0, Math.min(WIDTH, HEIGHT) / 8, 5); // Рисуем пять меньших H в углу
    }

    private void drawH(Graphics g, int x, int y, int size) {
        g.drawLine(x - size, y - size, x - size, y + size);
        g.drawLine(x + size, y - size, x + size, y + size);
        g.drawLine(x - size, y, x + size, y);
    }

    private void drawCornerH(Graphics g, int x, int y, int size, int count) {
        if (count <= 0) return;
        drawH(g, x, y, size);
        try {
            Thread.sleep(DELAY); // Пауза для анимации
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        drawCornerH(g, x, y + size * 2, size / 2, count - 1); // Рисуем следующую H
    }
}
