package com.example.finalproject;

//Create objects for each firebase product entry to pull
public class FireBaseData {
    private String name;
    private String price;
    private String quantity;
    private String expiryDate;
    private String purchaseDate;
    private String generalInfo;

    public FireBaseData(){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.purchaseDate = purchaseDate;
        this.generalInfo = name +" General Info: \n " +
                "Price: "+price+"\n" +
                "Purchase Date: "+purchaseDate+"\n" +
                "Quantity Purchased: "+quantity+"\n" +
                "Best Before: "+expiryDate+"\n" +
                "\n Remember Best Before date is \n" +
                "only a suggestion. Don't waste food, \n" +
                "always check online for best practices :)";
    }

    public String getGeneralInfo() {
        return generalInfo;
    }

    public String getProductName() {
        return name;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

}
