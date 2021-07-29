package com.kdu;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private HashMap<String, Location> locationCache = new HashMap<>();

    public Map<String, Location> getLocationCache(){
        return this.locationCache;
    }

    public Location getLocationFromCache(String addressPoint){
        if(!this.locationCache.isEmpty() && this.locationCache.containsKey(addressPoint))
            return this.locationCache.get(addressPoint);
        return new Location();
    }

    public void putLocationInCache(String addressPoint, Location location){
        this.locationCache.put(addressPoint,location);
    }
}
