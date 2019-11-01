package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.h.q;
import android.support.v4.widget.n;
import android.support.v7.a.a;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

public class m extends EditText implements q {
  private final g a = new g(this);
  
  private final z b;
  
  public m(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, a.a.editTextStyle); }
  
  public m(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(bj.a(paramContext), paramAttributeSet, paramInt);
    this.a.a(paramAttributeSet, paramInt);
    this.b = new z(this);
    this.b.a(paramAttributeSet, paramInt);
    this.b.a();
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    g g1 = this.a;
    if (g1 != null)
      g1.c(); 
    z z1 = this.b;
    if (z1 != null)
      z1.a(); 
  }
  
  public ColorStateList getSupportBackgroundTintList() {
    g g1 = this.a;
    return (g1 != null) ? g1.a() : null;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode() {
    g g1 = this.a;
    return (g1 != null) ? g1.b() : null;
  }
  
  public Editable getText() { return (Build.VERSION.SDK_INT >= 28) ? super.getText() : getEditableText(); }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) { return n.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this); }
  
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
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback) { super.setCustomSelectionActionModeCallback(n.a(this, paramCallback)); }
  
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
  
  public void setTextAppearance(Context paramContext, int paramInt) {
    super.setTextAppearance(paramContext, paramInt);
    z z1 = this.b;
    if (z1 != null)
      z1.a(paramContext, paramInt); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */