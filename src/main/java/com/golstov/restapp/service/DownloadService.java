package com.golstov.restapp.service;

import org.springframework.http.ResponseEntity;

import java.net.URI;

public interface DownloadService {
    ResponseEntity<byte[]> getGifByUrl(URI uri);

}
