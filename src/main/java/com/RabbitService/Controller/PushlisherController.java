package com.RabbitService.Controller;

import com.RabbitService.DTO.MessageDTO;
import com.RabbitService.DTO.ResponeDTO;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class PushlisherController {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    // config exchange
    private String exchange_book = "exchange_book";

    // config routing
    private String routing_book = "book_route_key";

    @PostMapping("/pushlish")
    public ResponeDTO bookTicket(@RequestBody @Valid MessageDTO message, HttpServletResponse response){
        Integer recieved = (Integer) rabbitTemplate.convertSendAndReceive(exchange_book,routing_book, message);
        if(recieved == 1){
            response.setStatus(404);
            return new ResponeDTO(response.getStatus(),"NOT_FOUND");
        } else if (recieved == 2) {
            response.setStatus(400);
            return new ResponeDTO(response.getStatus(),"BAD_REQUEST");
        } else if (recieved == 3) {
            response.setStatus(501);
            return new ResponeDTO(response.getStatus(),"NOT_IMPLEMENTED");
        }
        return new ResponeDTO(response.getStatus(),"OK");
    }
}
