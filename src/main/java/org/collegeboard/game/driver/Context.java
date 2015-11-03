package org.collegeboard.game.driver;

import java.util.Map;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNull;

/**
 * Context class where state can be shared across Game.
 * NOTE: This is not Thread Safe class. 
 *
 * @author pulkit.mehra
 * Created: Nov 2, 2015
 */
public class Context {

    /** The context map. */
    private Map<String, Object> contextMap;

    /**
     * Instantiates a new context.
     *
     * @param contextMap the context map
     */
    public Context(Map<String, Object> contextMap) {
        this.contextMap = contextMap;
    }

    /**
     * Gets the value for give key.
     *
     * @param key the key
     * @return the object
     */
    public Object get(@NotNull @NotBlank String key) {
        return contextMap.get(key);
    }

    /**
     * Put Key and Value.
     *
     * @param key the key
     * @param value the value
     */
    public void put(@NotNull @NotBlank String key, @NotNull Object value) {
        contextMap.put(key, value);
    }

    /**
     * Removes the Key and value.
     *
     * @param key the key
     */
    public void remove(@NotNull @NotBlank String key) {
        contextMap.remove(key);
    }
}
