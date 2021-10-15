package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Task;

/**
 * Servlet implementation class TaskNavigationServlet
 */
@WebServlet("/TaskNavigationServlet")
public class TaskNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskNavigationServlet() {
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
		
		String action = request.getParameter("performTaskAction");
		
		String path = "/ViewAllTasksServlet";
		
		if (action.equals("Add Task")) {
		    path = "/index.html";
		} else if (action.equals("Edit Task")) {
		    try {
		        Integer id = Integer.parseInt(request.getParameter("id"));
		        Task task = th.searchForTasksById(id);
		        request.setAttribute("newTask", task);
		        request.setAttribute("month", task.getDueDate().getMonthValue());
		        request.setAttribute("day", task.getDueDate().getDayOfMonth());
		        request.setAttribute("year", task.getDueDate().getYear());
		        path = "/edit-task.jsp";
		    } catch (NumberFormatException error) {
		        System.out.println("Missing task");
		    }
		} else if (action.equals("Delete Task")) {
		    try {
		        Integer id = Integer.parseInt(request.getParameter("id"));
		        Task task = th.searchForTasksById(id);
		        th.deleteTask(task);
		    } catch (NumberFormatException error) {
		        System.out.println("Missing task");
		    }
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}
