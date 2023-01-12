package metier.entities;

import java.io.Serializable;

public class Produit implements Serializable{
	
	
	
	
	private static final long serialVersionUID = 1L;
	private Long idProduit;
	private String nomProduit;
	private double prix;
	
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long iidProduit) {
		idProduit = iidProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduid) {
		this.nomProduit = nomProduid;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Produit(String nomProduid, double prix) {
		//super();
		this.nomProduit = nomProduid;
		this.prix = prix;
	}
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", prix=" + prix + "]";
	}


}
