package florian.budgetapp.group;

public class SpendOn {
    private String name;
    private String category;
    private double amount;

    public SpendOn(String category, String name, double amount){
        this.category = category;
        this.name = name;
        this.amount = amount;
    }

    public SpendOn(){
        this.category = "";
        this.name = "";
        this.amount = 0;
    }
    public String toString(){
        return this.category + "   " + this.name + "   " + this.amount + " €";

    }

    public void setCategory(String category){
        this.category = category;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public double getAmount(){
        return this.amount;
    }

    public String getName(){
        return this.name;
    }

    public String getCategory(){
        return this.category;
    }


}
