package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Category;

/**
 * Servlet implementation class CategoryGroupNavigationServlet
 */
@WebServlet("/CategoryGroupNavigationServlet")
public class CategoryGroupNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryGroupNavigationServlet() {
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
		
		String action = request.getParameter("performCategoryAction");
		
		if (action == null) {
		    getServletContext().getRequestDispatcher("/ViewAllCategoryGroupsServlet").forward(request, response);
		} else if (action.equals("Add Category Group")) {
		    getServletContext().getRequestDispatcher("/AddCategoryGroupServlet").forward(request, response);
		} else if (action.equals("Edit Category Group")) {
		    try {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Category category = ch.searchForCategoriesById(id);
		        request.setAttribute("newCategory", category);
		    
		        TaskHelper th = new TaskHelper();
		        request.setAttribute("tasks", th.showAllTasks());
		        if (th.showAllTasks().isEmpty()) {
		            request.setAttribute("tasks", "");
		        }
		    
		        getServletContext().getRequestDispatcher("/edit-category-group.jsp").forward(request, response);
		    } catch (NumberFormatException error) {
		        getServletContext().getRequestDispatcher("/ViewAllCategoryGroupsServlet").forward(request, response);
		    }
	    } else if (action.equals("Delete Category Group")) {
		    try {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Category category = ch.searchForCategoriesById(id);
		        ch.deleteCategory(category);
		    } catch (NumberFormatException error) {
		        System.out.println("Missing Category Group");
		    } finally {
		        getServletContext().getRequestDispatcher("/ViewAllCategoryGroupsServlet").forward(request, response);
		    }
		}
	}
}
