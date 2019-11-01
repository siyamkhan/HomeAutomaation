package b.a.a.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Spannable;
import android.widget.LinearLayout;
import android.widget.TextView;

class a extends LinearLayout {
  int[] a = new int[2];
  
  private Paint b;
  
  private RectF c;
  
  private TextView d;
  
  private TextView e;
  
  a(Context paramContext) {
    super(paramContext);
    float f = (paramContext.getResources().getDisplayMetrics()).density;
    setWillNotDraw(false);
    setOrientation(1);
    setGravity(17);
    this.c = new RectF();
    this.b = new Paint(1);
    this.b.setStrokeCap(Paint.Cap.ROUND);
    int i = (int)(10.0F * f);
    int j = (int)(f * 3.0F);
    this.d = new TextView(paramContext);
    this.d.setPadding(i, i, i, j);
    this.d.setGravity(17);
    this.d.setTextSize(1, 18.0F);
    this.d.setTextColor(-16777216);
    addView(this.d, new LinearLayout.LayoutParams(-2, -2));
    this.e = new TextView(paramContext);
    this.e.setTextColor(-16777216);
    this.e.setTextSize(1, 14.0F);
    this.e.setPadding(i, j, i, i);
    this.e.setGravity(17);
    addView(this.e, new LinearLayout.LayoutParams(-2, -2));
  }
  
  public void a(int paramInt) { this.d.setTextSize(2, paramInt); }
  
  public void a(Typeface paramTypeface) { this.e.setTypeface(paramTypeface); }
  
  public void a(Spannable paramSpannable) { this.e.setText(paramSpannable); }
  
  public void a(String paramString) {
    if (paramString == null) {
      removeView(this.d);
      return;
    } 
    this.d.setText(paramString);
  }
  
  public void b(int paramInt) { this.e.setTextSize(2, paramInt); }
  
  public void b(Typeface paramTypeface) { this.d.setTypeface(paramTypeface); }
  
  public void b(String paramString) { this.e.setText(paramString); }
  
  public void c(int paramInt) {
    this.b.setAlpha(255);
    this.b.setColor(paramInt);
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas) {
    super.onDraw(paramCanvas);
    getLocationOnScreen(this.a);
    this.c.set(getPaddingLeft(), getPaddingTop(), (getWidth() - getPaddingRight()), (getHeight() - getPaddingBottom()));
    paramCanvas.drawRoundRect(this.c, 15.0F, 15.0F, this.b);
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\b\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */