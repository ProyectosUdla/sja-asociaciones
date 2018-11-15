package mx.com.gm.sga.web;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaService;

@WebServlet("/personas")
public class PersonasServlet extends HttpServlet {

    @Inject
    PersonaService personaServiceEjbLocal;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Persona> personas = personaServiceEjbLocal.listarPersonas();
        System.out.println("personas:" + personas);
        request.setAttribute("personas", personas);
        request.getRequestDispatcher("/listadoPersonas.jsp").forward(request, response);
    }
}
