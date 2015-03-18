package net.cyl.changelog.sample;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import net.cyl.changelog.Changelog;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Changelog(this, R.xml.changelog).showWhatsNew();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch(id) {
            case R.id.action_sample1: {
                Changelog changelog = new Changelog(this, R.xml.changelog);
                changelog.show();
                return true;
            }
            case R.id.action_sample2: {
                Changelog.Builder builder = new Changelog.Builder(this, R.xml.changelog);
                builder.setReleasePrefix(R.string.version);
                builder.setStyle(new Changelog.StyleList(true));
                builder.create().show();
                return true;
            }

            case R.id.action_sample3: {
                Changelog.Builder builder = new Changelog.Builder(this, R.xml.changelog);
                builder.setReleasePrefix("RELEASE ");
                builder.setStyle(new Changelog.StyleCharacters("[-]", "[+]", "[*]"));
                builder.create().show();
                return true;
            }

            case R.id.action_sample4: {
                Changelog.Builder builder = new Changelog.Builder(this, R.xml.changelog);
                builder.setStyle(new Changelog.StyleList(true, 0xF0D0D0, 0xDBFFDB, 0xD0D0F0, null, null, null));
                builder.create().show();
                return true;
            }


            case R.id.action_sample5: {
                Changelog.Builder builder = new Changelog.Builder(this, R.xml.changelog);
                builder.setStyle(new Changelog.StyleList(true, null, null, null, 0xFF0000, 0x0000FF, null));
                builder.setButton("Contact", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Button pressed", Toast.LENGTH_LONG).show();
                    }
                });
                builder.create().show();
                return true;
            }

            case R.id.action_sample6: {
                Changelog.Builder builder = new Changelog.Builder(this, R.xml.changelog);
                builder.setTitle("My app Changelog")
                        .setReleaseColor(0x0000FF)
                        .setReleaseDateColor(0x707070)
                        .setStyle(new Changelog.StyleList(false).setBugBackgroundColor(0xFF0000).setBugColor(0xFFFFFF))
                        .create()
                        .show();
                return true;
            }

            case R.id.action_sample7: {
                Changelog.Builder builder = new Changelog.Builder(this, R.xml.changelog);
                builder.setStyle(new Changelog.Style() {

                    @Override
                    protected void renderStartReleaseChanges(StringBuilder sb) {
                        sb.append("<div class='table'>");
                    }

                    @Override
                    protected void renderEndReleaseChanges(StringBuilder sb) {
                        sb.append("</div>");
                    }

                    @Override
                    protected void renderChange(StringBuilder sb, String change, Changelog.ChangeType changeType) {
                        String backgroundClass = changeType == Changelog.ChangeType.EMPTY ? "" : changeType == Changelog.ChangeType.BUG ? "bug" : changeType == Changelog.ChangeType.NEW ? "new" : "improvement";
                        sb.append("<div class='tr'>")
                                .append("<div class='td ").append(backgroundClass).append("'><span>")
                                .append(change)
                                .append("</span></div><div style='clear:both;'></div></div>");
                    }

                    @Override
                    protected void generateStyles(StringBuilder sb) {
                        sb.append(".table {width: 100%; padding-top: 10pt; padding-bottom: 10pt;}");
                        sb.append(".table .td {float: left; font-size: 9pt; width: 100%; }");
                        sb.append(".table .td span {padding-left: 15pt; display: block; }");
                        sb.append(".table .bug {background-color: #FF0000; color: #FFFFFF;}");
                        sb.append(".table .new {background-color: #00AA00;}");
                        sb.append(".table .improvement {color: #0000FF;}");
                    }
                });
                builder.create().show();
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}

