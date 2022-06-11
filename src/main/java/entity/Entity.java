/*
Copyright © Michael Steinmoetzger (ShortPing) 2015 - 2022

Alle Rechte sind für dieses Projekt verbehalten, sofern es nicht
anders in einer Lizenzdatei angegeben ist.

All rights are reserved for this project, unless otherwise
stated in a license file.
*/
package entity;

import entity.world.Location;
import eu.steinmoetzger.platformer.Main;
import eu.steinmoetzger.platformer.game.Game;
import eu.steinmoetzger.platformer.render.Texture;
import eu.steinmoetzger.platformer.render.animation.Animatable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class Entity extends Animatable {

    private final UUID uuid;
    private Location location;
    private boolean visible;

    public Entity(Texture texture, Location location) {
        this.uuid = UUID.randomUUID();
        this.texture = texture;
        this.location = location;
        this.visible = false;
    }

    public void show() {
        this.visible = true;
    }

    public void hide() {
        this.visible = false;
    }

    public void load() {
        Main.INSTANCE.loadEntity(this);
    }

    public void unload() {
        Main.INSTANCE.removeEntity(this);
    }


}
