
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Feature feature = new Feature();
        String description;
        String name;
        int price;
        int quantity;
        int id;

        Product[] products = new Product[5];
        products[0] = new Product(1, "Candy", 5, 100, "sweet candy attractive to children");
        products[1] = new Product(2, "Car", 5000000, 10, "high priced luxury cars");
        products[2] = new Product(3, "Water", 7, 500, "mineral water to rehydrate for a long tiring day");
        products[3] = new Product(4, "Milk", 50, 3000, "milk is good for children and pregnant women");
        products[4] = new Product(5, "Salt", 15, 100, "salt is very salty, suitable for those who eat salty food");
        int choice;
        Product[] products1 = products;
        do {
            System.out.println("Menu:");
            System.out.println("1. Create a new product object and Add it to the array:");
            System.out.println("2. Edit a product of id:");
            System.out.println("3. Delete a product of id:");
            System.out.println("4. Display all product in array:");
            System.out.println("5. Display Products with the highest prices :");
            System.out.println("6. Display Products with the lowest  prices:");
            System.out.println("7. Display Products with the largest quantity:");
            System.out.println("8. Display Products with the least quantity:");
            System.out.println("9. Calculate the total amount of goods:");
            System.out.println("10. Exit");
            choice = input.nextInt();
            Product product;
            switch (choice) {
                case 1:
                    //Thêm các thông tin cho new product
                    System.out.println("Enter id: ");
                    id = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter name: ");
                    name = input.nextLine();
                    System.out.println("Enter price: ");
                    price = input.nextInt();
                    System.out.println("Enter quantity: ");
                    quantity = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter description: ");
                    description = input.nextLine();

                    product = new Product(id, name, price, quantity, description);

                    products1 = feature.addProductArray(products1, product);
                    feature.displayProduct(products1);
                    break;
                case 2:
                    //nhập
                    System.out.println("Enter id product edit: ");
                    id = input.nextInt();
                    input.nextLine();
                    if (feature.checkID(products1, id)) {
                        //sửa thông tin sp
                        System.out.println("Enter edit name: ");
                        name = input.nextLine();
                        System.out.println("Enter edit price: ");
                        price = input.nextInt();
                        System.out.println("Enter edit quantity: ");
                        quantity = input.nextInt();
                        input.nextLine();
                        System.out.println("Enter edit description: ");
                        description = input.nextLine();

                        product = new Product(id, name, price, quantity, description);
                        feature.editProduct(products1, id, product);
                        feature.displayProduct(products1);
                    } else {
                        System.out.println("Id not found.");
                    }

                    break;
                case 3:
                    System.out.println("Enter id product delete: ");
                    id = input.nextInt();
                    if (feature.checkID(products1, id)) {
                        Product[] productsDel = feature.deleteProduct(products1, id);
                        feature.displayProduct(productsDel);
                    } else {
                        System.out.println("Id not found.");
                    }
                    break;
                case 4:
                    feature.displayProduct(products1);
                    break;
                case 5:
                    System.out.println("Products with the highest prices:");
                    System.out.println(feature.showProductHighestPrice(products1));
                    break;
                case 6:
                    System.out.println("Products with the lowest  prices:");
                    System.out.println(feature.showProductLowestPrice(products1));
                    break;
                case 7:
                    System.out.println("Products with the largest quantity:");
                    System.out.println(feature.showProductLargestQuantity(products1));
                    break;
                case 8:
                    System.out.println("Products with the least quantity:");
                    System.out.println(feature.showProductLeastQuantity(products1));
                    break;
                case 9:
                    System.out.println("Total money:");
                    System.out.println(feature.showTotalMoney(products1));
            }
        } while (choice != 10);
    }
}