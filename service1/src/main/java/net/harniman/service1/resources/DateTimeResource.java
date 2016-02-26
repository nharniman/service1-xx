package net.harniman.service1.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.joda.time.DateTime;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

import net.harniman.service1.api.DateConvertor;

@Path("/date-time")
@Produces(MediaType.APPLICATION_JSON)
public class DateTimeResource {
    private final AtomicLong counter;

    public DateTimeResource() {
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    
    //Expects the date parameter in ISO8601 format - eg 2010-01-01T12:00:00Z
    // Beware 2010-01-01T12:00:00+01:00 needs tobe URL encoded to 
    // 2010-01-01T12%3A00%3A00%2B01%3A00 style
    
    public DateConvertor getDate(@QueryParam("date") Optional<String> date) {
        return new DateConvertor(counter.incrementAndGet(),
                date.or(new DateTime().toString()));
    }
}