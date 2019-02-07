package com.blogspot.hikmahtech.coeguide;

/**
 * Created by SUER on 7/4/2017.
 */

public class Word {
    private String mDefaultText;
    /** Image resource ID for the word */
    /** Image resource ID for the word */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;
    public Word(String defaultText,  int imageResourceId) {
        mDefaultText = defaultText;
        mImageResourceId = imageResourceId;
    }
    public String getDefaultTranslation(){
        return mDefaultText;
    }
    /**
     * Return the image resource ID of the word.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }
    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}