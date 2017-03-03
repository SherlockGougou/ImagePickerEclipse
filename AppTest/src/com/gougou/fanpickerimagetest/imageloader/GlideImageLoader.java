package com.gougou.fanpickerimagetest.imageloader;

import java.io.File;

import android.app.Activity;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.gougou.fanimgpickerlibrary.ImagePicker;
import com.gougou.fanimgpickerlibrary.loader.ImageLoader;
import com.gougou.fanimgpickerlibrary.utils.FileUtil;
import com.gougou.fanpickerimagetest.R;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧 Github地址：https://github.com/jeasonlzy0216
 * 版    本：1.0
 * 创建日期：2016/5/19
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class GlideImageLoader implements ImageLoader {

	private Activity activity;
    @Override
    public void displayImage(Activity activity, String path, ImageView imageView, int width, int height) {
    	this.activity = activity;
		Glide.with(activity)                     //配置上下文
		.load(Uri.fromFile(new File(path)))      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
//		.error(R.mipmap.default_image)           //设置错误图片
//		.placeholder(R.mipmap.default_image)     //设置占位图片
		.diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
		.into(imageView);
    }

    @Override
    public void clearMemoryCache() {
    	Glide.get(activity).clearDiskCache();
    	Glide.get(activity).clearMemory();
    }
}