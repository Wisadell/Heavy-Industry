package heavyindustry.world.blocks.heat;

import arc.*;
import arc.math.*;
import arc.util.io.*;
import mindustry.graphics.*;
import mindustry.ui.*;
import mindustry.world.blocks.heat.*;
import mindustry.world.blocks.power.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

import static heavyindustry.core.HeavyIndustryMod.*;

/**
 * @author guiY
 */
public class ThermalHeater extends ThermalGenerator {
    public float outputHeat = 5f;
    public float warmupRate = 0.15f;
    public ThermalHeater(String name) {
        super(name);

        drawer = new DrawMulti(new DrawDefault(), new DrawHeatOutput());
        rotateDraw = false;
        rotate = true;
        canOverdrive = false;
        drawArrow = true;
    }

    @Override
    public void setStats(){
        super.setStats();

        stats.add(Stat.output, Core.bundle.format(name("stat", "outputHeat"), outputHeat * (size * size)));
    }

    @Override
    public void setBars(){
        super.setBars();

        addBar("heat", (ThermalHeaterBuild entity) -> new Bar("bar.heat", Pal.lightOrange, () -> entity.heat > 0 ? 1 : 0));
    }

    public class ThermalHeaterBuild extends ThermalGeneratorBuild implements HeatBlock{
        public float heat;
        @Override
        public void updateTile(){
            super.updateTile();

            heat = Mathf.approachDelta(heat, outputHeat * efficiency * productionEfficiency, warmupRate * delta());
        }

        @Override
        public float heatFrac(){
            return heat / outputHeat;
        }

        @Override
        public float heat(){
            return heat;
        }

        @Override
        public void write(Writes write){
            super.write(write);
            write.f(heat);
        }

        @Override
        public void read(Reads read, byte revision){
            super.read(read, revision);
            heat = read.f();
        }
    }
}
