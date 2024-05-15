package com.customlistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int[] Icons={R.drawable.itadori,R.drawable.megumi,R.drawable.gojo,R.drawable.kugisaki,R.drawable.sukuna,R.drawable.inumaki,R.drawable.geto,R.drawable.mahito,R.drawable.jogo,R.drawable.chousou};
    String[] iconNames ={"itadori","megumi","gojo","kugisaki","sukuna","inumaki","geto","mahito","jogo","chousou"};

    String[] descriptions = {"Yuji Itadori is JJK's main protagonist. He is a teenager who's stronger than the average grown adult, " +
            "and whose pure physical strength even exceeds the most powerful Jujutsu Sorcerers. " +
            "He also has an inexplicably high resistance to cursed energy, which makes him the perfect vessel for Sukuna " +
            "after he inadvertently swallows one of the King of Curses' fingers. ",

            "Megumi Fushigoro was orphaned from a young age and placed into the care of Satoru Gojo. Due to his inheriting the Ten Shadows Technique, " +
                    "Megumi has some of the greatest latent potential of any sorcerer in the series, and Gojo does his best to help him tap into that in " +
                    "his own roundabout way.",

            "Born with both the Thousand Eyes and Limitless techniques, Satoru is the first sorcerer of his kind born in the Gojo family " +
                    "in the past 200 years. His power is so beyond all others in Japan that his mere presence prevents the most powerful " +
                    "villains from emerging from the shadows.",

            "Nobara is an extremely accomplished sorcerer who puts her all into training her cursed technique. Her technique, " +
                    "Straw Doll, allows her to create a voodoo doll of her enemies which gives her the ability to do debilitating " +
                    "damage to her enemies from long range.",

            "As the King of Curses, Sukuna is the main antagonist of Jujutsu Kaisen. He once ruled supreme during the Heian Era, " +
                    "a thousand years before the events of JJK, in an age also known as \"The Golden Age of Jujutsu.\"",

            "Toge's cursed speech is one of the more powerful cursed techniques in the series—so much so, that Toge has to constantly " +
                    "speak in coded language using sushi ingredients to prevent accidentally hurting someone with his ability.",

            "Geto's technique allows him to swallow and absorb cursed spirits, which he can then call upon at will to do his bidding. " +
                    "Geto was once a person with a strong moral compass who felt that practicing Jujutsu Sorcerery was all about protecting " +
                    "the weak and innocent who couldn't defend themselves.",

            "Mahito is the youngest of the disaster curses but by far the most deadly. Mahito's cursed technique, called Idle Transfiguration, " +
                    "lets him manipulate and control the soul of anyone he touches. This includes himself, meaning that no matter how much damage " +
                    "his physical body takes, he cannot be hurt as long as his soul remains intact.",

            "While the Disaster Curses have no appointed leader, Jogo often takes on the role. In terms of pure base power, " +
                    "Jogo may be the strongest in the group, though Mahito's technique and latent potential prove more devastating in the end.",

            "As a Death Painting Womb, Choso is a half-human, half-cursed spirit who has a flesh and blood body that is fully visible even " +
                    "to non-sorcerers. His appearance is predominantly that of a human man with long black stringy hair tied into two " +
                    "high ponytails that jut upward and outward."

    };

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Icons.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view= getLayoutInflater().inflate(R.layout.custom_layout,null);
            ImageView Img = (ImageView) view.findViewById(R.id.ImgDisp);
            Img.setImageResource(Icons[i]);
            TextView ImgTitle =(TextView) view.findViewById(R.id.ImgName);
            ImgTitle.setText(iconNames[i].toUpperCase());

            Button clickMe = view.findViewById(R.id.clickMe);
            clickMe.setText(iconNames[i].toUpperCase());

            clickMe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);
                    intent.putExtra("name", iconNames[i]);
                    intent.putExtra("description", descriptions[i]);
                    intent.putExtra("image", Icons[i]);
                    startActivity(intent);
                }
            });


            return view;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CustomAdapter adapter= new CustomAdapter();
        ListView DispItems = findViewById(R.id.lvItems);
        DispItems.setAdapter(adapter);
    }
}