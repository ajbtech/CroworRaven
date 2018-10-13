package com.lexicon.croworraven;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;
import com.mindorks.placeholderview.listeners.ItemRemovedListener;

@Layout(R.layout.bird_card_view)
public class BirdCard {

    @View(R.id.profileImageView)
    private ImageView profileImageView;

    private Profile mProfile;
    private Context mContext;
    private TextView mTextView_correct;
    private SwipePlaceHolderView mSwipeView;
    private String thingA;
    private String thingB;

    public BirdCard(Context context, Profile profile, SwipePlaceHolderView swipeView, TextView textView_correct) {
        mContext = context;
        mProfile = profile;
        mSwipeView = swipeView;
        mTextView_correct = textView_correct;
        thingA = "Crow";
        thingB = "Raven";
    }

    @Resolve
    private void onResolved(){
        Glide.with(mContext).load(mProfile.getImageUrl()).into(profileImageView);
    }

    @SwipeOut
    private void onSwipeA(){
        Log.d("EVENT", "onSwipedOut");
        if(mProfile.getType().equals(thingA)) {
            mTextView_correct.setTextAppearance(R.style.Correct);
            mTextView_correct.setText(R.string.correct);
        }
        else{
            mTextView_correct.setTextAppearance(R.style.Wrong);
            mTextView_correct.setText(R.string.wrong);
        }


    }

    @SwipeIn
    private void onSwipeB(){
        Log.d("EVENT", "onSwipedIn");
        if(mProfile.getType().equals(thingB)) {
            mTextView_correct.setTextAppearance(R.style.Correct);
            mTextView_correct.setText(R.string.correct);
        }
        else{
            mTextView_correct.setTextAppearance(R.style.Wrong);
            mTextView_correct.setText(R.string.wrong);
        }
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeInState
    private void onSwipeInState(){
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState(){
        Log.d("EVENT", "onSwipeOutState");
    }

    public Profile getProfile(){
        return mProfile;
    }

}
