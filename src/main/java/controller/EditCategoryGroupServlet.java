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
 * Servlet implementation class EditCategoryGroupServlet
 */
@WebServlet("/EditCategoryGroupServlet")
public class EditCategoryGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCategoryGroupServlet() {
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
		CategoryHelper ch = new CategoryHelper();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Category category = ch.searchForCategoriesById(id);
		
		String name = request.getParameter("name");
		category.setName(name);
		
		TaskHelper th = new TaskHelper();
		List<Task> tasks = new ArrayList<Task>();
		try {
		    String[] taskIds = request.getParameterValues("tasks");
		    for (int i = 0; i < taskIds.length; ++i) {
		        Task task = th.searchForTasksById(Integer.parseInt(taskIds[i]));
		        tasks.add(task);
		    }
		} catch (NullPointerException error) {
		    tasks = new ArrayList<Task>();
		}
		category.setTasks(tasks);
		
		ch.updateCategory(category);
		
		getServletContext().getRequestDispatcher("/ViewAllCategoryGroupsServlet").forward(request, response);
	}
}
