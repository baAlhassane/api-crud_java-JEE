package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import metier.entities.Produit;

@WebServlet(name="cs",urlPatterns= {"/controller","*.do"})
public class ControllerServlet extends HttpServlet {
	IProduitDao metier;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String path=request.getServletPath();
		if(path.equals("/indoex.do")) {
			request.getRequestDispatcher("produits.jsp").forward(request, response);
	
		}
		
		else if(path.equals("/chercher.do")){
			String motCle=request.getParameter("motClet");
			ProduitModel model=new ProduitModel();
			model.setMotCle(motCle);
			List<Produit> prods=metier.produitsParMC(motCle);
			model.setProduits(prods);
			request.setAttribute("model", model);
			request.getRequestDispatcher("produits.jsp").forward(request, response);
			
			
			
			
		}
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		//super.init();
		metier=new ProduitDaoImpl();
		
		
	}
	

}
