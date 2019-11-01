package android.support.v7.widget;

import android.content.Context;
import android.support.v4.widget.n;
import android.support.v7.c.a.a;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

public class j extends CheckedTextView {
  private static final int[] a = { 16843016 };
  
  private final z b = new z(this);
  
  public j(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, 16843720); }
  
  public j(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(bj.a(paramContext), paramAttributeSet, paramInt);
    this.b.a(paramAttributeSet, paramInt);
    this.b.a();
    bm bm = bm.a(getContext(), paramAttributeSet, a, paramInt, 0);
    setCheckMarkDrawable(bm.a(0));
    bm.a();
  }
  
  protected void drawableStateChanged() {
    super.drawableStateChanged();
    z z1 = this.b;
    if (z1 != null)
      z1.a(); 
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) { return n.a(super.onCreateInputConnection(paramEditorInfo), paramEditorInfo, this); }
  
  public void setCheckMarkDrawable(int paramInt) { setCheckMarkDrawable(a.b(getContext(), paramInt)); }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback) { super.setCustomSelectionActionModeCallback(n.a(this, paramCallback)); }
  
  public void setTextAppearance(Context paramContext, int paramInt) {
    super.setTextAppearance(paramContext, paramInt);
    z z1 = this.b;
    if (z1 != null)
      z1.a(paramContext, paramInt); 
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */