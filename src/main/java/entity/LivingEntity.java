/*
Copyright © Michael Steinmoetzger (ShortPing) 2015 - 2022

Alle Rechte sind für dieses Projekt verbehalten, sofern es nicht
anders in einer Lizenzdatei angegeben ist.

All rights are reserved for this project, unless otherwise
stated in a license file.
*/
package entity;

import entity.world.Location;
import eu.steinmoetzger.platformer.render.Texture;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LivingEntity extends Entity {


    private boolean invincible;
    private boolean dead;

    private int maxHealth;
    private int health;

    public LivingEntity(Texture texture, Location location, boolean invincible, boolean dead, int maxHealth, int health) {
        super(texture, location);
        this.invincible = invincible;
        this.dead = dead;
        this.maxHealth = maxHealth;
        this.health = health;
    }
}
