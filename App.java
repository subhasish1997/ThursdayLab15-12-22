package Lab1512;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    static String productId, productName;
    static double price;
    static FileWriter fileWriter;

    static {
        try {
           fileWriter = new FileWriter("D:\\details.txt");
        } catch (IOException ignored) { }
    }
    public static void main(String[] args) throws IOException {
        storeProduct();
    }
    static void storeProduct() throws IOException {
        System.out.println("Enter product id: ");
        productId = new Scanner(System.in).next();
        System.out.println("Enter product name: ");
        productName = new Scanner(System.in).nextLine();
        System.out.println("Enter price: ");
        price = new Scanner(System.in).nextDouble();
        try {
            fileWriter.write("\nProduct ID: "+productId);
            fileWriter.write("\tProduct Name: "+productName);
            fileWriter.write("\tPrice: "+price);
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("enter y for add another product, any other character for exit");
        char input = new Scanner(System.in).next().charAt(0);
        if (input == 'Y' || input == 'y') storeProduct();
        else {
            fileWriter.close();
            System.exit(0);
        }
    }
}