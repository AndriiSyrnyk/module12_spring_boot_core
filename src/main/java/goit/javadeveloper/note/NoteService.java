package goit.javadeveloper.note;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {
    private Map<Long, Note> notes;
    private NoteStorage noteStorage;

    public NoteService() {
        noteStorage = new NoteStorage();
        notes = noteStorage.getNotes();
    }
    public Map<Long, Note> getAll() {
        return notes;
    }

    public Note add(Note note) {
        long nextId = noteStorage.getNextAutoGeneratedId();
        note.setId(nextId);
        notes.put(nextId, note);
        noteStorage.setNextAutoGeneratedId();
        return note;
    }

    public void deleteById(long id) {
        if (notes.containsKey(id)) {
            notes.remove(id);
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void update(Note note) {
        long id = note.getId();
        if (notes.containsKey(id)) {
            if (id == getById(id).getId()) {
                notes.put(id, note);
            }
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    public Note getById(long id) {
        if (notes.containsKey(id)) {
            return notes.get(id);
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }
}
