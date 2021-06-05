package com.enset.demo.web;

import com.enset.demo.dao.FilmRepository;
import com.enset.demo.dao.TicketRepository;
import com.enset.demo.entites.Film;
import com.enset.demo.entites.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/* @Autowired
 private FilmRepository filmRepository;
 @GetMapping("/listeFilms")
 public List<Film> films(){
     return filmRepository.findAll();
 }

 */
@RestController
@CrossOrigin("*")
public class CinemaRestController {


    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @GetMapping(path = "imageFilm/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] image(@PathVariable (name="id")Long id) throws Exception{
        Film f = filmRepository.findById(id).get();
        String photoname = f.getPhoto();
        File file = new File(System.getProperty("user.home")+"/cinema/images/"+photoname);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }

    @PostMapping("/payerTickets")
    @Transactional
    public List<Ticket> payerTickets(@RequestBody TicketForm ticketF){
        List<Ticket> ticketList = new ArrayList<>();
        ticketF.getTickets().forEach(idTicket->{
            Ticket ticket = ticketRepository.findById(idTicket).get();
            ticket.setNomClient(ticketF.getNomClient());
            ticket.setReserve(true);
            ticket.setCodePayement(ticketF.getCodePayement());
            ticketRepository.save(ticket);
            ticketList.add(ticket);
        });
        return ticketList;

    }


    @Data
    static class TicketForm{
        private String nomClient;
        private int codePayement;
        private List<Long> tickets = new ArrayList<>();
    }
}
