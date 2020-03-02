package practiceExc;

public class Rectangle {
	float Length;
	float Breadth;
	double Area;
// no parameters
	public Rectangle() {
		Length = Breadth =  0;
		Area = Length * Breadth;
		System.out.println("Area of Rectangle is "+ Area);
	}
//two parameters
	public Rectangle(float length ,float breadth) {
		Length = length;
		Breadth = breadth;
		Area = Length * Breadth;
		System.out.println("Area of Rectangle with length and breadth is "+Area);
	}
//single parameter
	public Rectangle(float value) {
		Length = Breadth = value;
		Area = Length * Breadth;
		System.out.println("Area of Rectangle with same length and breadth is "+Area);
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle a1 = new Rectangle();
		Rectangle a2 = new Rectangle(4,8);
		Rectangle a3 = new Rectangle(6);
	}

}
