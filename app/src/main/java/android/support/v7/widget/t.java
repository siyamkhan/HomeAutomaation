package android.support.v7.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.graphics.drawable.c;
import android.util.AttributeSet;
import android.widget.ProgressBar;

class t {
  private static final int[] a = { 16843067, 16843068 };
  
  private final ProgressBar b;
  
  private Bitmap c;
  
  t(ProgressBar paramProgressBar) { this.b = paramProgressBar; }
  
  private Drawable a(Drawable paramDrawable) {
    AnimationDrawable animationDrawable;
    if (paramDrawable instanceof AnimationDrawable) {
      AnimationDrawable animationDrawable1 = (AnimationDrawable)paramDrawable;
      int i = animationDrawable1.getNumberOfFrames();
      AnimationDrawable animationDrawable2 = new AnimationDrawable();
      animationDrawable2.setOneShot(animationDrawable1.isOneShot());
      for (byte b1 = 0; b1 < i; b1++) {
        Drawable drawable = a(animationDrawable1.getFrame(b1), true);
        drawable.setLevel(10000);
        animationDrawable2.addFrame(drawable, animationDrawable1.getDuration(b1));
      } 
      animationDrawable2.setLevel(10000);
      animationDrawable = animationDrawable2;
    } 
    return animationDrawable;
  }
  
  private Drawable a(Drawable paramDrawable, boolean paramBoolean) {
    ShapeDrawable shapeDrawable;
    if (paramDrawable instanceof c) {
      c c1 = (c)paramDrawable;
      Drawable drawable = c1.a();
      if (drawable != null) {
        c1.a(a(drawable, paramBoolean));
        return paramDrawable;
      } 
    } else {
      if (paramDrawable instanceof LayerDrawable) {
        LayerDrawable layerDrawable1 = (LayerDrawable)paramDrawable;
        int i = layerDrawable1.getNumberOfLayers();
        Drawable[] arrayOfDrawable = new Drawable[i];
        byte b1 = 0;
        for (byte b2 = 0; b2 < i; b2++) {
          boolean bool;
          int j = layerDrawable1.getId(b2);
          Drawable drawable = layerDrawable1.getDrawable(b2);
          if (j == 16908301 || j == 16908303) {
            bool = true;
          } else {
            bool = false;
          } 
          arrayOfDrawable[b2] = a(drawable, bool);
        } 
        LayerDrawable layerDrawable2 = new LayerDrawable(arrayOfDrawable);
        while (b1 < i) {
          layerDrawable2.setId(b1, layerDrawable1.getId(b1));
          b1++;
        } 
        return layerDrawable2;
      } 
      if (paramDrawable instanceof BitmapDrawable) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable)paramDrawable;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        if (this.c == null)
          this.c = bitmap; 
        ShapeDrawable shapeDrawable1 = new ShapeDrawable(b());
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
        shapeDrawable1.getPaint().setShader(bitmapShader);
        shapeDrawable1.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
        if (paramBoolean)
          return new ClipDrawable(shapeDrawable1, 3, 1); 
        shapeDrawable = shapeDrawable1;
      } 
    } 
    return shapeDrawable;
  }
  
  private Shape b() { return new RoundRectShape(new float[] { 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F, 5.0F }, null, null); }
  
  Bitmap a() { return this.c; }
  
  void a(AttributeSet paramAttributeSet, int paramInt) {
    bm bm = bm.a(this.b.getContext(), paramAttributeSet, a, paramInt, 0);
    Drawable drawable1 = bm.b(0);
    if (drawable1 != null)
      this.b.setIndeterminateDrawable(a(drawable1)); 
    Drawable drawable2 = bm.b(1);
    if (drawable2 != null)
      this.b.setProgressDrawable(a(drawable2, false)); 
    bm.a();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */