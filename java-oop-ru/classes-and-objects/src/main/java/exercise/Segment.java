package exercise;

// BEGIN
public class Segment {

    private Point beginPoint;
    private Point endPoint;
    private Point midPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;
        this.midPoint = calcMidPoint(beginPoint.getX(), beginPoint.getY(), endPoint.getX(), endPoint.getY());
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        return midPoint;
    }

    private Point calcMidPoint(int xBegin, int yBegin, int xEnd, int yEnd) {
        var xMid = (xBegin + xEnd) / 2;
        var yMid = (yBegin + yEnd) / 2;

        return new Point(xMid, yMid);
    }
}
// END
