/*
Copyright © Michael Steinmoetzger (ShortPing) 2015 - 2022

Alle Rechte sind für dieses Projekt verbehalten, sofern es nicht
anders in einer Lizenzdatei angegeben ist.

All rights are reserved for this project, unless otherwise
stated in a license file.
*/
package eu.steinmoetzger.platformer.render.animation;

import eu.steinmoetzger.platformer.render.Texture;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Animation {

    private Texture[] animationQueue;
    private boolean repeat;
    private float delay;

    public Animation(int delay, Texture... textures) {
        this.animationQueue = textures;
        this.delay = delay;
        this.repeat = false;
    }

    public Animation(int delay, boolean repeat, Texture... textures) {
        this.animationQueue = textures;
        this.delay = delay;
        this.repeat = repeat;
    }

}
