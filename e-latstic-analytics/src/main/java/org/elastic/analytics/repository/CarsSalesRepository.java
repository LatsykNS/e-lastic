package org.elastic.analytics.repository;

import org.elastic.analytics.model.CarSales;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsSalesRepository extends ElasticsearchRepository<CarSales, String> {
}
