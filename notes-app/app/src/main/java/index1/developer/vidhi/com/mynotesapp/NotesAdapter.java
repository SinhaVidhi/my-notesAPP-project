package index1.developer.vidhi.com.mynotesapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import index1.vidhi.com.mynotesapp.R;


public class NotesAdapter extends ArrayAdapter<Note> {


    public NotesAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Note> notes) {
        super(context, resource, notes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_note, null);
        }

        Note note = getItem(position);

        if(note != null)
        {
            TextView title = (TextView) convertView.findViewById(R.id.list_note_title);
            TextView date = (TextView) convertView.findViewById(R.id.list_note_date);
            TextView content = (TextView) convertView.findViewById(R.id.list_note_content);

            title.setText(note.gettl());
            date.setText(note.getDateTimeFormatted(getContext()));

            if(note.getct1().length() > 50)
            {
                content.setText(note.getct1().substring(0, 50));
            }
            else
            {
                content.setText(note.getct1());
            }
        }
        return convertView;
    }
}
