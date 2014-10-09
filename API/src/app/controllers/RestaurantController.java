package controllers;

import static play.libs.Json.toJson;
import static play.data.Form.*;

import java.util.List;

import models.Restaurant;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;
import play.*;

public class RestaurantController extends Controller {

	public static Result get() {
		List<Restaurant> objects = new Model.Finder(String.class, Restaurant.class).all();
		return ok(toJson(objects));
	}
	
	public static Result find(String id) {
		Restaurant object = Restaurant.find.ref(id);
		return ok(toJson(object));
	}
	    
    public static Result post() {
    	Restaurant object = Form.form(Restaurant.class).bindFromRequest().get();
    	object.save();
    	response().setHeader("Content-Location", "/restaurant/" + object.id);
        return created();
    }
    
    public static Result addFoodType(String id) {
    	Restaurant restaurant = Restaurant.find.ref(id);
    	restaurant.addFoodType(form().bindFromRequest().get("foodTypeId"));
        return created();
    }
    
    public static Result removeFoodType(String id) {
    	Restaurant restaurant = Restaurant.find.ref(id);
    	restaurant.removeFoodType(form().bindFromRequest().get("foodTypeId"));
        return noContent();
    }
	
}
