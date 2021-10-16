package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;
import model.Task;

/**
 * Servlet implementation class CreateNewCategoryGroupServlet
 */
@WebServlet("/CreateNewCategoryGroupServlet")
public class CreateNewCategoryGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewCategoryGroupServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String name = request.getParameter("name");
	    
	    String[] taskIds = request.getParameterValues("tasks");
	    List<Task> tasks = new ArrayList<Task>();
	    TaskHelper th = new TaskHelper();
	    if (taskIds != null && taskIds.length > 0) {
	        for (int i = 0; i < taskIds.length; ++i) {
	            Task task = th.searchForTasksById(Integer.parseInt(taskIds[i]));
	            tasks.add(task);
	        }
	    }
	    
	    Category category = new Category(name, tasks);
	    
	    CategoryHelper ch = new CategoryHelper();
	    ch.insertNewCategory(category);
	    
	    getServletContext().getRequestDispatcher("/ViewAllCategoryGroupsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
