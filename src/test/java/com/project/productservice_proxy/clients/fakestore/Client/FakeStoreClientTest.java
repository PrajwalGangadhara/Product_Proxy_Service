package com.project.productservice_proxy.clients.fakestore.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FakeStoreClientTest {
    @Autowired
    FakeStoreClient fakeStoreClient;

}