package Res.Restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Res.Restapi.model.Note;
import Res.Restapi.service.NoteService;

@RestController
@RequestMapping("api/user/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping("/create")
    public String createNote(@RequestBody Note note) {
        String message = noteService.createNote(note);
        return message;
    }

}
