package com.example.cidseuser.colorcloset;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.content.Intent;

import java.io.ByteArrayOutputStream;

public class Library extends Activity {


    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library);
        Button back_to_camera = (Button) findViewById(R.id.back_to_camera);
        Button tops = (Button) findViewById(R.id.button);
        tops.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode, data);

        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImg = data.getData();

            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImg, filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView targetImage = (ImageView) findViewById(R.id.targetimage);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Bitmap bmp = BitmapFactory.decodeFile(picturePath);
            int nh = (int) ( bmp.getHeight() * (512.0 / bmp.getWidth()) );
            Bitmap scaled = Bitmap.createScaledBitmap(bmp, 512, nh, true);
//            bmp.compress(Bitmap.CompressFormat.PNG, 50, stream);
//            byte[] byteArray = stream.toByteArray();
//            Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0,
//                    byteArray.length);
            targetImage.setImageBitmap(scaled);

        } else {
            Toast.makeText(this, ":(", Toast.LENGTH_LONG).show();
        }
    }
}











































/*public class Library extends AppCompatActivity {

    Button tops;
    Button back_to_camera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library);

        tops = (Button) findViewById(R.id.button);
        tops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Library.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });

        back_to_camera = (Button) findViewById(R.id.back_to_camera);
        back_to_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Library.this,
                       CameraActivity.class);
                startActivity(intent);
                }
            });

        GridView gridview = (GridView) findViewById(R.id.gridView);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(Library.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(mContext);
            imageView.setImageResource(mThumbIds[position]);
            return imageView;

        }

        private Integer[] mThumbIds = {

                R.drawable.shorts,
                R.drawable.shorts2,
                R.drawable.shorts3,
                R.drawable.pants,
                R.drawable.pants2,
                R.drawable.skirt,
                R.drawable.skirt2
        };}
}
*/

