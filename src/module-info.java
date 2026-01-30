module dorkbox.minlog {
    exports com.esotericsoftware.minlog;

    requires transitive dorkbox.updates;
    requires transitive org.slf4j;

    requires transitive kotlin.stdlib;
}
