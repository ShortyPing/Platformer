/*
Copyright © Michael Steinmoetzger (ShortPing) 2015 - 2022

Alle Rechte sind für dieses Projekt verbehalten, sofern es nicht
anders in einer Lizenzdatei angegeben ist.

All rights are reserved for this project, unless otherwise
stated in a license file.
*/
package eu.steinmoetzger.platformer.render;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Texture {

    private final String sprite;
    private int size;

    public Texture(String sprite, int size) {
        this.sprite = sprite;
        this.size = size;
    }
}
