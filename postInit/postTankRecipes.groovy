return

sus = ["arc_furnace",
"assembler",
"assembly_line",
"autoclave",
"centrifuge",
"chemical_bath",
"chemical_reactor",
"circuit_assembler",
"cutter",
"electrolyzer",
"fluid_solidifier",
"mixer"]
import gregtech.api.recipes.GTRecipeHandler
import gregtech.api.recipes.ingredients.IntCircuitIngredient

// sus = ["chemical_reactor"]

for (suspect in sus) {
  recipes = recipemap(suspect)
  recipelist = recipes.getRecipeList()
  GTRecipeHandler.removeAllRecipes(recipes)
  for (recipe in recipelist) {
    if (recipe.outputs[0] == null) {
      continue // if there is no item outputs(only fluid outputs)
    }
    predicate = recipes.recipeBuilder().duration(recipe.duration).EUt(recipe.EUt).outputs(recipe.outputs)
    for (fluidinputs in recipe.fluidInputs) {
      predicate.notConsumable(fluidinputs.getInputFluidStack()) // dont consume fluid inputs
    }
    for (iteminputs in recipe.inputs){
      if (iteminputs instanceof IntCircuitIngredient) {
        predicate.notConsumable(iteminputs.getInputStacks()[0]) // programmed circuit
        continue
      }
      predicate.inputs(iteminputs.getInputStacks()[0]) // item input
    }
    predicate.buildAndRegister()
  }
  log.info("another imposter is finished")
}
