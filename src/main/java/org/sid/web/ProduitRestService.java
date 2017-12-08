package org.sid.web;
import org.sid.entities.Produit;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.sid.dao.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ProduitRestService {

	@Autowired
	private ProduitRepository produitRepository;
	
		
	@RequestMapping(value="/produits",method=RequestMethod.GET)
	public List<Produit> listProduits(Integer page,Integer size){
		return  produitRepository.findAll();
	
	}
	
	@RequestMapping(value="/produits/{id}",method=RequestMethod.GET)
	public Produit getProduits(@PathVariable(name="id")Long id){
		return produitRepository.findOne(id);
}
	@RequestMapping(value="/produits",method=RequestMethod.POST)
	public Produit save(@RequestBody Produit p){
		return produitRepository.save(p);
}
	
	@RequestMapping(value="/chercher",method=RequestMethod.GET)
	public Page<Produit>chercher(
			@RequestParam(name="mc",defaultValue="") String mc, 
			@RequestParam(name="page",defaultValue="")int page,
			@RequestParam(name="size",defaultValue="2")int size){
		return produitRepository
				.chercher("%"+mc+"%",new PageRequest(page,size));
}
	@RequestMapping(value="/produits/{id}",method=RequestMethod.PUT )
	public Produit update(@PathVariable(name="id")Long id,@RequestBody Produit p){
	p.setId(id);
		return produitRepository.save(p);
}
	/*@RequestMapping(value="/produits/{id}",method=RequestMethod.DELETE )
	public void delete(@PathVariable(name="id")Long id){
  produitRepository.delete(id);*/
}

