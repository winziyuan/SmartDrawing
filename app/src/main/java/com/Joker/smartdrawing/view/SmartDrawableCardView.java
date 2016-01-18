package com.Joker.smartdrawing.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.ImageView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.Joker.smartdrawing.R;

/**
 * Created by SmartDengg on 2016/1/16.
 */
public class SmartDrawableCardView extends CardView {

  @Nullable @Bind(R.id.drawable_layout_iv) protected ImageView imageView;
  private Callback callback;

  public SmartDrawableCardView(Context context) {
    super(context);
    if (!this.isInEditMode()) {
      SmartDrawableCardView.this.init(context);
    }
  }

  public SmartDrawableCardView(Context context, AttributeSet attrs) {
    super(context, attrs);
    if (!this.isInEditMode()) {
      SmartDrawableCardView.this.init(context);
    }
  }

  public SmartDrawableCardView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    if (!this.isInEditMode()) {
      SmartDrawableCardView.this.init(context);
    }
  }

  private void init(Context context) {

    int _dp = context.getResources().getDimensionPixelOffset(R.dimen.material_8dp);

    SmartDrawableCardView.this.setContentPadding(0, 0, 0, 0);
    SmartDrawableCardView.this.setCardBackgroundColor(Color.parseColor("#E6E6E6"));
    SmartDrawableCardView.this.setRadius(_dp);

    LayoutInflater.from(context).inflate(R.layout.drawable_laout, SmartDrawableCardView.this, true);
  }

  @Override protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    ButterKnife.bind(SmartDrawableCardView.this);
  }

  @Override protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    ButterKnife.unbind(SmartDrawableCardView.this);
  }

  public void setDrawingDrawable(Bitmap bitmap) {

    SmartDrawableCardView.this.imageView.setScaleType(ImageView.ScaleType.CENTER);
    SmartDrawableCardView.this.imageView.setImageBitmap(bitmap);
  }

  @Nullable @OnClick(R.id.drawable_layout_btn) void onButtonClick() {
    if (callback != null) callback.onCancel();
  }

  @Override public boolean dispatchKeyEvent(KeyEvent event) {
    int keyCode = event.getKeyCode();
    if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
      if (callback != null) callback.onCancel();
    }

    return super.dispatchKeyEvent(event);
  }

  public void setCallback(Callback callback) {
    this.callback = callback;
  }

  public interface Callback {
    void onCancel();
  }
}
