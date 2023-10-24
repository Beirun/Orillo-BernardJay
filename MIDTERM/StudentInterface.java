import java.util.Scanner;

public class StudentInterface {
    public static void main(String[] args) {
        Student sOne = new Student();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        sOne.setFirstName(sc.nextLine());
        System.out.print("Enter Middle Name: ");
        sOne.setMiddleName(sc.nextLine());
        System.out.print("Enter Last Name: ");
        sOne.setLastName(sc.nextLine());
        System.out.print("Enter Suffix: ");
        sOne.setSuffix(sc.nextLine());

        System.out.println("First Name: " + sOne.getFirstName());
        System.out.println("Middle Name: " + sOne.getMiddleName());
        System.out.println("Last Name: " + sOne.getLastName());
        System.out.println("Suffix: " + sOne.getSuffix());
        System.out.println("Full Name: " + sOne.getFullName());

    }
}
