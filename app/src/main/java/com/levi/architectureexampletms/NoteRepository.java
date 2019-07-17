package com.levi.architectureexampletms;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;


    public NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.get_instance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    public void insert(Note note) {
        new com.levi.architectureexampletms.NoteRepository.InsertNoteAsynchTask(noteDao).execute(note);
    }

    public void update(Note note) {
        new UpdateNoteAsynchTask(noteDao).execute(note);
    }

    public void delete(Note note) {
        new DeleteNoteAsynchTask(noteDao).execute(note);
    }

    public void deleteAllNotes() {
        new DeleteAllNoteAsynchTask(noteDao).execute();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    private static class InsertNoteAsynchTask extends AsyncTask<Note, Void, Void> {

        private NoteDao notedao;

        private InsertNoteAsynchTask(NoteDao noteDao) {
            this.notedao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            notedao.insert(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsynchTask extends AsyncTask<Note, Void, Void> {

        private NoteDao notedao;

        private UpdateNoteAsynchTask(NoteDao noteDao) {
            this.notedao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            notedao.update(notes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsynchTask extends AsyncTask<Note, Void, Void> {

        private NoteDao notedao;

        private DeleteNoteAsynchTask(NoteDao noteDao) {
            this.notedao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            notedao.delete(notes[0]);
            return null;
        }
    }

    private static class DeleteAllNoteAsynchTask extends AsyncTask<Void, Void, Void> {

        private NoteDao notedao;

        private DeleteAllNoteAsynchTask(NoteDao noteDao) {
            this.notedao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            notedao.deleteAllNotes();
            return null;
        }
    }

}
