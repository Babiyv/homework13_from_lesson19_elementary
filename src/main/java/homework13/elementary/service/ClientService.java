package homework13.elementary.service;

import homework13.elementary.dao.ClientDao;
import homework13.elementary.dto.ClientDto;
import homework13.elementary.entity.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private final ClientDao clientDao;

    public ClientService() {
        clientDao = new ClientDao();
    }

    public List<ClientDto> findAllClients() {
        List<Client> clients = clientDao.findAllClients();
        List<ClientDto> result = new ArrayList<>();
        for (Client client : clients) {
            ClientDto dto = new ClientDto();
            dto.setId(client.getId());
            dto.setName(client.getName());
            dto.setEmail(client.getEmail());
            dto.setPhone(client.getPhone());
            dto.setAbout(client.getAbout());
            dto.setAge(client.getAge());
            result.add(dto);
        }
        return result;
    }
}