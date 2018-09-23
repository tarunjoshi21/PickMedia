package com.tarun.pickmedia;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;

public class ImageProvider {
    private static final ImageProvider ourInstance = new ImageProvider();
    private static Context mContext;

    public static ImageProvider getInstance(Context context) {
        mContext = context;
        return ourInstance;
    }

    private ImageProvider() {
    }

    /**
     * https://stackoverflow.com/questions/30777023/displaying-all-images-from-device-in-my-app
     * Get all the images path in the phone
     */
    public void getImages() {
        boolean isSDPresent = android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
        final String[] columns = {MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID};
        final String orderBy = MediaStore.Images.Media._ID;
//Stores all the images from the gallery in Cursor
        Cursor cursor = null;
        if (isSDPresent) {
           cursor = mContext.getContentResolver().query(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null,
                    null, orderBy);
        } else {
           cursor = mContext.getContentResolver().query(
                    MediaStore.Images.Media.INTERNAL_CONTENT_URI, columns, null,
                    null, orderBy);
        }
        if (cursor != null) {
            //Total number of images
            int count = cursor.getCount();

            //Create an array to store path to all the images
            String[] arrPath = new String[count];

            for (int i = 0; i < count; i++) {
                cursor.moveToPosition(i);
                int dataColumnIndex = cursor.getColumnIndex(MediaStore.Images.Media.DATA);
                //Store the path of the image
                arrPath[i] = cursor.getString(dataColumnIndex);
                //Log.i("PATH", arrPath[i]);
            }
            Log.i("Total Images", arrPath.length+"");
            // The cursor should be freed up after use with close()
            cursor.close();
        }

    }
}
