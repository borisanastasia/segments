package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    private final Point start;

    private final Point end;

    public Segment(Point start, Point end) {
        if (start == null || end == null || start.equals(end)) {
            throw new IllegalArgumentException("Incorrect incoming parameters");
        }

        this.start = start;
        this.end = end;
    }

    public double length() {
        double diffX = end.getX() - start.getX();
        double diffY = end.getY() - start.getY();

        return Math.sqrt(diffX * diffX + diffY * diffY);
    }

    public Point middle() {
        return new Point((start.getX() + end.getX()) / 2, (start.getY() + end.getY()) / 2);
    }

    public Point intersection(Segment segment2) {
        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double x2 = this.end.getX();
        double y2 = this.end.getY();

        double x3 = segment2.start.getX();
        double y3 = segment2.start.getY();
        double x4 = segment2.end.getX();
        double y4 = segment2.end.getY();

        double v = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        double t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / v;
        double u = ((x1 - x3) * (y1 - y2) - (y1 - y3) * (x1 - x2)) / v;

        if (t >= 0 && t <= 1 && u >= 0 && u <= 1) {
            return new Point(x1 + t*(x2-x1), y1 + t*(y2-y1));
        }

        return null;
    }

}

