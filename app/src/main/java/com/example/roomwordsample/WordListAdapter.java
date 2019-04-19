package com.example.roomwordsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private Context context;
    private List<Word> wordList;

    WordListAdapter(Context context) {
        this.context = context;
    }

    class WordViewHolder extends RecyclerView.ViewHolder {

        private final TextView wordItemView;

        private WordViewHolder(@NonNull View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, viewGroup, false);

        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int i) {
        if (wordList != null) {
            Word word = wordList.get(i);
            wordViewHolder.wordItemView.setText(word.getWord());
        } else {
            wordViewHolder.wordItemView.setText("No Word");
        }

    }

    void setWords(List<Word> words) {
        wordList = words;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (wordList != null) {
            return wordList.size();
        } else {
            return 0;
        }
    }


}
