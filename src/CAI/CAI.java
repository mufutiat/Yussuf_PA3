package CAI;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CAI {
    private static DecimalFormat df = new DecimalFormat("0.00");
    static double answer;
    static boolean validate = true;
    static int level;
    static int num1, num2;
    static int arith;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        String question = "";
        double cnt1 = 0;
        double cnt2 = 0;
        int i;
        while(validate){
            System.out.print("Please choose a difficulty level between 1 and 4: ");
            level = scan.nextInt();
            System.out.println("\nPlease choose the type of arithmetic problem you wish to study.");
            System.out.print("'1' for addition, '2' for multiplication, '3' for subtraction, '4' for division and '5' for all types: ");
            arith = scan.nextInt();
            System.out.println();
            for(i = 0; i < 10; i++) {
                question = getQuestion();
                System.out.print(question + ": ");
                double input = scan.nextDouble();

                if (input == answer || (input > answer && input < (answer+1))){
                    validate = true;
                    cnt1++;
                    display();
                } else {
                    validate = false;
                    cnt2++;
                    display();
                }
            }
            double fraction = cnt1/(cnt1+cnt2);
            double percentage = fraction * 100;

            System.out.println();
            System.out.println("Correct responses: " +cnt1+ ", Incorrect responses: " +cnt2);
            if(percentage < 75.00){
                System.out.println("Please ask your teacher for extra help.");
                System.out.println();
            }
            else{
                System.out.println("Congratulations, you are ready to go to the next level!");
                System.out.println();
            }
            System.out.print("Do you wish to begin a new session? Y or N: ");
            char choice = scan.next().charAt(0);
            System.out.println();

            if(choice == 'N')
                validate = false;
            else
                validate = true;
            cnt1 = 0;
            cnt2 = 0;
        }
    }

    public static String getQuestion() {
        SecureRandom sr = new SecureRandom();

        switch (level) {
            case 1:
                num1 = sr.nextInt(9) + 1;
                num2 = sr.nextInt(9) + 1;
                break;
            case 2:
                num1 = sr.nextInt(89) + 10;
                num2 = sr.nextInt(89) + 10;
                break;
            case 3:
                num1 = sr.nextInt(900) + 100;
                num2 = sr.nextInt(900) + 100;
                break;
            case 4:
                num1 = sr.nextInt(9999) + 1000;
                num2 = sr.nextInt(9999) + 1000;
                break;
        }

        int choice;
        if(arith == 5){
            choice  = sr.nextInt(4) + 1;
        }else
            choice = arith;

        String q = null;
        switch (choice) {
            case 1:
                answer = num1 + num2;
                q = "How much is " + num1 + " plus " + num2;
                break;
            case 2:
                answer = num1 * num2;
                q = "How much is " + num1 + " times " + num2;
                break;
            case 3:
                answer = num1 - num2;
                q = "How much is " + num1 + " minus " + num2;
                break;
            case 4:
                answer = (double)num1 / (double)num2;
                q = "How much is " + num1 + " divided by " + num2;
                break;
        }
        return q;
    }

    public static void display(){
        SecureRandom scr = new SecureRandom();
        int num = scr.nextInt(4)+ 1;

        if(validate) {
            switch (num) {
                case 1:
                    System.out.println("Very Good!");
                    break;
                case 2:
                    System.out.println("Excellent!");
                    break;
                case 3:
                    System.out.println("Nice work!");
                    break;
                case 4:
                    System.out.println("Keep up the good work!");
                    break;
            }
        }
        else{
            switch(num){
                case 1:
                    System.out.println("No. Please try again.");
                    break;
                case 2:
                    System.out.println("Wrong. Try once more.");
                    break;
                case 3:
                    System.out.println("Don't give up!");
                    break;
                case 4:
                    System.out.println("No. Keep trying.");
                    break;
            }
        }
    }
}

