import gregtech.common.metatileentities.MetaTileEntities
import gregtech.client.renderer.texture.Textures

log.info(Textures.CLIPBOARD_RENDERER)

if (isReloading()) return

import classes.MetaTileEntityEnergyPacker
import classes.MetaTileEntityInscryber
import classes.MetaTileEntityExtremeMacerator

MetaTileEntities.registerMetaTileEntity(32102, new MetaTileEntityEnergyPacker(new ResourceLocation("gregtech", "energy_packer")))
MetaTileEntities.registerMetaTileEntity(32101, new MetaTileEntityExtremeMacerator(new ResourceLocation("gregtech", "extreme_macerator")))
MetaTileEntities.registerMetaTileEntity(32104, new MetaTileEntityInscryber(new ResourceLocation("gregtech", "inscryber")))
