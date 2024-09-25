package heavyindustry.world.blocks.distribution

import arc.util.Time

/** An electrically powered and accelerated unloader is one that adjusts the acceleration parameters of the original version and assigns them back after acceleration. */
open class OverchargeDirectionalUnloader(name: String) : AdaptDirectionalUnloader(name) {
    init {
        hasPower = true
    }

    open inner class OverchargeDirectionalUnloaderBuild : AdaptDirectionalUnloaderBuild() {
        var ts = 1f
        var td = 0f
        var powers = 0f

        override fun delta(): Float {
            return Time.delta * ts
        }

        override fun applyBoost(intensity: Float, duration: Float) {
            if (intensity >= ts) td = td.coerceAtLeast(duration)
            ts = ts.coerceAtLeast(intensity)
        }

        override fun updateTile() {
            powers = power.status

            if (td > 0) {
                td -= Time.delta
                if (td <= 0) ts = 1f
            }

            timeScale = Math.max(ts * powers, 0.001f)
            timeScaleDuration = td / powers.coerceAtLeast(0.001f)

            if (powers >= 0.999) super.updateTile()
        }
    }
}