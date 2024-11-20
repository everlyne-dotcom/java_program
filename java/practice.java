import java.util.Scanner;
public class practice{
    
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        while (true) { 
            System.out.println("Select a shape to display:");
            System.out.println("A. Rectangle");
            System.out.println( "B. Circle");
            System.out.println("C. Triangle");
            System.out.println("E. Exit");
            System.out.println("Enter your choice: ");

            String choice = scanner.next().toUpperCase();

            switch (choice) {
                case "A"->displayRectangle(scanner);

                case "B"->displayCircle(scanner);

                case "C"->displayTriangle(scanner);

                case "E"-> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }

                default-> System.out.println("Invalid choice. Please try again");
                    
                
            }
            
        }
    }

    private static void displayRectangle(Scanner scanner) {
     System.out.println("Enter the length of the rectangle (between 1 and 20):");
     int length = scanner.nextInt();

     while (length <1 || length > 20) {
        System.out.print("Invalid length. Please enter a value between 1 and 20: ");
        length = scanner.nextInt();
     }
     System.out.print("Enter the width of the rectangle(between 1 and 20:)");
     int width = scanner.nextInt();

     while (width <1 || width > 20){
        System.out.print("Invalid width. Please enter a value between 1 and 20: ");
        width = scanner.nextInt();
     }
     for (int i = 0; i< length; i++) {
        for (int j =0; j<width; j++){
            System.out.print("* ");
        }
        System.err.println();
     }

    }

    private static void displayCircle(Scanner scanner) {
        System.out.print("Enter the radius of the circle between 1 and 20: ");
        int radius = scanner.nextInt();
        
        while ( radius >1 || radius > 10) {
            System.out.print("Invalid radius. Please enter the value between 1 and 20");
            radius = scanner.nextInt();
        }
        for (int i = -radius; i<= radius; i++) {
            for ( int j= -radius; j<=radius; j++){
                if ( i*i+j*j <= radius * radius ){
                    System.out.print("* ");
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
        
    }

    private static void displayTriangle(Scanner scanner) {
    System.out.print("Enter the height of the triangle (between 1 and 10): ");
    int height = scanner.nextInt();

    while (height <1 ||height >10) {
        System.out.print("Invalid height. Please enter a value between 1 and 10");
        height = scanner.nextInt();
    }

    for (int i = 0; i<height; i++){
        for ( int j=0; j <=i; j++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    }
}