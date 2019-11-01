package android.support.design.widget;

import android.widget.ImageButton;

public class t extends ImageButton {
  private int a;
  
  public final void a(int paramInt, boolean paramBoolean) {
    super.setVisibility(paramInt);
    if (paramBoolean)
      this.a = paramInt; 
  }
  
  public final int getUserSetVisibility() { return this.a; }
  
  public void setVisibility(int paramInt) { a(paramInt, true); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\design\widget\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */