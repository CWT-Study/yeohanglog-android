package team.triplog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import team.triplog.adpater.MainHomeAdapter;
import team.triplog.vo.MainHomeVo;

public class MainHomeFragment extends Fragment {
    private View rootView;
    private TextView txtNameUser;
    private TextView txtTripTitle;
    private TextView txtTripContent;
    private TextView txtTripDate;
    private RecyclerView recyclerView;
    private MainHomeAdapter mAdpater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main_home, container, false);
        init();
        setData();
        return rootView;
    }

    private void init(){
        txtNameUser = rootView.findViewById(R.id.txt_name_user);
        txtTripTitle = rootView.findViewById(R.id.txt_trip_title);
        txtTripContent = rootView.findViewById(R.id.txt_trip_content);
        txtTripDate = rootView.findViewById(R.id.txt_trip_date);
        recyclerView = rootView.findViewById(R.id.recyclerview);
    }

    private void setData(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<MainHomeVo> mainHomeVos = new ArrayList<>();
        MainHomeVo mainHomeVo = new MainHomeVo();
        mainHomeVo.title="테스트";
        mainHomeVo.drawbleId=R.drawable.ic_launcher_background;

        MainHomeVo mainHomeVo2 = new MainHomeVo();
        mainHomeVo2.title="테스트2";
        mainHomeVo2.drawbleId=R.drawable.ic_launcher_background;

        MainHomeVo mainHomeVo3 = new MainHomeVo();
        mainHomeVo3.title="테스트3";
        mainHomeVo3.drawbleId=R.drawable.ic_launcher_background;

        MainHomeVo mainHomeVo4 = new MainHomeVo();
        mainHomeVo4.title="테스트4";
        mainHomeVo4.drawbleId=R.drawable.ic_launcher_background;

        MainHomeVo mainHomeVo5 = new MainHomeVo();
        mainHomeVo5.title="테스트5";
        mainHomeVo5.drawbleId=R.drawable.ic_launcher_background;

        MainHomeVo mainHomeVo6 = new MainHomeVo();
        mainHomeVo6.title="테스트6";
        mainHomeVo6.drawbleId=R.drawable.ic_launcher_background;

        MainHomeVo mainHomeVo7 = new MainHomeVo();
        mainHomeVo7.title="테스트7";
        mainHomeVo7.drawbleId=R.drawable.ic_launcher_background;

        MainHomeVo mainHomeVo8 = new MainHomeVo();
        mainHomeVo8.title="테스트8";
        mainHomeVo8.drawbleId=R.drawable.ic_launcher_background;


        mainHomeVos.add(mainHomeVo);
        mainHomeVos.add(mainHomeVo2);
        mainHomeVos.add(mainHomeVo3);
        mainHomeVos.add(mainHomeVo4);
        mainHomeVos.add(mainHomeVo5);
        mainHomeVos.add(mainHomeVo6);
        mainHomeVos.add(mainHomeVo7);
        mainHomeVos.add(mainHomeVo8);



        mAdpater = new MainHomeAdapter(rootView.getContext(),mainHomeVos,onClickItem);

        recyclerView.setAdapter(mAdpater);

//        MainHomeListDecoration decoration = new MainHomeListDecoration();
//        recyclerView.addItemDecoration(decoration);

        recyclerView.setNestedScrollingEnabled(false);

    }

    private View.OnClickListener onClickItem = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str = (String) v.getTag();
            Toast.makeText(rootView.getContext(), str, Toast.LENGTH_SHORT).show();
        }
    };

}
