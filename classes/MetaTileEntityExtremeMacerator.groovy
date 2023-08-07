import gregtech.api.metatileentity.MetaTileEntity
import gregtech.api.metatileentity.interfaces.IGregTechTileEntity
import gregtech.api.metatileentity.multiblock.IMultiblockPart
import gregtech.api.metatileentity.multiblock.RecipeMapMultiblockController
import gregtech.api.pattern.BlockPattern
import gregtech.api.pattern.FactoryBlockPattern
import gregtech.api.recipes.RecipeMap
import gregtech.api.recipes.builders.SimpleRecipeBuilder
import gregtech.client.renderer.ICubeRenderer

import gregtech.client.renderer.texture.Textures
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType
import gregtech.common.blocks.BlockMachineCasing
import gregtech.common.blocks.MetaBlocks
import gregtech.api.unification.material.Materials;
import gregtech.api.pattern.TraceabilityPredicate;
import gregtech.api.metatileentity.multiblock.*

import net.minecraft.init.Blocks
import net.minecraft.util.ResourceLocation


public class MetaTileEntityExtremeMacerator extends RecipeMapMultiblockController {

    private static final RecipeMap<SimpleRecipeBuilder> EMACERATOR_RECIPES = new RecipeMap<>("extreme_macerator", 1, 3, 0, 0, new SimpleRecipeBuilder(), false)


    public MetaTileEntityExtremeMacerator(ResourceLocation metaTileEntityId) {
        super(metaTileEntityId, EMACERATOR_RECIPES)
    }

    @Override
    public MetaTileEntity createMetaTileEntity(IGregTechTileEntity tileEntity) {
        return new MetaTileEntityExtremeMacerator(metaTileEntityId)
    }

    @Override
    protected BlockPattern createStructurePattern() {
        return FactoryBlockPattern.start()
                .aisle("CCC", "CCC", "CCC")
                .aisle("CCC", "CFC", "C#C")
                .aisle("CCC", "CFC", "C#C")
                .aisle("CCC", "CFC", "C#C")
                .aisle("CCC", "CSC", "CCC")
                .where('S' as char, selfPredicate())
                .where('C' as char, states(getCasingState()).setMinGlobalLimited(30).or(autoAbilities(true, true, true, true, false, false, false)))
                .where('#' as char, air())
                .where('F' as char, frames(Materials.HSSS))
                .build()
    }

    @Override
    public ICubeRenderer getBaseTexture(IMultiblockPart sourcePart) {
        return Textures.ROBUST_TUNGSTENSTEEL_CASING
        }
    private IBlockState getCasingState() {
      return MetaBlocks.METAL_CASING.getState(MetalCasingType.HSSE_STURDY)
        }
}
