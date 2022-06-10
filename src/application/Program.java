package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner key = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = key.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + " data: ");
            System.out.print("Common, used or imported (c/u/i)? ");
            char response = key.next().charAt(0);

            key.nextLine();
            System.out.print("Name: ");
            String name = key.nextLine();

            System.out.print("Price: ");
            double price = key.nextDouble();

            if (response == 'c') {
                list.add(new Product(name, price));
            } else if (response == 'u') {
                System.out.print("Customs fee: ");
                System.out.print("Manufacture date: ");
                Date date = sdf.parse(key.next());
                list.add(new UsedProduct(name, price, date));
            } else {
                System.out.print("Customs fee: ");
                double customsFee = key.nextDouble();
                list.add(new ImportedProduct(name, price, customsFee));
            }

        }

        System.out.println();
        System.out.println("PRICE TAGS: ");
        for (Product prod : list) {
            System.out.println(prod.priceTag());
        }
        key.close();
    }
}