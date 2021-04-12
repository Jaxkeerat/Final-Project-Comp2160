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

    public double getPrice_input() {
        double dnum = Double.parseDouble(price_input);
        return dnum;
    }

    public void setPrice_input(String price_input) {
        this.price_input = price_input;
    }

    public int getItem_quantity() {
        int q = Integer.parseInt(item_quantity);
        return q;
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

    public String setGetGeneralInfo() {
        this.generalInfo = product +" General Info: \n\n" +
                "Price: $"+price_input+"\n" +
                "Purchase Date: "+editTextDate+"\n" +
                "Quantity: "+item_quantity+"\n" +
                "Best Before: "+editTextDate2+"\n" +
                "\nRemember \n" +
                "No Waste.\n" +
                "Leaves a Great Taste \n" +
                "Don't Throw it away\n" +
                "Unless its gone bad";

        return generalInfo;
    }
    @Override
    public String toString() {
        return product + " BestBefore: " + editTextDate2;
    }
}
