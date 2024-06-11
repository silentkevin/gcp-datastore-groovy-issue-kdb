package com.silvertree.gcpdatastoregroovyissuekdb

import com.google.cloud.datastore.Entity
import com.google.common.collect.Lists
import com.silvertree.gcpdatastoregroovyissuekdb.dao.GroovyDAO
import com.silvertree.gcpdatastoregroovyissuekdb.dao.JavaDAO
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

import static org.junit.jupiter.api.Assertions.assertEquals

@SpringBootTest
class GcpDatastoreGroovyIssueKdbApplicationTests {
    @Autowired MyDatastoreRepository myDatastoreRepository
    @Autowired JavaDAO javaDAO
    @Autowired GroovyDAO groovyDAO

    @BeforeEach
    void setup() {
        myDatastoreRepository.deleteAll()

        myDatastoreRepository.save(new MyEntity(id: 1, stringField1: "stringField1_1", stringField2: "stringField2_1", stringField3: "stringField3_1"))
        myDatastoreRepository.save(new MyEntity(id: 2, stringField1: "stringField1_2", stringField2: "stringField2_2", stringField3: null))
    }

    @Test
    void contextLoads() {
    }

    @Test
    void testJavaDAO() {
        List<Entity> entities = javaDAO.getAllMyEntities()
        assertEquals(2, entities.size())
    }

    @Test
    void testGroovyDAO() {
        List<Entity> entities = groovyDAO.getAllMyEntities()
        assertEquals(2, entities.size())
    }

    @Test
    void testRepository() {
        List<MyEntity> entities = Lists.newArrayList(myDatastoreRepository.findAll())
        assertEquals(2, entities.size())
    }
}
