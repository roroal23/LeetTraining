package LeetTraining.arrays;
import java.util.*;

public class LT_2115_FindAllPosibleRecipesFromGivenSupplies {

	public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
		Set<String> available = new HashSet<>();//Set to check efficiently if a supply/recipe is available
		for(String supply: supplies) {//Add all available suuplies
			available.add(supply);
		}
		
		Set<String> recipesSet = new HashSet<>();
		for(String recipe: recipes)
			recipesSet.add(recipe);
		

		
		
		return null;
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
