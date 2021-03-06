package com.chainsys.product.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;
import com.chainsys.product.service.ProductService;
import com.chainsys.product.service.ProductServiceImpl;

public class ProductClient {
	public static void main(String[] args) {

		Set<Product> productSet;
		ProductService service = new ProductServiceImpl();
		String date;
		DateTimeFormatter dateFormat;
		int id;
		String name;
		System.out.println("Enter the choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Find All Products");
			productSet = service.findAll();
			System.out.println(productSet);
			break;
		case 2:
			System.out.println("Find the Product By Id");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				Product product = service.findById(id);
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
		case 3:
			System.out.println("Update the Product Name Based on the Id");
			date = "06/05/2019";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product updateProduct = new Product(4, "Pencil", LocalDate.parse(date, dateFormat));
			try {
				service.update(updateProduct);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {

			}
			break;
		case 4:
			System.out.println("Adding a Product");
			date = "06/05/2019";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product newProduct = new Product(4, "Pencil", LocalDate.parse(date, dateFormat));
			service.save(newProduct);
			productSet = service.findAll();
			System.out.println(productSet);
			break;
		case 5:
			System.out.println("Deleting a Product");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				service.delete(id);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
		case 6:
			System.out.println("Find product by name");
			name = scanner.next();
			try {
				Product product = service.findByName(name);
				System.out.println(product);
			} catch (Exception e) {
			}
			break;
		case 7:
			System.out.println("Update the expiry date by Id");
			id=scanner.nextInt();
			date = "10/08/2021";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product updatedate = new Product(id, "Pencil", LocalDate.parse(date, dateFormat));
			try {
				service.updateexpire(updatedate);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {

			}
			break;
		case 8:
			System.out.println("Deleting a Product");
			System.out.println("Enter the Product Name");
			name = scanner.next();
			try {
				service.delete(name);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (Exception e) {
			}
			break;
		case 9:
			System.out.println("Deleting a Product");
			date = "01/01/23";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			try {
				service.delete_date(LocalDate.parse(date,dateFormat));
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (Exception e) {
			}
			break;
		case 10:
			System.out.println("Find product by name");
			date = "10/08/2021";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			try {
				Product product = service.findBydate(LocalDate.parse(date,dateFormat));
				System.out.println(product);
			} catch (Exception e) {
			}
			break;
		default:
			break;
		}
		scanner.close();
	}

}
