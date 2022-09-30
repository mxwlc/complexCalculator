import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static double input_double(){
        double result;
        while(true){
            Scanner input = new Scanner(System.in);
            try{
                result = Double.parseDouble(input.next());
                return result;
            }
            catch (NumberFormatException ignore){
                System.out.println("Invalid input type");
            }
        }
    }
    public static complexNumber inputComplexNumber() {
        System.out.println("Input the real component: ");
        double real = input_double();

        System.out.println("Input the imaginary component: ");
        double imaginary = input_double();

        return new complexNumber(real, imaginary);

    }

    public static String choices() {
        String choice;
        String[] validArray = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        ArrayList<String> validChoices = new ArrayList<>(Arrays.asList(validArray));
        do {
            System.out.println("""
                    Do you want to
                    1. Add two complex numbers
                    2. Subtract two complex numbers
                    3. Multiply either two complex numbers or multiply a complex number by a scalar
                    4. Divide either two complex numbers or divide one complex number by a scalar
                    5. Get the modulus of a complex number
                    6. Get the argument of a complex number (in radians)
                    7. Get a complex number in polar form
                    8. Get a complex number in trigonometric form
                    9. Square a complex number
                    0. Find the complex conjugate
                    """);
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter choice: ");
            choice = input.nextLine();
        } while (!validChoices.contains(choice));

        return choice;
    }

    public static void add() {
        System.out.println("""
                v = z + w
                Please input complex number z:
                """);
        complexNumber z = inputComplexNumber();

        System.out.println("Please input complex number w:\n");
        complexNumber w = inputComplexNumber();

        System.out.println("The result is\n" + complexNumber.addition(z, w));

    }

    public static void subtract() {
        System.out.println("""
                v = z - w
                Please input complex number z:
                """);
        complexNumber z = inputComplexNumber();

        System.out.println("Please input complex number w:\n");
        complexNumber w = inputComplexNumber();

        System.out.println("The result is\n" + complexNumber.subtraction(z, w));
    }

    public static void multiply_by_complex() {
        System.out.println("""
                v = w x z;
                Please input complex number z:
                """);
        complexNumber z = inputComplexNumber();

        System.out.println("Please input complex number w:\n");
        complexNumber w = inputComplexNumber();

        System.out.println("The result is\n" + complexNumber.multiplication(z, w));
    }

    public static void multiply_by_scalar() {
        System.out.println("""
                w = l x z;
                Please input complex number z:
                """);
        complexNumber z = inputComplexNumber();

        System.out.println("Please input scalar l\n");
        double scalar = input_double();

        System.out.println("The result is\n" + complexNumber.multiplication(z, scalar));
    }

    public static void divide_by_complex() {
        System.out.println("""
                v = z/w
                Please input complex number z:
                """);
        complexNumber z = inputComplexNumber();

        System.out.println("Please input complex number w:\n");
        complexNumber w = inputComplexNumber();

        System.out.println("The result is\n" + complexNumber.division(z, w));
    }

    public static void divide_by_scalar() {
        System.out.println("""
                w = z/l;
                Please input complex number z:
                """);
        complexNumber z = inputComplexNumber();

        System.out.println("Please input scalar l\n");
        double scalar = input_double();

        System.out.println("The result is\n" + complexNumber.division(z, scalar));
    }

    public static void modulus() {
        System.out.println("""
                |z|
                Please input complex number z:
                """);

        complexNumber z = inputComplexNumber();

        System.out.println("The result is\n" + z.modulus());
    }

    public static void argument() {
        System.out.println("""
                arg(z)
                Please input complex number z:
                """);

        complexNumber z = inputComplexNumber();

        System.out.println("The result is\n" + z.argument());
    }

    public static void polar_form() {
        System.out.println("""
                z = re^i*theta
                Please input complex number z:
                """);

        complexNumber z = inputComplexNumber();

        System.out.println("The result is\n" + z.polar_form());
    }

    public static void trigonometric_form() {
        System.out.println("""
                z = r(cos theta + isin theta)
                Please input complex number z:
                """);

        complexNumber z = inputComplexNumber();

        System.out.println("The result is\n" + z.trigonometric_form());
    }

    public static void square() {
        System.out.println("""
                z^2
                Please input complex number z:
                """);

        complexNumber z = inputComplexNumber();

        System.out.println("The result is\n" + complexNumber.square(z));
    }

    public static void multiply() {
        String choice;
        do {
            System.out.println("""
                    1. v = z * w
                    2. w = lz
                    """);

            Scanner input = new Scanner(System.in);
            choice = input.nextLine();
        } while (!Objects.equals(choice, "1") && !Objects.equals(choice, "2"));

        if (choice.equals("1")) {
            multiply_by_complex();
        } else {
            multiply_by_scalar();
        }
    }

    public static void divide() {
        String choice;
        do {
            System.out.println("""
                    1. v = z / w
                    2. w = z / l
                    """);

            Scanner input = new Scanner(System.in);
            choice = input.nextLine();
        } while (!Objects.equals(choice, "1") && !Objects.equals(choice, "2"));
        if (choice.equals("1")) {
            divide_by_complex();
        } else {
            divide_by_scalar();
        }
    }

    public static void complex_conjugate() {
        System.out.println("""
                z = a + ib
                z* = a - ib
                Please input complex number z:
                """);

        complexNumber z = inputComplexNumber();

        System.out.println("The result is\n" + z.complex_conjugate());
    }

    public static void main(String[] args) {
        String repeat;
        boolean again = true;
        do {
            String choice = choices();

            if (Objects.equals(choice, "1")) {
                add();
            }
            if (Objects.equals(choice, "2")) {
                subtract();
            }
            if (Objects.equals(choice, "3")) {
                multiply();
            }
            if (Objects.equals(choice, "4")) {
                divide();
            }
            if (Objects.equals(choice, "5")) {
                modulus();
            }
            if (Objects.equals(choice, "6")) {
                argument();
            }
            if (Objects.equals(choice, "7")) {
                polar_form();
            }
            if (Objects.equals(choice, "8")) {
                trigonometric_form();
            }
            if (Objects.equals(choice, "9")) {
                square();
            }
            if (Objects.equals(choice, "0")) {
                complex_conjugate();
            }
            do {
                Scanner input = new Scanner(System.in);
                System.out.println("Do you want to run the calculator again (y/n)");
                repeat = input.nextLine();

            } while (!Objects.equals(repeat, "y") && !Objects.equals(repeat, "Y") && !Objects.equals(repeat, "n") && !Objects.equals(repeat, "N"));
            if (repeat.equals("n") || repeat.equals("N")) {
                again = false;
            }
        } while (again);
    }
}