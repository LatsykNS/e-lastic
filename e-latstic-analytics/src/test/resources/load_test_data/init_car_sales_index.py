from elasticsearch import Elasticsearch

es = Elasticsearch("http://localhost:9200")
index_name = "car_sales"

mappings = {
    "mappings": {
        "properties": {
            "car_model": {"type": "text"},
            "car_year": {"type": "text"},
            "price": {"type": "long"},
            "currency": {"type": "text"},
            "country": {"type": "text"},
            "city": {"type": "text"},
            "dealer": {"type": "text"},
            "created_date": {"type": "date", "format": "date_hour_minute_second_fraction"}
        }
    }
}

if es.indices.exists(index=index_name):
    print(f"Index {index_name} already exists. Deleting and recreating it.")
    es.indices.delete(index=index_name)

es.indices.create(index=index_name, body=mappings)
print(f"Index {index_name} created with mappings.")