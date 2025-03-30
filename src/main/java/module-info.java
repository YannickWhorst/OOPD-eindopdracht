module towerShower {
    requires hanyaeger;

    exports main;
    exports main.entities.map;

    opens backgrounds;
    opens sprites.goblins;
    opens sprites.tiles;
    opens sprites.towers;
}
