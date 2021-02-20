package ru.tkachenko.ecarebillboard.rest;

import ru.tkachenko.ecarebillboard.entity.Option;
import ru.tkachenko.ecarebillboard.entity.Tariff;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Stateless
public class RestEJB {

    public List<Tariff> getTariffs() {
        Client client = ClientBuilder.newClient();
        List<Tariff> tariffList = client.target("http://localhost:8081/billboard")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Tariff>>() {
                });
        client.close();
        for (Tariff tariff : tariffList) {
            Set<Option> optionSet = tariff.getOptionAvailableSet().stream()
                    .sorted(Comparator.comparing(Option::getCategory)
                    .thenComparing(Option::getOptionName)).collect(Collectors.toCollection(LinkedHashSet::new));
            tariff.setOptionAvailableSet(optionSet);
        }
        return tariffList;
    }
}
