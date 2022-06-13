package com.golstov.restapp.service.impl;

import com.golstov.restapp.client.DownloadClient;
import com.golstov.restapp.service.DownloadService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class DownloadServiceImpl implements DownloadService {

    private final DownloadClient downloadClient;

    public DownloadServiceImpl(DownloadClient downloadClient) {
        this.downloadClient = downloadClient;
    }

    @Override
    public ResponseEntity<byte[]> getGifByUrl(URI uri) {
        return downloadClient.getGifByUrl(uri);
    }
}
