package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;

class e extends Filter {
  a a;
  
  e(a parama) { this.a = parama; }
  
  public CharSequence convertResultToString(Object paramObject) { return this.a.c((Cursor)paramObject); }
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence) {
    Cursor cursor = this.a.a(paramCharSequence);
    Filter.FilterResults filterResults = new Filter.FilterResults();
    if (cursor != null) {
      filterResults.count = cursor.getCount();
    } else {
      filterResults.count = 0;
      cursor = null;
    } 
    filterResults.values = cursor;
    return filterResults;
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults) {
    Cursor cursor = this.a.a();
    if (paramFilterResults.values != null && paramFilterResults.values != cursor)
      this.a.a((Cursor)paramFilterResults.values); 
  }
  
  static interface a {
    Cursor a();
    
    Cursor a(CharSequence param1CharSequence);
    
    void a(Cursor param1Cursor);
    
    CharSequence c(Cursor param1Cursor);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\android\support\v4\widget\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */