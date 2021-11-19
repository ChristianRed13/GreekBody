package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import foodData.Food;
import foodData.FoodIngredient;
import foodData.Ingredient;
import service.FoodService;


public class IngredientFoodDao extends GenericDao<FoodIngredient> {

	private EntityManagerFactory factory;

	public IngredientFoodDao(EntityManagerFactory factory) {
		super(FoodIngredient.class);
		this.factory = factory;
	}

	@Override
	public EntityManager getEntityManager() {
		try {
			return factory.createEntityManager();
		} catch (Exception ex) {
			System.out.println("The entity manager cannot be created!");
			return null;
		}
	}

	// find by food id 
	public Map<String, String> find(Integer id) throws Exception {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<FoodIngredient> q = cb.createQuery(FoodIngredient.class);

		Root<FoodIngredient> c = q.from(FoodIngredient.class);
		ParameterExpression<Food> paramF = cb.parameter(Food.class);
		q.select(c).where(cb.equal(c.get("id_food"), paramF));
		FoodService fs = new FoodService(); 
		TypedQuery<FoodIngredient> query = em.createQuery(q);
		query.setParameter(paramF, fs.findFoodWithID(id));

		List<FoodIngredient> results = query.getResultList();
		
		
		
		CriteriaQuery<Ingredient> qi = cb.createQuery(Ingredient.class);
		Root<Ingredient> ci = qi.from(Ingredient.class);
		Map<String, String> finalResults = new HashMap<String, String>();
		
		ParameterExpression<Ingredient> paramI = cb.parameter(Ingredient.class);
		
		for(FoodIngredient f : results){
		qi.select(ci).where(cb.equal(ci.get("id_ingredient"), paramI));
		TypedQuery<Ingredient> query2 = em.createQuery(qi);
		query2.setParameter(paramI, f.getIngredient());
		finalResults.put(f.getCantity(), f.getIngredient().getName());
		}
		
		return finalResults ;
	}	
}

