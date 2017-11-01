package advance.iak.advance3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class OneFragment extends Fragment implements View.OnClickListener {

    private static final String KEY_POSITION = "key_position";

    private int number;

    public OneFragment() {}

    public static OneFragment newInstance(int position){
        OneFragment fragment = new OneFragment();
        Bundle b = new Bundle();
        b.putInt(KEY_POSITION, position);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        number = getArguments().getInt(KEY_POSITION);

        Button btn = view.findViewById(R.id.btn_goto_next_fragment);
        btn.setText(getString(R.string.goto_fragment, number+1));
        btn.setOnClickListener(this);

        TextView text = view.findViewById(R.id.text);
        text.setText(String.valueOf(number));

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_goto_next_fragment:
                number++;
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(String.valueOf(number))
                        .replace(R.id.fragment_container, OneFragment.newInstance(number), null)
                        .commit();
                break;
            default:
        }
    }
}
