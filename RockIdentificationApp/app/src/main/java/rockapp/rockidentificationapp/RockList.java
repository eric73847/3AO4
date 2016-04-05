package rockapp.rockidentificationapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Niko on 4/5/2016.
 *
 * Custom ListView to display a list of rocks (used in both history and searches)
 */
public class RockList extends ArrayAdapter<String> {
    private final Activity context;
    private final Rock[] rockMembers;

    public RockList(Activity context,
                      Rock[] rocks) {
        super(context, R.layout.list_single);
        this.context = context;
        rockMembers = rocks;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);

        Rock rock = rockMembers[position];

        //Build the single item view
        TextView rockTitle = (TextView) rowView.findViewById(R.id.rock_name);
        rockTitle.setText(rock.toString());

        TextView rockDescription = (TextView) rowView.findViewById(R.id.rock_description);
        rockDescription.setText(rock.getHardness().toString());

        //TODO grab image
        //ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        //imageView.setImageResource(imageId[position]);

        return rowView;
    }
}
