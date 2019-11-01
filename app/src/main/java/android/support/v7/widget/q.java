package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.h.q;
import android.support.v4.widget.p;
import android.util.AttributeSet;
import android.widget.ImageView;

public class q extends ImageView implements q, p {
  private final g a = new g(this);
  
  private final p b;
  
  public q(Context paramContext) { this(paramContext, null); }
  
  public q(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 0); }
  
  public q(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(bj.a(paramContext), paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
    this.b = new p(this);
    this.b.a(paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    g g1 = this.a;
    if (g1 != null)
      g1.c(); 
    p p1 = this.b;
    if (p1 != null)
      p1.d(); 
  }
  
  public ColorStateList getSupportBackgroundTintList() {
    g g1 = this.a;
    return (g1 != null) ? g1.a() : null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode() {
    g g1 = this.a;
    return (g1 != null) ? g1.b() : null;
  }
  
  public ColorStateList getSupportImageTintList() {
    p p1 = this.b;
    return (p1 != null) ? p1.b() : null;
  }
  
  public PorterDuff.Mode getSupportImageTintMode() {
    p p1 = this.b;
    return (p1 != null) ? p1.c() : null;
  }
  
  public boolean hasOverlappingRendering() { return (this.b.a() && super.hasOverlappingRendering()); }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    super.setBackgroundDrawable(paramDrawable);
    g g1 = this.a;
    if (g1 != null)
      g1.a(paramDrawable); 
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
    g g1 = this.a;
    if (g1 != null)
      g1.a(paramInt); 
  }
  
  public void setImageBitmap(Bitmap paramBitmap) {
    super.setImageBitmap(paramBitmap);
    p p1 = this.b;
    if (p1 != null)
      p1.d(); 
  }
  
  public void setImageDrawable(Drawable paramDrawable) {
    super.setImageDrawable(paramDrawable);
    p p1 = this.b;
    if (p1 != null)
      p1.d(); 
  }
  
  public void setImageResource(int paramInt) {
    p p1 = this.b;
    if (p1 != null)
      p1.a(paramInt); 
  }
  
  public void setImageURI(Uri paramUri) {
    super.setImageURI(paramUri);
    p p1 = this.b;
    if (p1 != null)
      p1.d(); 
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList) {
    g g1 = this.a;
    if (g1 != null)
      g1.a(paramColorStateList); 
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode) {
    g g1 = this.a;
    if (g1 != null)
      g1.a(paramMode); 
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList) {
    p p1 = this.b;
    if (p1 != null)
      p1.a(paramColorStateList); 
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode) {
    p p1 = this.b;
    if (p1 != null)
      p1.a(paramMode); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */