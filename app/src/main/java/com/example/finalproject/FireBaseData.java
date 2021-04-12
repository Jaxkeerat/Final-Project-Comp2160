package com.example.finalproject;

//Create objects for each firebase product entry to pull
public class FireBaseData {

    private String product;
    private String price_input;
    private String item_quantity;
    private String editTextDate;
    private String editTextDate2;
    private String generalInfo;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPrice_input() {
        return price_input;
    }

    public void setPrice_input(String price_input) {
        this.price_input = price_input;
    }

    public String getItem_quantity() {
        return item_quantity;
    }

    public void setItem_quantity(String item_quantity) {
        this.item_quantity = item_quantity;
    }

    public String getEditTextDate() {
        return editTextDate;
    }

    public void setEditTextDate(String editTextDate) {
        this.editTextDate = editTextDate;
    }

    public String getEditTextDate2() {
        return editTextDate2;
    }

    public void setEditTextDate2(String editTextDate2) {
        this.editTextDate2 = editTextDate2;
    }

    public String getGeneralInfo() {
        return generalInfo;
    }

    public void setGeneralInfo(String generalInfo) {
        this.generalInfo = product +" General Info: \n " +
                "Price: "+price_input+"\n" +
                "Purchase Date: "+editTextDate+"\n" +
                "Quantity Purchased: "+item_quantity+"\n" +
                "Best Before: "+editTextDate2+"\n" +
                "\n Remember Best Before date is \n" +
                "only a suggestion. Don't waste food, \n" +
                "always check online for best practices :)";
    }
    @Override
    public String toString() {
        return product + " --> BestBefore: " + editTextDate2;
    }
}
