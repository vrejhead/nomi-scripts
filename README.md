# multiblocks

---
MetaTileEntityEnergyPacker(Energy Packager)(Metadata: 32102):
## gated by zpm field generator(awakened draconium)
### this is mostly for large transdimensional energy transfer without p2p(use dimensional transcievers to transport the items)
accepts unlimited energy hatches(most likely you will use up to 16x 16A UHV energy hatches)
takes the energy and compresses it into an item which can be decompressed for energy in naquadah reactors
> the naquadah reactors accept up to 3 dynamo hatches by default so if you want to use more than that you have to go into /(instance name)/minecraft/scripts/multiblocks_normal.zs(or multiblocks_expert on hm.zs),
>
> scroll to the naquadah reactors section, and remove the .setMaxGlobalLimited(3) on OUTPUT_ENERGY, and .setMinGlobalLimited(1) on EXPORT_ITEMS(restart game)(repeat on the other naq reactor if you want)
>
> this makes the naq reactor accept up to 16 dynamo hatches(cause 18 casings - 1 controller - 1 input bus = 16)

using this in naq reactors output wood bolts for the lol-s but you can turn on void items to allow for 0 output buses

---
MetaTileEntityExtremeMacerator(Extreme Macerator)(Metadata: 32101):
## gated by t3 ore drilling plant(assembly line in nm, taranium in hm)

### this is mostly for quadrupling mm ores without losing sanity
exactly what the tooltip says, acts like an ore drill and quadruples your ores(with the same amount of byproducts)

every recipe takes 1t at luv, but im pretty sure the ore plant takes more than 1t per ore so you also get a time discount ig


---
MetaTileEntityInscryber(Large Inscryption Factory)(Metadata: 32103):
## gated by luv forming press(assembly line)
### this is mostly for making ae2 usable :trollface:
multiblock version of ae2 inscriber, takes 50s for printed circuits and 100s for processors

does a stack at a time(parallel hatches replacing this will be soontm), recipes are all ev

---

# scripts

---

## postTankRecipes.groovy
### this is disabled by default, to enable it, delete the ```return``` on line 1 of the script

this is what it says, changes recipes to make post tank(dont use it in hm im watching) less laggy

most recipes have their fluid inputs set to not consume(you dont need a creative tank anymore, just fill the fluid inputs and they will never deplete)

(some recipes with fluids arent changed like the distillery cause you dont need to use it post tank at all)

recipes have their fluid outputs removed for obvious reasons, recipes with no item outputs and only fluid ones are removed
