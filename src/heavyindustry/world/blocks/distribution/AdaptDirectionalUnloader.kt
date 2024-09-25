package heavyindustry.world.blocks.distribution

import mindustry.world.blocks.distribution.DirectionalUnloader

open class AdaptDirectionalUnloader(name: String) : DirectionalUnloader(name) {
    open inner class AdaptDirectionalUnloaderBuild : DirectionalUnloaderBuild() {
        private var counter = 0f

        /** Make its uninstallation speed no longer affected by frame rate. */
        override fun updateTile() {
            counter += edelta()
            val limit = speed

            while (counter >= limit) {
                unloadTimer = speed
                super.updateTile()
                counter -= limit
            }
        }
    }
}
