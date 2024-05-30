package orangekalanso.tp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("serial")
@WebServlet("/contacts")
public class ContactServlet extends HttpServlet {
    private List<Contact> contacts = new ArrayList<>();
    private int idCounter = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            Contact contact = contacts.stream()
                    .filter(c -> c.getId() == Integer.parseInt(id))
                    .findFirst()
                    .orElse(null);
            req.setAttribute("contact", contact);
            req.getRequestDispatcher("/ModifierSupprimerContact.jsp").forward(req, resp);
        } else {
            req.setAttribute("contacts", contacts);
            req.getRequestDispatcher("/contacts.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("_method");
        if (method != null && method.equals("DELETE")) {
            String id = req.getParameter("id");
            contacts = contacts.stream()
                    .filter(c -> c.getId() != Integer.parseInt(id))
                    .collect(Collectors.toList());
        } else {
            String id = req.getParameter("id");
            String nom = req.getParameter("nom");
            String prenom = req.getParameter("prenom");
            String numero = req.getParameter("numero");
            String email = req.getParameter("email");
            String adresse = req.getParameter("adresse");

            if (id != null && !id.isEmpty()) {
                Contact contact = contacts.stream()
                        .filter(c -> c.getId() == Integer.parseInt(id))
                        .findFirst()
                        .orElse(null);
                if (contact != null) {
                    contact.setNom(nom);
                    contact.setPrenom(prenom);
                    contact.setNumero(numero);
                    contact.setEmail(email);
                    contact.setAdresse(adresse);
                }
            } else {
                contacts.add(new Contact(idCounter++, nom, prenom, numero, email, adresse));
            }
        }
        resp.sendRedirect("contacts");
    }
}
