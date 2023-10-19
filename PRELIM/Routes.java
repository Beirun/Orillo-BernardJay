import java.util.Scanner;
public class Routes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Barili, Dumanjug = "";
        String Route = "\tCebu City\t\tSTART\n\tMingla\t\t\tRoute 1\n\tSan Fernando\tRoute 2\n\tCarcar\t\t\tRoute 3";

        System.out.print("Input the speed: ");
        double speed = sc.nextDouble();
        sc.nextLine();
        double distance;

        System.out.print("Is Barili Obstructed? (Yes or No?)->");
        Barili = sc.nextLine().trim();
        if(Barili.equalsIgnoreCase("yes")) {
            System.out.print("Is Dumanjug Obstructed? (Yes or No?)->");
            Dumanjug = sc.nextLine().trim();
        }
        if(Barili.equalsIgnoreCase("yes") && Dumanjug.equalsIgnoreCase("yes")) {
            Route += "\n\tSibonga\t\t\tRoute 4\n\tArgao\t\t\tRoute 5\n\tRonda\t\t\tRoute 5.1\n\tAlcantara\t\tRoute 5.2";
            distance = 110;
        } else if(Dumanjug.equalsIgnoreCase("no")){
            Route += "\n\tSibonga\t\t\tRoute 4.2\n\tDumanjug\t\tRoute 4.2.1\n\tAlcantara\t\tRoute 4.2.2";
            distance = 103;
        } else {
            Route += "\n\tBarili\t\t\tRoute 4.1\n\tDumanjug\t\tRoute 4.1.1\n\tAlcantara\t\tRoute 4.1.2";
            distance = 88.2;
        }
        Route += "\n\tMoalboal\t\tEND";
        System.out.println("\nOutput: ");
        System.out.println("Recommended Route:\n" + Route);
        System.out.println("Speed: "+speed+" km/hrs.");
        System.out.println("distance: " + distance+" km.");
        System.out.println("Estimated Time of Arrival: " + hour(distance, speed) + " hour(s) " +
                (int) minute(distance, speed) + " minute(s) "+ second(distance, speed)+" second(s).");
    }
    static int hour(double distance, double speed){
        return  (int) (distance/speed);
    }
    static double minute(double distance, double speed){
         return ((distance/speed - Math.floor(distance/speed))*60);
    }
    static int second(double distance, double speed){
        return (int)(( minute(distance, speed) - Math.floor(minute(distance, speed)))*60);
    }
}
