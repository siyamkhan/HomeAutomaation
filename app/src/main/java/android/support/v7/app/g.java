package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.h.e;
import android.support.v7.a.a;
import android.support.v7.view.b;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

public class g extends Dialog implements d {
  private e a;
  
  private final e.a b = new e.a(this) {
      public boolean a(KeyEvent param1KeyEvent) { return this.a.a(param1KeyEvent); }
    };
  
  public g(Context paramContext, int paramInt) {
    super(paramContext, a(paramContext, paramInt));
    a().a(null);
    a().i();
  }
  
  private static int a(Context paramContext, int paramInt) {
    if (paramInt == 0) {
      TypedValue typedValue = new TypedValue();
      paramContext.getTheme().resolveAttribute(a.a.dialogTheme, typedValue, true);
      paramInt = typedValue.resourceId;
    } 
    return paramInt;
  }
  
  public e a() {
    if (this.a == null)
      this.a = e.a(this, this); 
    return this.a;
  }
  
  public b a(b.a parama) { return null; }
  
  public void a(b paramb) {}
  
  public boolean a(int paramInt) { return a().c(paramInt); }
  
  boolean a(KeyEvent paramKeyEvent) { return super.dispatchKeyEvent(paramKeyEvent); }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) { a().b(paramView, paramLayoutParams); }
  
  public void b(b paramb) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent) {
    View view = getWindow().getDecorView();
    return e.a(this.b, view, this, paramKeyEvent);
  }
  
  public <T extends View> T findViewById(int paramInt) { return (T)a().a(paramInt); }
  
  public void invalidateOptionsMenu() { a().f(); }
  
  protected void onCreate(Bundle paramBundle) {
    a().h();
    super.onCreate(paramBundle);
    a().a(paramBundle);
  }
  
  protected void onStop() {
    super.onStop();
    a().d();
  }
  
  public void setContentView(int paramInt) { a().b(paramInt); }
  
  public void setContentView(View paramView) { a().a(paramView); }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) { a().a(paramView, paramLayoutParams); }
  
  public void setTitle(int paramInt) {
    super.setTitle(paramInt);
    a().a(getContext().getString(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    super.setTitle(paramCharSequence);
    a().a(paramCharSequence);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\app\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */