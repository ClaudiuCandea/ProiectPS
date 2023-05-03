package com.example.demo;

import com.example.demo.DAO.DAO;
import com.example.demo.Model.Car;
import com.example.demo.Model.Client;
import com.example.demo.Service.CarService;
import com.example.demo.Service.ClientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClientTest {

    @Mock
    private DAO<Client> dao;

    @Test
    void testSaveClient(){
        Client client = new Client(1,1,"George","geroge@gmail.com","075478988","1245-2131-231-3524","george1","client");
        ClientService clientService = new ClientService(dao);
        clientService.saveClient(client);
        verify(dao).save(client);

    }

    @Test
    void testDeleteClient(){
        ClientService clientService = new ClientService(dao);
        clientService.deleteClient(1);
        verify(dao).delete(1);
    }

    @Test
    void testGetClientById(){
        Client client = new Client(1,1,"George","geroge@gmail.com","075478988","1245-2131-231-3524","george1","client");
        ClientService clientService = new ClientService(dao);
        when(dao.get(1)).thenReturn(client);
        clientService.getClient(1);
        verify(dao).get(1);
    }

    @Test
    void testGetAllClients() {
        Client client1 = new Client(1, 1, "George", "geroge@gmail.com", "075478988", "1245-2131-2312-3524", "george1", "client");
        Client client2 = new Client(2, 2, "Eugen", "eugen@gmail.com", "075478988", "1245-2132-2322-3524", "eugen1", "client");
        ClientService clientService = new ClientService(dao);
        ArrayList<Client> clients = new ArrayList<Client>();
        clients.add(client1);
        clients.add(client2);
        when(dao.getAll()).thenReturn(clients);
        clientService.getAllClients();
        verify(dao).getAll();
    }

    @Test
    void testUpdateClient(){
        Client client = new Client(2,2,"Eugen","eugen@gmail.com","075478988","1245-2132-2322-3524","eugen1","client");
        ClientService clientService = new ClientService(dao);
        when(dao.update(client)).thenReturn(1);
        clientService.updateClient(client);
        verify(dao).update(client);
    }


}
