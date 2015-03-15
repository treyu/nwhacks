package nwhacks.tree_tapper;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class GameActivity extends ActionBarActivity {
    private int trees_tapped;

    public int getTrees_Tapped() {
        return this.trees_tapped;
    }

    public void setTrees_Tapped(int trees_tapped) {
        this.trees_tapped = trees_tapped;
    }

    public void onClick(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     *
     * @param view
     */
    public void ComputeScore(View view) {
        ImageView imageView = (ImageView) view;
        String tag = imageView.getTag().toString();
        int tapped = 0;

        if (tag.equals("tree")) {
            tapped = this.getTrees_Tapped() + 1;
            this.setTrees_Tapped(tapped);
        } else if (tag.equals("car")) {
            tapped = this.getTrees_Tapped() - 1;
            this.setTrees_Tapped(tapped);
        }

        TextView textView = (TextView) findViewById(R.id.score);
        textView.setText(Integer.toString(tapped));
    }
}
