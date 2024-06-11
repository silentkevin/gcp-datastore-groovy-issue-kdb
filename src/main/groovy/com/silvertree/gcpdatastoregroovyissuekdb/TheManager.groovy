package com.silvertree.gcpdatastoregroovyissuekdb

import com.google.cloud.datastore.Entity
import com.google.common.collect.Lists
import com.silvertree.gcpdatastoregroovyissuekdb.dao.GroovyDAO
import com.silvertree.gcpdatastoregroovyissuekdb.dao.JavaDAO
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
@CompileStatic
@Slf4j
class TheManager {
    @Autowired MyDatastoreRepository myDatastoreRepository
    @Autowired JavaDAO javaDAO
    @Autowired GroovyDAO groovyDAO

    Integer runNumber = 1

    @Scheduled(initialDelay = 1_000, fixedRate = 5_000)
    void doSomething() {
        log.info("doSomething - start")
        MyEntity entity = new MyEntity(id: runNumber, stringField1: "stringField1_$runNumber".toString(), stringField2: "stringField2_$runNumber".toString())
        if (runNumber % 2 == 0) {
            entity.setStringField3("stringField3_$runNumber".toString())
        } else {
            entity.setStringField3(null)
        }
        MyEntity entityAfter = myDatastoreRepository.save(entity)
        log.info("doSomething - id=${entityAfter.getId()}, stringField1=${entityAfter.getStringField1()}, stringField2=${entityAfter.getStringField2()}, stringField3=${entityAfter.getStringField3()}")
        runNumber++

        Thread.sleep(1000)

        List<MyEntity> entitiesFromRepository = Lists.newArrayList(myDatastoreRepository.findAll())
        log.info("doSomething - entitiesFromRepository.size=${entitiesFromRepository.size()}")
        List<Entity> entitiesFromJavaDAO = javaDAO.getAllMyEntities()
        log.info("doSomething - entitiesFromJavaDAO.size=${entitiesFromJavaDAO.size()}")
        List<Entity> entitiesFromGroovyDAO = groovyDAO.getAllMyEntities()
        log.info("doSomething - entitiesFromGroovyDAO.size=${entitiesFromGroovyDAO.size()}")
    }
}
