public class ShoppingCart {
    private Product[]productList;

    public ShoppingCart(Product[] productList) {
        this.productList = productList;
    }

    public Product[] getProductList() {
        return productList;
    }

    public void setProductList(Product[] productList) {
        this.productList = productList;
    }

    public int  computeTotalPrice()throws InvalidPriceException{
        int totalPrice = 0;
        for (int i = 0; i < productList.length ; i++) {
            if(productList[i].getPrice()<=0){
                throw new InvalidPriceException("Price is negative");
            }
           totalPrice += productList[i].getPrice();
        }
        return totalPrice;
    }
}
