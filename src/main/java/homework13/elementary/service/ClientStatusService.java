package homework13.elementary.service;

import homework13.elementary.dao.ClientStatusDao;
import homework13.elementary.dto.ClientStatusDto;
import homework13.elementary.entity.ClientStatus;

import java.util.ArrayList;
import java.util.List;

public class ClientStatusService {
    private final ClientStatusDao clientStatusDao;

    public ClientStatusService() {
        clientStatusDao = new ClientStatusDao();
    }

    public List<ClientStatusDto> findAllClients() {
        List<ClientStatus> allStatuses = clientStatusDao.getAllStatuses();
        List<ClientStatusDto> result = new ArrayList<>();
        for (ClientStatus clientStatus : allStatuses) {
            ClientStatusDto dto = new ClientStatusDto();
            dto.setClientId(clientStatus.getClientId());
            dto.setStatusId(clientStatus.getStatusId());
            result.add(dto);
        }
        return result;
    }
}
