package com.yahoo.elide.example;

import com.yahoo.elide.Elide;
import com.yahoo.elide.audit.Slf4jLogger;
import com.yahoo.elide.dbmanagers.hibernate5.HibernateManager;
import com.yahoo.elide.resources.JsonApiEndpoint;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Example application for resource config
 */
public class ExampleResource extends ResourceConfig {
    public ExampleResource() {
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                JsonApiEndpoint.DefaultOpaqueUserFunction noUserFn = v -> null;
                bind(noUserFn).to(JsonApiEndpoint.DefaultOpaqueUserFunction.class).named("elideUserExtractionFunction");

                StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
                SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
                bind(new Elide(new Slf4jLogger(), new HibernateManager(sessionFactory))).to(Elide.class).named("elide");
            }
        });
    }
}
