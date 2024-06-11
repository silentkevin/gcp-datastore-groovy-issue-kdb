package com.silvertree.gcpdatastoregroovyissuekdb

import com.google.cloud.spring.data.datastore.repository.config.EnableDatastoreRepositories
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableDatastoreRepositories
@EnableScheduling
@CompileStatic
@Slf4j
class GcpDatastoreGroovyIssueKdbApplication {
    static void main(String[] args) {
        SpringApplication.run(GcpDatastoreGroovyIssueKdbApplication, args)
    }
}
