package com.meetaide.meetaide.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meetaide.meetaide.constants.EmailConstants;
import com.meetaide.meetaide.constants.MailchimpConstants;
import com.meetaide.meetaide.dto.GetCompainsDto;
import com.microtripit.mandrillapp.lutung.MandrillApi;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailchimpService {
    public void sendTestEmail(String email) throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        //1519e7e94f566dd55f584afc519812ba-a83a87a9-dedf987c
        headers.setBasicAuth("anystring", MailchimpConstants.API_KEY);
        HttpEntity requestEntity = new HttpEntity<>( headers);
        ResponseEntity<String> response = restTemplate.exchange(MailchimpConstants.GET_CAMP, HttpMethod.GET,requestEntity,String.class);
        System.out.println(response);
        GetCompainsDto compainsDto =obj.readValue(response.getBody(),GetCompainsDto.class);
        compainsDto.getCampaigns().forEach(campaign -> {
            String compaignId = campaign.getId();
            String listId = campaign.getRecipients().getListId();
            if(!Strings.isEmpty(listId)&&!Strings.isBlank(listId)){
                Map<String,Object> postBody = new HashMap<>();
                postBody.put("test_emails", Arrays.asList(email));
                postBody.put("send_type","plain_text");
                HttpEntity<Map<String,Object>>post = new HttpEntity<>( postBody,headers);
                String sendEmail = MailchimpConstants.GET_CAMP+"/"+compaignId+"/actions/test";
                System.out.println(sendEmail);
                ResponseEntity<String> res = restTemplate.exchange(sendEmail, HttpMethod.POST,post,String.class);
                System.out.println(res);
            }
        });
    }

}
