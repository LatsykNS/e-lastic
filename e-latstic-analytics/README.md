# E-Lastic Analytics
## Overview
This is the analytics application which collects data about car sales.

## Requirements
- Java 17
- Elasticsearch 7.17.x
- Kibana 7.17.x

## Configuration
- Elasticsearch configuration is located in `src/main/resources/application.properties` file.
```yaml
elasticsearch:
  host: localhost:9200
```

## Endpoints
- `POST /elastic-analytics/api/v1/sales`: Push sales data information.

Request body (example):
```json
{
  "carModel": "F2",
  "carYear":"2024",
  "price": 10000,
  "currency": "USD",
  "country": "Ukraine",
  "city": "Lviv",
  "dealer": "Alians"
}
```

## Load test data
For testing purposes you can load test data which is located in `src/test/resources/load_test_data` folder.

Requirements:
- install python 3.11
- install elasticsearch package for python
```bash
 python -m pip install elasticsearch==7.17.0
```

Load data to Elasticsearch:
- Run the following command to initialize car_sales index:
```bash
python init_car_sales_index.py
```
- Run the following command to load test data:
```bash
python push_car_sales_test_data.py
```
