package goit.javadeveloper.note;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NoteServiceTest {
    private final NoteService noteService;

    @PostConstruct
    public void init() {
        Note note1 = new Note();
        note1.setTitle("note1");
        note1.setContent("note1 content");
        Note note2 = new Note();
        note2.setTitle("note2");
        note2.setContent("note2 content");
        Note note3 = new Note();
        note3.setTitle("note3");
        note3.setContent("note3 content");

        noteService.add(note1);
        noteService.add(note2);
        noteService.add(note3);

        System.out.println("noteService.getAll() = " + noteService.getAll());
        noteService.deleteById(2);

        Note note4 = new Note();
        note4.setTitle("note4");
        note4.setContent("note4 content");
        noteService.add(note4);
        Note note5 = new Note();
        note5.setId(1);
        note5.setTitle("note11");
        note5.setContent("note11 content");
        noteService.update(note5);

        System.out.println("noteService.getAll() = " + noteService.getAll());
    }
}
