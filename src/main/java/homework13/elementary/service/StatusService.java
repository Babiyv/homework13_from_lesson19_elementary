package homework13.elementary.service;

import homework13.elementary.dao.StatusDao;
import homework13.elementary.dto.StatusDto;
import homework13.elementary.entity.Status;

import java.util.ArrayList;
import java.util.List;

public class StatusService {
    private final StatusDao statusDao;

    public StatusService() {
        statusDao = new StatusDao();
    }

    public List<StatusDto> findAllStatuses() {
        List<Status> statuses = statusDao.findAllStatuses();
        List<StatusDto> result = new ArrayList<>();
        for (Status status : statuses) {
            StatusDto dto = new StatusDto();
            dto.setId(status.getId());
            dto.setAlias(status.getAlias());
            dto.setDescription(status.getDescription());
            result.add(dto);
        }
        return result;
    }
}
