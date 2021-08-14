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

@WebServlet("/statuses")
public class StatusServlet extends HttpServlet {
    private final StatusService statusService = new StatusService();
    private final AccountService accountService = new AccountService();
    private final ClientService clientService = new ClientService();
    private final ClientStatusService clientStatusService = new ClientStatusService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("statuses", statusService.findAllStatuses());
        req.setAttribute("accounts", accountService.findAllAccounts());
        req.setAttribute("clients", clientService.findAllClients());
        req.setAttribute("clients_statuses", clientStatusService.findAllClients());
        req.getRequestDispatcher("views/statuses.jsp").forward(req, resp);
    }
}