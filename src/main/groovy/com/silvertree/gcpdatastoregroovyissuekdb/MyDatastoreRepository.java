package com.silvertree.gcpdatastoregroovyissuekdb;

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository;

public interface MyDatastoreRepository extends DatastoreRepository<MyEntity, Long> {
}
