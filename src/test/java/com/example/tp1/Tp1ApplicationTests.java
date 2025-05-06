package com.example.tp1;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.example.tp1.Entities.Produit;
import com.example.tp1.repos.ProduitRepository;
import com.example.tp1.service.ProduitService;

@SpringBootTest
class Tp1ApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private ProduitRepository produitRepository;
	private ProduitService produitService;


	@Test
	public void testCreateProduit() {
		Produit prod = new Produit("PC HP", 2200.500, new Date());

		produitRepository.save(prod);
	}
	
	@Test
	public void testFindProduit() {
		Produit p = produitRepository.findById(3L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateProduit() {
		Produit p = produitRepository.findById(1L).get();
		p.setPrixProduit(1000.0);
		produitRepository.save(p);
	}

	@Test
	public void testDeleteProduit() {
		produitRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousProduits() {
		List<Produit> prods = produitRepository.findAll();
		for (Produit p : prods) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testFindByNomProduitContains() {
		Page<Produit> prods = produitService.getAllProduitsParPage(0, 2);
		System.out.println(prods.getSize());
		System.out.println(prods.getTotalElements());
		System.out.println(prods.getTotalPages());
		prods.getContent().forEach(p -> {
			System.out.println(p.toString());
		});
		/*
		 * ou bien for (Produit p : prods) { System.out.println(p); }
		 */
	}	
	
	
	@Test
	public void testFindByNomProduit()
	{
	List<Produit> prods = produitRepository.findByNomProduit("PC Dell");
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}
		
	
	@Test
	public void testfindByNomPrix()
	{
	List<Produit> prods = produitRepository.findByNomPrix("PC Dell",2200.5);
	for (Produit p : prods)
	{
	System.out.println(p);
	}
	}

}
