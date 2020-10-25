package nl.avd.dvo.sportcanteen.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class RegisterTextIO {

    public static HashMap<String, Double> readProducts(String fileName){
        HashMap<String, Double> products = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()){
                String productLine = scanner.nextLine();
                String[] parts = productLine.split(";");

                NumberFormat format = NumberFormat.getInstance(Locale.getDefault());
                double price = format.parse(parts[1]).doubleValue();
                products.put(parts[0], price);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (ParseException e) {
            System.out.println("Format of the file incorrect");
        }

        return products;
    }

    public static void writeSales(String fileName, HashMap<String, Integer> sales){
        try (PrintWriter printWriter = new PrintWriter(new File(fileName))) {
            sales.forEach((product, count) ->
                    printWriter.println(product + ";" + count));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
