package com.property.glory.propertyservice.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.media.MediaScannerConnection;
import com.property.glory.propertyservice.R;
import com.property.glory.propertyservice.base.MVPBaseActivity;
import com.property.glory.propertyservice.bean.BaseResultBean;
//import com.property.glory.propertyservice.presenter.ChangePwdPrensenter;
import com.property.glory.propertyservice.bean.User;
import com.property.glory.propertyservice.presenter.PersonalAataPrensenter;
import com.property.glory.propertyservice.utils.Constants;
import com.property.glory.propertyservice.utils.PhotoUtil;
import com.property.glory.propertyservice.utils.ToastUtil;
import com.property.glory.propertyservice.view.ILoginView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class PersonalAataActivity extends MVPBaseActivity<PersonalAataPrensenter> implements ILoginView<BaseResultBean> {
Button btnsave;
com.property.glory.propertyservice.utils.CircleImageView imgphoto;
    File f;
    private File mCurrentPhotoFile;
    private static final int PHOTO_PICKED_WITH_DATA = 1881;
    private static final int CAMERA_WITH_DATA = 1882;
    private static final int CAMERA_CROP_RESULT = 1883;
    private static final int PHOTO_CROP_RESOULT = 1884;
    private static final int ICON_SIZE = 96;
    String datestr,path,photoUrl=null;
    private Bitmap imageBitmap;
    SharedPreferences mySharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_aata);
        btnsave=(Button)findViewById(R.id.btnsave);
        imgphoto=(com.property.glory.propertyservice.utils.CircleImageView)findViewById(R.id.imgphoto);
        mySharedPreferences = getSharedPreferences(Constants.APPLICATION_NAME,
                Activity.MODE_PRIVATE);
        // 实例化SharedPreferences.Editor对象（第二步）
        editor = mySharedPreferences.edit();
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(photoUrl!=null)
                prensenter.savedata(mySharedPreferences.getString("workerId", ""),photoUrl);
                else
                    ToastUtil.showToast(PersonalAataActivity.this,"未作任何修改！");
            }
        });
        imgphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new PopupWindows(PersonalAataActivity.this, imgphoto);
            }
        });
    }
    public class PopupWindows extends PopupWindow {

        public PopupWindows(Context mContext, View parent) {

            View view = View.inflate(mContext,
                    R.layout.personal_popwindows_layout, null);
//            view.startAnimation(AnimationUtils.loadAnimation(mContext,
//                    R.anim.neigh_borspost_message_fade_popupwindow));
            LinearLayout ll_popup = (LinearLayout) view
                    .findViewById(R.id.ll_popup);
//            ll_popup.startAnimation(AnimationUtils.loadAnimation(mContext,
//                    R.anim.neigh_borspost_message_push_popupwindow));

            setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
            setHeight(LinearLayout.LayoutParams.MATCH_PARENT);
            setFocusable(true);
            setOutsideTouchable(true);
            setContentView(view);
            showAtLocation(parent, Gravity.BOTTOM, 0, 0);
            update();

            Button camera = (Button) view
                    .findViewById(R.id.item_popupwindows_camera);
            Button Photo = (Button) view
                    .findViewById(R.id.item_popupwindows_Photo);
            Button cancel = (Button) view
                    .findViewById(R.id.item_popupwindows_cancel);
            camera.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    doTakePhoto();
                    dismiss();
                }
            });
            Photo.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    doPickPhotoFromGallery();
                    dismiss();
                }
            });
            cancel.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    dismiss();
                }
            });

        }
    }

    /**
     * 调用系统相机拍照
     */
    protected void doTakePhoto() {
        try {
            // Launch camera to take photo for selected contact
            File file = new File(Environment.getExternalStorageDirectory()
                    + "/DCIM/Photo");
            if (!file.exists()) {
                file.mkdirs();
            }
            mCurrentPhotoFile = new File(file, PhotoUtil.getRandomFileName());
            final Intent intent = getTakePickIntent(mCurrentPhotoFile);
            startActivityForResult(intent, CAMERA_WITH_DATA);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "手机中无可用的图片", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 从相册选择图片
     */
    protected void doPickPhotoFromGallery() {
        try {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, PHOTO_PICKED_WITH_DATA);
            // final Intent intent = getPhotoPickIntent();
            // startActivityForResult(intent, PHOTO_PICKED_WITH_DATA);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "相册中无照片", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // try {
        // if (requestCode == 1) {
        // // data.getStringExtra("commnity");
        // if (!data.getStringExtra("commnity").equals("")) {
        // textcommunity.setText(data.getStringExtra("commnity"));
        // }
        // if (!data.getStringExtra("communityId").equals("")) {
        // houseId=data.getStringExtra("communityId");
        // }
        // }
        // } catch (Exception e) {
        // // TODO: handle exception
        // }

        if (resultCode == RESULT_OK) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            switch (requestCode) {
                case PHOTO_PICKED_WITH_DATA:
                    // 相册选择图片后裁剪图片
                    if (data != null) {
                        startPhotoZoom(data.getData());
                    }

                    // System.out.println("data.getData()" + data.getData());
                    break;
                case PHOTO_CROP_RESOULT:
                    Bundle extras = data.getExtras();
                    datestr = null;
                    if (extras != null) {
                        imageBitmap = extras.getParcelable("data");

                        try {
                            SimpleDateFormat sDateFormat = new SimpleDateFormat(
                                    "yyyy-MM-dd-hh:mm:ss");
                            datestr = sDateFormat.format(new java.util.Date());

                            saveMyBitmap("phone" + datestr);
                            System.out.println("jin");
                            File pathRoot = Environment.getExternalStorageDirectory();
                            String pathstr = pathRoot.getAbsolutePath() + "/" + "phone" + datestr
                                    + ".jpg";
                            System.out.println("路径"+pathstr);

//                File file = new File("/storage/emulated/0/phone2018-03-15-11:08:13.jpg");
//                            System.out.println("file"+file.getName());
                            File file = new File(pathstr);
//                params.put(file.getName(), file);
                            prensenter.uploadimg(file.getName(),file);
//                            String uploadUrl = Constants.BASEURL + "uploadImage";
////                            uploadphoto(uploadUrl);
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                        imgphoto.setImageBitmap(imageBitmap);
                    }
                    break;
                case CAMERA_WITH_DATA:
                    // 相机拍照后裁剪图片
                    doCropPhoto(mCurrentPhotoFile);
                    break;
                case CAMERA_CROP_RESULT:
                    imageBitmap = data.getParcelableExtra("data");
                    // imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                    imgphoto.setImageBitmap(imageBitmap);
                    break;
            }
        }
    }

    public static Intent getTakePickIntent(File f) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE, null);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));

        return intent;
    }

    /**
     * 获取调用相册的Intent
     */
    public static Intent getPhotoPickIntent() {
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        return intent;
    }

    /**
     * 相册裁剪图片
     *
     * @param uri
     */
    public void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");// 调用Android系统自带的一个图片剪裁页面,
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");// 进行修剪
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", ICON_SIZE);
        intent.putExtra("outputY", ICON_SIZE);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, PHOTO_CROP_RESOULT);
    }

    /**
     * 相机剪切图片
     */
    protected void doCropPhoto(File f) {
        try {
            // Add the image to the media store
            MediaScannerConnection.scanFile(this,
                    new String[] { f.getAbsolutePath() },
                    new String[] { null }, null);

            // Launch gallery to crop the photo
            final Intent intent = getCropImageIntent(Uri.fromFile(f));

            startActivityForResult(intent, CAMERA_CROP_RESULT);
        } catch (Exception e) {
            Toast.makeText(this, "无可用照片", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 获取系统剪裁图片的Intent.
     */
    public static Intent getCropImageIntent(Uri photoUri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(photoUri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", ICON_SIZE);
        intent.putExtra("outputY", ICON_SIZE);
        intent.putExtra("return-data", true);
        return intent;
    }

    public void saveMyBitmap(String bitName) throws IOException {
        File pathRoot = Environment.getExternalStorageDirectory();
        path = pathRoot.getAbsolutePath() + "/" + bitName + ".jpg";
        System.out.println("path" + path);
        f = new File(path);
        f.createNewFile();
        FileOutputStream fOut = null;
        try {
            fOut = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
        try {
            fOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    protected PersonalAataPrensenter getPrensenter() {
        return new PersonalAataPrensenter(this);
    }

    @Override
    public void showProgressView(String showText) {

    }

    @Override
    public void dismissProgressView() {

    }

    @Override
    public void showPrompt(String showText) {

    }


    @Override
    public void loginResult(BaseResultBean result) {

    }

    @Override
    public void backResult(String msg) {
if(msg.equals("success")){
    ToastUtil.showToast(PersonalAataActivity.this,"保存成功");
    finish();
}else
    photoUrl=msg;
    }


}
