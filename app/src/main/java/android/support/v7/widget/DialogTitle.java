package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.n;
import android.support.v7.a.a;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.widget.TextView;

public class DialogTitle extends TextView {
  public DialogTitle(Context paramContext, AttributeSet paramAttributeSet) { super(paramContext, paramAttributeSet); }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    super.onMeasure(paramInt1, paramInt2);
    Layout layout = getLayout();
    if (layout != null) {
      int i = layout.getLineCount();
      if (i > 0 && layout.getEllipsisCount(i - 1) > 0) {
        setSingleLine(false);
        setMaxLines(2);
        TypedArray typedArray = getContext().obtainStyledAttributes(null, a.j.TextAppearance, 16842817, 16973892);
        int j = typedArray.getDimensionPixelSize(a.j.TextAppearance_android_textSize, 0);
        if (j != 0)
          setTextSize(0, j); 
        typedArray.recycle();
        super.onMeasure(paramInt1, paramInt2);
      } 
    } 
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback) { super.setCustomSelectionActionModeCallback(n.a(this, paramCallback)); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\widget\DialogTitle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */