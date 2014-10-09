package controllers;

import static play.libs.Json.toJson;

import java.util.List;

import models.FoodType;
import models.Restaurant;
import play.data.Form;
import play.db.ebean.Model;
import play.mvc.Controller;
import play.mvc.Result;

public class FoodTypeController extends Controller {

	public static Result get() {
		List<FoodType> objects = new Model.Finder(String.class, FoodType.class).all();
		return ok(toJson(objects));
	}
	
	public static Result find(String id) {
		FoodType object = FoodType.find.ref(id);
		return ok(toJson(object));
	}
	    
    public static Result post() {
        FoodType object = Form.form(FoodType.class).bindFromRequest().get();
        object.save();
        response().setHeader("Content-Location", "/foodType/" + object.id);
        return created();
    }
	
}
