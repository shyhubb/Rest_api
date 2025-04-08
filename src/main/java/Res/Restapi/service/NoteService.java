package Res.Restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Res.Restapi.model.Note;
import Res.Restapi.repository.NoteRepository;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public String createNote(Note note) {
        noteRepository.save(note);
        return "Thêm Thành Công Ghi Chú !";
    }
}
