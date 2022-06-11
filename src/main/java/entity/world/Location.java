/*
Copyright © Michael Steinmoetzger (ShortPing) 2015 - 2022

Alle Rechte sind für dieses Projekt verbehalten, sofern es nicht
anders in einer Lizenzdatei angegeben ist.

All rights are reserved for this project, unless otherwise
stated in a license file.
*/
package entity.world;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Location {

    private float x;
    private float y;
    private float rotation;

    public void addX(float i) {
        x += i;
    }

    public void addY(float i) {
        y += i;
    }

    public void addRotation(float i) {
        rotation += i;
    }

    public void deductX(float i) {
        x -= i;
    }

    public void deductY(float i) {
        y -= i;
    }

    public void deductRotation(float i) {
        rotation -= i;
    }


}
