package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.b.a.b;
import android.support.v4.h.c;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

class l extends k {
  l(Context paramContext, b paramb) { super(paramContext, paramb); }
  
  k.a a(ActionProvider paramActionProvider) { return new a(this, this.a, paramActionProvider); }
  
  class a extends k.a implements ActionProvider.VisibilityListener {
    c.b c;
    
    public a(l this$0, Context param1Context, ActionProvider param1ActionProvider) { super(this$0, param1Context, param1ActionProvider); }
    
    public View a(MenuItem param1MenuItem) { return this.a.onCreateActionView(param1MenuItem); }
    
    public void a(c.b param1b) {
      ActionProvider.VisibilityListener visibilityListener;
      this.c = param1b;
      ActionProvider actionProvider = this.a;
      if (param1b != null) {
        visibilityListener = this;
      } else {
        visibilityListener = null;
      } 
      actionProvider.setVisibilityListener(visibilityListener);
    }
    
    public boolean b() { return this.a.overridesItemVisibility(); }
    
    public boolean c() { return this.a.isVisible(); }
    
    public void onActionProviderVisibilityChanged(boolean param1Boolean) {
      c.b b1 = this.c;
      if (b1 != null)
        b1.a(param1Boolean); 
    }
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v7\view\menu\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */