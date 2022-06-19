package com.github.juviga.pelem;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.juviga.pelem.adapter.DataAdapter;
import com.github.juviga.pelem.models.Pagination;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SearchFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SearchFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    RecyclerView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        Log.d("test", "searchMasuk");

        SharedData.MOVIE_SERVICE.search(SharedData.searchText, 1).enqueue(new Callback<Pagination>() {
            @Override
            public void onResponse(retrofit2.Call<Pagination> call, Response<Pagination> response) {
                Pagination pagination = response.body();
                SharedData.searchList = pagination.getResults();

                for (int i = 0; i < SharedData.searchList.size(); i++) {
                    Log.d("test", SharedData.searchList.get(i).getTitle());
                }

                searchView = view.findViewById(R.id.searchView);
                DataAdapter dataAdapter = new DataAdapter(getActivity(), SharedData.searchList);
                searchView.setLayoutManager(new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false));
                searchView.setAdapter(dataAdapter);

                dataAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(retrofit2.Call<Pagination> call, Throwable t) {

            }

        });
        return view;
    }
}