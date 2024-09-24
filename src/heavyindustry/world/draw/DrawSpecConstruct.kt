package heavyindustry.world.draw

import heavyindustry.graphics.Drawc
import heavyindustry.util.HIUtils
import arc.graphics.Color
import arc.graphics.g2d.Draw
import arc.graphics.g2d.TextureRegion
import mindustry.gen.Building
import mindustry.graphics.Layer
import mindustry.graphics.Pal
import mindustry.world.Block
import mindustry.world.draw.DrawBlock

open class DrawSpecConstruct : DrawBlock() {
    @JvmField var stages = 3
    @JvmField var constructColor1: Color = Pal.accent
    @JvmField var constructColor2: Color = Pal.accent

    lateinit var stageRegions: Array<TextureRegion>

    override fun draw(build: Building) {
        val stage = (build.progress() * stages).toInt()
        val stageProgress = (build.progress() * stages) % 1f

        for (i in 0 until stage) {
            Draw.rect(stageRegions[i], build.x, build.y)
        }

        Draw.draw(Layer.blockOver) {
            Drawc.construct(build, stageRegions[stage], constructColor1, constructColor2, 0f, stageProgress, build.warmup() * build.efficiency(), build.totalProgress() * 1.6f)
        }
    }

    override fun load(block: Block) {
        stageRegions = HIUtils.split(block.name + "-construct", 32, 0)
    }
}