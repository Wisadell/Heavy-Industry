package heavyindustry.content;

import arc.struct.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.Objectives.*;
import mindustry.type.*;

import static heavyindustry.content.HIBlocks.*;
import static heavyindustry.content.HIUnitTypes.*;
import static heavyindustry.content.HISectorPresets.*;
import static mindustry.content.Blocks.*;
import static mindustry.content.UnitTypes.*;
import static mindustry.content.SectorPresets.*;
import static mindustry.content.TechTree.*;

/**
 * Sets up content {@link TechNode tech tree nodes}. Loaded after every other content is instantiated.
 * @author Wisadell
 */
public class HITechTree {
    public static TechNode context = null;
    public static void load(){
        //items,liquids
        addToNode(Liquids.oil, () -> nodeProduce(HILiquids.nitratedOil, () -> {}));
        addToNode(Liquids.ozone, () -> nodeProduce(HILiquids.methane, () -> {}));
        addToNode(Items.sand, () -> nodeProduce(HIItems.rareEarth, () -> {}));
        addToNode(Items.silicon, () -> nodeProduce(HIItems.nanocore, () -> nodeProduce(HILiquids.nanofluid, () -> {})));
        addToNode(Items.thorium, () -> nodeProduce(HIItems.uranium, () -> nodeProduce(HIItems.chromium, () -> {})));
        addToNode(Items.surgeAlloy, () -> nodeProduce(HIItems.heavyAlloy, () -> {}));
        addToNode(Items.phaseFabric, () -> nodeProduce(HIItems.highEnergyFabric, () -> {}));
        //items,liquids-erekir
        addToNode(Items.oxide, () -> nodeProduce(HIItems.nanocoreErekir, () -> {}));
        //wall
        addToNode(copperWall, () -> node(armoredWall, () -> node(armoredWallLarge, () -> {})));
        addToNode(thoriumWall, () -> node(uraniumWall, () -> {
            node(uraniumWallLarge, () -> {});
            node(chromiumWall, () -> {
                node(chromiumWallLarge, () -> {});
                node(chromiumDoor, () -> node(chromiumDoorLarge, () -> {}));
            });
        }));
        addToNode(surgeWall, () -> node(heavyAlloyWall, () -> {
            node(heavyAlloyWallLarge, () -> {});
            node(nanoCompositeWall, () -> node(nanoCompositeWallLarge, () -> {}));
        }));
        //drill
        addToNode(waterExtractor, () -> {
            node(largeWaterExtractor, () -> {});
            node(slagExtractor, () -> {});
        });
        addToNode(blastDrill, () -> {
            node(cuttingDrill, Seq.with(new SectorComplete(impact0078)), () -> {});
            node(beamDrill, () -> {
                node(speedModule, () -> {});
                node(refineModule, () -> {});
                node(deliveryModule, () -> {});
            });
        });
        addToNode(oilExtractor, () -> node(reinforcedOilExtractor, () -> {}));
        //drill-erekir
        addToNode(cliffCrusher, () -> node(largeCliffCrusher, ItemStack.with(Items.graphite, 1600, Items.silicon, 600, Items.beryllium, 1200, Items.tungsten, 500), Seq.with(new OnSector(lake)), () -> {}));
        addToNode(impactDrill, () -> node(unitMinerDepot, () -> {}));
        addToNode(largePlasmaBore, () -> node(heavyPlasmaBore, ItemStack.with(Items.silicon, 6000, Items.oxide, 3000, Items.beryllium, 7000, Items.tungsten, 5000, Items.carbide, 2000), () -> {}));
        //distribution
        addToNode(junction, () -> {
            node(invertedJunction, () -> {});
            node(itemLiquidJunction, () -> {});
        });
        addToNode(plastaniumConveyor, () -> node(stackHelper, () -> {}));
        addToNode(phaseConveyor, () -> node(highEnergyItemNode, () -> {}));
        addToNode(titaniumConveyor, () -> node(chromiumEfficientConveyor, () -> {
            node(chromiumArmorConveyor, () -> node(chromiumStackConveyor, () -> node(chromiumStackRouter, () -> {})));
            node(chromiumItemBridge, () -> {});
            node(chromiumRouter, () -> {});
            node(chromiumJunction, () -> {});
            node(chromiumInvertedJunction, () -> {});
        }));
        //distribution-erekir
        addToNode(duct, () -> node(ductJunction, () -> {}));
        addToNode(armoredDuct, () -> {
            node(armoredDuctBridge, () -> {});
            node(waveDuct, () -> {
                node(waveDuctRouter, () -> node(overflowWaveDuct, () -> node(underflowWaveDuct, () -> {})));
                node(waveDuctBridge, () -> {});
            });
        });
        addToNode(ductUnloader, () -> node(rapidDuctUnloader, () -> {}));
        //liquid
        addToNode(impulsePump, () -> node(turboPump, () -> {}));
        addToNode(phaseConduit, () -> node(highEnergyLiquidNode, () -> {}));
        addToNode(platedConduit, () -> node(chromiumArmorConduit, () -> {
            node(chromiumLiquidBridge, () -> {});
            node(chromiumArmorLiquidContainer, () -> node(chromiumArmorLiquidTank, () -> {}));
        }));
        //liquid-erekir
        addToNode(reinforcedLiquidRouter, () -> {
            node(liquidSorter, () -> {});
            node(liquidValve, () -> {});
        });
        removeNode(reinforcedPump);
        addToNode(reinforcedConduit, () -> node(smallReinforcedPump, Seq.with(new OnSector(basin)), () -> node(reinforcedPump, () -> node(largeReinforcedPump, () -> {}))));
        //power
        addToNode(powerNode, () -> node(windTurbine, () -> {}));
        addToNode(powerNodeLarge, () -> node(powerNodeGiant, () -> node(powerNodeHighEnergy, () -> {})));
        addToNode(thoriumReactor, () -> node(uraniumReactor, () -> {}));
        addToNode(impactReactor, () -> node(magneticStormRadiationReactor, () -> {}));
        addToNode(batteryLarge, () -> node(armoredCoatedBattery, () -> {}));
        //power-erekir
        addToNode(beamNode, () -> {
            node(beamDiode, () -> {});
            node(beamInsulator, () -> {});
        });
        addToNode(turbineCondenser, () -> node(liquidConsumeGenerator, ItemStack.with(Items.beryllium, 2200, Items.graphite, 2400, Items.silicon, 2300, Items.tungsten, 1600, Items.oxide, 60), () -> {}));
        //production
        addToNode(kiln, () -> node(largeKiln, () -> {}));
        addToNode(pulverizer, () -> node(largePulverizer, () -> {
            node(uraniumSynthesizer, Seq.with(new OnSector(desolateRift)), () -> {});
            node(chromiumSynthesizer, Seq.with(new OnSector(desolateRift)), () -> {});
        }));
        addToNode(melter, () -> node(largeMelter, () -> {}));
        addToNode(surgeSmelter, () -> node(heavyAlloySmelter, () -> {}));
        addToNode(disassembler, () -> node(metalAnalyzer, Seq.with(new OnSector(desolateRift)), () -> {}));
        addToNode(cryofluidMixer, () -> {
            node(largeCryofluidMixer, Seq.with(new SectorComplete(impact0078)), () -> {});
            node(nanocoreActivator, () -> {});
        });
        addToNode(pyratiteMixer, () -> node(largePyratiteMixer, () -> {}));
        addToNode(blastMixer, () -> node(largeBlastMixer, () -> {}));
        addToNode(cultivator, () -> node(largeCultivator, () -> {}));
        addToNode(plastaniumCompressor, () -> node(largePlastaniumCompressor, Seq.with(new SectorComplete(tarFields)), () -> {}));
        addToNode(surgeSmelter, ()-> node(largeSurgeSmelter, () -> {}));
        addToNode(siliconCrucible, () -> node(blastSiliconSmelter, () -> {}));
        addToNode(siliconSmelter, () -> node(nanocoreConstructor, Seq.with(new SectorComplete(impact0078)), () -> node(nanocorePrinter, () -> {})));
        addToNode(sporePress, () -> node(nitrificationReactor, () -> node(nitratedOilSedimentationTank, () -> {})));
        addToNode(phaseWeaver, () -> {
            node(highEnergyEnergizer, Seq.with(new SectorComplete(impact0078)), () -> {
                node(highEnergyReactor, () -> {});
                node(highEnergyFabricFusionInstrument, () -> {});
            });
            node(highEnergyPhaseWeaver, () -> {});
        });
        //production-erekir
        addToNode(siliconArcFurnace, () -> {
            node(chemicalSiliconSmelter, ItemStack.with(Items.graphite, 2800, Items.silicon, 1000, Items.tungsten, 2400, Items.oxide, 50), () -> {});
            node(ventHeater, () -> {});
            node(nanocoreConstructorErekir, Seq.with(new SectorComplete(crossroads)), () -> node(nanocorePrinterErekir, Seq.with(new SectorComplete(origin)), () -> {}));
        });
        addToNode(electricHeater, () -> {
            node(largeElectricHeater, ItemStack.with(Items.tungsten, 3000, Items.oxide, 2400, Items.carbide, 800), () -> {});
            node(liquidFuelHeater, () -> {});
            node(heatReactor, () -> {});
        });
        addToNode(oxidationChamber, () -> node(largeOxidationChamber, ItemStack.with(Items.tungsten, 3600, Items.graphite, 4400, Items.silicon, 4400, Items.beryllium, 6400, Items.oxide, 600, Items.carbide, 1400), () -> {}));
        addToNode(surgeCrucible, () -> node(largeSurgeCrucible, ItemStack.with(Items.graphite, 4400, Items.silicon, 4000, Items.tungsten, 4800, Items.oxide, 960, Items.surgeAlloy, 1600), () -> {}));
        addToNode(carbideCrucible, () -> node(largeCarbideCrucible, ItemStack.with(Items.thorium, 6000, Items.tungsten, 8000, Items.oxide, 1000, Items.carbide, 1200), () -> {}));
        //defense
        addToNode(illuminator, () -> node(lighthouse, () -> {}));
        addToNode(mendProjector, () -> node(mendDome, () -> {}));
        addToNode(overdriveDome, () -> node(assignOverdrive, () -> {}));
        //defense-erekir
        addToNode(radar, () -> node(largeRadar, ItemStack.with(Items.graphite, 3600, Items.silicon, 3200, Items.beryllium, 600, Items.tungsten, 200, Items.oxide, 10), () -> {}));
        //storage
        addToNode(coreShard, () -> node(coreBeStationed, () -> {}));
        addToNode(router, () -> node(bin, ItemStack.with(Items.copper, 550, Items.lead, 350), () -> node(machineryUnloader, ItemStack.with(Items.copper, 300, Items.lead, 200), () -> {})));
        addToNode(vault, () -> node(cargo, () -> {}));
        addToNode(unloader, () -> node(rapidUnloader, () -> node(rapidDirectionalUnloader, () -> {})));
        //payload
        addToNode(payloadConveyor, () -> node(payloadJunction, () -> {}));
        //payload-erekir
        addToNode(reinforcedPayloadConveyor, () -> node(reinforcedPayloadJunction, () -> {}));
        //unit
        addToNode(tetrativeReconstructor, () -> node(titanReconstructor, () -> node(experimentalUnitFactory, Seq.with(new SectorComplete(bombardmentWarzone)), () -> {})));
        //unit-erekir
        addToNode(unitRepairTower, () -> node(largeUnitRepairTower, ItemStack.with(Items.graphite, 2400, Items.silicon, 3000, Items.tungsten, 2600, Items.oxide, 1200, Items.carbide, 600), Seq.with(new OnSector(siege)), () -> {}));
        addToNode(basicAssemblerModule, () -> node(seniorAssemblerModule, () -> {}));
        //logic
        addToNode(memoryCell, () -> node(buffrerdMemoryCell, () -> node(buffrerdMemoryBank, () -> {})));
        addToNode(hyperProcessor, () -> node(matrixProcessor, () -> {}));
        addToNode(largeLogicDisplay, () -> node(hugeLogicDisplay, () -> {}));
        addToNode(switchBlock, () -> node(heatSink, () -> {
            node(heatFan, () -> {});
            node(heatSinkLarge, () -> {});
        }));
        //turret
        addToNode(segment, () -> node(dissipation, () -> {}));
        addToNode(duo, () -> {
            node(rocketLauncher, Seq.with(new SectorComplete(ruinousShores)), () -> node(multipleRocketLauncher, Seq.with(new SectorComplete(stainedMountains)), () -> {
                node(largeRocketLauncher, Seq.with(new SectorComplete(extractionOutpost)), () -> node(spark, () -> node(fireworks, Seq.with(new SectorComplete(bombardmentWarzone)), () -> {})));
                node(rocketSilo, Seq.with(new SectorComplete(tarFields)), () -> {});
            }));
            node(cloudbreaker, () -> {});
        });
        addToNode(scorch, () -> node(dragonBreath, () -> {}));
        addToNode(arc, () -> node(hurricane, () -> {}));
        addToNode(salvo, () -> {
            node(spike, () -> node(fissure, () -> {}));
            node(minigun, () -> {});
        });
        addToNode(meltdown, () -> {
            node(frost, Seq.with(new SectorComplete(fallenStronghold)), () -> {});
            node(judgement, () -> {});
        });
        //turret-erekir
        addToNode(breach, () -> node(rupture, () -> {}));
        //tier6
        addToNode(reign, () -> node(suzerain, () -> {}));
        addToNode(corvus, () -> node(supernova, () -> {}));
        addToNode(toxopid, () -> node(cancer, () -> {}));
        addToNode(eclipse, () -> node(sunlit, () -> {}));
        addToNode(oct, () -> node(windstorm, () -> {}));
        addToNode(omura, () -> node(mosasaur, () -> {}));
        addToNode(navanax, () -> node(killerWhale, () -> {}));
        //tier6-erekir
        addToNode(conquer, () -> node(dominate, () -> {}));
        addToNode(collaris, () -> node(oracle, () -> {}));
        addToNode(disrupt, () -> node(havoc, () -> {}));
        //sector presets
        addToNode(SectorPresets.craters, () -> node(iceboundTributary, Seq.with(new SectorComplete(SectorPresets.craters), new Research(Items.metaglass)), () -> {}));
        addToNode(ruinousShores, () -> {
            node(desertWastes, Seq.with(new SectorComplete(ruinousShores), new Research(airFactory)), () -> {});
            node(whiteoutPlains, Seq.with(new SectorComplete(ruinousShores)), () -> {});
        });
        addToNode(windsweptIslands, () -> node(snowyLands, Seq.with(new SectorComplete(windsweptIslands)), () -> {}));
        addToNode(coastline, () -> node(sunkenPier, Seq.with(new SectorComplete(coastline)), () -> {}));
        addToNode(desolateRift, () -> {
            node(fallenStronghold, Seq.with(new SectorComplete(desolateRift)), () -> {});
            node(coastalCliffs, Seq.with(new SectorComplete(desolateRift), new Research(overdriveProjector), new Research(swarmer), new Research(foreshadow), new Research(navanax)), () -> {});
        });
        addToNode(planetaryTerminal, () -> node(bombardmentWarzone, Seq.with(new SectorComplete(planetaryTerminal)), () -> {}));
    }

    public static void addToNode(UnlockableContent content, Runnable children){
        context = TechTree.all.find(t -> t.content == content);
        children.run();
    }

    public static void removeNode(UnlockableContent content){
        context = TechTree.all.find(t -> t.content == content);
        if(context != null){
            context.remove();
        }
    }

    public static void node(UnlockableContent content, Runnable children){
        node(content, content.researchRequirements(), children);
    }

    public static void node(UnlockableContent content, ItemStack[] requirements, Runnable children){
        node(content, requirements, null, children);
    }

    public static void node(UnlockableContent content, ItemStack[] requirements, Seq<Objective> objectives, Runnable children){
        TechNode node = new TechNode(context, content, requirements);
        if(objectives != null){
            node.objectives.addAll(objectives);
        }

        TechNode prev = context;
        context = node;
        children.run();
        context = prev;
    }

    public static void node(UnlockableContent content, Seq<Objective> objectives, Runnable children){
        node(content, content.researchRequirements(), objectives, children);
    }

    public static void nodeProduce(UnlockableContent content, Seq<Objective> objectives, Runnable children){
        node(content, content.researchRequirements(), objectives.add(new Produce(content)), children);
    }

    public static void nodeProduce(UnlockableContent content, Runnable children){
        nodeProduce(content, new Seq<>(), children);
    }
}
