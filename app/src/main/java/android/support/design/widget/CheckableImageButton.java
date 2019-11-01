package android.support.design.widget;

import android.content.Context;
import android.support.v4.h.a.c;
import android.support.v4.h.b;
import android.support.v4.h.r;
import android.support.v7.a.a;
import android.support.v7.widget.o;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;

public class CheckableImageButton extends o implements Checkable {
  private static final int[] a = { 16842912 };
  
  private boolean b;
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet) { this(paramContext, paramAttributeSet, a.a.imageButtonStyle); }
  
  public CheckableImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    r.a(this, new b(this) {
          public void a(View param1View, c param1c) {
            super.a(param1View, param1c);
            param1c.a(true);
            param1c.b(this.a.isChecked());
          }
          
          public void a(View param1View, AccessibilityEvent param1AccessibilityEvent) {
            super.a(param1View, param1AccessibilityEvent);
            param1AccessibilityEvent.setChecked(this.a.isChecked());
          }
        });
  }
  
  public boolean isChecked() { return this.b; }
  
  public int[] onCreateDrawableState(int paramInt) { return this.b ? mergeDrawableStates(super.onCreateDrawableState(paramInt + a.length), a) : super.onCreateDrawableState(paramInt); }
  
  public void setChecked(boolean paramBoolean) {
    if (this.b != paramBoolean) {
      this.b = paramBoolean;
      refreshDrawableState();
      sendAccessibilityEvent(2048);
    } 
  }
  
  public void toggle() { setChecked(true ^ this.b); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\CheckableImageButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */