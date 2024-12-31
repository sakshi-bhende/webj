package com.cdac.controllers;

import com.cdac.dto.TicketDTO;
import com.cdac.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllOpenTickets(){
        try{
            return ResponseEntity.ok(ticketService.fetchAllOpenTickets());
        }
        catch (RuntimeException e) {
            return ResponseEntity.ok().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    @GetMapping("/{tid}")
    public ResponseEntity<?> getTicketById(@PathVariable("tid") long id){
        try{
            return ResponseEntity.ok(ticketService.fetchTicketById(id));
        }catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PostMapping("/save")
    public ResponseEntity<?> saveTicket(@RequestBody TicketDTO ticketDTO){
        try{
            return ResponseEntity.ok(ticketService.createTicket(ticketDTO));
        }catch (RuntimeException e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
        catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PutMapping("/update")
    public ResponseEntity<?> getTicketById(@RequestBody TicketDTO ticketDTO){
        try{
            return ResponseEntity.ok(ticketService.updateTicket(ticketDTO));
        }catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
