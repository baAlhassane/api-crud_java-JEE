package test;

import java.util.ArrayList;
import java.util.List;

import dao.ProduitDaoImpl;
import metier.entities.Produit;

public class TestDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProduitDaoImpl pdao=new ProduitDaoImpl();
		Produit prod=pdao.save(new Produit("Iphone 12",2800));
		
		System.out.println(prod.toString());
		
		List<Produit> prods=pdao.produitsParMC("HP");
		
		for(Produit p: prods) {
			System.out.println(p.toString());

		}
		
		
		

	}

}
