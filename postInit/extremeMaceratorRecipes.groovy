
def recipe = recipemap('macerator')
def ores = ore('ore*')
for (ore in ores) {
  currentRecipe = mods.gregtech.macerator.find(2, [ore], null)
  if (currentRecipe != null) {
    chancedOutputs = currentRecipe['chancedOutputs']
    mods.gregtech.extreme_macerator.recipeBuilder()
      .inputs(ore)
      .outputs(currentRecipe['outputs'][0] * (currentRecipe['outputs'][0].count * 4))
      .outputs(chancedOutputs[1].getItemStack())
      .chancedOutput(chancedOutputs[0].getItemStack(), 5650, 850)
      .duration(1)
      .EUt(30720)
      .buildAndRegister()
    }
}

crafting.shapedBuilder()
  .name('gregtech:extreme_macerator')
  .output(item('gregtech:machine:32101'))
  .matrix('BNB', 'PSP', 'BNB')
  .key('N', ore('circuitZpm'))
  .key('S', item('gregtech:machine:1028'))
  .key('B', item('gregtech:meta_tool_head_buzz_saw:396'))
  .key('P', item('gregtech:meta_item_1:177'))
  .register()
