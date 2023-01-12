package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import metier.SingletonConnection;
import metier.entities.Produit;

public class ProduitDaoImpl implements IProduitDao {

	@Override
	public Produit save(Produit p) {
		// TODO Auto-generated method stub
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement(
					"INSERT INTO PRODUITS(NOM_PRODUIT,PRIX) VALUES(?,?)");
			         //ps.setLong(1, p.getIdProduit());
			         ps.setString(1, p.getNomProduit());
			         ps.setDouble(2, p.getPrix());
			         ps.executeUpdate();
			         
			         PreparedStatement ps2=conn.prepareStatement(
			        "SELECT MAX(ID_PRODUIT) as MAX_ID FROM PRODUITS");
			             ResultSet rs= ps2.executeQuery();
			             if(rs.next()) {
			            	 p.setIdProduit(rs.getLong("MAX_ID"));
			             }
			             ps.close();
			             ps2.close();
			         
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Produit getProduit(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit updateProduit(Produit p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduit(Produit p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Produit> produitsParMC(String mc) {
		// TODO Auto-generated method stub
		 List<Produit> prods=new ArrayList<Produit>();
		 Connection conn=SingletonConnection.getConnection();
		 try {
			 PreparedStatement ps=conn.prepareStatement("SELECT * FROM PRODUITS WHERE NOM_PRODUIT LIKE ?");
			 ps.setString(1, "%"+mc+"%");
			 ResultSet rs=ps.executeQuery();
			 while(rs.next()) {
				 Produit p=new Produit();
				 p.setIdProduit(rs.getLong("ID_PRODUIT"));
				 p.setNomProduit(rs.getString("NOM_PRODUIT"));
				 p.setPrix(rs.getDouble("PRIX"));
				 prods.add(p); 
			 }
		 }
		 catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		 
		
		return prods;
	}

}
