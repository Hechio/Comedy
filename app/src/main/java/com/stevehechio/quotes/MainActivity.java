package com.stevehechio.quotes;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
   private  ConstraintLayout myLayout;
   private Button myBack,myNext;
   private TextSwitcher mySwitcher;
   private  int mPosition=0;
   private Switch myToggle;
   private  TextSwitcher mySwitcher1;
   private TextSwitcher mySwitcher2;
   private AdView myAdView;
   public AdRequest adRequest;
   private CardView myCard,myCard1,myCard2;
   private TextView myText1,myText2,myText3;


   private static final  String[] men = {"Some boyfriends are like bang, you love him but you cannot take them to your parents",
           "Most probably, your girlfriend is with you because she did not find Bill Gates' son",
           "Ninety per cent of kenyan men do not know how they ended up with the women they married",
           "Drink until she is cute, but stop before the wedding",
           "If you girlfriends back does not shake while cooking, you are dating a man",
           "If she removes her pants and trouser together, use a condom my brother",
           "Bar owners will employ beautiful ladies to confuse a man to drink more",
           "Every man bathing during the cold weather is an attention seeker, men shall not be distracted",
           "A man's phone is an onion, if you touch it you will cry",
           "Nobody walks faster than a man accompanying an ugly girl in the morning after one night stand.",
           "Dear boyfriends, if you argue with her and she says, 'Listen young man',she is doing old men",
           " If you are married and every time money gets lost from you pocket in the house, put a packet of condom in your trouser, you will know the thief",
           "You girlfriend will only tell you about broke and ugly guys that ask her out, but not the rich ones; wake up my brother.",
           "Beware of short-haired ladies, they will drink you money, go to the toilet, put on the wig and join another table",
           "When of you go with your girlfriends at your friends home and the dog does not bark,WISDOM WISDOM WISDOM please ",
           "A man will work for ten years living with unemployed wife and no one will know; A woman will be employed for five days and the whole country will know about her unemployed husband",
           "Every man is a Millionaire, maybe according to his sperms account; but even these millions are still spent on women",
           "If the bride's parents and relatives keep on dancing nonstop at her wedding day, just know that she has a baby that you don't know about",
           "Before you have sex in the name of cold weather remember that hot coffee is cheaper that baby pampers",
           "God bless those side chicks who when they see us with out wives they ignore us totally",
           "When a single man sees people walking in pairs, he always thinks that Noah has built another Ark",
           "My uncle wrote a book titled: '20 Ways to Make Money', he is still looking for money to publish it",
           "The only time a man recalls all the ladies he has ever met is when he is a VCT center",
           "From a caring father; before she reaches 24 years, the only boyfriend allowed in my daughter's life is The Father, The Son and the Holy Spirit",
           "Do not waste your jokes on a lady in a relationship, let her suffer with her boring boyfriend",
           "If she keeps saying 'my child means everything to me', she broke away with her husband or boyfriend",
           "Explain to your girlfriends where you are taking them out; a lady from upcountry will sweep the whole lodging compound"
           ,"A man who does not drink and does not like women is a thief,do not argue with me",
           "Some men will watch football with their side-chicks but still claim the referee is cheating",
           "When the man's mother calls the man's girlfriend 'Our wife', she have been accepted",
           "When you enter into a club, all the waitresses look more beautiful than your wife/girlfriend",
           "Do not ask why men become stingy on a lady after seduction; you do not campaign after winning",
           "Men learn a lot of patient when they want to go out with a bar waitress, they wait until she is off duty",
           "If you want to eat meat in a funeral, wait until women of that home start calling their husbands and follow them"

   };

    private static final  String[] women = {"If you are a side chick, you are not allowed to send me sweet messages, just ask 'Hey Coach, do we have practise today?', i will understand",
            "A blessed woman is the one who does not shake her back, the back shakes automatically",
            "Ladies, stay away from a man who knows when your periods ends but does not know your birthday",
            "Married women, do not employ a house help who is more beautiful than you or else you will be graduated from the wife to the FIRST wife",
            "Married ladies, do not let your lazy boyfriend make you cheat on your working husband",
            "When praying for your husband, pray for his friends too; they are the B.O.G",
            "There is nothing as heavy as a packet of Condom after she has switched off her phone when you are going back home, it feels like a bag of cement",
            "If you are ugly, you are ugly; stop talking about inner beauty, men do not walk with X-Rays",
            "Ladies, never say that all he wanted was sex because that is what you offered",
            "When your boyfriend call when your husband is in just pick up the call and say, 'Man of The Lord, the angels are here and they protecting us'",
            "I do not know what is in a man's phone that their ladies are not allowed to touch",
            "Dear ladies, not all men are bad, some are dead",
            "Do not cheat on your man with someone you is stronger than him, you cannot break someone twice",
            "If he asks for your number, give him one digit per month to test his patience",
            "A woman's relationship will not last long if her best friend is still single",
            "Ladies, a man who is good in bed is unfaithful; it is in the constitution",
            "Some women's legs are like rumors, they keep on spreading.",
            "No matter how lazy your husband/boyfriend is, he will never ask you to pass him his phone; his ancestors will always give him strength",
            "Just because a guy is flatting with you,it does not mean you are hot; sometimes when you are hungry even cabbage is delicious",
            "No matter how small your buttocks are, God had to divide into twos",
            "You approach a lady and she asks if you are single, have you ever seen anyone buying clothes while naked?",
            "Ladies, it is so sad that your head that failed Mathematics you put a very expensive weave on it",
            "Ladies, you do not owe anyone perfect eyebrows, just draw whatever you can draw",
            "He starts calling you sexy the removes Y to have sex, finally he removes S and you become the ex",
            "Ladies, telling him you have a boyfriend will not stop him from chasing you, just ask him a large amount of money",
            "When you are telling your boyfriend your problems and he asks,'What do you think we should do?', just know he is part of the problem",
            "If you husband wrongs you, look him through a fork and he will look like he is in the prison"
            ,"Big buttocks on a stupid lady is like an holiday on the weekend, very useless",
            "A woman is like an iron sheet, if you do not nail it, you will find it in the neighbour's compound",
            "Fear women, a women saw a talking snake and she did not run away",
            "Most ladies do not love long distance relationship but they love money coming from long distances",
            "Ladies who give us money under the table to pay bills, so that we can look like gentlemen, the kingdom of God belongs to you",
            " Nothing confuses a lady like a broke man who is good is bed",
            "Know that he will not marry you when you are hanging out together and he asks,'Between you and me, who do you think will get married first'",
            "Dear married ladies, if a man ask your phone number, give him your husband's, let them deal man to man",
            "My daughter, when you live a life beyond your parents' capabilities, be ready to pay the price as per the provider's wish"

    };
    private static final  String[] money = {"A portfolio without a corresponding bank account is an illegal structure",
            "The only English landlords understand is 'This is my house!'",
            "First exchange time for money second, exchange money for time",
            "If you do not hustle hard during your youth years, your eulogy will be short",
            "Do not call people your best friend, best colleague,neighbour, let your hard times introduce them",
            "If you are my friend, be my friend; if you are my enemy, be my enemy; stay in one spot; stop confusing the thunder",
            "It is not easy, the good comes for those who are out there and want to make it",
            "If you sit there and wait for someone to come for you, stand up because nobody is doing to come.",
            "Ninety per cent of Bedbugs in homes are brought husbands who sleep in cheap lodgings",
            "Money is not everything, it is the only thing",
            " A friend who does not tell you where he is drinking from is an enemy",
            "Some people are like Mugabe, since WhatsApp was created they are still admins, please hand over the powers"
            ,"If you still pray in English, you have not seen problems; when you reach the rock bottom of your problem, you will pray in your mother tongue",
            "What is fraud? Fraud is well you get a girlfriend today and tomorrow is her birthday",
            "First, exchange time for money; second, exchange money for time",
            "Happy are those who expect nothing, for they will not be disappointed if nothing comes their way",
            "Being a firstborn is not easy, it automatically makes you the deputy parent",
            "If a thermometer uses alcohol to give accurate reading, then one should not ignore the opinion of a drunkard",
            "One billion churches,four billion members,four thousand religions, thousands of years; fighting ONE Satan",
            "Know your priorities right and spend you money wisely; Do not buy a selfie stick when you armpits needs a shaving stick",
            "When you are jobless, dress up in the morning and leave the house to confuse the devil",
            "Things we should learn from dogs; the loyalty,friendship and trust,unfortunatly we learnt only the position",
            "When you are broke, that is when you will realize you are not an alcohol addict",
            "An empty spot on your bed is better that having a wrong spirit lying on it",
            "Having a partner is a blessing; so the more partners you have, the more blessings you get",
            "You dream you have a car, you wake up with nothing; you dream you have money you wake up with nothing; you dream you urinating in bed and the dream comes true",
            "Love is a journey; however, many people have already used their fare",
            "Kenyan will bath with a soap until it look like a SIM card",
            "Put on you clothes again and again to confirm it is yours",
            "If you have problem with people carrying their car keys on their hands, please carry you fare",
            "The effect of cheap alcohol is  first felt  on the knees",
            "Most pastors dance more than the best dancer while receiving offerings",
            "To be at peace with a man, never touch his piece of land, his money and his wife"

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        MobileAds.initialize(this,"ca-app-pub-3940256099942544~3347511713");
        myBack = (Button)findViewById(R.id.jalango_prev);
        myNext = (Button) findViewById(R.id.jalango_next);
        mySwitcher = (TextSwitcher)findViewById(R.id.jalango_switcher);

        myLayout = (ConstraintLayout)findViewById(R.id.layout);
        mySwitcher1=(TextSwitcher)findViewById(R.id.jalango_switcher1);
        mySwitcher2=(TextSwitcher)findViewById(R.id.jalango_switcher2);
        myAdView = (AdView)findViewById(R.id.adView);
        myCard = (CardView)findViewById(R.id.cardView);
        myCard1 = (CardView)findViewById(R.id.cardView1);
        myCard2 = (CardView)findViewById(R.id.cardView2);
        myText1 = (TextView)findViewById(R.id.textView);
        myText2 = (TextView)findViewById(R.id.textView1);
        myText3 = (TextView)findViewById(R.id.textView2);
        myToggle = (Switch)findViewById(R.id.switchShuffle);
        myBack.setEnabled(false);

        adRequest = new AdRequest.Builder().addTestDevice("A6256E31A1308D7B2A280A457E8B6739").build();
        myAdView.loadAd(adRequest);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          Toolbar  myToolbar= (Toolbar)findViewById(R.id.toolbar2);
          setSupportActionBar(myToolbar);
         getSupportActionBar().setTitle("");




        }

        mySwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView = new TextView(getApplicationContext());
                textView.setTextSize(20);
                textView.setText(men[mPosition]);

                    textView.setTextColor(getResources().getColor(R.color.black));

                return textView;
            }
        });
        mySwitcher1.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView1 = new TextView(getApplicationContext());
                textView1.setTextSize(20);

                    textView1.setTextColor(getResources().getColor(R.color.black));

                textView1.setText(women[mPosition]);
                return textView1;
            }
        });
        mySwitcher2.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView2 = new TextView(getApplicationContext());
                textView2.setTextSize(20);


                    textView2.setTextColor(getResources().getColor(R.color.black));
                textView2.setText(money[mPosition]);
                return textView2;
            }
        });
        myToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    shuffle();
                }
                else {

                    mySwitcher.setText(men[mPosition]);
                    mySwitcher1.setText(women[mPosition]);
                    mySwitcher2.setText(money[mPosition]);
                    myBack.setEnabled(false);
                    unshuffle();
                }
            }
        });

        unshuffle();


    }

    public void shuffle(){


        myNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int showMan = random.nextInt(men.length - 1);
                int showWomen = random.nextInt(women.length - 1);
                int showMoney = random.nextInt(money.length - 1);

                myBack.setEnabled(true);
                mySwitcher.setText(men[showMan]);
                mySwitcher1.setText(women[showWomen]);
                mySwitcher2.setText(money[showMoney]);


            }
        });
        myBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int showMan = random.nextInt(men.length - 1);
                int showWomen = random.nextInt(women.length - 1);
                int showMoney = random.nextInt(money.length - 1);

                showMan--;
                showWomen--;
                showMoney--;

                mySwitcher.setText(men[showMan]);
                mySwitcher1.setText(women[showWomen]);
                mySwitcher2.setText(money[showMoney]);

            }

        });
    }
    public void unshuffle(){

        myNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 myBack.setEnabled(true);
                        mPosition++;
                if(mPosition==women.length-1){
                    myNext.setEnabled(false);
                }
                else if (mPosition < money.length - 1) {
                        mySwitcher.setText(men[mPosition]);
                        mySwitcher1.setText(women[mPosition]);
                        mySwitcher2.setText(money[mPosition]);
                    }
                else if(mPosition>money.length-1 && mPosition<women.length-1){
                        mySwitcher.setText(men[mPosition]);
                        mySwitcher1.setText(women[mPosition]);
                        mySwitcher2.setText(money[money.length-1]);
                    }
               else if(mPosition>=men.length-1 && mPosition <=women.length-1){
                        mySwitcher.setText(women[mPosition]);
                        mySwitcher1.setText(men[men.length-1]);
                        mySwitcher2.setText(money[money.length-1]);
                    }


            }
        });
        myBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              myNext.setEnabled(true);
                mPosition--;
                if (mPosition==0) {
                    myBack.setEnabled(false);
                    mySwitcher.setText(men[0]);
                    mySwitcher1.setText(women[0]);
                    mySwitcher2.setText(money[0]);

                }
                else if (mPosition <= women.length - 1 && mPosition != 0 && mPosition > men.length - 1 && mPosition > money.length - 1) {
                    mySwitcher.setText(women[mPosition]);
                    mySwitcher1.setText(men[men.length - 1]);
                    mySwitcher2.setText(money[money.length - 1]);
                } else if (mPosition <= women.length - 1 && mPosition != 0 && mPosition <= men.length - 1 && mPosition <= money.length - 1) {
                    mySwitcher.setText(men[mPosition]);
                    mySwitcher1.setText(women[mPosition]);
                    mySwitcher2.setText(money[mPosition]);
                }

            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_option,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.about:
                Intent myintent = new Intent(MainActivity.this,About.class);
                startActivity(myintent);
                break;
            case R.id.feedback:
                //Toast.makeText(this, "Sending email Feedback ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto"));
                String[] strings ={"stevehechio@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL,strings);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Jalang'o Quotes");
                intent.setType("text/plain");
                Intent chooser = Intent.createChooser(intent,"Send Feedback Mail");
                startActivity(chooser);
                break;
            case R.id.rate:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=" + "com.android.chrome")));

                } catch (ActivityNotFoundException e){
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=" +getPackageName())));
                }
                Toast.makeText(this, "Rating via PlayStore", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                //Toast.makeText(this, "share selected", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String[] message ={"Jalang'o Quotes","Please use this link to download the best of Jalang'o Quotes"};
                myIntent.putExtra(Intent.EXTRA_SUBJECT,message[0]);
                myIntent.putExtra(Intent.EXTRA_TEXT,message[1]);
                startActivity(Intent.createChooser(myIntent,"Share using"));
                 break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
