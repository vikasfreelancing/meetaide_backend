package com.meetaide.meetaide.service;

import com.meetaide.meetaide.constants.EmailConstants;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class SendEmailService {

    RestTemplate restTemplate = new RestTemplate();

    public void sendEmail(String email) {
        MultiValueMap<String, Object> form = new LinkedMultiValueMap<>();
        form.add("from", EmailConstants.from);
        form.add("to", email);
        form.add("subject", EmailConstants.subject);
        form.add("text", EmailConstants.text);

//        String url = UriComponentsBuilder.fromHttpUrl(EmailConstants.url).
//                queryParam("from", EmailConstants.from)
//                .queryParam("to", email)
//                .queryParam("subject", EmailConstants.subject)
//                .queryParam("text", EmailConstants.text).toUriString();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        //1519e7e94f566dd55f584afc519812ba-a83a87a9-dedf987c
        headers.setBasicAuth("api", "1519e7e94f566dd55f584afc519812ba-a83a87a9-dedf987c");
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(form, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(EmailConstants.url, requestEntity, String.class);
        System.out.println(response);
    }


}
