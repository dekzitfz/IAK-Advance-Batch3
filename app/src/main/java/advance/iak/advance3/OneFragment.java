package advance.iak.advance3;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class OneFragment extends Fragment implements View.OnClickListener {

    private Button btnPlus;

    private FragmentToHost fragmentToHostListener;

    public OneFragment() {}

    @Override
    public void onAttach(Context context) {
        fragmentToHostListener = (FragmentToHost) context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        btnPlus = view.findViewById(R.id.btn_plus);
        btnPlus.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_plus:
                if(fragmentToHostListener!=null){
                    fragmentToHostListener.saveData(1);
                }
                break;
            default:
        }
    }
}
