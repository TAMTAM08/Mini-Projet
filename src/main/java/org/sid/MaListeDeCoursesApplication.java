package org.sid;


import java.util.List;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaListeDeCoursesApplication implements CommandLineRunner{
	@Autowired
		private ProduitRepository produitRepository;
	public static void main(String[] args) {
		SpringApplication.run(MaListeDeCoursesApplication.class, args);
	
	}
		@Override
		public void run(String... arg0) throws Exception {
			// TODO Auto-generated method stub
			produitRepository.save(new Produit("des pommes", 2, 1));
			produitRepository.save(new Produit("des poires", 3, 10));	
			produitRepository.save(new Produit("des scoubidous ", 10, 5));	

		List<Produit> prods=produitRepository.findAll();
		prods.forEach(p->System.out.println(p.getDesignation()));
		}
}
