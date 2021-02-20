package ru.tkachenko.ecarebillboard.entity;

public class Option {

    private int id;
    private String optionName;
    private int optionCost;
    private int connectionCost;
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public int getOptionCost() {
        return optionCost;
    }

    public void setOptionCost(int optionCost) {
        this.optionCost = optionCost;
    }

    public int getConnectionCost() {
        return connectionCost;
    }

    public void setConnectionCost(int connectionCost) {
        this.connectionCost = connectionCost;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
