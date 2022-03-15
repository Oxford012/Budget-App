package florian.budgetapp.group;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;


public class Group implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private final double totalBudget;
    private int persons;
    private double amount;
    private ObservableList<SpendOn> spendings;
    private SimpleDoubleProperty budget;

    public Group(int persons,double amount){
        this. totalBudget = persons * amount;
        this.persons = persons;
        this.amount = amount;
        this.spendings = FXCollections.observableArrayList();
        this.budget = new SimpleDoubleProperty(this.totalBudget);
    }



    public int getPersons(){
        return this.persons;
    }

    public SimpleDoubleProperty getBudget(){
        return this.budget;
    }


    @Override
    public String toString() {
        return "Group{" +
                "persons=" + persons +
                ", amount=" + amount +
                '}';
    }

    public ObservableList<SpendOn> getSpendings(){
        return this.spendings;
    }

    public void addSpending(SpendOn spending){
        this.spendings.add(spending);
    }

    public void updateBudget() {
        double currentAmount = 0;
        for(SpendOn item : this.getSpendings()){
            currentAmount += item.getAmount();
        }
        this.budget.setValue((this.persons*this.amount) - currentAmount);
    }

    public void setSpendings(ObservableList<SpendOn> spendings){
        this.spendings = spendings;
    }

    public double getAmount(){
        return this.amount;
    }



}
