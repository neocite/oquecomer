package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class Restaurant extends Model {
	
	@Id
	public String id;
	
	@Required
	public String name;
	
	public String cep;
	
	@ManyToMany
	public List<FoodType> foodTypes = new ArrayList<FoodType>();
	
	
	public Restaurant(String name,String cep){
		this.name = name;
		this.cep = cep;
	}
	
	public static Finder<String,Restaurant> find = new Finder<String,Restaurant>(String.class, Restaurant.class);
	
	public static Restaurant create(String name,String cep){
		Restaurant restaurant = new Restaurant(name, cep);
		restaurant.save();
		restaurant.saveManyToManyAssociations("foodTypes");
		return restaurant;
	}
	
	public void addFoodType(String foodTypeId){
		this.foodTypes.add(FoodType.find.ref(foodTypeId));
		this.save();
	}
	
	public void removeFoodType(String foodTypeId){
		this.foodTypes.remove(FoodType.find.ref(foodTypeId));
		this.save();
	}
	
	
}
