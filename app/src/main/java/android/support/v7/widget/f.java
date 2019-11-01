package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.h.q;
import android.support.v4.widget.n;
import android.support.v7.a.a;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;

public class f extends AutoCompleteTextView implements q {
  private static final int[] a = { 16843126 };
  
  private final g b;
  
  private final z c;
  
  public f(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, a.a.autoCompleteTextViewStyle); }
  
  public f(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(bj.a(paramContext), paramAttributeSet, paramInt);
    bm bm = bm.a(getContext(), paramAttributeSet, a, paramInt, 0);
    if (bm.g(0))
      setDropDownBackgroundDrawable(bm.a(0)); 
    bm.a();
    this.b = new g(this);
    this.b.a(paramAttributeSet, paramInt);
    this.c = new z(this);
    this.c.a(paramAttributeSet, paramInt);
    this.c.a();
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    g g1 = this.b;
    if (g1 != null)
      g1.c(); 
    z z1 = this.c;
    if (z1 != null)
      z1.a(); 
  }
  
  public ColorStateList getSupportBackgroundTintList() {
    g g1 = this.b;
    return (g1 != null) ? g1.a() : null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode() {
    g g1 = this.b;
    return (g1 != null) ? g1.b() : null;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) { return n.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this); }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {
    super.setBackgroundDrawable(paramDrawable);
    g g1 = this.b;
    if (g1 != null)
      g1.a(paramDrawable); 
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
    g g1 = this.b;
    if (g1 != null)
      g1.a(paramInt); 
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback) { super.setCustomSelectionActionModeCallback(n.a(this, paramCallback)); }
  
  public void setDropDownBackgroundResource(int paramInt) { setDropDownBackgroundDrawable(a.b(getContext(), paramInt)); }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList) {
    g g1 = this.b;
    if (g1 != null)
      g1.a(paramColorStateList); 
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode) {
    g g1 = this.b;
    if (g1 != null)
      g1.a(paramMode); 
  }
  
  public void setTextAppearance(Context paramContext, int paramInt) {
    super.setTextAppearance(paramContext, paramInt);
    z z1 = this.c;
    if (z1 != null)
      z1.a(paramContext, paramInt); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */