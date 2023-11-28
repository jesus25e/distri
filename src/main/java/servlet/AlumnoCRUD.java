/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import com.google.gson.Gson;
import dao.AlumnoJpaController;
import dto.Alumno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Naomi
 */
@WebServlet(name = "AlumnoCRUD", urlPatterns = {"/alumnocrud"})
public class AlumnoCRUD extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String tipo = request.getParameter("tipo");
            String resultado = "";
            switch(tipo){
                case "1":
                    AlumnoJpaController aluDAO = new AlumnoJpaController();
                    List<Alumno> lista = aluDAO.findAlumnoEntities();
                    Gson g = new Gson();
                    resultado = g.toJson(lista);
                    resultado = "{\"data\":"+resultado+"}";
                    break;
                case "2":
    // Lógica para agregar un nuevo alumno
    String codigo = request.getParameter("codigo");
    String apellidoPaterno = request.getParameter("apellidoPaterno");
    String apellidoMaterno = request.getParameter("apellidoMaterno");
    String nombres = request.getParameter("nombres");

    Alumno nuevoAlumno = new Alumno();
    nuevoAlumno.setCodiAlum(codigo);
    nuevoAlumno.setAppaAlum(apellidoPaterno);
    nuevoAlumno.setApmaAlum(apellidoMaterno);
    nuevoAlumno.setNombAlum(nombres);

    AlumnoJpaController alumDAO = new AlumnoJpaController();
    try {
        alumDAO.create(nuevoAlumno); // Agregar el nuevo alumno a la base de datos
        resultado = "{\"resultado\":\"OK\"}";
    } catch (Exception ex) {
        resultado = "{\"resultado\":\"ERROR\"}";
        ex.printStackTrace();
    }
    break;
    case "3":
    // Lógica para agregar un nuevo alumno
   String codigoEditar = request.getParameter("codigo");
    String apellidoPaternoEditar = request.getParameter("apellidoPaterno");
    String apellidoMaternoEditar = request.getParameter("apellidoMaterno");
    String nombresEditar = request.getParameter("nombres");

    AlumnoJpaController alumDAOEditar = new AlumnoJpaController();
    try {
        // Obtener el alumno existente por su código
        Alumno alumnoExistente = alumDAOEditar.findAlumno(codigoEditar);

        // Actualizar la información del alumno con los nuevos datos
        alumnoExistente.setAppaAlum(apellidoPaternoEditar);
        alumnoExistente.setApmaAlum(apellidoMaternoEditar);
        alumnoExistente.setNombAlum(nombresEditar);

        // Guardar los cambios en la base de datos
        alumDAOEditar.edit(alumnoExistente);

        resultado = "{\"resultado\":\"OK\"}";
    } catch (Exception ex) {
        resultado = "{\"resultado\":\"ERROR\"}";
        ex.printStackTrace();
    }
    break;
            }
            out.print(resultado);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
