package server.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import server.entity.Note;
import server.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping("/addNote")
    public void createNote(@RequestBody Note note, HttpServletResponse response, Model model){
        try{
            noteService.createNote(note);
            response.setStatus(HttpServletResponse.SC_CREATED);
        }catch (Exception e){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

 /*   @PostMapping("/deleteNote")
    public void deleteNote(@RequestBody DeleteNote deleteNote, HttpServletResponse response){
        try{
            Long idRole = noteService.findByUserAndJournal(deleteNote.getLogin(), deleteNote.getJournalName()).getIdRole().getId();
                noteService.deleteNote(deleteNote.getIdNote());
                response.setStatus(HttpServletResponse.SC_CREATED);
            }else{
                response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
            }
        }catch (Exception e){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }*/

    @GetMapping("/listNote/{id}")
   public String listNote(@PathVariable(value = "id") Integer id, Model model){
        Optional<Note> note = noteService.getRecipe(id);
        ArrayList<Note> t = new ArrayList<>();
        note.ifPresent(t::add);
        model.addAttribute("res", t);
        return "notes";
    }

 /*   @PostMapping("/updateNote")
    public void update(@RequestBody UpdateNote updateNote, HttpServletResponse response){
        try{
            Long idRole = noteService.findByUserAndJournal(updateNote.getLogin(), noteService.findById(updateNote.getId()).get().getIdJournal().getName()).getIdRole().getId();
            if(idRole == 1 || idRole == 2){
                noteService.updateNote(updateNote.getId(), updateNote.getDate(), updateNote.getSum(), updateNote.getCategory(), updateNote.getComment());
                response.setStatus(HttpServletResponse.SC_OK);
            }else{
                response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
            }
        }catch(Exception e){
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }*/
}