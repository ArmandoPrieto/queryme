package org.prieto;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxStreamingHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.prieto.domain.Book;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
class QuerymeTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    @Client("/")
    RxStreamingHttpClient client;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testClient(){
        HttpRequest request = HttpRequest.GET("/store/book");

        HttpResponse<Book> rsp = client.toBlocking().exchange(request, Book.class);

        assertEquals(HttpStatus.OK, rsp.getStatus());
        assertNotNull(rsp.body());
        assertEquals(rsp.body().getIsbn(),"1234");
    }

}
