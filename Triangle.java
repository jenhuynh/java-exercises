public class Triangle {
    //declare instance variables
    double area; //double is considered twice the precision of the floating point
    int height;
    int length;

    public static void main (String[] args){
        //declare x to 0
        int x = 0;
        //declare array of triangles
        Triangle[] ta = new Triangle[4];

        while(x < 4) {//area of triangle 1/2 (height * base) or (height * base)/2
         // create instance of triangle
            ta[x] = new Triangle();
            ta[x].height = (x + 1) * 2;
            ta[x].length = x + 4;
            ta[x].setArea();

            System.out.print("triangle "+x+" , area");
            System.out.println(" = " + ta[x].area);
            x = x + 1;
         }
        int y = x;
        x = 27;
    Triangle t5 = ta[2];
    ta[2].area = 343;
    System.out.print("y = " + y);
    System.out.println(", t5 area = "+ t5.area);
}
    void setArea() {
       area = (height * length) / 2;
    }
}
