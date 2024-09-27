import ProductModels.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyword = new Scanner(System.in);
        boolean running = true;
        System.out.println("Ingresa el valor de tu tarjeta de crédito");
        int targetValue = keyword.nextInt();
        List<Product> productList = new ArrayList<>();

        while(running) {
            System.out.println("""
                    Escoge una de las siguientes opciones:
                    0. Si deseas salir.
                    1. Si deseas hacer compras.
                    2. Si deseas consultar tu saldo.
                    3. Si quieres consultar productos.
                    
                    """);

            int userInput = keyword.nextInt();
            switch (userInput) {
                case 0 -> {
                    System.out.println("Has comprado" + productList);
                    System.out.println("tu saldo es " + targetValue);
                    System.out.println("exiting...");
                    running = false;
                }
                case 1 -> {
                    System.out.println("Escribe el nombre del producto que deseas comprar");
                    keyword.nextLine();
                    String productName = keyword.nextLine();
                    System.out.println("Ingresa el valor del producto comprado");
                    int productPrice = keyword.nextInt();
                    keyword.nextLine();

                    if(productPrice > targetValue) {
                        System.out.println("************************");
                        System.out.println("No tienes suficiente saldo");
                        Collections.sort(productList);
                        System.out.println("Tus compras fueron " + productList);
                        System.out.println("Tu saldo es " + targetValue);
                        System.out.println("Exiting...");
                        running = false;
                    } else {
                            Product product = new Product(productName, productPrice);
                            productList.add(product);
                            System.out.println("***********************");
                            Collections.sort(productList);
                            System.out.println("Productos en la canasta " + productList);
                            targetValue -= productPrice;
                            System.out.println("Tu saldo restante es " + targetValue);

                    }
                }
                case 2 -> {
                    System.out.println("Tu saldo es " + targetValue);
                }
                case 3 -> {
                    System.out.println("Has comprado los siguientes productos: " + productList);
                }
                default -> {
                    System.out.println("Has ingresado una opción que no es válida");
                }
            }
        }

    }
}