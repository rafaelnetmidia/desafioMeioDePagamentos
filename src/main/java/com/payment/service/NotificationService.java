package com.payment.service;

import com.payment.domain.user.User;
import com.payment.service.dto.NotificationDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
@AllArgsConstructor
public class NotificationService {

    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {

        if(!notificationUser(user.getEmail(), message)){
            System.out.println("Erro ao enviar a notificação");
            throw new Exception("Serviço de notificação está indisponivel");
        }

    }

    public boolean notificationUser(String email, String message){

        NotificationDTO notificationRequest = new NotificationDTO(email, message);
        ResponseEntity<String> notificationResponse = restTemplate.postForEntity("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6", notificationRequest, String.class);

        return notificationResponse.getStatusCode().is2xxSuccessful();
    }

}
