package homework13.elementary.controller;

import homework13.elementary.service.AccountService;
import homework13.elementary.service.ClientService;
import homework13.elementary.service.ClientStatusService;
import homework13.elementary.service.StatusService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// сервлет созданый(связаный) с помощью конфигурации в WEB.XML (1 из 2):
public class AccountServlet extends HttpServlet {  // *любой сервлет(класс) должен наследоваться от HttpServlets чтобы Tomcat мог определить его как сервлет (считатет анотацию);
    private final AccountService accountService = new AccountService();
    private final ClientService clientService = new ClientService();
    private final ClientStatusService clientStatusService = new ClientStatusService();
    private final StatusService statusService = new StatusService();

    // запрос на получение данных:
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // реквест в который мы передаем данные с сервиса CustomerService:
        req.setAttribute("accounts", accountService.findAllAccounts()); // "accounts" - ключ по которому будем обращаться к нашему jsp
        req.setAttribute("clients", clientService.findAllClients());
        req.setAttribute("clients_statuses", clientStatusService.findAllClients());
        req.setAttribute("statuses", statusService.findAllStatuses());
        // передаем наш реквест на jsp:
        req.getRequestDispatcher("views/accounts.jsp").forward(req, resp);
    }
}
