public class User {
    private String userName;
    //private static final int MIN_PASSWORD_LENGTH = 10;
    private String password;
    private ShoppingCart shoppingCarts;

    public User(String userName, String password, ShoppingCart shoppingCarts) {
        this.userName = userName;
        this.password = password;
        this.shoppingCarts = shoppingCarts;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ShoppingCart getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(ShoppingCart shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    public boolean hasStrongPassword() {
        //if(password.length()>=10){
        return password.length() >= 10;
    }

    public boolean hasValidUserName() {
        //return !"".equals(userName);
        return !userName.isBlank();
    }

    public boolean isValid() {
        return hasStrongPassword() & hasValidUserName();
    }

    public String generateInvoice() throws InvalidPriceException {
      return userName + " has paid " + shoppingCarts.computeTotalPrice();
    }
}
