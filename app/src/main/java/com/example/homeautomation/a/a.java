package com.salyantech.homecontrolpanel.a;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import com.salyantech.homecontrolpanel.b;
import com.salyantech.homecontrolpanel.b.a;
import com.salyantech.homecontrolpanel.c.a;
import java.util.ArrayList;

public class a extends RecyclerView.a<a.a> {
  private Context a;
  
  private ArrayList<a> b;
  
  private b c;
  
  public a(Context paramContext, ArrayList<a> paramArrayList, b paramb) {
    this.a = paramContext;
    this.b = paramArrayList;
    this.c = paramb;
  }
  
  private void a(a parama, a parama1) { // Byte code:
    //   0: aload_1
    //   1: invokevirtual e : ()Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: invokevirtual hashCode : ()I
    //   9: istore #4
    //   11: iload #4
    //   13: ldc -2134663084
    //   15: if_icmpeq -> 110
    //   18: iload #4
    //   20: ldc -1006804125
    //   22: if_icmpeq -> 95
    //   25: iload #4
    //   27: sipush #3714
    //   30: if_icmpeq -> 80
    //   33: iload #4
    //   35: ldc 101139
    //   37: if_icmpeq -> 65
    //   40: iload #4
    //   42: ldc 3035401
    //   44: if_icmpeq -> 50
    //   47: goto -> 125
    //   50: aload_3
    //   51: ldc 'bulb'
    //   53: invokevirtual equals : (Ljava/lang/Object;)Z
    //   56: ifeq -> 125
    //   59: iconst_0
    //   60: istore #5
    //   62: goto -> 128
    //   65: aload_3
    //   66: ldc 'fan'
    //   68: invokevirtual equals : (Ljava/lang/Object;)Z
    //   71: ifeq -> 125
    //   74: iconst_1
    //   75: istore #5
    //   77: goto -> 128
    //   80: aload_3
    //   81: ldc 'tv'
    //   83: invokevirtual equals : (Ljava/lang/Object;)Z
    //   86: ifeq -> 125
    //   89: iconst_2
    //   90: istore #5
    //   92: goto -> 128
    //   95: aload_3
    //   96: ldc 'others'
    //   98: invokevirtual equals : (Ljava/lang/Object;)Z
    //   101: ifeq -> 125
    //   104: iconst_4
    //   105: istore #5
    //   107: goto -> 128
    //   110: aload_3
    //   111: ldc 'speakers'
    //   113: invokevirtual equals : (Ljava/lang/Object;)Z
    //   116: ifeq -> 125
    //   119: iconst_3
    //   120: istore #5
    //   122: goto -> 128
    //   125: iconst_m1
    //   126: istore #5
    //   128: iload #5
    //   130: tableswitch default -> 164, 0 -> 217, 1 -> 204, 2 -> 191, 3 -> 178, 4 -> 165
    //   164: return
    //   165: aload_2
    //   166: getfield s : Landroid/widget/ImageView;
    //   169: astore #6
    //   171: ldc 2131230862
    //   173: istore #7
    //   175: goto -> 227
    //   178: aload_2
    //   179: getfield s : Landroid/widget/ImageView;
    //   182: astore #6
    //   184: ldc 2131230866
    //   186: istore #7
    //   188: goto -> 227
    //   191: aload_2
    //   192: getfield s : Landroid/widget/ImageView;
    //   195: astore #6
    //   197: ldc 2131230869
    //   199: istore #7
    //   201: goto -> 227
    //   204: aload_2
    //   205: getfield s : Landroid/widget/ImageView;
    //   208: astore #6
    //   210: ldc 2131230855
    //   212: istore #7
    //   214: goto -> 227
    //   217: aload_2
    //   218: getfield s : Landroid/widget/ImageView;
    //   221: astore #6
    //   223: ldc 2131230854
    //   225: istore #7
    //   227: aload #6
    //   229: iload #7
    //   231: invokevirtual setImageResource : (I)V
    //   234: return }
  
  private void a(a parama, a parama1, int paramInt) {
    parama1.r.setOnClickListener(new View.OnClickListener(this, parama, parama1, paramInt) {
          public void onClick(View param1View) { a.a(this.d, this.a.a(), this.b.r, this.a.c(), this.a.b(), this.a.e(), this.c); }
        });
    parama1.a.setOnClickListener(new View.OnClickListener(this, parama, parama1) {
          public void onClick(View param1View) {
            int i;
            Resources resources;
            TextView textView;
            if (this.a.d() == 0) {
              a.a.a(a.a(this.c), this.a.c().toUpperCase());
              a.b(this.c).a();
              this.a.a(1);
              this.b.q.setImageResource(2131230863);
              textView = this.b.t;
              resources = a.a(this.c).getResources();
              i = 2131755146;
            } else {
              a.a.a(a.a(this.c), this.a.c().toLowerCase());
              a.b(this.c).a();
              this.a.a(0);
              this.b.q.setImageResource(2131230864);
              textView = this.b.t;
              resources = a.a(this.c).getResources();
              i = 2131755145;
            } 
            textView.setText(resources.getString(i));
          }
        });
  }
  
  private void a(String paramString, int paramInt) {
    AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
    builder.setTitle(this.a.getResources().getString(2131755088));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.a.getResources().getString(2131755053));
    stringBuilder.append(" ");
    stringBuilder.append(paramString);
    stringBuilder.append("?");
    builder.setMessage(stringBuilder.toString());
    builder.setPositiveButton(this.a.getResources().getString(2131755162), new DialogInterface.OnClickListener(this, paramInt) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            (b.a()).b.a.remove(this.a);
            a.b(this.b).a();
          }
        });
    builder.setNegativeButton(this.a.getResources().getString(2131755112), new DialogInterface.OnClickListener(this, builder) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) { this.a.create().dismiss(); }
        });
    builder.show();
  }
  
  private void a(String paramString1, ImageView paramImageView, String paramString2, String paramString3, String paramString4, int paramInt) {
    PopupMenu popupMenu = new PopupMenu(this.a, paramImageView);
    popupMenu.getMenuInflater().inflate(2131558401, popupMenu.getMenu());
    PopupMenu.OnMenuItemClickListener onMenuItemClickListener = new PopupMenu.OnMenuItemClickListener(this, paramString1, paramString2, paramString3, paramString4, paramInt) {
        public boolean onMenuItemClick(MenuItem param1MenuItem) {
          int i = param1MenuItem.getItemId();
          if (i != 2131296318) {
            if (i != 2131296327)
              return true; 
            Intent intent = new Intent(a.a(this.f), com.salyantech.homecontrolpanel.activity.EditActivity.class);
            intent.putExtra("id", this.a);
            intent.putExtra("command", this.b);
            intent.putExtra("switchName", this.c);
            intent.putExtra("switchType", this.d);
            intent.putExtra("isEdit", true);
            a.a(this.f).startActivity(intent);
            return true;
          } 
          a.a(this.f, this.c, this.e);
          return true;
        }
      };
    popupMenu.setOnMenuItemClickListener(onMenuItemClickListener);
    popupMenu.show();
  }
  
  public int a() { return this.b.size(); }
  
  public void a(a parama, int paramInt) {
    int i;
    ImageView imageView;
    a a1 = (a)this.b.get(paramInt);
    parama.u.setText(a1.b());
    if (a1.d() == 0) {
      parama.t.setText(this.a.getResources().getString(2131755145));
      imageView = parama.q;
      i = 2131230864;
    } else {
      parama.t.setText(this.a.getResources().getString(2131755146));
      imageView = parama.q;
      i = 2131230863;
    } 
    imageView.setImageResource(i);
    parama.s.setImageResource(2131230862);
    a(a1, parama);
    a(a1, parama, paramInt);
  }
  
  public a c(ViewGroup paramViewGroup, int paramInt) { return new a(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131492931, paramViewGroup, false)); }
  
  public class a extends RecyclerView.x {
    ImageView q;
    
    ImageView r;
    
    ImageView s;
    
    TextView t;
    
    TextView u;
    
    public a(a this$0, View param1View) {
      super(param1View);
      this.q = (ImageView)param1View.findViewById(2131296363);
      this.r = (ImageView)param1View.findViewById(2131296362);
      this.t = (TextView)param1View.findViewById(2131296491);
      this.u = (TextView)param1View.findViewById(2131296494);
      this.s = (ImageView)param1View.findViewById(2131296360);
    }
  }
  
  public static interface b {
    void a();
  }
}


/* Location:              C:\Users\Siyam\Desktop\Home automation with java source files\Decompile tools\New folder\dex2jar-0.0.9.15-master\classes_dex2jar.jar!\com\salyantech\homecontrolpanel\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.7
 */