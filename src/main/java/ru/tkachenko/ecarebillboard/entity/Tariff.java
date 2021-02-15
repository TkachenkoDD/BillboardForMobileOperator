package ru.tkachenko.ecarebillboard.entity;

import java.util.HashSet;
import java.util.Set;

public class Tariff {

    private int id;
    private String tariffName;
    private int tariffCost;
    private Set<Option> optionAvailableSet = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public int getTariffCost() {
        return tariffCost;
    }

    public void setTariffCost(int tariffCost) {
        this.tariffCost = tariffCost;
    }

    public Set<Option> getOptionAvailableSet() {
        return optionAvailableSet;
    }

    public void setOptionAvailableSet(Set<Option> optionAvailableSet) {
        this.optionAvailableSet = optionAvailableSet;
    }
}

