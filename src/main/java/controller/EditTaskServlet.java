package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;
import model.Task;

/**
 * Servlet implementation class EditTaskServlet
 */
@WebServlet("/EditTaskServlet")
public class EditTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTaskServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    TaskHelper th = new TaskHelper();
        
        int id = Integer.parseInt(request.getParameter("id"));
        Task task = th.searchForTasksById(id);
	    
	    String personName = request.getParameter("personName");
        Person person = new Person(personName);
        task.setPerson(person);
        
        String name = request.getParameter("name");
        task.setName(name);
        
        String month = request.getParameter("month");
        String day   = request.getParameter("day");
        String year  = request.getParameter("year");
        
        LocalDate dueDate;
        try {
            dueDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        } catch (NumberFormatException error) {
            dueDate = LocalDate.now();
        }
		task.setDueDate(dueDate);
		
		th.updateTask(task);
		
		getServletContext().getRequestDispatcher("/ViewAllTasksServlet").forward(request, response);
	}
}
