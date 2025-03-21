module waterworld {
    requires hanyaeger;

// TODO: Change exports
    exports com.github.hanyaeger.tutorial;
    exports com.github.hanyaeger.tutorial.entities.map;

// TODO: Change opens
    opens audio;
    opens backgrounds;
    opens sprites;
}
