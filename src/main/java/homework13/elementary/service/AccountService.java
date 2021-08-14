package homework13.elementary.service;

import homework13.elementary.dao.AccountDao;
import homework13.elementary.dto.AccountDto;
import homework13.elementary.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private final AccountDao accountDao;

    public AccountService() {
        accountDao = new AccountDao();
    }

    public List<AccountDto> findAllAccounts() {
        List<Account> accounts = accountDao.findAllAccounts();
        List<AccountDto> result = new ArrayList<>();
        for (Account account : accounts) {
            AccountDto dto = new AccountDto();
            dto.setId(account.getId());
            dto.setClientId(account.getClientId());
            dto.setNumber(account.getNumber());
            dto.setValue(account.getValue());
            result.add(dto);
        }
        return result;
    }
}