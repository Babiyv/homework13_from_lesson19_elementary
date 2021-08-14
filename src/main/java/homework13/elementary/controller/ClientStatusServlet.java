package homework13.elementary.controller;

import homework13.elementary.service.AccountService;
import homework13.elementary.service.ClientService;
import homework13.elementary.service.ClientStatusService;
import homework13.elementary.service.StatusService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// cервлет созданный/связаный при помощи анотации (1 из 2):
@WebServlet("/clients_statuses")
public class ClientStatusServlet extends HttpServlet {
    private final ClientStatusService clientStatusService = new ClientStatusService();
    private final AccountService accountService = new AccountService();
    private final ClientService clientService = new ClientService();
    private final StatusService statusService = new StatusService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("clients_statuses", clientStatusService.findAllClients());
        req.setAttribute("accounts", accountService.findAllAccounts());
        req.setAttribute("clients", clientService.findAllClients());
        req.setAttribute("statuses", statusService.findAllStatuses());
        req.getRequestDispatcher("views/clients_statuses.jsp").forward(req, resp);
    }
}
