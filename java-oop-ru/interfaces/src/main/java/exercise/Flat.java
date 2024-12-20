package exercise;

// BEGIN
public class Flat implements Home {
     double area;
     double balconyArea;
     int floor;

    Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return balconyArea + area;
    }

    @Override
    public int compareTo(Home anotherArea) {
        return Double.compare(this.getArea(), anotherArea.getArea());
    }

    @Override
    public String toString() {
        var res = "Квартира площадью " + getArea() + " метров на " + floor + " этаже";
        return res;
    }
}
// END
