package org.academiadecodigo.medievalwar.objects;

import org.academiadecodigo.medievalwar.objects.terrain.Terrain;

/**
 * Created by codecadet on 10/06/2017.
 */
public interface Damager {

    void hit(Damageable unit, Terrain attackerTerrain,Terrain defenderTerrain);
}
