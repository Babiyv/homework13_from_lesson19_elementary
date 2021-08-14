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

// сервлет созданый(связаный) с помощью конфигурации в WEB.XML (2 из 2):
public class ClientServlet extends HttpServlet {
    private final ClientService clientService = new ClientService();
    private final AccountService accountService = new AccountService();
    private final ClientStatusService clientStatusService = new ClientStatusService();
    private final StatusService statusService = new StatusService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("clients", clientService.findAllClients());
        req.setAttribute("accounts", accountService.findAllAccounts());
        req.setAttribute("clients_statuses", clientStatusService.findAllClients());
        req.setAttribute("statuses", statusService.findAllStatuses());
        req.getRequestDispatcher("views/clients.jsp").forward(req, resp);
    }
}
