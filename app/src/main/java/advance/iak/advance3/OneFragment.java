package advance.iak.advance3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class OneFragment extends Fragment implements View.OnClickListener {

    private static final String KEY_DATA = "key_data";

    public OneFragment() {}

    public static OneFragment newInstance(String data){
        OneFragment fragment = new OneFragment();
        Bundle b = new Bundle();
        b.putString(KEY_DATA, data);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        Button btn = view.findViewById(R.id.btn_goto_fragment_two);
        btn.setOnClickListener(this);

        TextView text = view.findViewById(R.id.text);
        String data = getArguments().getString(KEY_DATA);
        text.setText(data);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_goto_fragment_two:
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(TwoFragment.class.getSimpleName())
                        .replace(R.id.fragment_container, new TwoFragment(), null)
                        .commit();
                break;
            default:
        }
    }
}
