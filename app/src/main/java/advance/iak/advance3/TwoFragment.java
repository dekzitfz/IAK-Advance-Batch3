package advance.iak.advance3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TwoFragment extends Fragment implements HostToFragment {

    private TextView text;

    public TwoFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        text = view.findViewById(R.id.text);

        ((MainActivity) getActivity()).setListener(this);
        return view;
    }

    @Override
    public void sendData(int number) {
        text.setText(String.valueOf(number));
    }
}
