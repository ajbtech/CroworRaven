package com.lexicon.croworraven;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

//TODO Load all images in the splash screen or start screen
//TODO Add a score
//TODO Randomize the list
//TODO Add a replay button at the end
//TODO Show the final score at the end
//TODO Add a high score list
//TODO Pretty up the splash screen

public class GameActivity extends AppCompatActivity {

    private SwipePlaceHolderView mSwipeView;
    private Context mContext;
    private TextView textView_Correct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mSwipeView = findViewById(R.id.swipeView);
        textView_Correct = findViewById(R.id.textView_correct);

        mContext = getApplicationContext();

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.bird_card_swipe_b)
                        .setSwipeOutMsgLayoutId(R.layout.bird_card_swipe_a));


        for(Profile profile : Utils.loadProfiles(this.getApplicationContext())){
            final BirdCard myBirdCard = new BirdCard(mContext, profile, mSwipeView, textView_Correct);
            mSwipeView.addView(myBirdCard);
        }

        findViewById(R.id.rejectBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(false);
            }
        });

        findViewById(R.id.acceptBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSwipeView.doSwipe(true);
            }
        });
    }
}