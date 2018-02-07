package com.example.user.qeestudiar;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.qeestudiar.cardpager.CardFragmentPagerAdapter;
import com.example.user.qeestudiar.cardpager.CardItem;
import com.example.user.qeestudiar.cardpager.CardPagerAdapter;
import com.example.user.qeestudiar.cardpager.ShadowTransformer;

public class DetailPerfilActivity extends AppCompatActivity {


    private ViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_perfil);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);


        mCardAdapter = new CardPagerAdapter();
      /*  mCardAdapter.addCardItem(new CardItem("PROD1", "Zapatillas Adidas", "https://http2.mlstatic.com/D_Q_NP_602715-MPE25280543856_012017-Q.jpg"), this);
        mCardAdapter.addCardItem(new CardItem("PROD 2", "Sandalias de Verano", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXeESk4wUpyinyJGb_2Cni_ZT-44EOLKLDrb-Ae0yYuG_whB3kgQ"), this);
        mCardAdapter.addCardItem(new CardItem("PROD 3", "Zapatos de Noche", "http://www.zapatos.org/wp-content/uploads/sites/8/2012/05/zapato-noche-blanco.jpeg"), this);
        mCardAdapter.addCardItem(new CardItem("PROD 4", "Botas doble encaje", "http://www.heyas.com.ar/media/catalog/product/cache/7/image/420x650/9df78eab33525d08d6e5fb8d27136e95/1/4/146z1046-ne0-1.jpg"), this);
        */
     mFragmentCardAdapter = new CardFragmentPagerAdapter(this.getSupportFragmentManager(),
                dpToPixels(2, this));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);

    }

    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

}
