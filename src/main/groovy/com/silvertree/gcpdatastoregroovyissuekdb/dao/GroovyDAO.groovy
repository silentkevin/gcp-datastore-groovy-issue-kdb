package com.silvertree.gcpdatastoregroovyissuekdb.dao

import com.google.cloud.datastore.Datastore
import com.google.cloud.datastore.Entity
import com.google.cloud.datastore.EntityQuery
import com.google.cloud.datastore.Query
import com.google.cloud.datastore.QueryResults
import com.google.cloud.datastore.StructuredQuery
import com.silvertree.gcpdatastoregroovyissuekdb.Constants
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
@CompileStatic
class GroovyDAO {
    @Autowired Datastore datastore

    List<Entity> getAllMyEntities() {
        EntityQuery.Builder queryBuilder = (EntityQuery.Builder) Query.newEntityQueryBuilder()
                .setKind(Constants.DATASTORE_KIND_MY_ENTITY)
                .setOrderBy(StructuredQuery.OrderBy.desc("stringField1"))
        Query<Entity> query = queryBuilder.build()

        List<Entity> ret = new ArrayList<>()
        QueryResults<Entity> results = datastore.run(query)
        while (results.hasNext()) {
            ret.add(results.next())
        }
        return ret
    }
}
