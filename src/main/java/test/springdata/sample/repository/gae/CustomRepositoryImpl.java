package test.springdata.sample.repository.gae;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import test.springdata.sample.domain.Parent;
import test.springdata.sample.repository.CustomRepository;
import test.springdata.sample.util.KeyUtils;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@NoRepositoryBean
public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
        implements CustomRepository<T, ID> {
    private static Logger logger = LoggerFactory.getLogger(CustomRepositoryImpl.class);

    @PersistenceContext
    private EntityManager em;

    private Class<T> domainClass;

    private Key parentKey;

    public CustomRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);

        this.em = entityManager;
        this.domainClass = domainClass;
    }

    private Key getParentKey() {
        if (parentKey != null) {
            return parentKey;
        }

        List<Parent> parents = em.createQuery("SELECT p FROM Parent p", Parent.class)
                .getResultList();
        if (parents == null || parents.size() == 0) {
            return null;
        }

        Parent parent = parents.get(0);
        parentKey = KeyFactory.stringToKey(parent.getKey());
        return parentKey;
    }

    @Override
    public T findOne(Long id) {
        return em.find(domainClass,
                KeyUtils.toKeyString(getParentKey(), domainClass.getSimpleName(), id));
    }
}
