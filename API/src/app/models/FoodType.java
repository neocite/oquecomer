package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity
public class FoodType extends Model {

	@Id
	public String id;
	
	public String name;
	
	@ManyToMany
	public List<Restaurant> restaurants = new ArrayList<Restaurant>();
	
	public static Finder<String,FoodType> find = new Finder<String,FoodType>(String.class, FoodType.class);
	 
	
}
