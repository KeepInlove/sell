package com.gxy.sell.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;

/**
 * @author GUO
 * @Classname Data2LongSerializer
 * @Description TODO
 * @Date 2020/10/5 12:00
 */
public class Date2LongSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
       jsonGenerator.writeNumber( date.getTime() / 1000);
    }
}
