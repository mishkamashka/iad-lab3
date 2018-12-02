
import org.hibernate.Session;

import java.util.LinkedList;

public class AreaChecker {
    private LinkedList<Point> points = new LinkedList<>();
    private double x = 0.0;
    private double y = 2.0;
    private double r = 4.0;
    private boolean ischeck;

    public void setR(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    private void setIscheck() {
        double X = x / 10;
        double Y = y;
        double R = r / 2;
        if (X <= 0 && Y >= 0 && X * X + Y * Y <= R * R) {
            ischeck = true;
            return;
        }
        if (X >= 0 && Y >= 0 && Y <= (-1 * X + R)) {
            ischeck = true;
            return;
        }
        if (X <= 0 && Y <= 0 && X <= (R / 2) && Y >= -R) {
            ischeck = true;
            return;
        }
        ischeck = false;
    }

    public boolean getIsCheck() {
        setIscheck();
        return ischeck;
    }

    public void newPoint() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Point p = new Point(getR(), getX(), getY(), getIsCheck());
        setPoint(p);
        session.save(p);
        session.getTransaction().commit();
    }

    private void setPoint(Point p) {
        points.add(p);
    }

    public LinkedList<Point> getPoints() {
        return points;
    }

}
