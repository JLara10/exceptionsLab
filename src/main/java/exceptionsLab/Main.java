package exceptionsLab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        createFile();
        writeFile();
        readFile();
        //numbers();

    }

    public static int numbers() {
        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        int counter = 1;
        while (counter == 1) {
            try {
                System.out.println("Type your numerator please!");
                int numerator = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Type your denominator please!");
                int denominator = scanner.nextInt();

                answer = numerator / denominator;
                //System.out.println("Your answer is: " + answer);
                counter++;
            } catch (ArithmeticException e) {
                System.out.println("You can not divide by zero");

            } catch (InputMismatchException inputMismatchException) {
                System.out.println("You can not type that");
                scanner.next();
            }
        }
        return answer;
    }

    public static void createFile(){

        try {
            File extra = new File("/Users/juan/IdeaProjects/exceptionsLab/src/main/resources/newFile");
            extra.createNewFile();
        } catch (IOException e) {
            System.out.println("doesnt work");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void writeFile(){
        FileWriter writer = null;

            try {
                writer = new FileWriter("/Users/juan/IdeaProjects/exceptionsLab/src/main/resources/newFile");
                writer.write(Integer.toString(numbers()));
            } catch (IOException e) {
                System.out.println(" unable to save");
            }finally {
                try{
                    writer.close();
                } catch (IOException e) {
                    System.out.println(" unable to close");
                }
            }
        }
        public static void readFile(){
        File file = new File("/Users/juan/IdeaProjects/exceptionsLab/src/main/resources/newFile");
        Scanner scanner = null;
        try{
            scanner = new Scanner(file);
            while(scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(scanner != null){
                scanner.close();
                System.out.println("closed the dam scanner yay!");
            }
        }
        }
    }

