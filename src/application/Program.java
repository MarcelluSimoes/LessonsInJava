package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> product = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			System.out.println("Product #" +(i+1)+" data:");
			System.out.print("Common, used or imported (c/u/i)?" );
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			sc.nextLine();
			
			switch(ch) {
			case 'c':
				Product common = new Product(name, price);
				product.add(common);
				break;
				
			case 'u':
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				System.out.print("Manufactured Date (DD/MM/YYYY): ");
				Date data = sdf.parse(sc.nextLine());
				
				Product used = new UsedProduct(name, price, data);
				product.add(used);
				break;
				
			case 'i':
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				
				Product imported = new ImportedProduct(name, price, customsFee);
				product.add(imported);
				break;
				
			default:
				System.out.println("Type not exist!");
				i -=1;
				break;
			}
			
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product p : product) {
			System.out.println(p.priceTag());
		}
		
		sc.close();
	}

}
