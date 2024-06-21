package org.elastic.analytics.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.Instant;


@AllArgsConstructor
@Data
@Document(indexName = "car_sales")
public class CarSales implements Persistable<String> {

    @Id
    private String id;

    @NotBlank(message = "Field 'carModel' is mandatory")
    @Field(type = FieldType.Text, name = "car_model")
    private String carModel;

    @NotBlank(message = "Field 'carYear' is mandatory")
    @Field(type = FieldType.Text, name = "car_year")
    private String carYear;

    @PositiveOrZero(message = "Field 'price' should be positive or zero")
    @Field(type = FieldType.Long)
    private Long price;

    @NotBlank(message = "Field 'currency' is mandatory")
    private String currency;

    @NotBlank(message = "Field 'country' is mandatory")
    private String country;

    @NotBlank(message = "Field 'city' is mandatory")
    private String city;

    @NotBlank(message = "Field 'dealer' is mandatory")
    private String dealer;

    @CreatedDate
    @Field(type = FieldType.Date, name = "created_date", format = DateFormat.date_hour_minute_second_fraction)
    private Instant createdDate;

    @Override
    public String getId() {
        return id;
    }

    public boolean isNew() {
        return id == null || createdDate == null;
    }
}
