package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    private int deltaX = 5;
    private int deltaY = 5;
    private int maxX;
    private int maxY;

    public RectangleMove(Rectangle rect, int maxX, int maxY) {
        this.rect = rect;
        this.maxX = maxX;
        this.maxY = maxY;
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            this.rect.setX(this.rect.getX() + deltaX);
            this.rect.setY(this.rect.getY() + deltaY);
            try {
                Thread.sleep(50);
                if (this.rect.getX() >= maxX || this.rect.getX() <= 0) {
                    deltaX = -deltaX;
                }
                if (this.rect.getY() >= maxY || this.rect.getY() <= 0) {
                    deltaY = -deltaY;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}