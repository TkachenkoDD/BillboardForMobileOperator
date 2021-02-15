package ru.tkachenko.ecarebillboard.dao;

import ru.tkachenko.ecarebillboard.entity.Tariff;

import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
public class RestEJB {

    public List<Tariff> getTariffs() {
        Client client = ClientBuilder.newClient();
        List<Tariff> tariffList = client.target("http://localhost:8081/billboard")
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Tariff>>() {
                });
        client.close();

        return tariffList;
    }
}
