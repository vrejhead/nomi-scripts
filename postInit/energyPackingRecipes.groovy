def tiers = ['zpm', 'uv', 'uhv', 'uev', 'uiv', 'uxv', 'opv']

for (int i = 1; i <= 7; i++) {
  recipemap('naquadah_reactor_1').recipeBuilder().inputs(item('nomiaddons:' + tiers[i - 1] + '_power')).outputs(metaitem('boltWood')).duration(1).EUt(-1 * 2 * 4 ** (7 + i)).buildAndRegister()
  recipemap('naquadah_reactor_2').recipeBuilder().inputs(item('nomiaddons:' + tiers[i - 1] + '_power')).outputs(metaitem('boltWood')).duration(1).EUt(-1 * 2 * 4 ** (7 + i)).buildAndRegister()
  recipemap('energy_packer').recipeBuilder().outputs(item('nomiaddons:' + tiers[i - 1] + '_power')).circuitMeta(i).duration(1).EUt(2 * 4 ** (7 + i)).buildAndRegister()
}


// recipemap('energy_packer').recipeBuilder().circuitMeta(i).outputs(item('nomiaddons:' + tiers[i - 1] + '_power')).duration(1).EUt(2 * 4 ** (7 + i)).buildAndRegister()


crafting.shapedBuilder()
  .name('gregtech:energy_packer')
  .output(item('gregtech:machine:32102'))
  .matrix('SPS', 'UFU', 'SPS')
  .key('S', item('appliedenergistics2:material:47'))
  .key('P', item('gregtech:meta_item_1:178'))
  .key('U', ore('circuitUv'))
  .key('F', item('gregtech:meta_item_1:208'))
  .register()
