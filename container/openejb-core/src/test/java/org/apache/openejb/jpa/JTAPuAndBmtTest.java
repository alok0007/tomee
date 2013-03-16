package org.apache.openejb.jpa;

import org.apache.openejb.jee.Empty;
import org.apache.openejb.jee.StatelessBean;
import org.apache.openejb.jee.jpa.unit.Persistence;
import org.apache.openejb.jee.jpa.unit.PersistenceUnit;
import org.apache.openejb.junit.ApplicationComposer;
import org.apache.openejb.testing.Configuration;
import org.apache.openejb.testing.Module;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertNotNull;

@RunWith(ApplicationComposer.class)
public class JTAPuAndBmtTest {
    @EJB
    private BmtManager bmtManager;

    @Configuration
    public Properties config() {
        final Properties p = new Properties();
        p.put("JTAPuAndBmtTest", "new://Resource?type=DataSource");
        p.put("JTAPuAndBmtTest.JdbcDriver", "org.hsqldb.jdbcDriver");
        p.put("JTAPuAndBmtTest.JdbcUrl", "jdbc:hsqldb:mem:bval");
        return p;
    }

    @Module
    public StatelessBean app() throws Exception {
        final StatelessBean bean = new StatelessBean(BmtManager.class);
        bean.setLocalBean(new Empty());
        return bean;
    }

    @Module
    public Persistence persistence() {
        final PersistenceUnit unit = new PersistenceUnit("foo-unit");
        unit.addClass(TheEntity.class);
        unit.setProperty("openjpa.jdbc.SynchronizeMappings", "buildSchema(ForeignKeys=true)");
        unit.getProperties().setProperty("openjpa.RuntimeUnenhancedClasses", "supported");
        unit.setExcludeUnlistedClasses(true);

        final Persistence persistence = new Persistence(unit);
        persistence.setVersion("2.0");
        return persistence;
    }

    @LocalBean
    @Stateless
    @TransactionManagement(TransactionManagementType.BEAN)
    public static class BmtManager {
        @PersistenceContext
        private EntityManager em;

        @Resource
        private EJBContext ctx;

        public TheEntity persist() {
            try {
                ctx.getUserTransaction().begin();
                final TheEntity entity = new TheEntity();
                entity.setName("name");
                em.persist(entity);
                ctx.getUserTransaction().commit();
                return entity;
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }

        public TheEntity findWithJpQl() {
            final TypedQuery<TheEntity> query = em.createQuery("select e from JTAPuAndBmtTest$TheEntity e", TheEntity.class);
            query.getResultList(); // to ensure we don't break OPENEJB-1443
            return query.getResultList().iterator().next();
        }

        public void update(final TheEntity entity) {
            entity.setName("new");
            try {
                ctx.getUserTransaction().begin();
                em.merge(entity);
                ctx.getUserTransaction().commit();
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Entity
    public static class TheEntity {
        @Id
        @GeneratedValue
        private long id;
        private String name;

        public long getId() {
            return id;
        }

        public void setId(long i) {
            id = i;
        }

        public String getName() {
            return name;
        }

        public void setName(String n) {
            name = n;
        }
    }

    @Test
    public void valid() {
        assertNotNull(bmtManager.persist());

        final TheEntity entity = bmtManager.findWithJpQl();
        assertNotNull(entity);

        bmtManager.update(entity); // will throw an exception if any error
    }
}