package advance.iak.advance3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class OneFragment extends Fragment implements View.OnClickListener {

    public OneFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        Button btn = view.findViewById(R.id.btn_goto_fragment_two);
        btn.setOnClickListener(this);

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
