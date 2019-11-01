package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class l extends d {
  private int j;
  
  private int k;
  
  private LayoutInflater l;
  
  @Deprecated
  public l(Context paramContext, int paramInt, Cursor paramCursor, boolean paramBoolean) {
    super(paramContext, paramCursor, paramBoolean);
    this.k = paramInt;
    this.j = paramInt;
    this.l = (LayoutInflater)paramContext.getSystemService("layout_inflater");
  }
  
  public View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup) { return this.l.inflate(this.j, paramViewGroup, false); }
  
  public View b(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup) { return this.l.inflate(this.k, paramViewGroup, false); }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\widget\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */