package test.springdata.sample.domain;

import javax.persistence.PostLoad;

import com.google.appengine.api.datastore.KeyFactory;

public class PlayerEntityListener {
    @PostLoad
    public void postLoad(Player entity) {
        entity.setEntityId(KeyFactory.stringToKey(entity.getId()).getId());
    }
}
