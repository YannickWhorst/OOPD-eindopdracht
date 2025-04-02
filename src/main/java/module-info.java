module towerShower {
    requires hanyaeger;

    exports main;
    exports main.entities.map;
    exports main.entities.map.tiles;
    exports main.entities.towers;

    opens backgrounds;
    opens sprites.goblins;
    opens sprites.tiles;
    opens sprites.towers;
}
