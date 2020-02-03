//package com.codility.tasks.dropwizard.solution;
//
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Optional;
//
//import com.codahale.metrics.health.HealthCheck;
//import io.dropwizard.Application;
//import io.dropwizard.Configuration;
//import io.dropwizard.setup.Bootstrap;
//import io.dropwizard.setup.Environment;
//
//public class CarResource {
//    private final CarDAO dao;
//
//    public CarResource(CarDAO dao) {
//        this.dao = dao;
//    }
//
//    // Please implement your REST endpoints here
//}
//
//class CarServiceHealthCheck extends HealthCheck {
//    private final CarDAO dao;
//
//    public CarServiceHealthCheck(CarDAO dao) {
//        this.dao = dao;
//    }
//
//    @Override
//    protected Result check() throws Exception {
//        return null;
//    }
//}
//
//class App extends Application<Configuration> {
//    private final CarDAO carDao;
//
//    public App(CarDAO carDao) {
//        this.carDao = carDao;
//    }
//
//    @Override
//    public void run(Configuration c, Environment e) throws Exception {
//        e.jersey().register(new CarResource(carDao));
//        e.healthChecks().register("Car service healthcheck", new CarServiceHealthCheck(carDao));
//    }
//}
