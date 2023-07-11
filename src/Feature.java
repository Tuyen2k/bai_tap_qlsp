
public class Feature {
    public Product[] addProductArray(Product[] arrProduct, Product product) {
        Product[] arrayNewProduct = new Product[arrProduct.length + 1];
        for (int i = 0; i < arrProduct.length; i++) {
            arrayNewProduct[i] = arrProduct[i];
        }
        arrayNewProduct[arrayNewProduct.length - 1] = product;
        return arrayNewProduct;
    }

    public void displayProduct(Product[] arrProduct) {
        for (Product product : arrProduct) {
            System.out.println(product.toString());
        }
    }

    public boolean checkID(Product[] arrProduct, int id) {
        boolean flag = false;
        for (Product product : arrProduct) {
            if (product.getId() == id) {
                flag = true;
            }
        }
        return flag;
    }

    public void editProduct(Product[] arrProduct, int id, Product product) {
        for (int i = 0; i < arrProduct.length; i++) {
            if (arrProduct[i].getId() == id) {
                arrProduct[i] = product;
            }
        }
    }

    public Product[] deleteProduct(Product[] arrProduct, int id) {
        Product[] arrDelete = new Product[arrProduct.length - 1];
        int index = -1;
        //tìm index của pt
        for (int i = 0; i < arrProduct.length; i++) {
            if (arrProduct[i].getId() == id) {
                index = i;
            }
        }

        //cắt pt
        for (int j = index; j < arrProduct.length - 1; j++) {
            arrProduct[j] = arrProduct[j + 1];
        }
        for (int i = 0; i < arrDelete.length; i++) {
            arrDelete[i] = arrProduct[i];
        }
        return arrDelete;
    }

    public String showProductHighestPrice(Product[] products){
        int maxPrice = products[0].getPrice();
        int index = 0;
        for (int i = 0; i < products.length; i++) {
            if (maxPrice < products[i].getPrice()){
                maxPrice = products[i].getPrice();
                index = i;
            }
        }
        return products[index].toString();
    }

    public String showProductLowestPrice(Product[] products){
        int minPrice = products[0].getPrice();
        int index = 0;
        for (int i = 0; i < products.length; i++) {
            if (minPrice > products[i].getPrice()){
                minPrice = products[i].getPrice();
                index = i;
            }
        }
        return products[index].toString();
    }

    public String showProductLargestQuantity(Product[] products){
        int maxQuantity = products[0].getQuantity();
        int index = 0;
        for (int i = 0; i < products.length; i++) {
            if (maxQuantity < products[i].getQuantity()){
                maxQuantity = products[i].getQuantity();
                index = i;
            }
        }
        return products[index].toString();
    }
    public String showProductLeastQuantity(Product[] products){
        int minQuantity = products[0].getQuantity();
        int index = 0;
        for (int i = 0; i < products.length; i++) {
            if (minQuantity > products[i].getQuantity()){
                minQuantity = products[i].getQuantity();
                index = i;
            }
        }
        return products[index].toString();
    }

    public int showTotalMoney(Product[] products){
        int sum = 0;
        for (Product product: products) {
            sum += product.getPrice()*product.getQuantity();
        }
        return sum;
    }

}
