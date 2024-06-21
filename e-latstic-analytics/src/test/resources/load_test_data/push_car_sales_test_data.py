import json
from datetime import datetime
from elasticsearch import Elasticsearch

es = Elasticsearch("http://localhost:9200")

index_name = "car_sales"

with open('car_sales_test_data.json', 'r') as file:
    test_data = json.load(file)

for record in test_data:
    record["created_date"] = datetime.now().isoformat()
    es.index(index=index_name, body=record)

print(f"Test data pushed to the {index_name} index.")