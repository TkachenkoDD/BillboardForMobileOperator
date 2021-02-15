package ru.tkachenko.ecarebillboard.controller;

import ru.tkachenko.ecarebillboard.dao.RestEJB;
import ru.tkachenko.ecarebillboard.entity.Tariff;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
 import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class TariffsController implements Serializable {

    private Tariff tariff;
    private List<Tariff> tariffList = new ArrayList<>();

    @EJB
    private RestEJB restEJB;

    public List<Tariff> getTariffList() {
        return restEJB.getTariffs();
    }

    public void setTariffList(List<Tariff> tariffList) {
        this.tariffList = tariffList;
    }
}
